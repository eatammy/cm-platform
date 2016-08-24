/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：模块表											
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
import cn.eatammy.cm.domain.auth.AuthModule;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * 《模块》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IAuthModuleDAO extends ICMBaseDAO<AuthModule> {

    /**
     * 启用、停用模块节点
     * @param pCode         父code
     * @param status        状态，0：启用，1：停用
     * @param lastModifier  更新者uid
     * @param lasModDate    更新时间
     * @return  返回，操作条数，非零：成功，0：失败
     */
    @DataSource("write")
    int updateStatus(@Param("pCode") String pCode, @Param("status") int status, @Param("lastModifier") String lastModifier, @Param("lastModDate") long lasModDate);

    /**
     * 获取某个用户某种身份下拥有的模块列表
     * @param userCode  用户code（uid）
     * @param userType  用户身份值
     * @param offset    偏移量
     * @param rows      行数
     * @return  返回，模块列表
     */
    @DataSource("write")
    List<AuthModule> queryModulesByUser(@Param("userCode") String userCode, @Param("userType")int userType, @Param("offset")Integer offset, @Param("rows") Integer rows);
}