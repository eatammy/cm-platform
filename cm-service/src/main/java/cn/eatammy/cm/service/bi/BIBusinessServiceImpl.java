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
        BiDataDto biDataDto;
        BiResultDto curWeek;
        BiResultDto lastWeek;
        BiResultDto curMonth;
        BiResultDto lastMonth;
        //查询交易总量
        double totalTrade = indentDAO.countTradeTotal();
        result.put("TOTALTRADE", totalTrade);

        //订单
        curWeek = indentDAO.countWeekIndents(0);    //本周
        lastWeek = indentDAO.countWeekIndents(1);   //上一周
        biDataDto = new BiDataDto();
        biDataDto.setContent(String.valueOf(curWeek.getValue()));
        biDataDto.setRate(df.format(curWeek.getValue() * 1.0 / lastWeek.getValue()) + "%");
        biDataDto.setUpOrDown(curWeek.getValue() > lastWeek.getValue() ? 1 : 0);
        result.put("INDENT", biDataDto);

        //商家
        curMonth = shopDAO.countMonthShops(0);      //本月
        lastMonth = shopDAO.countMonthShops(1);     //上一个月
        biDataDto = new BiDataDto();
        biDataDto.setContent(String.valueOf(curMonth.getValue()));
        biDataDto.setRate(df.format(curMonth.getValue() * 1.0 / lastMonth.getValue()) + "%");
        biDataDto.setUpOrDown(curMonth.getValue() > lastMonth.getValue() ? 1 : 0);
        result.put("SHOP", biDataDto);

        //商品
        curWeek = goodsDAO.countWeekGoodses(0);     //本周
        lastWeek = goodsDAO.countWeekGoodses(1);    //上一周
        biDataDto = new BiDataDto();
        biDataDto.setContent(String.valueOf(curWeek.getValue()));
        biDataDto.setRate(df.format(curWeek.getValue() * 1.0 / curWeek.getValue()) + "%");
        biDataDto.setUpOrDown(curWeek.getValue() > lastWeek.getValue() ? 1 : 0);
        result.put("GOODS", biDataDto);

        return result;
    }

    @Override
    public Map<String, Object> queryBusinessChart(int year, int month) {
        Map<String, Object> result = new HashMap<>();
        month = CommonUtils.calendar.get(Calendar.MONTH) + 1 - month;
        //查询图表数据
        List<BiResultDto> allIndents = indentDAO.countDailyIndentsByMonth(year, month, null);   //订单总数
        List<BiResultDto> payedIndents = indentDAO.countDailyIndentsByMonth(year, month, 1);    //付款订单数
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
        BiDataDto biDataDto = new BiDataDto();
        biDataDto.setTitle("今天订单数");
        biDataDto.setContent(String.valueOf(allIndents.get(allIndents.size() - 1).getValue()));
        biDataDto.setRate(df.format(allIndents.get(allIndents.size() - 1).getValue() * 1.0 / allIndents.get(allIndents.size() - 2).getValue()) + "%");
        biDataDto.setUpOrDown(allIndents.get(allIndents.size() - 1).getValue() > allIndents.get(allIndents.size() - 2).getValue() ? 1 : 0);
        dataList.add(biDataDto);

        //查询近两个月的数据
        List<BiResultDto> lastTowMonth = indentDAO.countLastTwoMonthIndentsAndSale();
        //近一个月订单
        biDataDto = new BiDataDto();
        biDataDto.setTitle("近一个月订单");
        biDataDto.setContent(String.valueOf(lastTowMonth.get(0).getValue()));
        biDataDto.setRate(df.format(lastTowMonth.get(0).getValue() * 1.0 / lastTowMonth.get(1).getValue()) + "%");
        biDataDto.setUpOrDown(lastTowMonth.get(0).getValue() > lastTowMonth.get(1).getValue() ? 1 : 0);
        dataList.add(biDataDto);
        //近一个月销售额
        biDataDto = new BiDataDto();
        biDataDto.setTitle("近一个月销售额");
        biDataDto.setContent(String.valueOf(lastTowMonth.get(0).getTotal()));
        biDataDto.setRate(df.format(lastTowMonth.get(0).getTotal() / lastTowMonth.get(1).getTotal()) + "%");
        biDataDto.setUpOrDown(lastTowMonth.get(0).getTotal() > lastTowMonth.get(1).getTotal() ? 1 : 0);
        dataList.add(biDataDto);

        //封装最终数据
        result.put("xAxis", xAxis);
        result.put("chartData", chartResult);
        result.put("dataList", dataList);
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