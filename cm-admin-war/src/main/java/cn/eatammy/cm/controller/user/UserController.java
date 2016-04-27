package cn.eatammy.cm.controller.user;

import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.param.user.UserDetailParam;
import cn.eatammy.cm.service.user.IUserDetailService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.sms.SMSTYPE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 郭旭辉 on 2016/3/25.
 * 管理用户控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/user")
public class UserController {

    @Autowired
    private IUserDetailService  userDetailService;

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
     * 注销
     * @param session session
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        return userDetailService.logout(session);
    }

    /**
     * 找回密码
     * @param username      用户名
     * @param password      密码
     * @param verifiedCode  验证码
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/forgetPassword")
    public String forgetPassword(String username, String password, String verifiedCode){
        return userDetailService.forgetPasswd(username, password,verifiedCode, SMSTYPE.FORGET_PASSWD_SMS.getTypeValue());
    }

    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<UserDetail> queryPage(UserDetailParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int pageSize){

    }
}
