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
import cn.eatammy.cm.dao.user.IUserDetailDAO;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.param.user.UserDetailParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.cm.service.sys.IVerificationService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.MD5Utils;
import cn.eatammy.common.utils.RETURNCODE;
import cn.eatammy.common.utils.http.HttpUtils;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 《用户》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("UserDetailServiceImpl")
public class UserDetailServiceImpl extends AbstractCMPageService<ICMBaseDAO<UserDetail>, UserDetail> implements IUserDetailService<ICMBaseDAO<UserDetail>, UserDetail> {
    @Autowired
    private IUserDetailDAO userDetailDAO;
    @Autowired
    private IVerificationService verificationService;

    @Override
    public ICMBaseDAO<UserDetail> getDao() {
        return userDetailDAO;
    }

    private static final String CREATOR = "ADMIN";
    private static final String NICKNAME = "萌萌的的吃货"+new Date().getYear();


    @Override
    public UserDetail isLogin(String username, String password, HttpSession session, HttpServletResponse response) {
        UserDetail user = findOne(UserDetailParam.F_Username, username);
        if (user == null) {
            throw new BizException(ERRORCODE.ACCOUNT_ILLEGAL.getCode(), ERRORCODE.ACCOUNT_ILLEGAL.getMessage());
        } else if (user.getPassword().equalsIgnoreCase(MD5Utils.getMD5(password + MD5Utils.SALT))) {
            //验证通过
            String token = MD5Utils.getToken(username, password);
            //设置session
            HttpUtils.generalUserSession(session, user, token, 30 * 60);
            //设置cookie
            HttpUtils.setCookie(response, token, 30 * 60);
            //设置缓存
//            UserContext.initUser();
            return user;
        } else {
            //登录验证未通过，自动转化为系统异常
            throw new RuntimeException();
        }
    }

    @Override
    public String register(UserDetailParam param, String verifiedCode, int typeValue) {
        if (verificationService.checkVerifiedCode(param.getUsername(),verifiedCode,typeValue)){
            UserDetail user = new UserDetail();
            if (StringUtils.isEmpty(param.getNickname())){
                user.setNickname(NICKNAME);
            }
            user.setUsername(param.getUsername());
            user.setPassword(MD5Utils.getMD5(param.getPassword()+MD5Utils.SALT));
            user.setCreator(CREATOR);
            user.setCreateDate(System.currentTimeMillis());
            user.setStatus(0);
            insert(user);
            return RETURNCODE.REGISTER_SUCCESS.getMessage();
        }else {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    @Override
    public String forgetPasswd(String username, String password, String verifiedCode, int typeValue) {
        if(verificationService.checkVerifiedCode(username,verifiedCode,typeValue)){
            password = MD5Utils.getMD5(password+MD5Utils.SALT);
            userDetailDAO.updateEx(username, password);
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }else{
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    @Override
    public UserDetail update(UserDetailParam param, AccountDto currentUser) {
        try {
            UserDetail userDetail = new UserDetail();
            userDetail.setNickname(param.getNickname());
            userDetail.setPhone(param.getPhone());
            userDetail.setStatus(0);
            userDetail.setAddress(param.getAddress());
            userDetail.setDescription(param.getDescription());
            userDetail.setLastModifier(currentUser.getUid());
            userDetail.setLastModifier(System.currentTimeMillis());
            userDetail.setId(param.getId());
            userDetail.setSex(param.getSex());
            userDetail.setHeadIcon(param.getHeadIcon());
            userDetailDAO.updateDetail(userDetail);
            return userDetail;
        } catch (Exception e){
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    @Override
    public boolean isExists(String property, Object value) {
        return this.findOne(property,value) == null ? false : true;
    }
}