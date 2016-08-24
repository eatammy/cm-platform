/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：权限角色表											
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
import cn.eatammy.cm.domain.auth.AuthRole;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * 《权限角色》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IAuthRoleDAO extends ICMBaseDAO<AuthRole> {

    /**
     * 更新角色状态
     *
     * @param id        角色id
     * @param status    状态，0：启用，1：停用
     * @return  返回，1：成功，0：失败
     */
    @DataSource("write")
    int updateStatus(@Param("id") long id, @Param("status") int status);

    /**
     * 根据userCode和userType获取角色列表
     * @param userCode userCode(uid)
     * @param userType  用户身份值
     * @return  返回，角色列表
     */
    @DataSource("read")
    List<AuthRole> queryRoles(@Param("userCode")String userCode, @Param("userType")int userType);
}