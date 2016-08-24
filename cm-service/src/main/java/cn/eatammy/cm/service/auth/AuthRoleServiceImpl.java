/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：权限角色表											
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
import cn.eatammy.cm.dao.auth.*;
import cn.eatammy.cm.domain.auth.*;
import cn.eatammy.cm.param.auth.AuthAclParam;
import cn.eatammy.cm.param.auth.AuthRoleParam;
import cn.eatammy.cm.param.auth.AuthRoleUserParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.domain.SearchField;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.CommonUtils;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.PageUtils;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 《权限角色》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("AuthRoleServiceImpl")
public class AuthRoleServiceImpl extends AbstractCMPageService<ICMBaseDAO<AuthRole>, AuthRole> implements IAuthRoleService<ICMBaseDAO<AuthRole>, AuthRole> {
    @Autowired
    private IAuthRoleDAO authRoleDAO;
    @Autowired
    private IAuthAclDAO authAclDAO;
    @Autowired
    private IAuthRoleUserDAO authRoleUserDAO;
    @Autowired
    private IAuthModuleDAO authModuleDAO;
    @Autowired
    private IAuthOperationDAO authOperationDAO;

    @Override
    public ICMBaseDAO<AuthRole> getDao() {
        return authRoleDAO;
    }


    @Override
    public String add(AuthRole authRole, AccountDto accountDto) {
        if(authRole.getIsDefault()&& isExist(AuthRoleParam.F_IsDefault, 1)){
            throw new BizException(ERRORCODE.DEFAULT_ROLE_EXIST.getCode(), ERRORCODE.DEFAULT_ROLE_EXIST.getMessage());
        }
        AuthRole queryRole = this.findOne(AuthRoleParam.F_Name, authRole.getName());
        if(queryRole != null){
            throw new BizException(ERRORCODE.ROLE_EXIST.getCode(), ERRORCODE.ROLE_EXIST.getMessage());
        }
        authRole.setCreator(accountDto.getUid());
        authRole.setCreateDate(System.currentTimeMillis());
        authRole.setStatus(0);
        authRole.setCode(CommonUtils.getUUID());
        if (this.insert(authRole) != 0) {
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public BizData4Page<AuthRole> queryPageEx(AuthRoleParam param, int pageNo, int pageSize) {
        Map<String, Object> condition = param.toSearchFieldMap();
        //根据名称模糊查询
        if (condition.containsKey(AuthRoleParam.F_Name)) {
            condition.put(AuthRoleParam.F_Name, new SearchField(AuthRoleParam.F_Name, "like", "%" + param.getName() + "%"));

        }
        List<AuthRole> data = this.queryPage(condition, (pageNo - 1) * pageSize, pageSize);
        int records = this.count(condition);
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }

    @Override
    public String update(AuthRole authRole, AccountDto accountDto) {
        if(authRole.getIsDefault()&& isExist(AuthRoleParam.F_IsDefault, 1)){
            throw new BizException(ERRORCODE.DEFAULT_ROLE_EXIST.getCode(), ERRORCODE.DEFAULT_ROLE_EXIST.getMessage());
        }
        AuthRole queryRole = this.findOne(AuthRoleParam.F_Name, authRole.getName());
        if(queryRole != null && !queryRole.getCode().equals(authRole.getCode())){
            throw new BizException(ERRORCODE.ROLE_EXIST.getCode(), ERRORCODE.ROLE_EXIST.getMessage());
        }

        authRole.setCreateDate(System.currentTimeMillis());
        authRole.setCreator(accountDto.getUid());
        authRole.setStatus(0);
        if(authRoleDAO.update(authRole) >0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String disableOrEnable(long id, int status) {
        if(authRoleDAO.updateStatus(id, status) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String deleteOne(long id, String roleCode) {
        //先删除角色对应的权限（操作）
        authAclDAO.deleteByProperty(AuthAclParam.F_SubjectCode, roleCode);
        //删除用户-角色
        authRoleUserDAO.deleteByProperty(AuthRoleUserParam.F_RoleCode, roleCode);
        //删除角色
        if(this.deleteById(id) > 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String deleteByIds(List<Long> ids, List<String> roleCodes) {
        //删除角色对应的权限（操作）
        authAclDAO.deleteBatchByProperty(AuthAclParam.F_SubjectCode, CommonUtils.transList(roleCodes));
        //删除角色-用户
        authRoleUserDAO.deleteBatchByProperty(AuthRoleUserParam.F_RoleCode, CommonUtils.transList(roleCodes));
        if(this.deleteByIds(ids) >0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public List<AuthTreeNode> queryModuleAndOperation() {
        //查询出所有模块
        List<AuthModule> authModules = authModuleDAO.findAll(null, null);
        //查询出所有的操作
        List<AuthOperation> authOperations = authOperationDAO.findAll(null, null);
        List<AuthTreeNode> result = new ArrayList<>();
        List<String> moduleCodes = new ArrayList<>();
        for(AuthModule authModule : authModules){
            moduleCodes.add(authModule.getCode());
            String moduleName = authModule.getName();
            if(authModule.getStatus() == 1){
                moduleName += "【已停用】";
            }
            AuthTreeNode authTreeNode = new AuthTreeNode(authModule.getCode(), moduleName, authModule.getPCode(), true);
            result.add(authTreeNode);
        }
        for (AuthOperation authOperation: authOperations){
            if(moduleCodes.contains(authOperation.getModuleCode())){
                String oprationName = authOperation.getName();
                if(authOperation.getStatus() == 1){
                    oprationName += "【已停用】";
                }
                AuthTreeNode authTreeNode = new AuthTreeNode(authOperation.getCode(), oprationName, authOperation.getModuleCode(), false);
                //添加到前面（树形结构）
                result.add(0, authTreeNode);
            }
        }
        return result;
    }

    @Override
    public String saveAuth(String roleCode, String[] moduleCodes, String[] operationCodes, AccountDto accountDto) {

        //对象封装
        List<AuthAcl> authAcls = new ArrayList<>();
        for(String code: moduleCodes){
            AuthAcl authAcl = new AuthAcl();
            authAcl.setSubjectType(0);
            authAcl.setSubjectCode(roleCode);
            authAcl.setResourceType(0);
            authAcl.setResourceCode(code);
            authAcl.setStatus(0);
            authAcl.setCreator(accountDto.getUid());
            authAcl.setCreateDate(System.currentTimeMillis());
            authAcls.add(authAcl);
        }
        for (String code: operationCodes){
            AuthAcl authAcl = new AuthAcl();
            authAcl.setSubjectType(0);
            authAcl.setSubjectCode(roleCode);
            authAcl.setResourceType(1);
            authAcl.setResourceCode(code);
            authAcl.setStatus(0);
            authAcl.setCreator(accountDto.getUid());
            authAcl.setCreateDate(System.currentTimeMillis());
            authAcls.add(authAcl);
        }
        //组装删除参数
        AuthAclParam authAclParam = new AuthAclParam();
        authAclParam.setSubjectType(0);
        authAclParam.setSubjectCode(roleCode);
        //先删除后再添加
        authAclDAO.deleteByCondition(authAclParam.toMap());
        if(authAcls.size() > 0){
            authAclDAO.insertBatch(authAcls);
        }
        //在这里更新权限缓存

        return RETURNCODE.ADD_COMPLETE.getMessage();
    }

    @Override
    public Boolean isExist(String property, Object value) {
        return this.findOne(property, value) != null;
    }

    @Override
    public Boolean isSuper(String userCode, int userType) {
        List<AuthRole> queryRoles = authRoleDAO.queryRoles(userCode, userType);
        for(AuthRole authRole: queryRoles){
            if(authRole.getIsSuper()){
                return true;
            }
        }
        return false;
    }
}