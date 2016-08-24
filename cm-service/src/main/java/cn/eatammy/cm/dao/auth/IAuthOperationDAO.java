/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：权限操作表											
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
import cn.eatammy.cm.domain.auth.AuthOperation;
import cn.eatammy.cm.domain.auth.AuthOperationEx;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《权限操作》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IAuthOperationDAO extends ICMBaseDAO<AuthOperation> {

    /**
     * 根据模块code删除操作
     * @param moduleCodes   模块code列表
     * @return  返回，非零：成功删除的记录数，0：失败
     */
    int deleteOperationByCodes(@Param("list") List<String> moduleCodes);

    /**
     * 分页查询（带模块名）
     * @param condition 条件
     * @param offset    便宜量
     * @param rows      页码大小
     * @return   分页数据
     */
    @DataSource("read")
    List<AuthOperationEx> queryPageEx(@Param("condition")Map<String, Object> condition, @Param("offset")int offset, @Param("rows")int rows);

    /**
     * 分页查询统计
     * @param condition 条件
     * @return 返回，统计结果
     */
    @DataSource("read")
    int countEx(@Param("condition")Map<String, Object> condition);

    /**
     * 获取用户当前身份下的的操作列表
     * @param userCode  用户代码
     * @param userType  用户code
     * @return 返回，权限列表
     */
    @DataSource("read")
    List<AuthOperation> queryOperationsByUser(@Param("userCode") String userCode, @Param("userType")int userType, @Param("offset") Integer offset, @Param("rows") Integer rows);
}