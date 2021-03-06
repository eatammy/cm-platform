/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：菜谱											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-14  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.dao.cook;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.cook.CookBook;
import cn.eatammy.cm.domain.cook.CookBookEx;

/**
 * 《菜谱》 数据访问接口
 * @author 郭旭辉
 *
 */
public interface ICookBookDAO extends ICMBaseDAO<CookBook> {

 /**
  * 根据菜谱id查找菜谱详情
  * @param cookBookId 菜谱id
  * @return 返回扩展的菜谱实例
  */
  public CookBookEx findCookBookInfoByCBid(Long cookBookId);

}