/*
{*****************************************************************************
{  主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户反馈表，记录用户反馈，建议，举报等信息											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-02  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.service.sys;

import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.service.IPageService;

/**
 * 《用户反馈表，记录用户反馈，建议，举报等信息》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IFeedbackService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {


    /**
     * 分页查询
     * @param pageNo        页码
     * @param pageSize      页大小
     * @return  返回，分页结果
     */
    BizData4Page queryPage(int pageNo, int pageSize);
}