/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商品信息表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-23  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.service.business;

import cn.eatammy.cm.param.business.GoodsParam;
import cn.eatammy.cm.param.business.GoodsParamEx;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.service.IPageService;

/**
 * 《商品信息》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IGoodsService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {

    /**
     * 商品分类
     * @param paramEx       插叙条件
     * @param pageNo        页码
     * @param pageSize      也大小
     * @return 返回， 分页结果
     */
    BizData4Page queryPage(GoodsParamEx paramEx, int pageNo, int pageSize);

    /**
     * 保存商品
     * @param param
     * @param currentUser
     * @return
     */
    String add(GoodsParam param, AccountDto currentUser);
}