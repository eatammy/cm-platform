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

package cn.eatammy.cm.dao.user;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.user.BuddyList;
import org.apache.ibatis.annotations.Param;

/**
 * 《好友列表（cm_user_buddyList）》 数据访问接口
 * @author 郭旭辉
 *
 */
public interface IBuddyListDAO extends ICMBaseDAO<BuddyList> {

  /**
   * 根据uid，buddyUid删除关注
   * @param uid       用户id
   * @param buddyUid  被关注用户id
   * @return 返回，0：失败，1：成功
     */
  int deleteOne(@Param("uid") long uid, @Param("buddyUid") long buddyUid);
}