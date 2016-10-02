package cn.eatammy.cm.controller.feedback;

import cn.eatammy.cm.service.sys.IFeedbackService;
import cn.eatammy.common.domain.BizData4Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 郭旭辉 on 2016/4/16.
 * 分类管理控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/feedback")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * 分页查询
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，统计结果集合
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page queryPage(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        return feedbackService.queryPage(pageNo, pageSize);
    }


}
