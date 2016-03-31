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
import cn.eatammy.cm.param.user.UserDetailParam;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.BaseDomain;
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
     * @return 返回操作码
     */
    String isLogin(String username, String password, HttpSession session, HttpServletResponse response);

    /**
     * 用户注册
     * @param param         用户注册参数
     * @param verifiedCode  验证码
     * @param typeValue     短信类型，1：注册短信，2：找回密码短信，4：商店认证短信
     * @return  返回，操作码
     */
    String register(UserDetailParam param, String verifiedCode, int typeValue);

    /**
     * 根据某个字段判断是否存在用户
     * @param property  字段名
     * @param value     字段值
     * @return  返回，true：存在，false：不存在
     */
    boolean isExists(String property, Object value);
}