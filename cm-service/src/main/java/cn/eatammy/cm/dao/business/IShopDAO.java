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
{  2016-03-14  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.dao.business;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.business.Shop;
import cn.eatammy.cm.domain.business.ShopEx;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《商家》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IShopDAO extends ICMBaseDAO<Shop> {

    /**
     * 分页查询商店接口
     *
     * @param condition
     * @param rows
     * @param offset
     * @return
     */
    @DataSource("read")
    List<ShopEx> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 统计分页行数
     * @param condition 分页查询条件
     * @return 返回，统计结果
     */
    @DataSource("read")
    int countEx(@Param("condition") Map<String, Object> condition);

    /**
     * 更新商店状态
     * @param id      商店id
     * @param status    状态，0：营业，1：审核
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateShopStatus(@Param("id")long id, @Param("status")int status);

    /**
     * 查询单个商店
     * @param code  商店
     * @return 返回，商店信息
     */
    @DataSource("read")
    ShopEx queryOneEx(@Param("code") String code);

    /**
     * 根据uid查询商店
     * @param uid   用户uid
     * @return 返回，商店信息
     */
    @DataSource("read")
    ShopEx queryShopByUid(@Param("uid") String uid);

    /**
     * 更新商家收入
     * @param income    收入
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateIncome(@Param("income") Float income);
}