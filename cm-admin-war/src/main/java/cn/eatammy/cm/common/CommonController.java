package cn.eatammy.cm.common;

import cn.eatammy.cm.service.user.IUserDetailService;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 郭旭辉 on 2016/3/25.
 * 公用请求控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/common")
public class CommonController {

    @Autowired
    private IUserDetailService userDetailService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public  String Login(HttpServletResponse response, HttpSession session,String username, String password){
        userDetailService.isLogin(username, password, session, response);
        return RETURNCODE.LOGIN_SUCCESS.getMessage();
    }
}
