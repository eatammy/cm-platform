package cn.eatammy.common.qiniu;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * Created by 郭旭辉 on 2016/4/19.
 */
public class UploadUtils {
    public static final String ACCESS_KEY = "qVyMxFKzP0dwwTmMbnCkXfX0pfhnDQVoL3TxoKxR";
    public static final String SECRET_KEY = "U_aQRil_1zMkFCyEOmaT5AX3lhnDbpjcUHFDe4lT";

    public UploadUtils() {
    }

    /**
     * 简单上传，使用默认策略
     *
     * @param auth   auth
     * @param bucket 上传空间
     * @return 返回 token
     */
    public static String generalToken(Auth auth, String bucket) {
        return auth.uploadToken(bucket);
    }

    /**
     * 覆盖上传
     * @param auth  auth
     * @return 返回，token
     */
    public static String generalToken1(Auth auth) {
        return auth.uploadToken("bucket", "auth");
    }

    /**
     * 覆盖上传
     * @param auth  auth
     * @return 返回，token
     */
    public static String generalToken2(Auth auth){
        return auth.uploadToken("bucket", null, 3600, new StringMap()
                .put("callbackUrl", "call back url").putNotEmpty("callbackHost", "")
                .put("callbackBody", "key=$(key)&hash=$(etag)"));
    }

    /**
     * 覆盖上传
     * @param auth  auth
     * @return 返回，token
     */
    public static String generalToken3(Auth auth){
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
     *        scope通过 bucket、key间接设置，deadline 通过 expires 间接设置
     * @param strict  是否去除非限定的策略字段，默认true
     * @return 生成的上传token
     */
    @Deprecated
    public String uploadToken(String bucket, String key, long expires, StringMap policy, boolean strict){return null;}
}
