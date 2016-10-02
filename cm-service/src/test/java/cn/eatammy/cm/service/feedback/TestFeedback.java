package cn.eatammy.cm.service.feedback;

import cn.eatammy.cm.domain.sys.Feedback;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.service.sys.IFeedbackService;
import cn.eatammy.cm.service.user.IUserDetailService;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 郭旭辉 on 2016/10/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class TestFeedback {

    @Autowired
    private IFeedbackService feedbackService;
    @Autowired
    private IUserDetailService userService;
    @Test
    public void testAddFeedback(){
        UserDetail randomUser = userService.getRandomUser();
        Feedback feedback = new Feedback();
        feedback.setUid(randomUser.getCode());
        feedback.setContent("。");
        feedback.setCreateTime(CommonUtils.randomDate("2016-05-01","2016-12-31").getTime());
        feedbackService.add(feedback);
    }

    @Test
    public void testQueryPage(){
        BizData4Page bizData4Page = feedbackService.queryPage(1, 10);
        System.out.println(bizData4Page.getUserData().size());
    }

}
