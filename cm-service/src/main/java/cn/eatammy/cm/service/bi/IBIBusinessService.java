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

import java.util.Map;

/**
 * 平台商务BI分析 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IBIBusinessService{

    /**
     * 查询统计数据面板
     * @return  返回，统计信息集合
     */
    Map<String, Object> getBusinessInfo();

    /**
     * 查询订单图表
     * @param year      年份
     * @param month     月份，0：表示当前月份，1：表示下个月，以此类推
     * @return  返回，图表信息
     */
    Map<String, Object> queryBusinessChart(int year, int month);

    /**
     * 查询商店销售额和商品销售量排行榜
     * @return  返回，排行榜信息
     */
    Map<String, Object> queryRanking();

    /**
     * 获取交易地区
     * @return 返回，信息集合
     */
    Map<String, Object> queryTradesZoo(Integer year, Integer month);

    /**
     * 根据商店code统计某个商店过去一个月的订单情况
     * @param shopCode 商店代码
     * @return 返回，统计情况
     */
    Map<String,Object> queryIndents4Shop(String shopCode);

    /**
     * 根据商店代码统计商店的销售情况
     * @param shopCode  商店代码
     * @return 返回，统计情况
     */
    Map<String,Object> querySales4Shop(String shopCode);
}