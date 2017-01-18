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
            userFlow.setDeviceType(getDeviceType());
            userFlow.setCreateTime(CommonUtils.randomDate("2017-01-01", "2017-12-31").getTime());
            result.add(userFlow);
        }
        userFlowService.addUserFlows(result);
//        System.out.println(result.size());
    }

    //登入设备，手机占45%左右，平板占30%，电脑占25%
    public int getDeviceType(){
        int[] weight = {40, 30, 30};
        int sum = 0;
        int flag = 0;
        int random = new Random().nextInt(100);
        for (int i = 0; i < weight.length; i++) {
            sum += weight[i];
            if (random <= sum) {
                flag = i;
                break;
            }
        }
       return flag;
    }

    public static void main(String[] args){
//        int x=0, y=0,z=0;
//        for(int i=0;i<100;i++){
//            switch (getDeviceType()){
//                case 0: x++;break;
//                case 1: y++;break;
//                case 2: z++;break;
//                default:
//                    System.out.println("deviceType is wrong!!");
//            }
//        }
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(z);
    }
}
