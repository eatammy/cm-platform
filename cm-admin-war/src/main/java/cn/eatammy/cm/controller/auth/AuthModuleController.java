package cn.eatammy.cm.controller.auth;

import cn.eatammy.cm.domain.auth.AuthModule;
import cn.eatammy.cm.param.auth.AuthModuleParam;
import cn.eatammy.cm.service.auth.IAuthModuleService;
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

import java.util.List;

/**
 * Created by 郭旭辉 on 2016/8/12.
 * 模块控制器
 */
@Controller
@RequestMapping(value = "/cm/admin/authModule")
public class AuthModuleController {

    @Autowired
    private IAuthModuleService authModuleService;

    /**
     * 添加一个模块
     * @param authModule 模块参数实体
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("module:add")
    public String add(AuthModule authModule){
        return authModuleService.add(authModule, UserContext.getCurrentUser());
    }

    /**
     * 查询模块树
     * @param status    状态，:0：正常，：停用
     * @return 返回模块树
     */
    @ResponseBody
    @RequestMapping(value = "/queryModules")
    public List queryModules(Integer status){
        return  authModuleService.queryModules(status);
    }

    /**
     * 查询模块列表（不出现子节点）
     * @param moduleFullCode    模块fullCode
     * @return 返回模块树
     */
    @ResponseBody
    @RequestMapping(value = "/queryModulesWithoutChild")
    public List queryModulesWithoutChild(String moduleFullCode){
        return  authModuleService.queryModulesNoChildren(moduleFullCode);
    }

    /**
     * 后台分页获取模块列表
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return 返回，查询结果
     */
    @ResponseBody
    @RequestMapping(value="/queryPage", method = RequestMethod.POST)
    @RequiresPermissions("module:query")
    public BizData4Page queryPage(AuthModuleParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        return authModuleService.queryPageEx(param, pageNo, pageSize);
    }

    /**
     * 获取一个模块信息（用于修改）
     * @param id    模块id
     * @return  返回，一个模块信息
     */
    @ResponseBody
    @RequestMapping("/queryOne")
    @RequiresPermissions("module:query")
    public AuthModule queryOne(@RequestParam(required = true) long id){
        return (AuthModule) authModuleService.findOne(AuthModuleParam.F_ID, id);
    }

    /**
     * 更新模块及诶单那
     * @param authModule    模块参数
     * @return      返回，操作码
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresPermissions("module:update")
    public String update(AuthModule authModule) throws Exception {
        return authModuleService.update(authModule, UserContext.getCurrentUser());
    }

    /**
     * 启用停用模块
     * @param id    模块id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
    @RequiresPermissions("module:disableOrEnable")
    public String disableOrEnable(@RequestParam(required = true) long id){
       return authModuleService.disableOrEnable(id, UserContext.getCurrentUser());
    }

    /**
     * 删除单个模块
     * @param id    模块id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    @RequiresPermissions("module:delete")
    public String deleteOne(@RequestParam(required =  true) long id){
       return authModuleService.deleteOne(id);
    }

    /**
     * 批量删除
     * @param ids    模块id列表
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "deleteByIds")
    @RequiresPermissions("module:delete")
    public String deleteByIds(@RequestParam(required = true) Long[] ids){
        for (Long id: ids){
            authModuleService.deleteOne(id);
        }
        return RETURNCODE.DELETE_COMPLETE.getMessage();
    }

}
