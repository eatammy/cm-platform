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
import cn.eatammy.cm.domain.auth.AuthRole;
import cn.eatammy.cm.domain.auth.AuthTreeNode;
import cn.eatammy.cm.param.auth.AuthRoleParam;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.service.IPageService;
import java.util.List;
/**
 * 《权限角色》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IAuthRoleService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {

    /**
     * 新增角色
     *
     * @param authRole      角色参数
     * @param accountDto    操作用户
     * @return 返回，操作码
     */
    String add(AuthRole authRole, AccountDto accountDto);

    /**
     * 分页查询角色
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return 返回，分页列表
     */
    BizData4Page<AuthRole> queryPageEx(AuthRoleParam param, int pageNo, int pageSize);

    /**
     * 更新角色
     * @param authRole      角色参数
     * @param accountDto    操作者
     * @return  返回，操作码
     */
    String update(AuthRole authRole, AccountDto accountDto);

    /**
     * 启用。停用角色
     * @param id        角色id
     * @param status    角色状态，0：启用，1：停用
     * @return 返回，操作码
     */
    String disableOrEnable(long id, int status);

    /**
     * 单个删除角色
     * @param id        角色id
     * @param roleCode  角色code
     * @return  返回，操作码
     */
    String deleteOne(long id, String roleCode);

    /**
     * 批量删除角色
     * @param ids       角色id集合
     * @param roleCodes 角色代码集合
     * @return  返回，操作码
     */
    String deleteByIds(List<Long> ids, List<String> roleCodes);

    /**
     * 查询模块和操作树
     * @return 返回，模块和操作树
     */
    List<AuthTreeNode> queryModuleAndOperation();

    /**
     * 保存授权信息
     * @param roleCode          角色代码
     * @param moduleCodes       模块代码集合
     * @param operationCodes    操作代码集合
     * @param accountDto        当前操作者
     * @return  返回，操作码
     */
    String saveAuth(String roleCode, String[] moduleCodes, String[] operationCodes, AccountDto accountDto);

    /**
     * 判断符合条件的某个字段是否存在
     * @param property  字段
     * @param value     值
     * @return  返回，true：存在，false：不存在
     */
    Boolean isExist(String property, Object value);

    /**
     * 根据userCode和userType判断用户是否具备超级管理员角色
     * @param userCode  用户code（uid）
     * @param userType  用户身份值
     * @return  返回，true：拥有超级管理员身份，false：不具备
     */
    Boolean isSuper(String userCode, int userType);
}