/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：食谱制作步骤表											
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

package cn.eatammy.cm.service.cook;

import cn.eatammy.cm.domain.cook.*;
import cn.eatammy.cm.domain.cook.Process;
import cn.eatammy.cm.param.cook.ProcessParam;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.service.IPageService;

 /**
 * 《食谱制作步骤》 业务逻辑服务接口
 * @author 郭旭辉
 *
 */
public interface IProcessService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>,IPageService<D, T>{

  /**
   * 添加菜谱制作步骤信息
   * @param user 用户
   * @param processParam 制作步骤参数实体
   * @return 成功返回1，否则抛出相关异常
   */
  Long saveProcess(String user, ProcessParam processParam);

  /**
   * 更新菜谱制作步骤信息
   * @param user 用户信息
   * @param processParam 制作步骤参数实体
   * @return 成功返回1，否则抛出相关异常
   */
  int updateProcess(String user,ProcessParam processParam);


}