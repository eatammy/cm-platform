package cn.eatammy.cm.controller.activity;

import cn.eatammy.cm.domain.activity.BusinessActivicty;
import cn.eatammy.cm.param.activity.BusinessActivictyParam;
import cn.eatammy.cm.param.activity.BusinessActivictyParamEx;
import cn.eatammy.cm.service.activity.IBusinessActivictyService;
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
@RequestMapping(value = "/cm/admin/businessActivity")
public class BusinessActivictyController {

    @Autowired
    private IBusinessActivictyService businessActivictyService;

    /**
     * 我的活动分页
     * @param paramEx     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，分页结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage4Me", method = RequestMethod.POST)
    public BizData4Page queryPage4Me(BusinessActivictyParamEx paramEx, @RequestParam(defaultValue = "1")int pageNo, @RequestParam(defaultValue = "10")int pageSize){
        return businessActivictyService.queryPage4Me(paramEx, pageNo, pageSize);
    }

    /**
     * 商家活动
     * @param paramEx     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，分页结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public BizData4Page queryPage(BusinessActivictyParamEx paramEx, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
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

    /**
     * 停用启用商城活动
     * @param id        活动id
     * @param status    活动
     * @return 返回操作码
     */
    @ResponseBody
    @RequestMapping(value= "/disableOrEnable")
    public String disableOrEnable(long id, int status){
        return businessActivictyService.disableOrEnable(id, status);
    }

    /**
     * 删除单个活动
     * @param id    活动id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value="/deleteOne")
    public String deleteOne(long id){
        if(businessActivictyService.deleteById(id) == 1){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    /**
     * 批量删除活动
     * @param ids   活动ids
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "deleteByIds")
    public String deletebyIds(Long[] ids){
        if (businessActivictyService.deleteByIds(Arrays.asList(ids)) == 1){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}
