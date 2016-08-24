package cn.eatammy.cm.controller.auth;

import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.param.user.UserDetailParam;
import cn.eatammy.cm.service.auth.IAuthRoleUserService;
import cn.eatammy.cm.service.user.IUserDetailService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.shiro.CmRealm;
import cn.eatammy.common.utils.RETURNCODE;
import cn.eatammy.common.utils.User.UserContext;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/8/17.
 * 用户角色控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/authRoleUser")
public class AuthRoleUserController {
    @Autowired
    private IUserDetailService userDetailService;
    @Autowired
    private IAuthRoleUserService authRoleUserService;

    @Autowired
    private CmRealm cmRealm;

    /**
     * 查询用户
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return 返回，用户分页
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    @RequiresPermissions("userRole:query")
    public BizData4Page<UserDetail> queryPage(UserDetailParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        return userDetailService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 查询单个用户
     * @param uid 用户uid
     * @return 返回，用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/getUserInfoByUid")
    @RequiresPermissions("userRole:setRole")
    public UserDetail getUserInfoByUid(String uid){
        return (UserDetail) userDetailService.findOne(UserDetailParam.F_Code, uid);
    }

    /**
     * 查询所有角色和当前身份用户具有的角色
     * @param uid           用户uid
     * @param userType      用户身份值
     * @param isNeedDefault 结果集是否需要默认角色
     * @return  返回，角色列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryRolesForAuth")
    @RequiresPermissions("userRole:setRole")
    public Map<String, Object> qqueryRolesForAuth(@RequestParam(required = true) String uid, @RequestParam(required = true) int userType, @RequestParam(defaultValue = "false") Boolean isNeedDefault){
        return  authRoleUserService.queryRolesForAuth(uid, userType, isNeedDefault);
    }

    /**
     * 保存用户角色关系
     * @param uid           用户uid
     * @param userType      当前用户身份值
     * @param roleCodes     角色代码列表
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("userRole:setRole")
    public String save(@RequestParam(required = true) String uid, @RequestParam(required = true)int userType, @RequestParam(required = true) String[] roleCodes){
        return authRoleUserService.save(uid, userType, roleCodes, UserContext.getCurrentUser());
    }

    /**
     * 更新用户权限缓存
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/refreshCache")
    @RequiresPermissions("userRole:refreshCache")
    public String refreshCache(){
        cmRealm.clearCahced();
        return RETURNCODE.SUCCESS_COMPLETE.getMessage();
    }
}
