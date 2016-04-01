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

package cn.eatammy.cm.dao.sys;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.sys.Verification;
import org.apache.ibatis.annotations.Param;

/**
 * 《验证模块：注册验证，修改密码验证，商店证验证以及其他认证验证（短信验证码验证）》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IVerificationDAO extends ICMBaseDAO<Verification> {

    /**
     * 获取最新的校验码
     * @param username      用户名
     * @param verifiedCode  短信验证码
     * @param type          短信类型，1：注册校验码，2：找回密码校验码，4：注册商家校验码
     * @return
     */
    Verification findOneEx(@Param("username") String username, @Param("verifiedCode") String verifiedCode, @Param("type") int type);

    /**
     * 根据id更新验证码状态
     * @param id    验证码id
     * @return 返回，0：失败，1：成功
     */
    int updateById(@Param("id") long id);
}