/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商城活动											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-05-18  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.dao.activity;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.activity.BusinessActivicty;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《商城活动》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IBusinessActivictyDAO extends ICMBaseDAO<BusinessActivicty> {

    /**
     * 分页查询
     *
     * @param condition 查询参数
     * @param offset    偏移量
     * @param rows      行数
     * @return 返回，分页列表
     */
    @DataSource("read")
    List<BusinessActivicty> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") long offset, @Param("rows") long rows);

    /**
     * 分页统计
     *
     * @param condition 查询参数
     * @return 返回，统计结果
     */
    @DataSource("read")
    int countEx(@Param("condition") Map<String, Object> condition);

    /**
     * 启用或停用分活动
     * @param id        活动id
     * @param status    活动状态， 0：启用，1：停用
     * @return  返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateStatus(@Param("id") long id, @Param("status")int status);
}