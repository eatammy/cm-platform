package cn.eatammy.common.shiro;

import cn.eatammy.cm.dao.auth.IAuthOperationDAO;
import cn.eatammy.cm.domain.auth.AuthOperation;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.param.auth.AuthOperationParam;
import cn.eatammy.cm.param.user.UserDetailParam;
import cn.eatammy.cm.service.auth.IAuthRoleService;
import cn.eatammy.cm.service.user.IUserDetailService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.DataStatusEnum;
import cn.eatammy.common.utils.ERRORCODE;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by 郭旭辉 on 2016/8/9.
 * 自定义realm
 */
public class CmRealm extends AuthorizingRealm {

    @Autowired
    private IUserDetailService userDetailService;
    @Autowired
    private IAuthRoleService authRoleService;
    @Autowired
    private IAuthOperationDAO authOperationDAO;

    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customeRealm");
    }

    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //从PrincipalCollection获取用户身份信息

        AccountDto accountDto = (AccountDto) principals.getPrimaryPrincipal();

        //从session中获取当前的用户信息
        AccountDto accountDto1 = (AccountDto) SecurityUtils.getSubject().getSession().getAttribute(accountDto.getToken());

        //从数据库中获取到权限数据
        List<AuthOperation> authOperations = null;
        if(authRoleService.isSuper(accountDto1.getUid(), accountDto1.getUserType())){
            authOperations = authOperationDAO.findList(AuthOperationParam.F_Status, DataStatusEnum.ENABLED, null, null);
        }else {
            authOperations = authOperationDAO.queryOperationsByUser(accountDto1.getUid(), accountDto1.getUserType(), null, null);
        }
        List<String> permission = new ArrayList<>();
       if(authOperations.size() > 0){
           for (AuthOperation authOperation: authOperations){
               permission.add(authOperation.getAuthCode());
           }
       }else{
           throw new BizException(ERRORCODE.AUTH_INSUFFICIENT.getCode(), ERRORCODE.AUTH_INSUFFICIENT.getMessage());
       }
        //查到权限数据，返回，授权信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将查询到的授权信息填充到SimpleAuthorizationInfo中
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserDetail user = (UserDetail) userDetailService.findOne(UserDetailParam.F_Username, username);
        AccountDto accountDto;
        if (user != null) {
            accountDto = new AccountDto();
            accountDto.setUid(user.getCode());
            accountDto.setUsername(user.getUsername());
            accountDto.setAddress(user.getAddress());
            accountDto.setAttentions(user.getAttentions());
            accountDto.setFuns(user.getFuns());
            accountDto.setHeadIcon(user.getHeadIcon());
            accountDto.setIdCard(user.getIdCard());
            accountDto.setIdCardPic(user.getIdCardPic());
            accountDto.setNickname(user.getNickname());
            accountDto.setPassword(user.getPassword());
            accountDto.setPhone(user.getPhone());
            accountDto.setSalt(user.getSalt());
            accountDto.setUserTypes(user.getUserTypes());
            return new SimpleAuthenticationInfo(accountDto, accountDto.getPassword(), ByteSource.Util.bytes(accountDto.getSalt()), this.getName());
        }else{
            //如果查询不到则返回空
            return null;
        }
    }

    public void clearCachedAuthorizationInfo(String principal){
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal,getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 秦楚缓存--此方法应该在修改权限的service中调用
     */
    public void clearCahced(){
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principalCollection);
    }
}
