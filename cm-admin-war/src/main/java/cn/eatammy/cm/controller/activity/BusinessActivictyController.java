package cn.eatammy.cm.controller.activity;

import cn.eatammy.cm.domain.activity.BusinessActivicty;
import cn.eatammy.cm.param.activity.BusinessActivictyParam;
import cn.eatammy.cm.param.activity.BusinessActivictyParamEx;
import cn.eatammy.cm.service.activity.IBusinessActivictyService;
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
@RequestMapping(value = "/cm/admin/businessActivity")
public class BusinessActivictyController {

    @Autowired
    private IBusinessActivictyService businessActivictyService;

    /**
     * 分页查询
     * @param paramEx     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，分页结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public BizData4Page queryPage(BusinessActivictyParamEx paramEx, @RequestParam(defaultValue = "1")int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        return businessActivictyService.queryPage(paramEx, pageNo, pageSize);
    }

    /**
     * 新增商家活动
     * @param param     新增参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(BusinessActivictyParam param){
        return businessActivictyService.add(param, UserContext.getCurrentUser());
    }

    /**
     * 查询一条商家活动
     * @param id    商家活动id
     * @return  返回，商家活动信息
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public BusinessActivicty queryOne(long id){
        return (BusinessActivicty) businessActivictyService.findOne(BusinessActivictyParam.F_ID, id);
    }

    /**
     * 更新商家活动
     * @param param 更新参数
     * @return 返回，参数
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(BusinessActivictyParam param){
        return businessActivictyService.update(param, UserContext.getCurrentUser());
    }
}
