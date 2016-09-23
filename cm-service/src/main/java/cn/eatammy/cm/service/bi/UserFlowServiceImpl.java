/*
{*****************************************************************************
{  主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户行为流量监控表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-09-01  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.service.bi;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.bi.IUserFlowDAO;
import cn.eatammy.cm.dao.user.IUserDetailDAO;
import cn.eatammy.cm.domain.bi.BiResultDto;
import cn.eatammy.cm.domain.bi.UserFlow;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.CommonUtils;
import cn.eatammy.common.utils.DeviceEnum;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 《用户行为流量监控》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("UserFlowServiceImpl")
public class UserFlowServiceImpl extends AbstractCMPageService<ICMBaseDAO<UserFlow>, UserFlow> implements IUserFlowService<ICMBaseDAO<UserFlow>, UserFlow> {
    @Autowired
    private IUserFlowDAO userFlowDAO;
    @Autowired
    private IUserDetailDAO userDetailDAO;

    @Override
    public ICMBaseDAO<UserFlow> getDao() {
        return userFlowDAO;
    }


    @Override
    public String addUserFlows(List<UserFlow> userFlows) {

        if (userFlowDAO.addUserFlows(userFlows) > 0) {
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public Map<String, Object> queryUserMap(Integer sex, Integer minAge, Integer maxAge) {
        if (maxAge == 0) {
            maxAge = null;
        }
        List<BiResultDto> biResultDtos = userDetailDAO.queryUserMap(sex, minAge, maxAge);
        if (biResultDtos.size() <= 0) {
            throw new BizException(ERRORCODE.DIRTY_DATA.getCode(), ERRORCODE.DIRTY_DATA.getMessage());
        }
        Map<Integer, String> map = CommonUtils.getMap();
        Map<String, Object> result = new HashMap<>();
        List<BiResultDto> data = new ArrayList<>(34);
        //设置标题
        result.put("text", "用户分布");
        result.put("subtext", "各省份用户分布");

        //设置最大值
        if (biResultDtos.size() > 1) {
            Collections.sort(biResultDtos, new Comparator<BiResultDto>() {
                @Override
                public int compare(BiResultDto o1, BiResultDto o2) {
                    return o1.getValue() > o2.getValue() ? 1 : 0;
                }
            });
            result.put("max", biResultDtos.get(0).getValue());
        }
        //设置数据
        BiResultDto biResultDto;
        for (BiResultDto item : biResultDtos) {
            if (map.containsKey(item.getName())) {
                biResultDto = new BiResultDto();
                biResultDto.setName(map.get(item.getName()));
                biResultDto.setValue(item.getValue());
                data.add(biResultDto);
            } else {
                throw new BizException(ERRORCODE.DIRTY_DATA.getCode(), ERRORCODE.DIRTY_DATA.getMessage());
            }
        }
        result.put("data", data);
        return result;
    }

    @Override
    public Map<String, Object> getRegisterInfo() {
        Map<String, Object> result = new HashMap<>();
        result.put("gross", userDetailDAO.count(null));
        result.put("monthRegister", userDetailDAO.countCurMonthRegister());
        result.put("weekRegister", userDetailDAO.countCurWeekRegister().get(0).getValue());
        result.put("dayRegister", userDetailDAO.countCurDayRegister());
        return result;
    }

    @Override
    public Map<String, Object> getRegisterCharts(Integer month) {
        int curMonth = new Date().getMonth() + 1;
        month = Math.abs(curMonth - month);
        List<BiResultDto> biResultDtos = userDetailDAO.queryRegister(month);
        if (biResultDtos.size() <= 0) {
            throw new BizException(ERRORCODE.NO_DATA.getCode(), ERRORCODE.NO_DATA.getMessage());
        }
        Map<String, Object> result = new HashMap<>();
        //设置标题
        result.put("text", curMonth + "月用户注册量统计");
        result.put("subtext", "当月每天注册量统计");
        List<String> xAxis = new ArrayList<>(biResultDtos.size());
        List<Integer> data = new ArrayList<>(biResultDtos.size());
        for (BiResultDto biResultDto : biResultDtos) {
            xAxis.add(biResultDto.getName().toString());
            data.add(biResultDto.getValue());
        }
        result.put("xAxis", xAxis);
        result.put("data", data);
        return result;
    }

    /**
     * 获取用户活动视图（分析统计）
     *
     * @param type  统计类型：0：每月访客，1：每月活跃用户，2：设备统计
     * @param month 月份
     * @return 返回，数据视图
     */
    @Override
    public Map<String, Object> getUserCharts(Integer type, Integer month, Integer year, Integer isDefault) {
        Map<String, Object> result = new HashMap<>();
        List<String> xAxis = null;
        List<Integer> data = null;
        switch (type) {
            case 0:
                result.put("text", "访客统计");
                result.put("subtext", "每天访客统计");
                List<BiResultDto> userPV = getUserPV(year, month);
                xAxis = new ArrayList<>(userPV.size());
                data = new ArrayList<>(userPV.size());
                for (BiResultDto biResultDto : userPV) {
                    xAxis.add(biResultDto.getName().toString());
                    data.add(biResultDto.getValue());
                }
                break;
            case 1:
                return getActivePV(isDefault);
            case 2:
                return getDevicePV(month);
            default:
                throw new BizException(ERRORCODE.PARAM_ISERROR.getCode(), ERRORCODE.PARAM_ISERROR.getMessage());
        }

        result.put("xAxis", xAxis);
        result.put("data", data);
        return result;
    }

    /**
     * 查询每个月的访客统计
     *
     * @param year  按年份查询
     * @param month 月份，0，表示当前月份，递增表示往前的月份，如1，表示上个月，2表示前个月
     * @return 返回，统计结果
     */
    private List<BiResultDto> getUserPV(Integer year, Integer month) {
        month = Math.abs(new Date().getMonth() + 1 - month);
        List<BiResultDto> queryResult = userFlowDAO.countMonthPV(year, month);
        if (queryResult.size() > 0) {
            return queryResult;
        }
        throw new BizException(ERRORCODE.NO_DATA.getCode(), ERRORCODE.NO_DATA.getMessage());
    }

    /**
     * 查询每个月的活跃用户统计
     *
     * @param isDefault 统计方式，0：按性别，1：按年龄区间
     * @return 返回，统计结果
     */
    private Map<String, Object> getActivePV(Integer isDefault) {
        List<BiResultDto> queryResult;
        Map<String, Object> result = new HashMap<>();
        result.put("text", "活跃用户统计");
        result.put("subtext", "每天活跃用户统计");
        if (isDefault.equals(0)) {    //表示按性别统计
            queryResult = userFlowDAO.countMonthActivePV();
            if (queryResult.size() > 0) {
                List<String> xAxis = new ArrayList<>();
                List<Integer> male = new ArrayList<>();
                List<Integer> females = new ArrayList<>();
                for (BiResultDto bi : queryResult) {
                    xAxis.add(bi.getName().toString());
                    if (bi.getSex() == 0) {
                        male.add(bi.getValue());
                    } else {
                        females.add(bi.getValue());
                    }
                }
                result.put("xAxis", xAxis);
                result.put("male", male);
                result.put("females", females);
                return result;
            }
        } else {    //按年龄段统计，步长为10岁
            int minAge = 10, maxAge = 80;
            List<String> xAxis = null;  //横坐标
            List<Integer> itemData;  // 数据值
            List<List<Integer>> data = new ArrayList<>();  // 数据值
            for (int i = minAge; i < maxAge; i += 10) {
                if (i >= 60) {
                    queryResult = userFlowDAO.countAgeRangeActivePV(i, maxAge);
                    xAxis = new ArrayList<>(queryResult.size());
                    for (BiResultDto bi : queryResult) {
                        xAxis.add(bi.getName().toString());
                    }
                    i += 20;//迫使本次循环之后退出循环
                } else {
                    queryResult = userFlowDAO.countAgeRangeActivePV(i, i + 10);
                }
                itemData = new ArrayList<>(queryResult.size());
                for (BiResultDto bi : queryResult) {
                    itemData.add(bi.getValue());
                }
                data.add(itemData);
            }
            result.put("xAxis", xAxis);
            result.put("data", data);
            return result;
        }
        throw new BizException(ERRORCODE.NO_DATA.getCode(), ERRORCODE.NO_DATA.getMessage());
    }


    /**
     * 得到设备统计
     *
     * @param month 月份，0，表示当前月份，递增表示往前的月份，如1，表示上个月，2表示前个月
     * @return 返回，统计结果
     */
    private Map<String, Object> getDevicePV(Integer month) {
        month = Math.abs(new Date().getMonth() + 1 - month);
        List<BiResultDto> queryResult = userFlowDAO.countDevicePV(month);
        List<BiResultDto> data;
        Map<String, Object> result;
        if (queryResult.size() > 0) {
            result = new HashMap<>();
            result.put("text", "活跃用户统计");
            result.put("subtext", "每天活跃用户统计");
            List<String> xAixs = Arrays.asList("电脑", "手机", "平板");
            data = new ArrayList<>(queryResult.size());
            BiResultDto biResultDto;
            for (BiResultDto bi : queryResult) {
                biResultDto = new BiResultDto();
                if (DeviceEnum.PC.getAction() == bi.getDeviceType()) {
                    biResultDto.setName(DeviceEnum.PC.getName());
                } else if (DeviceEnum.MOBILE.getAction() == bi.getDeviceType()) {
                    biResultDto.setName(DeviceEnum.MOBILE.getName());
                } else if (DeviceEnum.TABLET.getAction() == bi.getDeviceType()) {
                    biResultDto.setName(DeviceEnum.TABLET.getName());
                }
                biResultDto.setValue(bi.getValue());
                data.add(biResultDto);
            }
            result.put("xAixs", xAixs);
            result.put("data", data);
            return result;
        }
        throw new BizException(ERRORCODE.NO_DATA.getCode(), ERRORCODE.NO_DATA.getMessage());
    }
}