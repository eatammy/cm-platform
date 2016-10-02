/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：订单											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-14  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.dao.business;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.bi.BiResultDto;
import cn.eatammy.cm.domain.business.Indent;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 《订单》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IIndentDAO extends ICMBaseDAO<Indent> {


    /**
     * 统计本年交易总量
     * @return 返回，交易总量值
     */
    @DataSource("read")
    double countTradeTotal();

    /**
     * 查询某一周的订单统计
     * @param week 周，0：表示当前周，1：表示上一周，-1：表示下一周，以此类推2：表示前周，-2：后周
     * @return 返回，统计结果
     */
    @DataSource("read")
    BiResultDto countWeekIndents(int week);

    /**
     * 统计某年某月每天的订单
     * @param year 年份
     * @param month 月份，0：表示当前月份，1：表示上一个月，-1：表示下个月，以此类推：2：表示前个月，-2：表示下个月
     * @param isTraded 交易完成标记，0：为付款，1：已付款
     * @return  返回，统计结果
     */
    @DataSource("read")
    List<BiResultDto> countDailyIndentsByMonth(@Param("year") int year, @Param("month") int month, @Param("isTraded") Integer isTraded);

    /**
     * 查询近连个月订单数和销售额
     * @return  返回，统计结果
     */
    @DataSource("read")
    List<BiResultDto> countLastTwoMonthIndentsAndSale();

    /**
     * 查询交易地区统计
     * @return  返回，交易地区数据集合
     */
    @DataSource("read")
    List<BiResultDto> queryTradeZoo();
}