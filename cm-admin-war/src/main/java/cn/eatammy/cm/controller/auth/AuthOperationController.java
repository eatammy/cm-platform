package cn.eatammy.cm.controller.auth;

import cn.eatammy.cm.domain.auth.AuthOperation;
import cn.eatammy.cm.param.auth.AuthOperationParam;
import cn.eatammy.cm.service.auth.IAuthOperationService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.utils.RETURNCODE;
import cn.eatammy.common.utils.User.UserContext;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 郭旭辉 on 2016/8/16.
 *  操作控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/authOperation")
public class AuthOperationController {
    @Autowired
    private IAuthOperationService authOperationService;

    /**
     * 根据条件分页查询所有角色
     * @param param         功能查询参数
     * @param pageNo        页码
     * @param pageSize      页大小
     * @return  返回，分页列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    @RequiresPermissions("operation:query")
    public BizData4Page queryPage(AuthOperationParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        return authOperationService.queryPageEx(param, pageNo, pageSize);
    }

    /**
     * 新增操作
     * @param authOperation     操作实体
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("operation:add")
    public String add(AuthOperation authOperation){
        return authOperationService.add(authOperation, UserContext.getCurrentUser());
    }

    /**
     * 获取一个功能信息（用于修改）
     * @param id    功能id
     * @return 返回，功能实体信息
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    @RequiresPermissions("operation:query")
    public AuthOperation queryOne(@RequestParam(required = true) long id){
        return (AuthOperation) authOperationService.findOne(AuthOperationParam.F_ID, id);
    }

    /**
     * 更新功能信息
     * @param authOperation     功能实体
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    @RequiresPermissions("operation:update")
    public String update(AuthOperation authOperation){
        return authOperationService.update(authOperation, UserContext.getCurrentUser());
    }

    /**
     * 启用、停用功能
     * @param id    功能id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
    @RequiresPermissions("operation:disableOrEnable")
    public String disableOrEnable(@RequestParam(required = true) long id){
        return authOperationService.disableOrEnable(id, UserContext.getCurrentUser());
    }

    /**
     * 删除单个
     * @param id    功能id
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    @RequiresPermissions("operation:delete")
    public String deleteOne(@RequestParam(required = true) long id){
        return authOperationService.deleteOne(id);
    }

    /**
     * 批量删除
     * @param ids   id数组
     * @return 　返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "deleteByIds")
    @RequiresPermissions("operation:delete")
    public String deleteByIds(@RequestParam(required = true) Long[] ids){
        List<Long> list = Arrays.asList(ids);
        for(Long id: list){
            authOperationService.deleteOne(id);
        }
        return RETURNCODE.DELETE_COMPLETE.getMessage();
    }

}
