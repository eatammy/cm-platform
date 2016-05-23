package cn.eatammy.cm.controller.activity;

import cn.eatammy.cm.domain.activity.Activity;
import cn.eatammy.cm.param.activity.ActivityParam;
import cn.eatammy.cm.service.activity.IActivityService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.RETURNCODE;
import cn.eatammy.common.utils.User.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
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

    /**
     * 新增一条活动
     * @param param 新增参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ActivityParam param){
        return activityService.add(param, UserContext.getCurrentUser());
    }

    /**
     * 查询一条记录
     * @param id    活动id
     * @return 返回，活动信息
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public Activity queryOne(long id){
        return (Activity) activityService.findOne(ActivityParam.F_ID, id);
    }

    /**
     * 更新活动
     * @param param 更新参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ActivityParam param){
        return activityService.update(param, UserContext.getCurrentUser());
    }

    /**
     * 删除一条活动
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(long id){
        if(activityService.deleteById(id) == 1){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }else{
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 批量删除活动
     * @param ids   活动id
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public String deleteByIds(Long[] ids){
        if(activityService.deleteByIds(Arrays.asList(ids)) > 0){
            return  RETURNCODE.DELETE_COMPLETE.getMessage();
        }else{
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 启用或停用分活动
     * @param id        活动id
     * @param status    活动状态， 0：启用，1：停用
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
    public String disableOrEnable(long id, int status){
        return activityService.disableOrEnable(id, status);
    }
}
