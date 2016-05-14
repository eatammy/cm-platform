package cn.eatammy.cm.common;

import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.qiniu.BucketEnum;
import cn.eatammy.common.qiniu.BucketManagerService;
import cn.eatammy.common.qiniu.UploadUtils;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BucketManagerService bucketManagerService;

    /**
     * 获取上传凭证
     *
     * @return 返回，上传凭证
     */
    @ResponseBody
    @RequestMapping(value = "/generalUploadToken")
    public String generalUploadToken(int type, String key) {
        switch (type) {
            case 1:
                return UploadUtils.generalToken(BucketEnum.BUSINESS.getBucketName(), key, 300000, 0);
            case 2:
                return UploadUtils.generalToken(BucketEnum.COOKBOOK.getBucketName(), key, 300000, 0);
            case 3:
                return UploadUtils.generalToken(BucketEnum.DISCOVER.getBucketName(), key, 300000, 0);
            case 4:
                return UploadUtils.generalToken(BucketEnum.HEADICON.getBucketName(), key, 300000, 0);
            case 5:
                return UploadUtils.generalToken(BucketEnum.AUTH.getBucketName(), key, 300000, 0);
            default:
                throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 删除文件
     * @param type  空间类型，
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteImg")
    public String deleteImg(int type, String key){
        switch (type) {
            case 1:
                bucketManagerService.deleteFile(BucketEnum.HEADICON.getBucketName(), key);
                return RETURNCODE.DELETE_COMPLETE.getMessage();
            case 2:
                bucketManagerService.deleteFile(BucketEnum.HEADICON.getBucketName(), key);
                return RETURNCODE.DELETE_COMPLETE.getMessage();
            case 3:
                bucketManagerService.deleteFile(BucketEnum.HEADICON.getBucketName(), key);
                return RETURNCODE.DELETE_COMPLETE.getMessage();
            case 4:
                bucketManagerService.deleteFile(BucketEnum.HEADICON.getBucketName(), key);
                return RETURNCODE.DELETE_COMPLETE.getMessage();
            case 5:
                bucketManagerService.deleteFile(BucketEnum.HEADICON.getBucketName(), key);
                return RETURNCODE.DELETE_COMPLETE.getMessage();
            default:
                throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }
}
