/*
{*****************************************************************************
{  主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：用户反馈表，记录用户反馈，建议，举报等信息											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-02  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.dao.sys;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.domain.sys.Feedback;
import cn.eatammy.cm.domain.sys.FeedbackEx;
import cn.eatammy.common.sys.database.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《用户反馈表，记录用户反馈，建议，举报等信息》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IFeedbackDAO extends ICMBaseDAO<Feedback> {


    /**
     * 分页查询
     * @param offset    偏移量
     * @param rows      行数
     * @return  返回，反馈信息集合
     */
    @DataSource("read")
    List<FeedbackEx> queryPageEx(@Param("offset") Integer offset, @Param("rows") Integer rows);


}