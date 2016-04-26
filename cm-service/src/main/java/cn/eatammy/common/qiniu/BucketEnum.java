package cn.eatammy.common.qiniu;

/**
 * Created by 郭旭辉 on 2016/4/26.
 * bucketl类型
 */
public enum  BucketEnum {
    BUSINESS("business"),
    COOKBOOK("cookbook"),
    DISCOVER("discover"),
    HEADICON("headicon");
    private String bucketName;
    BucketEnum(String bucketName){
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
