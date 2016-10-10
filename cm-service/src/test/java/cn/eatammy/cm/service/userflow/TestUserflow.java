package cn.eatammy.cm.service.userflow;

import cn.eatammy.cm.domain.bi.UserFlow;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.service.bi.IUserFlowService;
import cn.eatammy.cm.service.user.IUserDetailService;
import cn.eatammy.common.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 郭旭辉 on 2016/10/5.
 * 用户流量表单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class TestUserflow {
    @Autowired
    private IUserFlowService userFlowService;

    @Autowired
    private IUserDetailService userDetailService;

    @Test
    public void testAddUserflow(){
        //随机获取用户进行登录操作
        List<UserDetail> randowUsers = userDetailService.getRandowUsers(new Random().nextInt(100));

        List<UserFlow> result = new ArrayList<>(randowUsers.size());
        UserFlow userFlow = null;
        for (UserDetail user: randowUsers){
            userFlow = new UserFlow();
            userFlow.setUid(user.getCode());
            userFlow.setEventType(1);
            userFlow.setEventValue("login");
            userFlow.setDeviceType(new Random().nextInt(3));
            userFlow.setCreateTime(CommonUtils.randomDate("2016-08-01", "2016-12-31").getTime());
            result.add(userFlow);
        }
        userFlowService.addUserFlows(result);
//        System.out.println(result.size());
    }
}
