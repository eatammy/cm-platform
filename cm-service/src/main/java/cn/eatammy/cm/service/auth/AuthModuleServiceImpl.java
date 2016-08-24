/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：模块表											
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
import cn.eatammy.cm.param.auth.AuthAclParam;
import cn.eatammy.cm.param.auth.AuthModuleParam;
import cn.eatammy.cm.param.auth.AuthOperationParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.domain.SearchField;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.*;
import cn.eatammy.common.utils.auth.AuthUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 《模块》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("AuthModuleServiceImpl")
public class AuthModuleServiceImpl extends AbstractCMPageService<ICMBaseDAO<AuthModule>, AuthModule> implements IAuthModuleService<ICMBaseDAO<AuthModule>, AuthModule> {
    @Autowired
    private IAuthModuleDAO authModuleDAO;
    @Autowired
    private IAuthOperationDAO authOperationDAO;
    @Autowired
    private IAuthAclDAO authAclDAO;
    @Autowired
    private IAuthRoleService authRoleService;

    @Override
    public ICMBaseDAO<AuthModule> getDao() {
        return authModuleDAO;
    }

    @Override
    public String add(AuthModule authModule, AccountDto accountDto) {
        //判断传入的url不为空并且唯一
        if (!StringUtils.isEmpty(authModule.getUrl()) && isExist(AuthModuleParam.F_Url, authModule.getUrl())) {
            throw new BizException(ERRORCODE.MODULEURL_EXIST.getCode(), "模块" + ERRORCODE.MODULEURL_EXIST.getMessage());
        }
        //设置code
        authModule.setCode(CommonUtils.getUUID());
        //查询父节点
        AuthModule p_authModule = this.findOne(AuthModuleParam.F_Code, authModule.getPCode());
        if (p_authModule == null) {
            authModule.setPId(0L);
            authModule.setFullCode("0." + authModule.getCode());
            authModule.setFullName(authModule.getName());
            authModule.setStatus(0);
        } else {
            authModule.setPId(p_authModule.getId());
            authModule.setFullCode(p_authModule.getFullCode() + "." + authModule.getCode());
            authModule.setFullName(p_authModule.getFullName() + "|" + authModule.getName());
            authModule.setStatus(p_authModule.getStatus());
        }
        authModule.setCreator(accountDto.getUid());
        authModule.setCreateDate(System.currentTimeMillis());

        if (this.insert(authModule) > 0) {
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());

    }

    @Override
    public List<Map<String, Object>> queryModules(Integer status) {
        List<AuthModule> authModuleList = this.findList(AuthModuleParam.F_Status, status);
        authModuleList = AuthUtils.buildAuthModuleTree(authModuleList, AuthUtils.AUTHROOTCODE, false);
        List<Map<String, Object>> result = new ArrayList<>();
        for (AuthModule authModule : authModuleList) {
            Map<String, Object> map = new HashMap<>();
            map.put(AuthModuleParam.F_Code, authModule.getCode());
            map.put(AuthModuleParam.F_Level, authModule.getLevel());
            map.put(AuthModuleParam.F_Name, "┠ " + StringUtils.repeat("─ ", authModule.getLevel() - 1) + authModule.getName());
            result.add(map);
        }
        return result;
    }

    @Override
    public List<AuthModule> getModules(String uid, int userType) {
        List<AuthModule> authModules = null;
        if (authRoleService.isSuper(uid, userType)) {
            authModules = this.findList(AuthModuleParam.F_Status, DataStatusEnum.ENABLED);
        } else {
            authModules = this.queryModulesByUser(uid, userType, null, null);
        }
        if(authModules.size() > 1){
            Collections.sort(authModules, new Comparator<AuthModule>() {
                @Override
                public int compare(AuthModule o1, AuthModule o2) {
                    if(Objects.equals(o1.getLevel(), o2.getLevel())){
                        return o1.getPriority().compareTo(o2.getPriority());
                    }else{
                        return o1.getLevel().compareTo(o2.getLevel());
                    }
                }
            });
        }
        return authModules;
    }

    @Override
    public List<Map<String, Object>> queryModulesNoChildren(String moduleFullCode) {
        List<AuthModule> authModuleList = this.findAll();
        authModuleList = AuthUtils.buildAuthModuleTree(authModuleList, AuthUtils.AUTHROOTCODE, false);
        List<Map<String, Object>> result = new ArrayList<>();
        for (AuthModule authModule : authModuleList) {
            if (authModule.getFullCode().startsWith(moduleFullCode)) {
                continue;
            }
            Map<String, Object> map = new HashMap<>();
            map.put(AuthModuleParam.F_Code, authModule.getCode());
            map.put(AuthModuleParam.F_Level, authModule.getLevel());
            map.put(AuthModuleParam.F_Name, "┠ " + StringUtils.repeat("─ ", authModule.getLevel() - 1) + authModule.getName());
            result.add(map);
        }
        return result;
    }

    @Override
    public BizData4Page<AuthModule> queryPageEx(AuthModuleParam param, int pageNo, int PageSize) {
        Map<String, Object> condition = param.toSearchFieldMap();
        //模块名称模糊查询
        if (condition.containsKey(AuthModuleParam.F_Name)) {
            condition.put(AuthModuleParam.F_Name, new SearchField(AuthModuleParam.F_Name, "like", "%" + param.getName() + "%"));
        }
        //根据code查询符合的fullCode，把其子节点列出来
        if (condition.containsKey(AuthModuleParam.F_Code)) {
            condition.remove(AuthModuleParam.F_Code);
            condition.put(AuthModuleParam.F_FullCode, new SearchField(AuthModuleParam.F_FullCode, "like", "%" + param.getCode() + "%"));
        }
        List data = this.queryPage(condition, (pageNo - 1) * PageSize, PageSize);
        int records = this.count(condition);
        return PageUtils.toBizData4Page(data, pageNo, PageSize, records);
    }

    @Override
    public String update(AuthModule authModule, AccountDto accountDto) {
        //先把之前的查询出来
        AuthModule originAuthModule = this.findOne(AuthModuleParam.F_ID, authModule.getId());
        //查询是否存在重复的URL
        Boolean isExistUrl = isExist(AuthModuleParam.F_Url, authModule.getUrl());
        if (!StringUtils.isEmpty(authModule.getUrl()) && !originAuthModule.getUrl().equals(authModule.getUrl()) && isExistUrl) {
            throw new BizException(ERRORCODE.REPEAT_URL.getCode(), "模块" + ERRORCODE.REPEAT_URL.getMessage());
        }
        try {
            //查询父节点
            AuthModule p_authModule = this.findOne(AuthModuleParam.F_Code, authModule.getPCode());
            AuthModule updateAuthModule = new AuthModule();
            BeanUtils.copyProperties(updateAuthModule, originAuthModule);
            if (p_authModule == null) {
                updateAuthModule.setPId(0L);
                updateAuthModule.setFullCode("0." + updateAuthModule.getCode());
                updateAuthModule.setFullName(authModule.getName());
            } else {
                updateAuthModule.setPId(p_authModule.getId());
                updateAuthModule.setFullCode(p_authModule.getFullCode() + "." + updateAuthModule.getCode());
                updateAuthModule.setFullName(p_authModule.getFullName() + "|" + authModule.getName());
                updateAuthModule.setStatus(p_authModule.getStatus());
            }
            updateAuthModule.setIcon(authModule.getIcon());
            updateAuthModule.setPCode(authModule.getPCode());
            updateAuthModule.setName(authModule.getName());
            updateAuthModule.setLevel(authModule.getLevel());
            updateAuthModule.setPriority(authModule.getPriority());
            updateAuthModule.setIsMenu(authModule.getIsMenu());
            updateAuthModule.setUrl(authModule.getUrl());
            updateAuthModule.setLastModDate(System.currentTimeMillis());
            updateAuthModule.setLastModifier(accountDto.getUid());
            //更新自身
            this.update(updateAuthModule);
            //更新子孙节点
            updateChild(originAuthModule, updateAuthModule, accountDto);

        } catch (Exception e) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
        return RETURNCODE.UPDATE_COMPLETE.getMessage();

    }

    @Override
    public void updateChild(AuthModule originAuthModule, AuthModule updateAuthModule, AccountDto accountDto) {
        //根性模块下的功能的状态
        if (!Objects.equals(originAuthModule.getStatus(), updateAuthModule.getStatus())) {
            updateOperationStatus(updateAuthModule.getStatus(), updateAuthModule.getCode(), accountDto.getUid());
        }
        //更新子节点的信息
        List<AuthModule> authModuleList = queryChildrenModules(originAuthModule.getFullCode());
        for (AuthModule authModule : authModuleList) {
            authModule.setFullCode(authModule.getFullCode().replace(originAuthModule.getFullCode(), updateAuthModule.getFullCode()));
            authModule.setFullName(authModule.getFullName().replace(originAuthModule.getFullName() + "|", updateAuthModule.getFullName() + "|"));
            authModule.setLevel(StringUtils.countMatches(authModule.getFullCode(), "."));
            authModule.setStatus(updateAuthModule.getStatus());
            this.update(authModule);
            //更新模块下的功能的状态
            if (!Objects.equals(originAuthModule.getStatus(), updateAuthModule.getStatus())) {
                updateOperationStatus(updateAuthModule.getStatus(), authModule.getCode(), accountDto.getUid());
            }
        }
    }

    @Override
    public String disableOrEnable(long id, AccountDto accountDto) {
        AuthModule queryAuthModule = this.findOne(AuthModuleParam.F_ID, id);
        //修改模块状态
        int status = queryAuthModule.getStatus() == 0 ? 1 : 0;
        //查看父节点状态
        AuthModule p_authModule = this.findOne(AuthModuleParam.F_Code, queryAuthModule.getPCode());
        if (p_authModule != null && status == 0 && p_authModule.getStatus() == 1) {
            throw new BizException(ERRORCODE.ENABLE_EXC.getCode(), ERRORCODE.ENABLE_EXC.getMessage() + "上级模块已停用，请启用后再试！");
        }
        //更新当前节点以及子孙节点状态
        authModuleDAO.updateStatus(queryAuthModule.getCode(), status, accountDto.getUid(), System.currentTimeMillis());
        //更新节点操作状态
        List<AuthModule> authModuleList = queryChildrenModules(queryAuthModule.getFullCode());
        for (AuthModule authModule : authModuleList) {
            updateOperationStatus(status, authModule.getCode(), accountDto.getUid());
        }
        return RETURNCODE.SUCCESS_COMPLETE.getMessage();
    }

    @Override
    public String deleteOne(long id) {
        AuthModule originAuthModule = this.findOne(AuthModuleParam.F_ID, id);
        if (originAuthModule != null) {
            List<AuthModule> authModuleList = queryChildrenModules(originAuthModule.getFullCode());
            List<Long> moduleIds = new ArrayList<>();
            List<String> moduleCodes = new ArrayList<>();
            List<Object> resourceCodes = new ArrayList<>();
            for (AuthModule authModule : authModuleList) {
                moduleIds.add(authModule.getId());
                moduleCodes.add(authModule.getCode());
                //查询对应模块的操作
                List<AuthOperation> authOperationList = authOperationDAO.findList(AuthOperationParam.F_ModuleCode, authModule.getCode(), null, null);
                for (AuthOperation authOperation : authOperationList) {
                    resourceCodes.add(authOperation.getCode());
                }
            }
            //删除模块对应的操作operation
            authOperationDAO.deleteOperationByCodes(moduleCodes);
            //删除acl中对应的模块+操作
            if (resourceCodes.size() > 0) {
                authAclDAO.deleteBatchByProperty(AuthAclParam.F_ResourceCode, resourceCodes);
            }
            //删除模块
            this.deleteByIds(moduleIds);
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public List<AuthModule> queryModulesByUser(String userCode, int userType, Integer pageNo, Integer pageSize) {
        return authModuleDAO.queryModulesByUser(userCode, userType, null, null);
    }

    @Override
    public boolean isExist(String column, String value) {
        return this.findOne(column, value) != null;
    }

    /**
     * 更新模块下对应的操作
     *
     * @param status     状态
     * @param moduleCode 模块code
     */
    private void updateOperationStatus(int status, String moduleCode, String uid) {
        Map<String, Object> updateMap = new HashMap<>();
        updateMap.put(AuthModuleParam.F_Status, status);
        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put(AuthOperationParam.F_ModuleCode, moduleCode);
        conditionMap.put(AuthModuleParam.F_LastModifier, uid);
        conditionMap.put(AuthModuleParam.F_LastModDate, System.currentTimeMillis());
        authOperationDAO.updateByCondition(updateMap, conditionMap);
    }

    /**
     * 根据模块code获取子模块，包括自己
     *
     * @param fullCode 模块
     * @return 返回，模块列表
     */
    private List<AuthModule> queryChildrenModules(String fullCode) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(AuthModuleParam.F_FullCode, new SearchField(AuthModuleParam.F_FullCode, "like", fullCode + "%"));
        return this.queryPage(condition, 0, Integer.MAX_VALUE);
    }
}