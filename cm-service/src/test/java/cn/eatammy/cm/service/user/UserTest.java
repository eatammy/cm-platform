package cn.eatammy.cm.service.user;

import cn.eatammy.cm.domain.bi.UserFlow;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.service.bi.IUserFlowService;
import cn.eatammy.common.utils.CommonUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by 郭旭辉 on 2016/9/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class UserTest {

    @Autowired
    private IUserDetailService userDetailService;
    @Autowired
    private IUserFlowService userFlowService;

    @Test
//    @Transactional(rollbackFor = {Exception.class})
    public void addUser() {
        long phone = 13500002001L;
        String password = "123123";
        List<UserDetail> userDetails = new ArrayList<>(100);
        UserDetail userDetail = null;
        for (int i = 0; i < 100; i++) {
            userDetail = new UserDetail();
            userDetail.setUsername(String.valueOf(phone + i));
            userDetail.setPhone(String.valueOf(phone + i));
            userDetail.setProvince(getProvince());
            userDetail.setCode(CommonUtils.getUUID());
            userDetail.setNickname("帅气的胖麦" + userDetail.getCode().substring(0, (int) (Math.random() * 15)));
            userDetail.setSex(getGender());
            userDetail.setAge(getAge());
            userDetail.setScore(0);
            userDetail.setUserTypes(1);
            userDetail.setSalt(CommonUtils.getUUID().substring(0, 8));
            userDetail.setCreator("557a5629d23351037c020d5a21b236fc");
            userDetail.setCreateDate(CommonUtils.randomDate("2016-09-20", "2016-12-31").getTime());
            userDetail.setStatus(0);
            userDetail.setPassword(getPassword(password, userDetail.getSalt()));
            userDetails.add(userDetail);
        }
        userDetailService.addUsers(userDetails);

        //新增用户成功后插入流量表

        List<UserFlow> userFlows = new ArrayList<>(100);
        UserFlow userFlow = null;
        for (UserDetail userDetail1 : userDetails) {
//            int flag = 0;
//            while (flag == 0) {
//                flag = (int) (Math.random() * 3);
//            }

            userFlow = new UserFlow();
            userFlow.setUid(userDetail1.getCode());
            userFlow.setEventType(1);
            userFlow.setEventValue("login");
            userFlow.setCreateTime(userDetail1.getCreateDate());
            userFlow.setDeviceType((int) (Math.random() * 3));
            userFlows.add(userFlow);
        }
        System.out.println(userFlows.size());
        userFlowService.addUserFlows(userFlows);
    }

    @Test
    public void testCount(){
        System.out.println(new Date().getMonth());
    }

    public String getPassword(String source, String salt) {
        return new Md5Hash(source, salt, 1).toString();
    }

    /**
     * 获取省份
     *
     * @return, 返回，省份值
     */
    private Integer getProvince() {
        int result = 0;
        while (result == 0) {
            result = (int) (Math.random() * 35);
        }
        return result;
    }

    @Test
    public void testGetAge() {
        for (int i = 0; i < 200; i++) {
            System.out.println(getAge());
        }
    }

    /**
     * 获取年龄，控制在18-45之间占比80%,45-70占20%
     *
     * @return 返回，年龄
     */
    private Integer getAge() {
        int[] weight = {55, 35, 10};
        int sum = 0;
        int min = 0, max = 0;
        int flag = 0;
        int random = new Random().nextInt(100);
        for (int i = 0; i < weight.length; i++) {
            sum += weight[i];
            if (random <= sum) {
                flag = i;
                break;
            }
        }
        switch (flag) {
            case 0:
                min = 18;
                max = 35;
                break;
            case 1:
                min = 35;
                max = 45;
                break;
            case 2:
                min = 45;
                max = 70;
                break;
        }

        return min + (int) (Math.random() * ((max - min) + 1));
    }

    //性别控制，男：30%，女：70%
    private  int getGender(){
        int[] weight = {30, 70};
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


}
