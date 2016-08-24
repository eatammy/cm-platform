package cn.eatammy.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 郭旭辉 on 2016/8/12.
 * 通用工具类
 */
public class CommonUtils {

    /**
     * 获取无“-”的UUID
     * @return 返回，32位的UUID
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * list类型转化
     * @param list
     * @return
     */
    public static List<Object> transList(List<String> list){
        List<Object> result = new ArrayList<>();
        for (String s : list){
            result.add(s);
        }
        return result;
    }
}
