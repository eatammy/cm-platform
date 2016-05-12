package cn.eatammy.cm.controller.shop;

import cn.eatammy.cm.param.business.ShopParamEx;
import cn.eatammy.cm.service.business.IShopService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.utils.User.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 郭旭辉 on 2016/5/11.
 * 商家审核管理控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/shop")
public class ShopController {

    @Autowired
    IShopService shopService;

    /**
     * 创建商店
     * @param paramEx   商店注册信息
     * @return 返回 ，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ShopParamEx paramEx) {
        return shopService.add(paramEx, UserContext.getCurrentUser());
    }

    /**
     * 分页查询
     * @param paramEx     商店查询参数
     * @param pageNo      页码
     * @param PageSize    页大小
     * @return  返回，商店分页数据
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page queryPage(ShopParamEx paramEx, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int PageSize){
        return shopService.queryPage(paramEx, pageNo, PageSize);
    }
}
