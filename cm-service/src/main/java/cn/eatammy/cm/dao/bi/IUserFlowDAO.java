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

package cn.eatammy.cm.dao.bi;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.bi.BiResultDto;
import cn.eatammy.cm.domain.bi.UserFlow;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《用户行为流量监控》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IUserFlowDAO extends ICMBaseDAO<UserFlow> {


    /**
     * 记录用户流量
     * @param userFlows     用户流量实体
     * @return  返回，0：失败，1：成功
     */
    @DataSource("write")
    int addUserFlows(@Param("list") List<UserFlow> userFlows);


    /**
     * 统计每个月每天用户的访问量
     * @param year  年份
     * @param month 月份，0，表示当前月份，递增表示往前的月份，如1，表示上个月，2表示前个月
     * @param day   天数
     * @param offset 偏移量
     * @param rows 行号
     * @return  一年中每个月的用户访问量集合
     */
    @DataSource("read")
    List<BiResultDto> countMonthPV(@Param("year") Integer year, @Param("month") Integer month, @Param("day") Integer day, @Param("offset") Integer offset, @Param("rows") Integer rows);



    /**
     * 统计近的用户活跃量（男女）
     * @param day 天
     * @return 返回，近一月的活跃用户统计量
     */
    @DataSource("read")
    List<BiResultDto> countMonthActivePV(@Param("day") Integer day);

    /**
     * 统计年龄区间段的用户活跃量（年龄区间）
     * @param year      年份
     * @param month     月份，0，表示当前月份，递增表示往前的月份，如1，表示上个月，2表示前个月
     * @param day       天数
     * @param minAge    最小年龄
     * @param maxAge    最大年龄
     * @return  返回，近一个月不同该年龄段的活跃用户统计量
     */
    @DataSource("read")
    List<BiResultDto> countAgeRangeActivePV(@Param("year") Integer year, @Param("month")Integer month, @Param("day") Integer day, @Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

    /**
     * 统计当前月各种设备的访问量
     * @param year   年份
     * @param month  月份，0，表示当前月份，递增表示往前的月份，如1，表示上个月，2表示前个月
     * @param day    天数
     * @return  返回，统计结果
     */
    @DataSource("read")
    List<BiResultDto> countDevicePV(@Param("year")Integer year, @Param("month") Integer month, @Param("day") Integer day);

    /**
     * 查询最后两个月的活跃用户
     * @param year      年份
     * @param month     0，表示当前月份，递增表示往前的月份，如1，表示上个月，2表示前个月
     * @param offset    偏移量
     * @param rows      行号
     * @return  返回，统计结果列表
     */
    @DataSource("read")
    List<BiResultDto> countLastTowMonthActivePV(@Param("year")Integer year, @Param("month")Integer month, @Param("offset")Integer offset, @Param("rows")Integer rows);

    /**
     * 统计某个月份的活跃用户量
     * @param year      年份
     * @param month     0，表示当前月份，递增表示往前的月份，如1，表示上个月，2表示前个月
     * @return 返回统计结果
     */
    @DataSource("read")
    BiResultDto countMonthActivePv(@Param("year") Integer year, @Param("month") Integer month);

}