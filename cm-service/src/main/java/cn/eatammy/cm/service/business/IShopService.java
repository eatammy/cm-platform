/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商家表											
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

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.business.Shop;
import cn.eatammy.cm.domain.business.ShopEx;
import cn.eatammy.cm.param.business.ShopParam;
import cn.eatammy.cm.param.business.ShopParamEx;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.service.IPageService;
import java.util.List;
/**
 * 《商家》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IShopService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {

    /**
     * 保存商店信息
     *
     * @param paramEx    商店参数列表
     * @param accountDto 当前操作用户
     * @return 返回，操作码
     */
    String add(ShopParamEx paramEx, AccountDto accountDto);

    /**
     * 批量查询商店
     * @param param         查询参数
     * @param pageNo        页码
     * @param pageSize      页大小
     * @return 返回，分页数据
     */
    BizData4Page<Shop> queryPage(ShopParam param, int pageNo, int pageSize);

    /**
     * 审核商店
     * @param id      商店code
     * @param status    状态，0：通过，1：审核
     * @return  返回，操作码
     */
    String disableOrEnable(long id, int status);

    /**
     * 根据code查询商店信息
     * @param code  商店code
     * @return  返回，商店信息
     */
    ShopEx queryOne(String code);

    /**
     * 根据id删除商店信息
     * @param id        商店id
     * @param code      商店code
     * @return  返回，操作码
     */
    String deleteOne(long id, String code);

    /**
     * 根据用户id查询商店
     * @param uid 用户id
     * @return  返回，商店信息
     */
    ShopEx findOne(String uid);

    String updateShopIncome(List<Shop> shops);
}