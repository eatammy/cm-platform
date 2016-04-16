package cn.eatammy.cm.controller.user;

import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.service.user.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ResponseBody
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        return userDetailService.logout(session);
    }
}
