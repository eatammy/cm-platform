package cn.eatammy.cm.controller.activity;

import cn.eatammy.cm.param.activity.ActivityParam;
import cn.eatammy.cm.service.activity.IActivityService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.utils.User.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 郭旭辉 on 2016/5/23.
 */
@Controller
@RequestMapping(value= "/cm/admin/activity")
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    /**
     * 分页查询活动
     * @param param     查询参数
     * @param pageNO    页码
     * @param pageSize  页大小
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    private BizData4Page queryPage(ActivityParam param, @RequestParam(defaultValue = "1") int pageNO, @RequestParam(defaultValue = "1") int pageSize){
        return activityService.queryPage(param, pageNO, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ActivityParam param){
        return activityService.add(param, UserContext.getCurrentUser());
    }
}
