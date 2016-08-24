package cn.eatammy.cm.controller.user;

import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.param.user.UserDetailParam;
import cn.eatammy.cm.param.user.UserDetailParamEx;
import cn.eatammy.cm.service.user.IUserDetailService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.qiniu.BucketEnum;
import cn.eatammy.common.qiniu.BucketManagerService;
import cn.eatammy.common.sms.SMSTYPE;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.RETURNCODE;
import cn.eatammy.common.utils.User.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 郭旭辉 on 2016/3/25.
 * 管理用户控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/user")
public class UserController {

    @Autowired
    private IUserDetailService userDetailService;

    @Autowired
    private BucketManagerService bucketManagerService;

//    /**
//     * 用户登录
//     *
//     * @param username 用户名
//     * @param password 密码
//     * @param session
//     * @param response
//     * @return 返回，userBean
//     */
//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public UserDetail isLogin(String username, String password, HttpSession session, HttpServletResponse response) {
//        return userDetailService.isLogin(username, password, session, response);
//    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public AccountDto isLogin( HttpServletRequest request, HttpServletResponse response) {
        return userDetailService.isLogin(request, response);
    }

    @ResponseBody
    @RequestMapping(value="/initUser")
    public String initUser(@RequestParam(required = true) String uid, @RequestParam(required = true) Integer userType){
        return userDetailService.initUser(uid, userType);
    }


    /**
     * 注销
     *
     * @param session session
     * @return 返回，操作码
     */
//    @ResponseBody
//    @RequestMapping(value = "/logout")
//    public String logout(HttpSession session) {
//        return userDetailService.logout(session);
//    }

    /**
     * 找回密码
     *
     * @param username     用户名
     * @param password     密码
     * @param verifiedCode 验证码
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/forgetPassword")
    public String forgetPassword(String username, String password, String verifiedCode) {
        return userDetailService.forgetPasswd(username, password, verifiedCode, SMSTYPE.FORGET_PASSWD_SMS.getTypeValue());
    }

    /**
     * 分页查询
     *
     * @param param    条件
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 返回，分页结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page queryPage(UserDetailParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return userDetailService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 保存用户
     *
     * @param paramEx 用户新增参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(UserDetailParamEx paramEx) {
        return userDetailService.add(paramEx, UserContext.getCurrentUser());
    }

    /**
     * 查找一个
     *
     * @param id 用户id
     * @return 返回，用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public UserDetail queryOne(long id) {
        return (UserDetail) userDetailService.findOne(UserDetailParam.F_ID, id);
    }

    /**
     * 更新用户信息
     *
     * @param paramEx 用户信息
     * @return 返回参数列表
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public String update(UserDetailParamEx paramEx) {
        return userDetailService.update(paramEx, UserContext.getCurrentUser());
    }

    /**
     * 根据用户code更新用户密码
     * @param code  用户code
     * @return  返回，用户密码
     */
    @ResponseBody
    @RequestMapping(value = "/resetPasswd")
    public String resetPasswd(String code){
        return userDetailService.resetPasswd(code);
    }

    /**
     * 单条删除
     *
     * @param id 用户id
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(long id) {
        if (userDetailService.deleteById(id) == 1) {
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        } else {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 批量删除
     *
     * @param ids id列表
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public String deleteByIds(Long[] ids) {
        if (userDetailService.deleteByIds(Arrays.asList(ids)) != 0) {
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        } else {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 启用， 停用用户
     *
     * @param id     用户id
     * @param status 用户状态，0：启用，1：停用
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
    public String disableOrEnable(Long id, Integer status) {
        return userDetailService.disableOrEnable(id, status);
    }

    /**
     * 删除头像
     *
     * @param key 头像key
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteHeadIcon")
    public String deleteHeadIcon(String key) {
        bucketManagerService.deleteFile(BucketEnum.HEADICON.getBucketName(), key);
        return RETURNCODE.DELETE_COMPLETE.getMessage();
    }

    /**
     * 查询商店用户
     * @return  查询商店用户
     */
    @ResponseBody
    @RequestMapping(value = "/queryUser4Shop")
    public  List<UserDetail> queryUser4Shop(){
        return userDetailService.queryUser4Shop();
    }
}
