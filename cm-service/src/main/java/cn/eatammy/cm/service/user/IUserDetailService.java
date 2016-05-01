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

package cn.eatammy.cm.service.user;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.param.user.UserDetailParam;
import cn.eatammy.cm.param.user.UserDetailParamEx;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.service.IPageService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 《用户》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IUserDetailService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {

    /**
     * 判断用户是否登录
     *
     * @param username 用户名
     * @param password 密码
     * @param session  session
     * @param response response
     * @return 返回, userbean
     */
    UserDetail isLogin(String username, String password, HttpSession session, HttpServletResponse response);

    /**
     * 注销
     *
     * @param session session
     * @return 返回操作码
     */
    String logout(HttpSession session);

    /**
     * 用户注册
     *
     * @param param        用户注册参数
     * @param verifiedCode 验证码
     * @param typeValue    短信类型，1：注册短信，2：找回密码短信，4：商店认证短信
     * @return 返回，操作码
     */
    String register(UserDetailParam param, String verifiedCode, int typeValue);

    /**
     * 找回密码
     *
     * @param username     用户名
     * @param password     新密码
     * @param verifiedCode 验证码
     * @param typeValue    短信类型，1：注册短信，2：找回密码短信，4：商店认证短信
     * @return 返回，操作码
     */
    String forgetPasswd(String username, String password, String verifiedCode, int typeValue);

    /**
     * 更新用户信息
     *
     * @param param       用户信息列表
     * @param currentUser 当前操作用户
     * @return 返回，最新用户实体
     */
    UserDetail update(UserDetailParam param, AccountDto currentUser);

    /**
     * 分页获取用户信息
     *
     * @param param    用户匹配参数
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 返回，分页
     */
    BizData4Page<UserDetail> queryPage(UserDetailParam param, int pageNo, int pageSize);

    /**
     * 根据某个字段判断是否存在用户
     *
     * @param property 字段名
     * @param value    字段值
     * @return 返回，true：存在，false：不存在
     */
    boolean isExists(String property, Object value);

    /**
     * 启用，停用用户
     *
     * @param id     用户id
     * @param status 用户状态，0：启用，1：停用
     * @return 返回操作码
     */
    String disableOrEnable(long id, int status);

    /**
     * 保存用户信息
     *
     * @param paramEx     用户信息参数
     * @param currentUser 当前用户
     * @return 返回，操作码
     */
    String add(UserDetailParamEx paramEx, AccountDto currentUser);

    /**
     * 更新用户信息
     * @param paramEx       用户信息参数
     * @param currentUser   当前用户
     * @return  返回，操作码
     */
    String update(UserDetailParamEx paramEx, AccountDto currentUser);

    /**
     * 更具用户code 重置用户密码
     * @param code  用户code
     * @return 返回， 新密码
     */
    String resetPasswd(String code);
}