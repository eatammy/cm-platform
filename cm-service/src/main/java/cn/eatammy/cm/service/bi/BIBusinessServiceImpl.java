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

import cn.eatammy.cm.dao.business.IGoodsDAO;
import cn.eatammy.cm.dao.business.IIndentDAO;
import cn.eatammy.cm.dao.business.IShopDAO;
import cn.eatammy.cm.domain.bi.BiDataDto;
import cn.eatammy.cm.domain.bi.BiResultDto;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.CommonUtils;
import cn.eatammy.common.utils.ERRORCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 平台商务BI分析 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("BIBusinessServiceImpl")
public class BIBusinessServiceImpl implements IBIBusinessService {

    @Autowired
    private IIndentDAO indentDAO;
    @Autowired
    private IShopDAO shopDAO;
    @Autowired
    private IGoodsDAO goodsDAO;

    DecimalFormat df = new DecimalFormat("#.##");


    @Override
    public Map<String, Object> getBusinessInfo() {

        Map<String, Object> result = new HashMap<>(4);
        //查询交易总量
        double totalTrade = indentDAO.countTradeTotal();
        result.put("TOTALTRADE", totalTrade);

        //订单
        result.put("INDENT", getIndentsInfo());

        //商家
        result.put("SHOP", getShopInfo());

        //商品
        result.put("GOODS", getGoodsInfo());

        return result;
    }

    /**
     * 统计本周订单数量
     * @return 返回，统计结果
     */
    private BiDataDto getIndentsInfo() {
        BiDataDto result = new BiDataDto();
        int year, month;
        BiResultDto curWeek = indentDAO.countWeekIndents(CommonUtils.CURRENTYEAR, 0, CommonUtils.getDayOfMonth(CommonUtils.CURRENTYEAR, CommonUtils.CURRENTMONTH + 1)); //本周
        if(curWeek == null){
            result.setContent("本周暂无订单数据");
            result.setRate("0%");
            result.setUpOrDown(0);
        }else{
            year = CommonUtils.WEEK_OF_YEAR == 1 ? CommonUtils.CURRENTYEAR - 1 : CommonUtils.CURRENTYEAR;
            month = CommonUtils.WEEK_OF_YEAR == 1 ? 12 : CommonUtils.CURRENTMONTH + 1;
            BiResultDto lastWeek = indentDAO.countWeekIndents(CommonUtils.CURRENTYEAR, 1,CommonUtils.getDayOfMonth(year,month ));//上周
            result.setContent(String.valueOf(curWeek.getValue()));
            if(lastWeek == null){
                result.setRate("100%");
                result.setUpOrDown(1);
            }else{
                result.setRate(df.format((curWeek.getValue()-lastWeek.getValue())*1.0 / lastWeek.getValue()*100)+"%");
                result.setUpOrDown(curWeek.getValue() >= lastWeek.getValue() ? 1 : 0);
            }
        }
        return result;
    }

    /**
     * 统计入驻商家
     *
     * @return 返回，统计结果
     */
    private BiDataDto getShopInfo() {
        BiDataDto result = new BiDataDto();
        int year, month;
        BiResultDto curMonth = shopDAO.countMonthShops(CommonUtils.CURRENTYEAR, 0, CommonUtils.getDayOfMonth(CommonUtils.CURRENTYEAR, CommonUtils.CURRENTMONTH + 1));      //本月
        if (curMonth == null) {
            result.setContent("本月暂无入驻商家");
            result.setRate("0%");
            result.setUpOrDown(0);
        } else {
            year = CommonUtils.CURRENTMONTH == 0 ? CommonUtils.CURRENTYEAR - 1 : CommonUtils.CURRENTYEAR;
            month = CommonUtils.CURRENTMONTH == 0 ? 12 : CommonUtils.CURRENTMONTH + 1;
            BiResultDto lastMonth = shopDAO.countMonthShops(year, 1, CommonUtils.getDayOfMonth(year, month));  // 上一个月
            result.setContent(String.valueOf(curMonth.getValue()));
            if (lastMonth == null) {
                result.setRate("100%");
                result.setUpOrDown(1);
            } else {
                result.setRate(df.format((curMonth.getValue() - lastMonth.getValue()) * 1.0 / lastMonth.getValue() * 100) + "%");
                result.setUpOrDown(curMonth.getValue() >= lastMonth.getValue() ? 1 : 0);
            }
        }
        return result;
    }

    /**
     * 统计新增商品
     * @return 返回，统计结果
     */
    private BiDataDto getGoodsInfo(){
        BiDataDto result = new BiDataDto();
        int year, month;
        BiResultDto curWeek = goodsDAO.countWeekGoodses(CommonUtils.CURRENTYEAR, 0, CommonUtils.getDayOfMonth(CommonUtils.CURRENTYEAR, CommonUtils.CURRENTMONTH + 1)); //本周
        if(curWeek == null){
            result.setContent("本周暂无订单数据");
            result.setRate("0%");
            result.setUpOrDown(0);
        }else{
            year = CommonUtils.WEEK_OF_YEAR == 1 ? CommonUtils.CURRENTYEAR - 1 : CommonUtils.CURRENTYEAR;
            month = CommonUtils.WEEK_OF_YEAR == 1 ? 12 : CommonUtils.CURRENTMONTH + 1;
            BiResultDto lastWeek = goodsDAO.countWeekGoodses(CommonUtils.CURRENTYEAR, 1,CommonUtils.getDayOfMonth(year,month ));//上周
            result.setContent(String.valueOf(curWeek.getValue()));
            if(lastWeek == null){
                result.setUpOrDown(1);
                result.setRate("100%");
            }else{
                result.setRate(df.format((curWeek.getValue()-lastWeek.getValue())*1.0 / lastWeek.getValue()*100)+"%");
                result.setUpOrDown(curWeek.getValue() >= lastWeek.getValue() ? 1 : 0);
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> queryBusinessChart(int year, int month) {
        Map<String, Object> result = new HashMap<>();
        //查询图表数据
        List<BiResultDto> allIndents = indentDAO.countDailyIndentsByMonth(year, CommonUtils.getMonthSpan(year, month), null);   //订单总数
        List<BiResultDto> payedIndents = indentDAO.countDailyIndentsByMonth(year, CommonUtils.getMonthSpan(year, month), 1);    //付款订单数
        List<String> xAxis = new ArrayList<>(allIndents.size());
        Map<String, Object> chartResult = new HashMap<>(2);     //图表数据结果集

        //订单总数数据封装
        List<Integer> allIndentsCount = new ArrayList<>(allIndents.size());
        for (BiResultDto biResultDto : allIndents) {
            xAxis.add(biResultDto.getName().toString());
            allIndentsCount.add(biResultDto.getValue());
        }

        //付款订单数据封装
        List<Integer> payedIndentsCount = new ArrayList<>(payedIndents.size());
        for (BiResultDto biResultDto : payedIndents) {
            payedIndentsCount.add(biResultDto.getValue());
        }

        chartResult.put("allIndentsCount", allIndentsCount);
        chartResult.put("payedIndentsCount", payedIndentsCount);

        //右侧数据列表
        List<BiDataDto> dataList = new ArrayList<>(3);
        BiResultDto todayIndent = allIndents.get(allIndents.size() - 1);        //今天订单数据
        BiResultDto yesterdayIndent = allIndents.get(allIndents.size() - 2);    //昨天订单数据
        BiDataDto biDataDto = new BiDataDto();
        biDataDto.setTitle("今天订单数");
        biDataDto.setContent(String.valueOf(todayIndent.getValue()));
        biDataDto.setRate(df.format((todayIndent.getValue()-yesterdayIndent.getValue()) * 1.0 / yesterdayIndent.getValue()) + "%");
        biDataDto.setUpOrDown(todayIndent.getValue() >= yesterdayIndent.getValue()? 1 : 0);
        dataList.add(biDataDto);

        //查询近两个月的数据
//        List<BiResultDto> lastTowMonth = indentDAO.countLastTwoMonthIndentsAndSale();
//        //近一个月订单
//        biDataDto = new BiDataDto();
//        biDataDto.setTitle("近一个月订单");
//        biDataDto.setContent(String.valueOf(lastTowMonth.get(0).getValue()));
//        biDataDto.setRate(df.format(lastTowMonth.get(0).getValue() * 1.0 / lastTowMonth.get(1).getValue()) + "%");
//        biDataDto.setUpOrDown(lastTowMonth.get(0).getValue() > lastTowMonth.get(1).getValue() ? 1 : 0);
//        dataList.add(biDataDto);
//        //近一个月销售额
//        biDataDto = new BiDataDto();
//        biDataDto.setTitle("近一个月销售额");
//        biDataDto.setContent(String.valueOf(lastTowMonth.get(0).getTotal()));
//        biDataDto.setRate(df.format(lastTowMonth.get(0).getTotal() / lastTowMonth.get(1).getTotal()) + "%");
//        biDataDto.setUpOrDown(lastTowMonth.get(0).getTotal() > lastTowMonth.get(1).getTotal() ? 1 : 0);
//        dataList.add(biDataDto);

        //添加近一个月订单与销售总量
        dataList.addAll(getLastMonthIndentAndSale());

        //封装最终数据
        result.put("xAxis", xAxis);
        result.put("chartData", chartResult);
        result.put("dataList", dataList);
        return result;
    }

    /**
     * 获取近一个月的订单数据与销售总量数据
     * @return  返回，统计结果
     */
    private List<BiDataDto> getLastMonthIndentAndSale(){
        List<BiDataDto> result = new ArrayList<>(2);
        int year = CommonUtils.CURRENTMONTH == 0 ? CommonUtils.CURRENTYEAR -1: CommonUtils.CURRENTYEAR;
        //先统计出当前月份的数据
        BiResultDto curMonth = indentDAO.countMonthIndentsAndSale(CommonUtils.CURRENTYEAR, CommonUtils.getMonthSpan(CommonUtils.CURRENTYEAR, CommonUtils.CURRENTMONTH+ 1), CommonUtils.getDayOfMonth(CommonUtils.CURRENTYEAR, CommonUtils.CURRENTMONTH+ 1));
        //统计前一个月的数据
        BiResultDto lastMonth = indentDAO.countMonthIndentsAndSale(year, CommonUtils.getMonthSpan(year, CommonUtils.CURRENTMONTH+ 1), CommonUtils.getDayOfMonth(year, CommonUtils.CURRENTMONTH+ 1));

        //近一个月订单
        BiDataDto biDataDto = new BiDataDto();
        biDataDto.setTitle("近一个月订单");
        biDataDto.setContent(String.valueOf(curMonth.getValue()));
        biDataDto.setRate(df.format((curMonth.getValue() - lastMonth.getValue()) * 1.0 / lastMonth.getValue()) + "%");
        biDataDto.setUpOrDown(curMonth.getValue() >= lastMonth.getValue() ? 1 : 0);
        result.add(biDataDto);
        //近一个月销售额
        biDataDto = new BiDataDto();
        biDataDto.setTitle("近一个月销售额");
        biDataDto.setContent(String.valueOf(curMonth.getTotal()));
        biDataDto.setRate(df.format((curMonth.getTotal() - lastMonth.getTotal())/ lastMonth.getTotal()) + "%");
        biDataDto.setUpOrDown(curMonth.getTotal() > lastMonth.getTotal() ? 1 : 0);
        result.add(biDataDto);
        return result;
    }


    @Override
    public Map<String, Object> queryRanking() {
        Map<String, Object> result = new HashMap<>(2);
        //查询商家
        result.put("SHOPS", shopDAO.queryTopTen());
        //查询商品
        result.put("GOODS", goodsDAO.queryTopTen());
        return result;
    }

    @Override
    public Map<String, Object> queryTradesZoo() {
        List<BiResultDto> queryResult = indentDAO.queryTradeZoo();
        if (queryResult.size() == 0) {
            throw new BizException(ERRORCODE.NO_DATA.getCode(), ERRORCODE.NO_DATA.getMessage());
        }
        Map<String, Object> result = new HashMap<>();
        // 获取地区map
        Map<Integer, String> map = CommonUtils.getMap();

        //设置数据
        List<BiResultDto> data = new ArrayList<>(queryResult.size());
        BiResultDto biResultDto;
        for (BiResultDto item : queryResult) {
            if (map.containsKey(item.getName())) {
                biResultDto = new BiResultDto();
                biResultDto.setName(map.get(item.getName()));
                biResultDto.setValue(item.getValue());
                biResultDto.setTotal(item.getTotal());
                data.add(biResultDto);
            } else {
                throw new BizException(ERRORCODE.DIRTY_DATA.getCode(), ERRORCODE.DIRTY_DATA.getMessage());
            }
        }
        //获取订单数最大值
//        int max = 0;
//        Collections.sort(queryResult, new Comparator<BiResultDto>() {
//            @Override
//            public int compare(BiResultDto o1, BiResultDto o2) {
//                return o1.getValue() > o2.getValue() ? 0 : 1;
//            }
//        });
//        max = queryResult.get(0).getValue();
        result.put("data", data);
//        result.put("max", max);
        return result;
    }
}