package cn.eatammy.cm.controller.activity;

import cn.eatammy.cm.service.activity.IBusinessActivictyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
/**
 * Created by 郭旭辉 on 2016/5/23.
 */
@Controller
@RequestMapping(value = "/cm/admin/businessActivity")
public class BusinessActivictyController {

    @Autowired
    private IBusinessActivictyService businessActivictyService;

}
