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
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.List;

/**
 * 《用户》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IUserDetailDAO extends ICMBaseDAO<UserDetail> {

    /**
     * 根据用户名修个密码
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateEx(@Param("username") String username, @Param("password") String password);

    /**
     * 修改用户详细信息
     *
     * @param user 用户修改参数
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateDetail(@Param("user") UserDetail user);

    /**
     * 更新粉丝数
     *
     * @param count 粉丝数量
     * @param id    当前用户id
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateFuns(@Param("count") int count, @Param("id") long id);

    /**
     * 更新粉丝数
     *
     * @param count 粉丝数量
     * @param id    当前用户id
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateAttentions(@Param("count") int count, @Param("id") long id);

    /**
     * 查询用户列表
     *
     * @param condition 条件
     * @param offset    偏移量
     * @param rows      页大小
     * @return 返回，用户列表
     */
    @DataSource("read")
    List<UserDetail> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 分页统计
     *
     * @param condition 条件
     * @return 返回，统计值
     */
    @DataSource("read")
    int countEx(@Param("condition") Map<String, Object> condition);

    /**
     * 根据用户id更新用户状态
     * @param id        用户id
     * @param status    状态，0：正常，1：停用
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateStatus(@Param("id") long id, @Param("status") int status);

    /**
     * 更具用户code更新用户密码
     * @param code          用户code
     * @param newPasswd     用户密码
     * @return  返回，0：失败，1：成功
     */
    @DataSource("write")
    int updatePasswdByCode(@Param("code") String code, @Param("newPasswd") String newPasswd);

    /**
     *  查询商店用户列表
     * @return 返回商店用户列表
     */
    @DataSource("read")
    List<UserDetail> queryUser4Shop();
}