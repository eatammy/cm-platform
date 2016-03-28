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
import cn.eatammy.cm.dao.sys.IVerificationDAO;
import cn.eatammy.cm.domain.sys.Verification;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.sms.client.JsonReqClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 《验证模块：注册验证，修改密码验证，商店证验证以及其他认证验证（短信验证码验证）》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("VerificationServiceImpl")
public class VerificationServiceImpl extends AbstractCMPageService<ICMBaseDAO<Verification>, Verification> implements IVerificationService<ICMBaseDAO<Verification>, Verification> {
    @Autowired
    private IVerificationDAO verificationDAO;

    @Override
    public ICMBaseDAO<Verification> getDao() {
        return verificationDAO;
    }

    private static final String ACCOUNTSID = "6660c7e8d6fac0828a9f1ab5a0416e08";
    private static final String TOKEN = "b67118bf2600eeb6efbe7fceca38920b";
    private static final String APPID = "ca8d40cb3cd94b8fbb75afddb389911b";
    private static final String TEMPLATEID = "22038";
    private static final String PARAM = ((int)(Math.random()*1000000))+",90";

    @Override
    public String sendSMS(String phone) {
        JsonReqClient jrc = new JsonReqClient();
        String result = jrc.templateSMS(ACCOUNTSID,TOKEN, APPID,TEMPLATEID,phone,PARAM);
        return result;
    }
}