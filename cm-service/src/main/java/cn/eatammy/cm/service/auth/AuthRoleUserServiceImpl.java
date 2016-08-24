/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户角色表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-08-09  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.service.auth;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.auth.IAuthRoleDAO;
import cn.eatammy.cm.dao.auth.IAuthRoleUserDAO;
import cn.eatammy.cm.domain.auth.AuthRole;
import cn.eatammy.cm.domain.auth.AuthRoleUser;
import cn.eatammy.cm.param.auth.AuthRoleParam;
import cn.eatammy.cm.param.auth.AuthRoleUserParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.DataStatusEnum;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.RETURNCODE;
import cn.eatammy.common.utils.SqlOrderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 《用户角色》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("AuthRoleUserServiceImpl")
public class AuthRoleUserServiceImpl extends AbstractCMPageService<ICMBaseDAO<AuthRoleUser>, AuthRoleUser> implements IAuthRoleUserService<ICMBaseDAO<AuthRoleUser>,AuthRoleUser>{
    @Autowired
    private IAuthRoleUserDAO authRoleUserDAO;
    @Autowired
    private IAuthRoleDAO authRoleDAO;

    @Override
    public ICMBaseDAO<AuthRoleUser> getDao() {
        return authRoleUserDAO;
    }

    @Override
    public Map<String, Object> queryRolesForAuth(String uid, int userType, Boolean isNeedDefault) {
        AuthRoleParam authRoleParam = new AuthRoleParam();
        authRoleParam.setStatus(DataStatusEnum.ENABLED.getValue());
        if(!isNeedDefault){
            authRoleParam.setIsDefault(isNeedDefault);
        }

        //获取所有的角色（不包括默认角色）
        List<AuthRole> authRoleList = authRoleDAO.queryList(authRoleParam.toMap(), AuthRoleParam.F_CreateDate, SqlOrderEnum.ASC.getAction());
        List<String> roleCodes = authRoleUserDAO.querySelectedRoles(uid, userType);
        Map<String, Object> result = new HashMap<>();
        result.put("allRole", authRoleList);
        result.put("selected", roleCodes);
        return result;
    }

    @Override
    public String save(String uid, int userType, String[] roleCodes, AccountDto accountDto) {

        //删除之前的记录
        AuthRoleUserParam param = new AuthRoleUserParam();
        param.setUserCode(uid);
        param.setUserType(userType);
        this.deleteByCondition(param.toMap());
        List<AuthRoleUser> authRoleUsers = new ArrayList<>();
        AuthRoleUser authRoleUser;
        for(String roleCode: roleCodes){
            authRoleUser = new AuthRoleUser();
            authRoleUser.setUserCode(uid);
            authRoleUser.setRoleCode(roleCode);
            authRoleUser.setUserType(userType);
            authRoleUser.setCreator(accountDto.getUid());
            authRoleUser.setCreateDate(System.currentTimeMillis());
            authRoleUser.setStatus(DataStatusEnum.ENABLED.getValue());
            authRoleUsers.add(authRoleUser);
        }
        if(authRoleUserDAO.insertBatch(authRoleUsers) > 0){
            //在这里刷新改用户权限模型
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}