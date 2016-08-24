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

import cn.eatammy.cm.domain.auth.AuthModule;
import cn.eatammy.cm.param.auth.AuthModuleParam;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.service.IPageService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * 《模块》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IAuthModuleService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {


    /**
     * 添加一个模块
     *
     * @param authModule 模块实体参数
     * @param accountDto 操作者
     * @return 返回，操作码
     */
     String add(AuthModule authModule, AccountDto accountDto);

    /**
     * 获取模块列表
     * @param status    模块状态，0：启用，1：停用
     * @return  返回，模块树
     */
    List<Map<String, Object>> queryModules(Integer status);

    /**
     * 根绝用户uid和用户身份类型获取用户角色列表
     * @param uid       用户uid
     * @param userType  用户身份值
     * @return  返回，模块列表
     */
    List<AuthModule> getModules(String uid, int userType);

    /**
     * 查询模块列表，（不出现子节点）
     * @param moduleFullCode    模块fullCode
     * @return 返回，模块树（不包含子节点）
     */
    List<Map<String, Object>> queryModulesNoChildren(String moduleFullCode);

    /**
     * 分页获取指定的模块列表
     * @param param         查询参数
     * @param pageNo        页码
     * @param PageSize      页大小
     * @return  返回，模块列表
     */
    BizData4Page<AuthModule> queryPageEx(AuthModuleParam param, int pageNo, int PageSize);

    /**
     * 更新一个模块节点
     * @param authModule    模块参数
     * @param accountDto    操作者
     * @return  返回，操作码
     */
    String update(AuthModule authModule, AccountDto accountDto) throws InvocationTargetException, IllegalAccessException, Exception;

    /**
     * 更新某个节点下的子孙节点
     * @param originAuthModule  原本的数据
     * @param updateAuthModule  更新的数据
     * @param accountDto        操作用户
     */
    void updateChild(AuthModule originAuthModule, AuthModule updateAuthModule, AccountDto accountDto);

    /**
     * 启用/停用模块状态
     * @param id            模块di
     * @param accountDto    操作者
     * @return 返回，操作码
     */
    String disableOrEnable(long id, AccountDto accountDto);


    /**
     * 删除一个模块
     * @param id    模块id
     * @return  返回操作码
     */
    String deleteOne(long id);

    /**
     * 获取某个用户某种身份下拥有的模块列表
     * @param userCode  用户code（uid）
     * @param userType  用户身份值
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，模块列表
     */
    List<AuthModule> queryModulesByUser(String userCode, int userType, Integer pageNo, Integer pageSize);

    /**
     * 判断某个字段是否存在
     * @param column    字段
     * @param value     字段值
     * @return 返回布尔值，true：存在，false：不存在
     */
    boolean isExist(String column, String value);
}