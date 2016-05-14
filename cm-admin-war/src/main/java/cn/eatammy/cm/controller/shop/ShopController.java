package cn.eatammy.cm.controller.shop;

import cn.eatammy.cm.domain.business.ShopEx;
import cn.eatammy.cm.param.business.ShopParamEx;
import cn.eatammy.cm.service.business.IShopService;
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

    /**
     * 审核商店
     * @param code      商店code
     * @param status    状态，0：通过，1：审核
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
    public String disableOrEnable(String code, @RequestParam(defaultValue = "0")int status){
        return shopService.disableOrEnable(code, status);
    }

    /**
     * 根据code查询商店信息
     * @param code  商店code
     * @return  返回，商店信息
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public ShopEx queryOne(String code){
        return shopService.queryOne(code);
    }

    /**
     * 根据用户id删除商店
     * @param id    商店id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(long id){
        if (shopService.deleteById(id) == 1){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        } else {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }
}
