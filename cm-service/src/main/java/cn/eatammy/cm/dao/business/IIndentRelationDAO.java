/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：订单关系表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-06-13  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.dao.business;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.business.IndentRelation;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《订单关系》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IIndentRelationDAO extends ICMBaseDAO<IndentRelation> {

    /**
     * 批量插入关系
     *
     * @param list 关系列表
     * @return 返回，0；失败，非零：成功
     */
    @DataSource("write")
    int insertRelations(@Param("list") List<IndentRelation> list);
}