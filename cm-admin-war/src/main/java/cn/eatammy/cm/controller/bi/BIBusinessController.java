package cn.eatammy.cm.controller.bi;

import cn.eatammy.cm.service.bi.IBIBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/9/30.
 * 商务分析控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/bibusiness")
public class BIBusinessController {
    @Autowired
    private IBIBusinessService biBusinessService;

    /**
     * 获取顶部信息呈现模块
     * @return  返回，统计结果
     */
    @ResponseBody
    @RequestMapping(value = "/getBusinessInfo")
    public Map<String, Object> getBusinessInfo() {
        return biBusinessService.getBusinessInfo();
    }

    /**
     * 订单图表呈现
     * @param year      年份
     * @param month     月份
     * @return  返回，统计结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryBusinessChart")
    public Map<String, Object> queryBusinessChart(int year, @RequestParam(defaultValue = "0") int month){
        return  biBusinessService.queryBusinessChart(year, month);
    }

    /**
     * 查询排行榜信息
     * @return  返回，统计排行榜集合
     */
    @ResponseBody
    @RequestMapping(value = "/queryRanking")
    public Map<String, Object> queryRanking(){
        return biBusinessService.queryRanking();
    }

    /**
     * 查询交易地区map
     * @return  返回，统计交易地区信息集合
     */
    @ResponseBody
    @RequestMapping(value = "/queryTradesZoo")
    public Map<String, Object> queryTradesZoo(){
        return biBusinessService.queryTradesZoo();
    }

}
