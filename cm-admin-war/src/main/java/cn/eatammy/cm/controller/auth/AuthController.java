package cn.eatammy.cm.controller.auth;

import cn.eatammy.cm.domain.auth.AuthModule;
import cn.eatammy.cm.service.auth.IAuthModuleService;
import cn.eatammy.cm.service.auth.IAuthOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/8/21.
 * 权限控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/auth")
public class AuthController {


    @Autowired
    private IAuthModuleService authModuleService;

    @Autowired
    private IAuthOperationService authOperationService;

    /**
     * 获取用户某个身份下的模块列表
     * @param uid           用户uid
     * @param userType      用户身份值
     * @return  返回，模块列表
     */
    @ResponseBody
    @RequestMapping(value = "/getModules")
    public List<AuthModule> getModules(@RequestParam(required = true) String uid, @RequestParam(required = true) int userType) {
        return authModuleService.getModules(uid, userType);
    }

    /**
     * 获取当前用户的权限数据列表，每个权限由moduleUrl+authCode组成
     * @param uid       用户uid
     * @param userType  用户身份值
     * @return  返回，权限数据列表
     */
    @ResponseBody
    @RequestMapping(value = "/getPermissions")
    public List<String> getPermissions(@RequestParam(required = true) String uid, @RequestParam(required = true) int userType){
        List<String> result = new ArrayList<>();
        Map<String, List<String>> authCodeListMap = authOperationService.getOperation(uid, userType);
        for(Map.Entry<String, List<String>> entry : authCodeListMap.entrySet()){
           String moduleUrl = entry.getKey();
            if(!moduleUrl.endsWith("/")){
                moduleUrl += "/";
            }
            for(String authCode: entry.getValue()){
                result.add(moduleUrl+authCode);
            }
        }
        return  result;
    }
}
