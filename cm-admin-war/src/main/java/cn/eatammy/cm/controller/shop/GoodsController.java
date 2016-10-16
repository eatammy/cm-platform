package cn.eatammy.cm.controller.shop;

import cn.eatammy.cm.domain.business.Goods;
import cn.eatammy.cm.param.business.GoodsParam;
import cn.eatammy.cm.param.business.GoodsParamEx;
import cn.eatammy.cm.service.business.IGoodsService;
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
 * Created by 郭旭辉 on 2016/5/16.
 */
@Controller
@RequestMapping(value = "/cm/admin/goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;

    /**
     * 分页查询
     *
     * @param paramEx  查询参数
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 返回，分页结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public BizData4Page queryPage(GoodsParamEx paramEx, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return goodsService.queryPage(paramEx, pageNo, pageSize);
    }

    /**
     * 保存商品
     *
     * @param param 商品信息参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(GoodsParam param) {
        return goodsService.add(param, UserContext.getCurrentUser());
    }


    /**
     * 根据id返回商品信息
     *
     * @param id 商品id
     * @return 返回，商品信息
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public Goods queryOne(long id) {
        return (Goods) goodsService.findOne(GoodsParam.F_ID, id);
    }

    /**
     * 更新当前商品信息
     * @param param 参数信息
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(GoodsParam param){
        return goodsService.update(param, UserContext.getCurrentUser());
    }

    /**
     * 根据id删除一条商品信息
     * @param id    商品id
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(long id){
        if(goodsService.deleteById(id) == 1){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }else{
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 批量删除
     *
     * @param ids id列表
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public String deleteByIds(Long[] ids) {
        if (goodsService.deleteByIds(Arrays.asList(ids)) != 0) {
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        } else {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 启用， 停用商品
     *
     * @param id     用户id
     * @param status 用户状态，0：启用，1：停用
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
    public String disableOrEnable(Long id, Integer status) {
        return goodsService.disableOrEnable(id, status);
    }

}
