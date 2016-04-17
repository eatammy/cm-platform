/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：分类表											
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

package cn.eatammy.cm.dao.sys;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.sys.Category;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《分类》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface ICategoryDAO extends ICMBaseDAO<Category> {

    /**
     * 获取分类列表
     * @param name      分类名称
     * @param type      分类类型
     * @param status    分类状态
     * @param offset    偏移量
     * @param rows      行数
     * @return   返回，分类列表
     */
    @DataSource("read")
    List<Category> queryListEx(@Param("name") String name, @Param("type") Integer type, @Param("status") Integer status, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 统计分类大小
     * @param name      分类名称
     * @param type      分类类型
     * @param status    分类状态
     * @return 返回，统计结果
     */
    @DataSource("read")
    int countEx(@Param("name") String name, @Param("type") Integer type, @Param("status") Integer status);

    /**
     * 根据id更新分类
     * @param param    分类实体参数
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateById(@Param("param") Category param);
}