/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户角色表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-08-09  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.dao.auth;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.auth.AuthRoleUser;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《用户角色》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IAuthRoleUserDAO extends ICMBaseDAO<AuthRoleUser> {


    /**
     * 根据字段批量删除
     * @param property  字段
     * @param values    字段值集合
     * @return  返回，非零：成功操作条数，0：失败
     */
    @DataSource("write")
    int deleteBatchByProperty(@Param("property") String property, @Param("list") List<Object> values);

    /**
     * 查询角色列表（当前用户身份的角色列表，包括回显已选角色）
     * @param userCode  用户code（用户uid）
     * @param userType  当前用户身份值
     * @return  返回，用户角色列表
     */
    @DataSource("read")
    List<String> querySelectedRoles(@Param("userCode") String userCode, @Param("userType") int userType);

    /**
     * 批量导入用户角色关系
     * @param authRoleUsers 用户角色关系列表
     * @return  返回。非零：成功导入的条数，0：失败
     */
    @DataSource("write")
    int insertBatch(@Param("list") List<AuthRoleUser> authRoleUsers);

}