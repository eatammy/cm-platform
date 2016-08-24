package cn.eatammy.common.utils.User;

import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.sys.filter.CMRequestFilter;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.http.HttpUtils;
import org.apache.shiro.SecurityUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 郭旭辉 on 2016/3/21.
 * 用户上下文
 */
public class UserContext {

//    private  static  ThreadLocal<AccountDto> context = new ThreadLocal<>();


//    public static void initUser(){
//        HttpServletRequest request = CMRequestFilter.getRequest();
//        String url = request.getRequestURI();
//        if (url.contains("login")){
//
//        }
//        //获取access_token
//        Cookie cookie = HttpUtils.getCookie(request.getCookies(),HttpUtils.ACCESS_TOKEN);
//        String token = cookie.getValue();
//        UserDetail userDetail = (UserDetail) request.getSession().getAttribute(token);
//        if (userDetail != null){
//            AccountDto accountDto = setAccount(userDetail);
//            IUserContext userContext = new DefaultUserContextImpl();
//            Map<String, Object> datas = new HashMap<>(4);
//            datas.put(IUserContext.UID, accountDto.getUid());
//            ((DefaultUserContextImpl) userContext).setContexts(datas);
//            UserContextHolder.setUserContext(userContext);
//        }
//        setCurrentUser(setAccount(userDetail));
//    }

    /**
     * 更新当前用户
     * @return
     */
    public static AccountDto refreshUser(){
        return null;
    }

    /**
     * 获取当前用户
     * @return 返回 AccountDto
     */
    public static AccountDto getCurrentUser(){
        HttpServletRequest request = CMRequestFilter.getRequest();
        //获取access_token
        Cookie cookie = HttpUtils.getCookie(request.getCookies(),HttpUtils.ACCESS_TOKEN);
        if (cookie != null){
            String token = cookie.getValue();
            AccountDto accountDto = (AccountDto) SecurityUtils.getSubject().getSession().getAttribute(token);
//            UserDetail userDetail = (UserDetail) request.getSession().getAttribute(token);
            if (accountDto != null){
                return accountDto;
            }else {
                throw new BizException(ERRORCODE.ILLEGAL_LOGIN.getCode(), ERRORCODE.ILLEGAL_LOGIN.getMessage());
            }
        }else {
            throw new BizException(ERRORCODE.ILLEGAL_LOGIN.getCode(), ERRORCODE.ILLEGAL_LOGIN.getMessage());
        }

    }

    /**
     * 设置当前用户
     * @param user
     */
//    public static void setCurrentUser(AccountDto user){
//        //缓存记录
//        context.set(user);
//    }

    /**
     * 移除当前用户
     */
//    public static void removeCurrentUser(){
//        context.remove();
//    }

    private static AccountDto setAccount(UserDetail userDetail){
        AccountDto accountDto = new AccountDto();
        accountDto.setUid(userDetail.getCode());
        accountDto.setUsername(userDetail.getUsername());
        accountDto.setPassword(userDetail.getPassword());
        accountDto.setPhone(userDetail.getPhone());
        accountDto.setAddress(userDetail.getAddress());
        accountDto.setNickname(userDetail.getNickname());
        accountDto.setSex(userDetail.getSex());
        accountDto.setHeadIcon(userDetail.getHeadIcon());
        accountDto.setFuns(userDetail.getFuns());
        accountDto.setAttentions(userDetail.getAttentions());
        accountDto.setScore(userDetail.getScore());
        accountDto.setIdCard(userDetail.getIdCard());
        accountDto.setIdCardPic(userDetail.getIdCardPic());
        return accountDto;
    }
}
