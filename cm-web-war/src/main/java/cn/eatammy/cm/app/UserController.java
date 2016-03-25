package cn.eatammy.cm.app;

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
 *
 * 用户中心控制类
 */
@Controller
@RequestMapping("/cm/app/user")
public class UserController {

    @Autowired
    IUserDetailService userDetailService;


    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String isLogin(String username, String password, HttpSession session, HttpServletResponse response){
        userDetailService.isLogin(username, password, session, response);
        return RETURNCODE.SUCCESS_COMPLETE.getMessage();
    }


    @ResponseBody
    @RequestMapping(value="/test")
    public String test(){
        return UserContext.getCurrentUser().getUsername();
    }

}
