package cn.eatammy.cm.controller.category;

import cn.eatammy.cm.param.sys.CategoryParam;
import cn.eatammy.cm.service.sys.ICategoryService;
import cn.eatammy.common.utils.User.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(CategoryParam param){
        return categoryService.add(param, UserContext.getCurrentUser());
    }


}
