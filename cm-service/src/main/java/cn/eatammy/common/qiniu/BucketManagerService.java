package cn.eatammy.common.qiniu;

import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FileInfo;
import org.springframework.stereotype.Component;

/**
 * Created by 郭旭辉 on 2016/4/26.
 * 空间资源管理
 */
@Component("bucketManagerService")
public class BucketManagerService {

    private BucketManager bucketManager = null;

    /**
     * 获取空间管理器
     * @return 返回，管理器实例
     */
    private BucketManager getBucketManager(){
        return new BucketManager(UploadUtils.auth);
    }

    /**
     * 获取文件信息
     * @param bucket    空间名称
     * @param key       文件名称
     * @return 返回，文件信息
     */
    public FileInfo getFileInfo(String bucket, String key){
        try {
            return getBucketManager().stat(bucket, key);
        } catch (QiniuException e) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 移动单个文件（将文件从文件key移动到文件key2, 可以在不同bucket移动，同空间移动相当于重命名）
     * @param bucket    空间1
     * @param key       文件名
     * @param bucket2   空间2
     * @param key       文件名2
     */
    public void moveFile(String bucket, String key, String bucket2, String key2){
        try {
            getBucketManager().move(bucket, key, bucket2, key2);
        } catch (QiniuException e) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 复制单个文件（将文件从文件key 复制到文件key2。 可以在不同bucket复制）
     * @param bucket    空间1
     * @param key       文件名
     * @param bucket2   空间2
     * @param key       文件名2
     */
    public void copyFile(String bucket, String key, String bucket2, String key2){
        try {
            getBucketManager().copy(bucket, key, bucket2, key2);

        } catch (QiniuException e) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    /**
     * 删除单个文件
     * @param bucket    空间
     * @param key       文件名
     */
    public void deleteFile(String bucket, String key){
        try {
            getBucketManager().delete(bucket, key);
        } catch (QiniuException e) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

}
