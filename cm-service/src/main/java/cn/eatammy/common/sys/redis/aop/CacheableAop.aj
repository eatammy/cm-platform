package cn.eatammy.common.sys.redis.aop;

import cn.eatammy.common.sys.redis.anno.CacheKey;
import cn.eatammy.common.sys.redis.anno.Cacheable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * Created by 郭旭辉 on 2016/7/11.
 *
 */
@Aspect
@Component
public class CacheableAop {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Around(value = "@annotation(cache)", argNames = "proceedingJoinPoint,cacheable")
    public Object cached(final ProceedingJoinPoint proceedingJoinPoint, Cacheable cacheable) throws Throwable {
        String key = getCahcheKey(proceedingJoinPoint, cacheable);
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Object value = valueOperations.get(key);
        if(value != null){
            return value;
        }
        value = proceedingJoinPoint.proceed();
        if(cacheable.expire() <= 0){
            valueOperations.set(key, value);
        } else{
            valueOperations.set(key,value,cacheable.expire(), TimeUnit.SECONDS);
        }
        return value;
    }

    private String getCahcheKey(ProceedingJoinPoint proceedingJoinPoint, Cacheable cacheable) {
        StringBuilder buf = new StringBuilder();
        buf.append(proceedingJoinPoint.getSignature().getDeclaringTypeName()).append(".").append(proceedingJoinPoint.getSignature().getName());
        if (cacheable.key().length() > 0) {
            buf.append(".").append(cacheable.key());
        }

        Object[] args = proceedingJoinPoint.getArgs();
        if (cacheable.keyMode() == Cacheable.KeyMode.DEFAULT) {
            Annotation[][] annotations = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getParameterAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                for (Annotation annotation : annotations[i]) {
                    if (annotation instanceof CacheKey) {
                        buf.append(".").append(args[i].toString());
                        break;
                    }
                }
            }
        } else if (cacheable.keyMode() == Cacheable.KeyMode.BASIC) {
            for (Object arg : args) {
                if (arg instanceof String) {
                    buf.append(".").append(arg);
                } else if (arg instanceof Integer || arg instanceof Long || arg instanceof Short) {
                    buf.append(".").append(arg.toString());
                } else if (arg instanceof Boolean) {
                    buf.append(".").append(arg.toString());
                }
            }
        } else if (cacheable.keyMode() == Cacheable.KeyMode.ALL) {
            for (Object arg : args) {
                buf.append(".").append(arg.toString());
            }
        }
        return buf.toString();
    }
}
