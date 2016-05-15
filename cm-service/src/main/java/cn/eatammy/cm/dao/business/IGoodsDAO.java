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
import cn.eatammy.cm.domain.business.Goods;
import cn.eatammy.cm.domain.business.GoodsEx;
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
    List<GoodsEx> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);


    /**
     * 统计分页总数
     * @param condition 查询条件
     * @return  返回，统计结果
     */
    int countEx(@Param("condition") Map<String, Object> condition);
}