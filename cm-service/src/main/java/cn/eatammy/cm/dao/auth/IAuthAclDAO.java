/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：访问控制表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-08-09  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.dao.auth;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.auth.AuthAcl;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《访问控制》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IAuthAclDAO extends ICMBaseDAO<AuthAcl> {

    /**
     * 根据字段批量删除
     *
     * @param property 字段
     * @param values   字段值集合
     * @return 返回，非零：成功删除的条数，0：删除失败
     */
    @DataSource("write")
    int deleteBatchByProperty(@Param("property") String property, @Param("list") List<Object> values);

    /**
     * 查询资源code用户回显
     *
     * @param subjectType 主体类型，0：角色
     * @param subjectCode 主体代码
     * @return 返回，资源列表
     */
    @DataSource("read")
    List<String> queryResourceCode(@Param("subjectType") Integer subjectType, @Param("subjectCode") String subjectCode);

    /**
     * 批量插入
     * @param authAcls  权限控制集合
     * @return  受影响行数
     */
    @DataSource("write")
    int insertBatch(@Param("authAclList") List<AuthAcl> authAcls);
}