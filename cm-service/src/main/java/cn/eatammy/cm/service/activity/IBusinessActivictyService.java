/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商城活动											
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

import cn.eatammy.cm.param.activity.BusinessActivictyParam;
import cn.eatammy.cm.param.activity.BusinessActivictyParamEx;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.service.IPageService;

/**
 * 《商城活动》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IBusinessActivictyService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {

    /**
     * 分页查询
     * @param paramEx     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return 返回，分页列表
     */
    BizData4Page queryPage(BusinessActivictyParamEx paramEx, int pageNo, int pageSize);

    /**
     * 新增商家活动
     * @param param         新增参数
     * @param currentUser   当前操作用户
     * @return 返回，操作码
     */
    String add(BusinessActivictyParam param, AccountDto currentUser);

    /**
     * 更新商家活动
     * @param param         更新参数
     * @param currentUser   当前操作用户
     * @return  返回，操作码
     */
    String update(BusinessActivictyParam param, AccountDto currentUser);

    /**
     * 启用或停用分活动
     * @param id        活动id
     * @param status    活动状态， 0：启用，1：停用
     * @return  返回，操作码
     */
    String disableOrEnable(long id, int status);
}