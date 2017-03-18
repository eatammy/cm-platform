package cn.eatammy.cm.controller.bi;

import cn.eatammy.cm.service.bi.IBIBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 郭旭辉 on 2017/3/5.
 * 商家bi预测
 */
@Controller
@RequestMapping(value = "/cm/admin/bi/shop")
public class BIShopBusinessController {

    @Autowired
    private IBIBusinessService biBusinessService;

    /**
     * 统计近一个月订单数
     * @param shopCode  商店id
     * @return  返回，统计结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryIndents4Shop")
    public Map<String, Object> queryIndents4Shop(String shopCode){
        return biBusinessService.queryIndents4Shop(shopCode);
    }

    /**
     * 封装商店销售总额
     * @param shopCode      商店代码
     * @return  返回，销售订单统计
     */
    @ResponseBody
    @RequestMapping(value = "/querySales4Shop")
    public Map<String, Object> querySales4Shop(String shopCode){
        return biBusinessService.querySales4Shop(shopCode);
    }
}
