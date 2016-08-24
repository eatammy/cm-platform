/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：权限操作表											
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
import cn.eatammy.cm.dao.auth.IAuthAclDAO;
import cn.eatammy.cm.dao.auth.IAuthModuleDAO;
import cn.eatammy.cm.dao.auth.IAuthOperationDAO;
import cn.eatammy.cm.domain.auth.AuthModule;
import cn.eatammy.cm.domain.auth.AuthOperation;
import cn.eatammy.cm.domain.auth.AuthOperationEx;
import cn.eatammy.cm.param.auth.AuthAclParam;
import cn.eatammy.cm.param.auth.AuthModuleParam;
import cn.eatammy.cm.param.auth.AuthOperationParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 《权限操作》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("AuthOperationServiceImpl")
public class AuthOperationServiceImpl extends AbstractCMPageService<ICMBaseDAO<AuthOperation>, AuthOperation> implements IAuthOperationService<ICMBaseDAO<AuthOperation>, AuthOperation> {
    @Autowired
    private IAuthOperationDAO authOperationDAO;
    @Autowired
    private IAuthModuleDAO authModuleDAO;
    @Autowired
    private IAuthAclDAO authAclDAO;
    @Autowired
    private IAuthRoleService authRoleService;
    @Autowired
    private IAuthModuleService authModuleService;


    @Override
    public ICMBaseDAO<AuthOperation> getDao() {
        return authOperationDAO;
    }

    @Override
    public BizData4Page<AuthOperationEx> queryPageEx(AuthOperationParam param, int pageNo, int pageSize) {
        List<AuthOperationEx> data = authOperationDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        int records = authOperationDAO.countEx(param.toMap());
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }

    @Override
    public String add(AuthOperation authOperation, AccountDto accountDto) {
        if (isExistAuthCode(authOperation.getModuleCode(), authOperation.getAuthCode())) {
            throw new BizException(ERRORCODE.REPEAT_CODE.getCode(), "权限" + ERRORCODE.REPEAT_CODE.getMessage());
        }
        //查询所属模块
        AuthModule authModule = authModuleDAO.findOne(AuthModuleParam.F_Code, authOperation.getModuleCode(), null, null);
        if (authModule == null) {
            throw new BizException(ERRORCODE.MODULE_NOT_EXIST.getCode(), ERRORCODE.MODULE_NOT_EXIST.getMessage());
        } else {
            authOperation.setStatus(authModule.getStatus());
            authOperation.setCreator(accountDto.getUid());
            authOperation.setCreateDate(System.currentTimeMillis());
            //设置code
            authOperation.setCode(CommonUtils.getUUID());
            if (authOperationDAO.insert(authOperation) > 0) {
                return RETURNCODE.ADD_COMPLETE.getMessage();
            }
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String update(AuthOperation authOperation, AccountDto accountDto) {
        //先查询
        AuthOperation queryAuthOperation = this.findOne(AuthModuleParam.F_ID, authOperation.getId());
        if (!queryAuthOperation.getAuthCode().equals(authOperation.getAuthCode()) && isExistAuthCode(authOperation.getModuleCode(), authOperation.getAuthCode())) {
            throw new BizException(ERRORCODE.REPEAT_CODE.getCode(), "权限" + ERRORCODE.REPEAT_CODE.getMessage());
        }
        //查询所属模块
        //查询所属模块
        AuthModule authModule = authModuleDAO.findOne(AuthModuleParam.F_Code, authOperation.getModuleCode(), null, null);
        if (authModule == null) {
            throw new BizException(ERRORCODE.MODULE_NOT_EXIST.getCode(), ERRORCODE.MODULE_NOT_EXIST.getMessage());
        } else {
            queryAuthOperation.setStatus(authModule.getStatus());
            queryAuthOperation.setName(authOperation.getName());
            queryAuthOperation.setModuleCode(authOperation.getModuleCode());
            queryAuthOperation.setAuthCode(authOperation.getAuthCode());
            queryAuthOperation.setLastModDate(System.currentTimeMillis());
            queryAuthOperation.setLastModifier(accountDto.getUid());
            if (this.update(queryAuthOperation) > 0) {
                return RETURNCODE.UPDATE_COMPLETE.getMessage();
            }
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String disableOrEnable(long id, AccountDto accountDto) {
        AuthOperation queryOperation = this.findOne(AuthOperationParam.F_ID, id);
        int status = queryOperation.getStatus() == 0 ? 1 : 0;
        AuthModule authModule = authModuleDAO.findOne(AuthModuleParam.F_Code, queryOperation.getModuleCode(), null, null);
        if(status ==0 && authModule.getStatus() == 1){
            throw new BizException(ERRORCODE.ENABLE_EXC.getCode(), ERRORCODE.ENABLE_EXC.getMessage()+ "所属模块已停用，请启用后再试！");
        }
        queryOperation.setStatus(status);
        queryOperation.setLastModifier(accountDto.getUid());
        queryOperation.setLastModDate(System.currentTimeMillis());
        if(this.update(queryOperation) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String deleteOne(long id) {
        //查出该功能信息
        AuthOperation queryOperation = this.findOne(AuthOperationParam.F_ID, id);
        //删除acl对应的功能
        authAclDAO.deleteBatchByProperty(AuthAclParam.F_ResourceCode, CommonUtils.transList(Arrays.asList(queryOperation.getCode())));
        if(this.deleteById(id)> 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public Map<String, List<String>> getOperation(String userCode, int userType) {
        List<AuthOperation> authOperations ;
        if(authRoleService.isSuper(userCode, userType)){
            authOperations = this.findList(AuthOperationParam.F_Status, DataStatusEnum.ENABLED);
        }else {
            authOperations = authOperationDAO.queryOperationsByUser(userCode, userType, null, null);
        }
        List<AuthModule> authModules = authModuleService.getModules(userCode, userType);
        Map<String, List<String>> result = new HashMap<>();
        for(AuthModule authModule : authModules){
            result.put(authModule.getUrl(), getAuthCodeListByModuleCode(authModule.getCode(), authOperations));
        }
        return result;
    }

    private List<String> getAuthCodeListByModuleCode(String moduleCode, List<AuthOperation> authOperations){
        List<String> authCodes = new ArrayList<>();
        for(AuthOperation authOperation: authOperations){
            if(moduleCode.equals(authOperation.getModuleCode())){
                authCodes.add(authOperation.getAuthCode());
            }
        }
        return authCodes;
    }

    @Override
    public Boolean isExistAuthCode(String moduleCode, String authCode) {
        AuthOperationParam param = new AuthOperationParam();
        param.setModuleCode(moduleCode);
        param.setAuthCode(authCode);
        return this.queryOne(param.toMap()) != null;
    }
}