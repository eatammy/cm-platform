/*
{*****************************************************************************
{  主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商务流量表（cm_bi_business_flow）											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-09-01  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.service.bi;

import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.service.IPageService;

 /**
 * 《商务流量表（cm_bi_business_flow）》 业务逻辑服务接口
 * @author 郭旭辉
 *
 */
public interface IBusinessFlowService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>,IPageService<D, T>{

}