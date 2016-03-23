package cn.eatammy.cm.app;

import cn.eatammy.cm.domain.cook.CookBook;
import cn.eatammy.cm.domain.cook.CookBookEx;


import cn.eatammy.cm.param.cook.CookBookParam;
import cn.eatammy.cm.param.cook.MaterialParam;
import cn.eatammy.cm.param.cook.ProcessParam;
import cn.eatammy.cm.service.cook.ICookBookService;

import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 郭旭辉 on 2016/3/14.
 *
 * 食谱控制类
 */
@Controller
@RequestMapping(value = "/cm/app/cook")
public class CookController {
    @Autowired
    private ICookBookService cookBookService;

    @ResponseBody
    @RequestMapping(value = "/saveCookBook" ,method = RequestMethod.POST)
    public String saveCookBook(CookBookParam cookBookParam, MaterialParam materialParam,
                                ProcessParam processParam){
        //获取用户信息

        String user = "test";

        //insert
        cookBookService.saveCookBook(user,cookBookParam,materialParam,processParam);

        return RETURNCODE.SUCCESS_COMPLETE.getCode();
    }


    @ResponseBody
    @RequestMapping("/findCookBook")
    public CookBookEx findCookBook(Long cookBookId){


        return cookBookService.findCookBookByCBid(cookBookId);
    }

    @ResponseBody
    @RequestMapping("/deleteCookBook")
    public String deleteCookBook(Long cookBookId){
       /* throw  new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());*/
        cookBookService.deleteCookBookByCBid(cookBookId);

        return RETURNCODE.DELETE_COMPLETE.getCode();
    }


    @ResponseBody
    @RequestMapping(value = "/updateCookBook")
    public String updateCookBook(CookBookParam cookBookParam, MaterialParam materialParam,
                                 ProcessParam processParam){
        String user = "testupdate";

        cookBookService.updateCookBook(user,cookBookParam,materialParam,processParam);
        return RETURNCODE.UPDATE_COMPLETE.getCode();
    }

    @ResponseBody
    @RequestMapping("/test1")
    public String test1( CookBook cookBook){

        System.out.println(cookBook);
        return RETURNCODE.SUCCESS_COMPLETE.getMessage();
    }
}

