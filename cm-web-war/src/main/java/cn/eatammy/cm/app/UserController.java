package cn.eatammy.cm.app;

import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.param.user.UserDetailParam;
import cn.eatammy.cm.service.sys.IVerificationService;
import cn.eatammy.cm.service.user.IUserDetailService;
import cn.eatammy.common.utils.RETURNCODE;
import cn.eatammy.common.utils.User.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 郭旭辉 on 2016/3/14.
 * <p/>
 * 用户中心控制类
 */
@Controller
@RequestMapping("/cm/app/user")
public class UserController {

    @Autowired
    IUserDetailService userDetailService;
    @Autowired
    IVerificationService verificationService;


    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @param session
     * @param response
     * @return 返回，userBean
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDetail isLogin(String username, String password, HttpSession session, HttpServletResponse response) {
        return userDetailService.isLogin(username, password, session, response);
    }

    /**
     * 用户注册
     *
     * @param param        用户注册信息参数
     * @param verifiedCode 验证码
     * @param typeValue    验证码类型
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(UserDetailParam param, String verifiedCode, int typeValue) {
        return userDetailService.register(param, verifiedCode, typeValue);
    }

    /**
     * 获取验证码
     *
     * @param username  用户名
     * @param typeValue 短信值
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/getVerifiedCode", method = RequestMethod.POST)
    public String getVerifiedCode(String username, int typeValue) {
        return verificationService.sendSMS(username, typeValue);
    }

    /**
     * 校验短信验证码
     *
     * @param username     用户名
     * @param verifiedCode 短信验证码
     * @param typeValue    短信值
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkVerifiedCode")
    public String checkVerifiedCode(String username, String verifiedCode, int typeValue) {
        return RETURNCODE.REGISTER_SUCCESS.getMessage();
    }

    /**
     * 找回密码/修改密码
     * @param username      用户名
     * @param password      密码
     * @param verifiedCode  验证码
     * @param typeValue     短信值
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/forgetPassowd", method = RequestMethod.POST)
    public String forgetPassowd(String username, String password, String verifiedCode, int typeValue) {
        return userDetailService.forgetPasswd(username, password, verifiedCode, typeValue);
    }

    /**
     * 根据uid获取用户信息
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public UserDetail queryOne(String uid){
        return (UserDetail) userDetailService.findOne(UserDetailParam.F_ID,uid);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public UserDetail update(UserDetailParam param){
        return userDetailService.update(param, UserContext.getCurrentUser());
    }
}
