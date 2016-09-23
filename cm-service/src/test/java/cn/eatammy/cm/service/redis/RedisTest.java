package cn.eatammy.cm.service.redis;

import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.common.sys.redis.RedisUtils;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 郭旭辉 on 2016/7/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void test(){
        UserDetail user = new UserDetail();
        user.setAddress("dasdhjas");
        user.setNickname("Nicos");
        Gson gson = new Gson();

        redisUtils.set("Nicos", gson.toJson(user));
        UserDetail userDetail = gson.fromJson(redisUtils.get("Nicos","no Value"), UserDetail.class);
        System.out.println(userDetail.getNickname());
//        List<UserDetail> list = new ArrayList<>();
//        list.add(user);
//
//
//        System.out.println(gson.toJson(user));
//        System.out.println(gson.toJson(list));
//        System.out.println(redisUtils.get("Nicos","haha"));
    }
}
