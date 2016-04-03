/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：好友列表（cm_user_buddyList）											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-04-03  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.service.user;

import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.service.IPageService;

/**
 * 《好友列表（cm_user_buddyList）》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IBuddyListService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {

    /**
     * 根据用户
     * @param uid           用户id
     * @param buddyUid      被关注用户id
     * @param currentUser   当前操作者
     * @return 返回，操作码
     */
    String attachOne(long uid, long buddyUid, AccountDto currentUser);

    /**
     * 取消对用户的关注
     * @param uid       用户id
     * @param buddyUid  被关注用户id
     * @return 返回，操作码
     */
    String inattach(long uid, long buddyUid);
}