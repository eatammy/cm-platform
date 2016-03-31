/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：验证模块：注册验证，修改密码验证，商店证验证以及其他认证验证（短信验证码验证）											
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

package cn.eatammy.cm.service.sys;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.common.service.IPageService;

/**
 * 《验证模块：注册验证，修改密码验证，商店证验证以及其他认证验证（短信验证码验证）》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IVerificationService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {

    /**
     * 根据手机号码发送短信
     *
     * @param username 用户名
     * @param type 短信类型，1：注册验证，2：找回密码验证，4：注册商店商店验证码
     * @return 返回操作码
     */
    String sendSMS(String username, int type);

    /**
     * 根据用户名校验合法性
     * @param username      用户名
     * @param verifiedCode  短信验证码
     * @param typeValue     短信类型
     * @return 返回，true：合法，false：不合法
     */
    boolean checkVerifiedCode(String username, String verifiedCode, int typeValue);
}