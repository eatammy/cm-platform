package cn.eatammy.common.utils.User;

import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.sys.filter.CMRequestFilter;
import cn.eatammy.common.utils.http.HttpUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 郭旭辉 on 2016/3/21.
 * 用户上下文
 */
public class UserContext {

    private  static  ThreadLocal<AccountDto> context = new ThreadLocal<>();


    public static void initUser(){
        HttpServletRequest request = CMRequestFilter.getRequest();
        //获取access_token
        Cookie cookie = HttpUtils.getCookie(request.getCookies(),HttpUtils.ACCESS_TOKEN);
        String token = cookie.getValue();
        UserDetail userDetail = (UserDetail) request.getSession().getAttribute(token);
//        if (userDetail != null){
//            AccountDto accountDto = setAccount(userDetail);
//            IUserContext userContext = new DefaultUserContextImpl();
//            Map<String, Object> datas = new HashMap<>(4);
//            datas.put(IUserContext.UID, accountDto.getUid());
//            ((DefaultUserContextImpl) userContext).setContexts(datas);
//            UserContextHolder.setUserContext(userContext);
//        }
        setCurrentUser(setAccount(userDetail));
    }

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
        return context.get();
    }

    /**
     * 设置当前用户
     * @param user
     */
    public static void setCurrentUser(AccountDto user){
        //缓存记录
        context.set(user);
    }

    /**
     * 移除当前用户
     */
    public static void removeCurrentUser(){
        context.remove();
    }

    private static AccountDto setAccount(UserDetail userDetail){
        AccountDto accountDto = new AccountDto();
        accountDto.setUid(userDetail.getId());
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
        accountDto.setStudent(userDetail.getIsStudent());
        accountDto.setStudentId(userDetail.getStudentId());
        accountDto.setStudentPic(userDetail.getStudentPic());
        accountDto.setIdCard(userDetail.getIdCard());
        accountDto.setIdCardPic(userDetail.getIdCardPic());
        return accountDto;
    }
}
