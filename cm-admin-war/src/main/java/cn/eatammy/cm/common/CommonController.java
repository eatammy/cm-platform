package cn.eatammy.cm.common;

import cn.eatammy.common.qiniu.BucketEnum;
import cn.eatammy.common.qiniu.UploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 郭旭辉 on 2016/3/25.
 * 公用请求控制类
 */
@Controller
@RequestMapping(value = "/cm/admin/common")
public class CommonController {


    /**
     * 获取上传凭证
     * @return 返回，上传凭证
     */
    @ResponseBody
    @RequestMapping(value = "/generalUploadToken")
    public String generalUploadToken(){
        return UploadUtils.generalToken(BucketEnum.COOKBOOK.getBucketName());
    }
}
