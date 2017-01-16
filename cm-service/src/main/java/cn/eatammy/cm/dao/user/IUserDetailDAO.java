/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：用户表											
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

package cn.eatammy.cm.dao.user;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.bi.BiResultDto;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《用户》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IUserDetailDAO extends ICMBaseDAO<UserDetail> {

    /**
     * 根据用户名修个密码
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateEx(@Param("username") String username, @Param("password") String password);

    /**
     * 修改用户详细信息
     *
     * @param user 用户修改参数
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateDetail(@Param("user") UserDetail user);

    /**
     * 更新粉丝数
     *
     * @param count 粉丝数量
     * @param id    当前用户id
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateFuns(@Param("count") int count, @Param("id") long id);

    /**
     * 更新粉丝数
     *
     * @param count 粉丝数量
     * @param id    当前用户id
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateAttentions(@Param("count") int count, @Param("id") long id);

    /**
     * 查询用户列表
     *
     * @param condition 条件
     * @param offset    偏移量
     * @param rows      页大小
     * @return 返回，用户列表
     */
    @DataSource("read")
    List<UserDetail> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);

    @DataSource("read")
    List<UserDetail> queryPage4BI(@Param("offset") int offset, @Param("rows") int rows);
    /**
     * 分页统计
     *
     * @param condition 条件
     * @return 返回，统计值
     */
    @DataSource("read")
    int countEx(@Param("condition") Map<String, Object> condition);

    /**
     * 根据用户id更新用户状态
     * @param id        用户id
     * @param status    状态，0：正常，1：停用
     * @return 返回，0：失败，1：成功
     */
    @DataSource("write")
    int updateStatus(@Param("id") long id, @Param("status") int status);

    /**
     * 更具用户code更新用户密码
     * @param code          用户code
     * @param newPasswd     用户密码
     * @return  返回，0：失败，1：成功
     */
    @DataSource("write")
    int updatePasswdByCode(@Param("code") String code, @Param("newPasswd") String newPasswd);

    /**
     *  查询商店用户列表
     * @return 返回商店用户列表
     */
    @DataSource("read")
    List<UserDetail> queryUser4Shop();

    /**
     * 根据用户code更新用户身份
     * @param code      用户code
     * @param userType  用户身份值，普通用户：1，商家用户：2，管理员：4
     * @return
     */
    @DataSource("write")
    int updateUserTypes(@Param("code") String code, @Param("userType") int userType);

    /**
     * 批量插入用户（生产数据）
     * @param userDetails
     * @return
     */
    @DataSource("write")
    int addUsers(@Param("list")List<UserDetail> userDetails);

    /**
     * 根据用户传入条件查询用户地图（BI）
     * @param sex       性别：-1：默认，0：男，1：女
     * @param minAge    最小年龄
     * @param maxAge    最大年龄
     * @return  返回，统计数据列表
     */
    @DataSource("read")
    List<BiResultDto> queryUserMap(@Param("sex")Integer sex, @Param("minAge")Integer minAge, @Param("maxAge")Integer maxAge);

    /**
     * 查询某个月份每天的注册量 (BI)
     *
     * @param year      年份
     * @param month     月份，0，表示当前月份，递增表示往前的月份，如1，表示上个月，2表示前个月
     * @return  返回，每天注册的统计集合
     */
    @DataSource("read")
    List<BiResultDto> queryRegister(@Param("year") Integer year, @Param("month") Integer month, @Param("day") Integer day);

    /**
     * 统计当前月份的注册量（BI）
     * @return  返回，统计结果
     */
    @DataSource("read")
    int countCurMonthRegister();

    /**
     * 按周获取注册量（）
     * @return   返回，统计结果
     */
    @DataSource("read")
    List<BiResultDto> countCurWeekRegister();

    /**
     * 统计每天的注册量
     * @return  返回，统计结果
     */
    @DataSource("read")
    int countCurDayRegister();

    /**
     * 随机获取一个用户
     * @return 返回， 用户
     */
    @DataSource("read")
    UserDetail getRandomUser();

    /**
     * 随机获取用户列表
     * @param count 数量
     * @return 返回，用户列表
     */
    @DataSource("read")
    List<UserDetail> getRandomUsers(@Param("count") int count);


    /**
     * 统计不同年龄区间的用户注册量
     * @param year      年份
     * @param month     月份偏移量，0表示当前月份，1：上一个月，以此递增
     * @param day       天
     * @param minAge    最小年龄
     * @param maxAge    最大年龄
     * @return  返回统计结果集合
     */
    List<BiResultDto> countAgeRangeRegisterPV(@Param("year") Integer year, @Param("month") Integer month, @Param("day") Integer day, @Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);
}