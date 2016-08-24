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

import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.service.IPageService;

import java.util.Map;

/**
 * 《用户角色》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IAuthRoleUserService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {


    /**
     * 获取全部角色（不包括默认角色）
     * @param uid   用户uid
     * @param userType 用户当前的身份值
     * @param isNeedDefault 是否需要获取默认角色
     * @return 返回，所有角色和用户当前勾选的角色
     */
    Map<String, Object> queryRolesForAuth(String uid, int userType, Boolean isNeedDefault);

    /**
     * 保存用户角色信息
     * @param uid           用户uid
     * @param userType      当前用户身份值
     * @param roleCodes     角色代码集合
     * @param accountDto    当前操作者
     * @return  返回，操作码
     */
    String save(String uid, int userType, String[] roleCodes, AccountDto accountDto);
}