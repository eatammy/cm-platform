/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：活动表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-05-18  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.service.activity;

import cn.eatammy.cm.param.activity.ActivityParam;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.service.IPageService;

/**
 * 《活动》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IActivityService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {

    /**
     * 分页查询活动
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return 返回，分页结果
     */
    BizData4Page queryPage(ActivityParam param, int pageNo, int pageSize);

    /**
     * 新增一条活动记录
     * @param param         新增参数
     * @param accountDto    当前操作用户
     * @return  返回，操作码
     */
    String add(ActivityParam param, AccountDto accountDto);

    /**
     * 更新活动
     * @param param         新增参数
     * @param accountDto    当前作用用户
     * @return 返回，操作码
     */
    String update(ActivityParam param, AccountDto accountDto);

    /**
     * 启用或停用分活动
     * @param id        活动id
     * @param status    活动状态， 0：启用，1：停用
     * @return  返回，操作码
     */
    String disableOrEnable(long id, int status);
}