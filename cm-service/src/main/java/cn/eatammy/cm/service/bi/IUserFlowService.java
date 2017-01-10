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

import cn.eatammy.cm.domain.bi.UserFlow;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.service.IPageService;

import java.util.List;
import java.util.Map;

/**
 * 《用户行为流量监控》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IUserFlowService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {


    /**
     * 批量增加用户流量（生产数据）
     *
     * @param userFlows 流量列表
     * @return 操作码
     */
    String addUserFlows(List<UserFlow> userFlows);


    /**
     * 查询用户分布地图（分析）
     *
     * @param sex    性别，-1：默认，0：男，1：女
     * @param minAge 最小年龄
     * @param maxAge 最大年龄
     * @return 返回，用户地图分布
     */
    Map<String, Object> queryUserMap(Integer sex, Integer minAge, Integer maxAge);

    /**
     * 统计历史注册总量，日注册量，周注册量，月注册量
     *
     * @return 返回，注册结果
     */
    Map<String, Object> getRegisterInfo();

    /**
     * 获取注册情况（分析统计）
     *
     * @param year  年份
     * @param month 月份
     * @return 返回，数据视图
     */
    Map<String, Object> getRegisterCharts(Integer year, Integer month);

    /**
     * 获取统计数据视图
     * @return  返回，统计结果集合
     */
    Map<String, Object> getStatisticalData();

    /**
     * 获取用户活动视图（分析统计）
     *
     * @param type  统计类型：0：每月访客，1：每月活跃用户，2：设备统计
     * @param month 月份
     * @param year  年份
     * @param isDefault  是否默认选项
     * @return 返回，数据视图
     */
    Map<String, Object> getUserCharts(Integer type, Integer month, Integer year, Integer isDefault);
}