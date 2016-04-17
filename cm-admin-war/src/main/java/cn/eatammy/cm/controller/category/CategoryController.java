package cn.eatammy.cm.controller.category;

import cn.eatammy.cm.domain.sys.Category;
import cn.eatammy.cm.param.sys.CategoryParam;
import cn.eatammy.cm.service.sys.ICategoryService;
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
 * Created by 郭旭辉 on 2016/4/16.
 * 分类管理控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    /**
     * 保存分类
     *
     * @param param 分类实体参数
     * @return 返回操作码
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(CategoryParam param) {
        return categoryService.add(param, UserContext.getCurrentUser());
    }

    /**
     * 分页查询
     *
     * @param name     分类名称
     * @param type     分类类型，1：食谱分类，2：商店分类,4：商品分类，8：活动分类
     * @param status   状态，）：正常，1：审核
     * @param pageNo   页码，默认1
     * @param pageSize 页大小，默认10
     * @return 返回分页结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public BizData4Page<Category> queryPage(String name, int type, int status, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return categoryService.queryPage(name, type, status, pageNo, pageSize);
    }

    /**
     * 根据id获取单个分类
     * @param id 分类id
     * @return 返回，分类值
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    public Category queryOne(int id){
        return (Category) categoryService.findOne(CategoryParam.F_ID, id);
    }

    /**
     * 更新分类
     * @param param 分类实体参数
     * @return，返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(CategoryParam param){
        return categoryService.update(param, UserContext.getCurrentUser());
    }

    /**
     * 启用，停用分类
     * @param id        分类id
     * @param status    分类状态，0：启用，1：停用
     * @return 返回操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
    public String disableOrEnable(long id, int status){
        return categoryService.disableOrEnable(id, status);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(long id){
        if(categoryService.deleteById(id) == 1){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public String deleteByIds(long[] ids){
        return categoryService.deleteByIds(ids);
    }

}
