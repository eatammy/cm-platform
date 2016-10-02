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
import cn.eatammy.cm.param.user.UserDetailParamEx;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.cm.service.sys.IVerificationService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.sys.filter.CMRequestFilter;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.MD5Utils;
import cn.eatammy.common.utils.PageUtils;
import cn.eatammy.common.utils.RETURNCODE;
import cn.eatammy.common.utils.http.HttpUtils;
import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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
    private static final String NICKNAME = "萌萌的的吃货" + new Date().getYear();


    @Override
    public UserDetail isLogin(String username, String password, HttpSession session, HttpServletResponse response) {
        UserDetail user = findOne(UserDetailParam.F_Username, username);
        if (user == null) {
            throw new BizException(ERRORCODE.ACCOUNT_ILLEGAL.getCode(), ERRORCODE.ACCOUNT_ILLEGAL.getMessage());
        } else if (user.getPassword().equalsIgnoreCase(MD5Utils.getMD5(password + MD5Utils.SALT))) {
            //验证通过
            String token = MD5Utils.getToken(username, password);
            //设置session
            HttpUtils.generalUserSession(session, user, token, 2 * 60 * 60);
            //设置cookie
            HttpUtils.setCookie(response, token, 2 * 60 * 60);
            //设置缓存
//            UserContext.initUser();
            return user;
        } else {
            //登录验证未通过，自动转化为系统异常
            throw new RuntimeException();
        }
    }

    @Override
    public AccountDto isLogin( HttpServletRequest request, HttpServletResponse response) {
        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(!StringUtils.isEmpty(exceptionClassName)){
            if(UnknownAccountException.class.getName().equals(exceptionClassName)){
                throw new BizException(ERRORCODE.ACCOUNT_ILLEGAL.getCode(), ERRORCODE.ACCOUNT_ILLEGAL.getMessage());
            }else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
                throw new BizException(ERRORCODE.ACCOUNT_PASSWD_UNMATCH.getCode(), ERRORCODE.ACCOUNT_PASSWD_UNMATCH.getMessage());
            }else {//未知异常
                throw new RuntimeException();
            }
        }
        //从shiro的session给货品获取到session并进行设置
        Subject subject = SecurityUtils.getSubject();
        //得到用户信息
        AccountDto accountDto = (AccountDto) subject.getPrincipal();

        //生产token
        String token = MD5Utils.getToken(accountDto.getUsername(), accountDto.getPassword());
        accountDto.setToken(token);
        Session session = subject.getSession();
        session.setAttribute(token, accountDto);
        //设置cookie
        HttpUtils.setCookie(response, token, 60 * 60);
        return  accountDto;
    }

    @Override
    public String initUser(String uid, Integer userType) {
        //从shiro的session给货品获取到session并进行设置
        Subject subject = SecurityUtils.getSubject();
        //得到用户信息
        String token = ((AccountDto) subject.getPrincipal()).getToken();
        Session session = subject.getSession();
        AccountDto accountDto = (AccountDto) session.getAttribute(token);
        if (accountDto.getUid().equals(uid)) {
            accountDto.setUserType(userType);
        } else {
            throw new BizException(ERRORCODE.INITIAL_EXC.getCode(), "用户" + ERRORCODE.INITIAL_EXC.getMessage());
        }
        session.setAttribute(token, accountDto);
        return RETURNCODE.SUCCESS_COMPLETE.getMessage();
    }

    @Override
    public String logout(HttpSession session) {
        HttpServletRequest request = CMRequestFilter.getRequest();
        //获取access_token
        Cookie cookie = HttpUtils.getCookie(request.getCookies(), HttpUtils.ACCESS_TOKEN);
        if (cookie != null) {
            //清除session
            session.removeAttribute(cookie.getValue());
        }
        return RETURNCODE.LOGOUT_SUCCESS.getMessage();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String register(UserDetailParam param, String verifiedCode, int typeValue) {
        if (verificationService.checkVerifiedCode(param.getUsername(), verifiedCode, typeValue)) {
            UserDetail user = new UserDetail();
            if (StringUtils.isEmpty(param.getNickname())) {
                user.setNickname(NICKNAME);
            }
            user.setUsername(param.getUsername());
            user.setPassword(MD5Utils.getMD5(param.getPassword() + MD5Utils.SALT));
            user.setCreator(CREATOR);
            user.setCreateDate(System.currentTimeMillis());
            user.setStatus(0);
            insert(user);
            return RETURNCODE.REGISTER_SUCCESS.getMessage();
        } else {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String forgetPasswd(String username, String password, String verifiedCode, int typeValue) {
        if (verificationService.checkVerifiedCode(username, verifiedCode, typeValue)) {
            password = MD5Utils.getMD5(password + MD5Utils.SALT);
            userDetailDAO.updateEx(username, password);
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        } else {
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
        } catch (Exception e) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    @Override
    public BizData4Page<UserDetail> queryPage(UserDetailParam param, int pageNo, int pageSize) {
        List<UserDetail> data = userDetailDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        int records = userDetailDAO.countEx(param.toMap());
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }

    @Override
    public boolean isExists(String property, Object value) {
        return this.findOne(property, value) != null;
    }

    @Override
    public String add(UserDetailParamEx paramEx, AccountDto currentUser) {
        if (!isExists(paramEx.F_Username, paramEx.getUsername())) {
            UserDetail userDetail = new UserDetail();
            userDetail.setUsername(paramEx.getUsername());
            userDetail.setPassword(MD5Utils.getMD5(paramEx.getPassword() + MD5Utils.SALT));
            userDetail.setHeadIcon(paramEx.getHeadIcon());
            userDetail.setPhone(paramEx.getPhone());
            userDetail.setAddress(paramEx.getAddress());
            userDetail.setNickname(paramEx.getNickname());
            userDetail.setSex(paramEx.getSex());
            userDetail.setCode(paramEx.getCode());
            userDetail.setUserTypes(getUserTypes(paramEx.getUserType()));
            userDetail.setDescription(paramEx.getDescription());
            userDetail.setCreator(currentUser.getUid());
            userDetail.setCreateDate(System.currentTimeMillis());
            userDetail.setStatus(0);
            userDetail.setFuns(0);
            userDetail.setAttentions(0);
            userDetail.setScore(0);
            if (userDetailDAO.insert(userDetail) == 1) {
                return RETURNCODE.ADD_COMPLETE.getMessage();
            }
        }
        throw new BizException(ERRORCODE.ACCOUNT_EXISTS.getCode(), ERRORCODE.ACCOUNT_EXISTS.getMessage());

    }

    @Override
    public String addUsers(List<UserDetail> userDetails) {
        if(userDetailDAO.addUsers(userDetails) > 0){
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String update(UserDetailParamEx paramEx, AccountDto currentUser) {
        paramEx.setLastModDate(System.currentTimeMillis());
        paramEx.setLastModifier(currentUser.getUid());
        paramEx.setUserTypes(getUserTypes(paramEx.getUserType()));
        paramEx.setPassword(MD5Utils.getMD5(paramEx.getPassword() + MD5Utils.SALT));
        if (userDetailDAO.updateMap(paramEx.toMap()) == 1) {
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String disableOrEnable(long id, int status) {
        if (userDetailDAO.updateStatus(id, status) == 1) {
            return RETURNCODE.SUCCESS_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String resetPasswd(String code) {
        String newPasswd = "";
        while (newPasswd.length() < 6) {
            newPasswd = (int) (Math.random() * 1000000) + "";
        }
        if (userDetailDAO.updatePasswdByCode(code, MD5Utils.getMD5(newPasswd + MD5Utils.SALT)) == 1) {
            return newPasswd;
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    private int getUserTypes(Integer[] userType) {
        int sum = 0;
        for (Integer i : userType) {
            sum += i;
        }
        return sum;
    }

    @Override
    public List<UserDetail> queryUser4Shop() {
        return userDetailDAO.queryUser4Shop();
    }

    @Override
    public UserDetail getRandomUser() {
        return userDetailDAO.getRandomUser();
    }

    //    @Override
//    public List<BiResultDto> queryUserMap() {
//        return userDetailDAO.queryUserMap();
//    }
}