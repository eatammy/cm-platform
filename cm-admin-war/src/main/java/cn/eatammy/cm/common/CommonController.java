package cn.eatammy.cm.common;

import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.qiniu.UploadUtils;
import cn.eatammy.common.utils.ERRORCODE;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.util.Auth;
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
        Auth auth = Auth.create(UploadUtils.ACCESS_KEY, UploadUtils.SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth);
        try {
            String[] buckets = bucketManager.buckets();
            return UploadUtils.generalToken(auth, buckets[0]);
        } catch (QiniuException e) {
            throw new BizException(ERRORCODE.TOKEN_INVALID.getCode(), ERRORCODE.TOKEN_INVALID.getMessage());
        }
    }
}
