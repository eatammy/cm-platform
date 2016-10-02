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

package cn.eatammy.cm.service.sys;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.sys.IFeedbackDAO;
import cn.eatammy.cm.domain.sys.Feedback;
import cn.eatammy.cm.domain.sys.FeedbackEx;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 《用户反馈表，记录用户反馈，建议，举报等信息》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("FeedbackServiceImpl")
public class FeedbackServiceImpl extends AbstractCMPageService<ICMBaseDAO<Feedback>, Feedback> implements IFeedbackService<ICMBaseDAO<Feedback>, Feedback> {
    @Autowired
    private IFeedbackDAO feedbackDAO;

    @Override
    public ICMBaseDAO<Feedback> getDao() {
        return feedbackDAO;
    }

    @Override
    public BizData4Page queryPage(int pageNo, int pageSize) {
        List<FeedbackEx> data = feedbackDAO.queryPageEx((pageNo - 1) * pageSize, pageSize);
        int records = this.count(null);
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }
}