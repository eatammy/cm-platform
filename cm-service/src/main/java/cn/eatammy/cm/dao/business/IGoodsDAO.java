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
{  2016-03-14  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.dao.business;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.bi.BiResultDto;
import cn.eatammy.cm.domain.business.Goods;
import cn.eatammy.cm.domain.business.GoodsEx;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《商品信息》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IGoodsDAO extends ICMBaseDAO<Goods> {


    /**
     * 查询商品列表
     *
     * @param condition 查询条件
     * @param offset    偏移量
     * @param rows      行数
     * @return  返回，查询列表
     */
    @DataSource("read")
    List<GoodsEx> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);


    /**
     * 统计分页总数
     * @param condition 查询条件
     * @return  返回，统计结果
     */
    @DataSource("read")
    int countEx(@Param("condition") Map<String, Object> condition);

    /**
     * 启用，停用商品
     * @param id        商品id
     * @param status    商品状态，0：启用，1：停用
     * @return 返回， 0：失败，1：成功
     */
    @DataSource("write")
    int disableOrEnable(@Param("id")long id, @Param("status")int status);

    /**
     * 批量插入商品
     * @param goodses   商品列表
     * @return  返回，非零：成功插入的条数，零，失败
     */
    @DataSource("write")
    int addBatch(@Param("list")List<Goods> goodses);

    /**
     * 随机获取N条商品信息
     * @param num   条数
     * @return  返回，商品列表
     */
    @DataSource("read")
    List<Goods> getRandomGoodses(@Param("num") int num);

    /**
     * 查询某一周的新增商品统计
     * @param year 年份
     * @param week 月份，0：表示当前周，1：表示上一周，-1：表示下一周，以此类推2：表示前周，-2：后周
     * @param day  天数
     * @return 返回，统计结果
     */
    @DataSource("read")
    BiResultDto countWeekGoodses(@Param("year")Integer year, @Param("week") Integer week, @Param("day") Integer day);

    /**
     * 批量更新商品库存销售量
     * @param goodses   待更新商品列表
     * @return  返回，非零，更新条数，0：更新失败
     */
    @DataSource("write")
    int updateGoodsStock(@Param("list")List<Goods> goodses);

    /**
     * 查询商品销售量前10
     * @return  返回，商品列表
     */
    @DataSource("read")
    List<Goods> queryTopTen();

    /**
     * 根据商店代码分页查询仓储情况
     * @param shopCode      商店代码
     * @param offset        偏移量
     * @param rows          页大小
     * @return  返回，分页结果集
     */
    List<GoodsEx> queryStorageByShopCode(@Param("shopCode") String shopCode, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 根据商店代码分页查询仓储情况（统计分页总数）
     * @param shopCode      商店代码
     * @return  返回，统计结果
     */
    int countStorageByShopCode(@Param("shopCode") String shopCode);

    /**
     * 根据商店代码查询商品销售排行榜
     * @param shopCode      商店代码
     * @return  返回，统计结果
     */
    List<GoodsEx> queryGoodsRankByShopCode(@Param("shopCode") String shopCode);

    /**
     * 根据商店code统计商店总销售额
     * @param shopCode  商店code
     * @return  返回，销售总额
     */
    double querySumSales(@Param("shopCode") String shopCode);
}