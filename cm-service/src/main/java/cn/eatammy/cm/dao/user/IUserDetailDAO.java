/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：用户表											
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

package cn.eatammy.cm.dao.user;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.user.UserDetail;
import org.apache.ibatis.annotations.Param;

/**
 * 《用户》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IUserDetailDAO extends ICMBaseDAO<UserDetail> {

    /**
     * 根据用户名修个密码
     * @param username  用户名
     * @param password  密码
     * @return 返回，0：失败，1：成功
     */
    int updateEx(@Param("username") String username, @Param("password") String password);

    /**
     * 修改用户详细信息
     * @param user  用户修改参数
     * @return  返回，0：失败，1：成功
     */
    int updateDetail(@Param("user") UserDetail user);
}