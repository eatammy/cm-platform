package cn.eatammy.common.sys.redis.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 郭旭辉 on 2016/7/11.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Cacheable {

    enum KeyMode {
        DEFAULT,    //只有加了@CacheKey的参数，才加入key后缀
        BASIC,      //只有基本类型参数，才加入key后缀，如：String，Integer,Long,Short,boolean
        ALL        //所有参数都加入key后缀
    }

    String key() default  ""; //缓存key
    KeyMode keyMode() default  KeyMode.DEFAULT; //key 的后缀模式
    int expire() default  0; // 缓存多少秒，默认无期限
}
