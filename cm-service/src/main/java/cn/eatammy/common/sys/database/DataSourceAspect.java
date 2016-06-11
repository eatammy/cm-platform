package cn.eatammy.common.sys.database;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by 郭旭辉 on 2016/4/6.
 * 动态数据源
 */
public class DataSourceAspect {

    public void before(JoinPoint joinPoint){
        Object target = joinPoint.getTarget();
        String method = joinPoint.getSignature().getName();
        Class<?>[] classz = target.getClass().getInterfaces();
        Class<?>[] parameterType = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        try {


            //当前类
            Class cls = classz[0];

            //类
            if (cls.isAnnotationPresent(DataSource.class)){
                DataSource dataSource = (DataSource) cls.getAnnotation(DataSource.class);
                DataSourceHandler.setDataSource(dataSource.value());
//                System.out.println("======当前线程："+DataSourceHandler.context.get());
                return;
            }

            //方法
            Method method1 = cls.getMethod(method, parameterType);
            if (method1 != null && method1.isAnnotationPresent(DataSource.class)){
                DataSource dataSource = method1.getAnnotation(DataSource.class);
                DataSourceHandler.setDataSource(dataSource.value());
//                System.out.println("======当前线程："+DataSourceHandler.context.get());
                return;
            }
//            System.out.println("======当前线程："+DataSourceHandler.context.get());
            DataSourceHandler.setDataSource(null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void after(JoinPoint joinPoint){
//        System.out.println("======增强当前线程："+DataSourceHandler.context.get());

        DataSourceHandler.removeDataSource();
    }
}
