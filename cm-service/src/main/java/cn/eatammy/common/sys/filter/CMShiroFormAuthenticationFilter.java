package cn.eatammy.common.sys.filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by 郭旭辉 on 2016/8/9.
 *
 */
public class CMShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
//        String username = request.getParameter(UserDetailParam.F_Username);
//        String password = request.getParameter(UserDetailParam.F_Password);
//        HttpServletRequest request1 = (HttpServletRequest) request;
//        HttpServletResponse response1 = (HttpServletResponse) response;
//        AccountDto accountDto = userDetailServicel.isLogin(username, password, request1, response1);
//        issueSuccessRedirect(request, response);
        return true;
    }
}
