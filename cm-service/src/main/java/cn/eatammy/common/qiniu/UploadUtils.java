package cn.eatammy.common.qiniu;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * Created by 郭旭辉 on 2016/4/19.
 */
public class UploadUtils {
    public static final String ACCESS_KEY = "m4J_jaQvhVieQxlJfqPu6Imrn6Qu8aMTzWX7OJBK";
    public static final String SECRET_KEY = "fBn9DJg1Lrpw6U9yQ8wLJW3na_ZH59wjMVq41LOY";

    public static final Auth auth = Auth.create(UploadUtils.ACCESS_KEY, UploadUtils.SECRET_KEY);
    public UploadUtils() {
    }


    /**
     * 简单上传，使用默认策略
     *
     * @param bucket 上传空间
     * @return 返回 token
     */
    public static String generalToken(String bucket) {
        return auth.uploadToken(bucket);
    }

    /**
     * 覆盖上传
     *
     * @param bucket       bucket位置
     * @param key          文件名称
     * @param timeout      token过期时间
     * @param isInsertOnly 只能上传指定key的文件，并且不允许修改，那么可以将下面的 insertOnly 属性值设为 1。
     * @return ，返回token
     */
    public static String generalToken(String bucket, String key, long timeout, int isInsertOnly) {
        if (isInsertOnly == 1) {
            return auth.uploadToken(bucket, key, timeout, new StringMap().put("insertOnly", 1));
        }
        return auth.uploadToken(bucket, key, timeout, new StringMap().put("insertOnly", 0));
    }

    /**
     * 覆盖上传
     *
     * @return 返回，token
     */
    public static String generalToken2() {
        return auth.uploadToken("bucket", null, 3600, new StringMap()
                .put("callbackUrl", "call back url").putNotEmpty("callbackHost", "")
                .put("callbackBody", "key=$(key)&hash=$(etag)"));
    }

    /**
     * 覆盖上传
     *
     * @return 返回，token
     */
    public static String generalToken3() {
        return auth.uploadToken("bucket", null, 3600, new StringMap()
                .putNotEmpty("persistentOps", "").putNotEmpty("persistentNotifyUrl", "")
                .putNotEmpty("persistentPipeline", ""), true);
    }

    /**
     * 生成上传token
     *
     * @param bucket  空间名
     * @param key     key，可为 null
     * @param expires 有效时长，单位秒。默认3600s
     * @param policy  上传策略的其它参数，如 new StringMap().put("endUser", "uid").putNotEmpty("returnBody", "")。
     *                scope通过 bucket、key间接设置，deadline 通过 expires 间接设置
     * @param strict  是否去除非限定的策略字段，默认true
     * @return 生成的上传token
     */
    @Deprecated
    public String uploadToken(String bucket, String key, long expires, StringMap policy, boolean strict) {
        return null;
    }





    public static void main(String[] args) throws QiniuException {
        //创建上传对象
        UploadManager uploadManager = new UploadManager();
        //调用put方法上传
        Response res = uploadManager.put("haha".getBytes(), "haha.txt", generalToken(BucketEnum.AUTH.getBucketName()));
        //打印返回的信息
        System.out.println(res.bodyString());
    }
}
