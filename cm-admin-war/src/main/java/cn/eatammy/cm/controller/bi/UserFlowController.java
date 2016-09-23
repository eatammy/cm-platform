package cn.eatammy.cm.controller.bi;

import cn.eatammy.cm.service.bi.IUserFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/9/3.
 * 用户流量表
 */
@Controller
@RequestMapping(value = "/cm/admin/userFlow")
public class UserFlowController {

    @Autowired
    private IUserFlowService userFlowService;

    /**
     * 查询用户在中国地图上的分布情况
     *
     * @return 返回，地图信息
     */
    @ResponseBody
    @RequestMapping(value = "/getUserMap")
    public Map<String, Object> getUserMap(@RequestParam(defaultValue = "-1") Integer sex, @RequestParam(defaultValue = "0") Integer minAge, @RequestParam(defaultValue = "0") Integer maxAge) {
        return userFlowService.queryUserMap(sex, minAge, maxAge);
    }


    /**
     * 初始化注册面板
     *
     * @return 返回，注册统计结果
     */
    @ResponseBody
    @RequestMapping(value = "/getRegisterInfo")
    public Map<String, Object> getRegisterInfo() {
        return userFlowService.getRegisterInfo();
    }

    /**
     * 获取注册量表图
     *
     * @param month 月份
     * @return 返回，当月注册量信息
     */
    @ResponseBody
    @RequestMapping(value = "/getRegisterCharts")
    public Map<String, Object> getRegisterCharts(@RequestParam(defaultValue = "0") Integer month) {
        return userFlowService.getRegisterCharts(month);
    }


    @ResponseBody
    @RequestMapping(value = "/{type}/getUserCharts")
    public Map<String, Object> getUserCharts(@PathVariable("type") Integer type, @RequestParam(defaultValue = "0") Integer month, Integer year, @RequestParam(defaultValue = "0") Integer isDefault) {
        return userFlowService.getUserCharts(type, month, year, isDefault);
    }
}
