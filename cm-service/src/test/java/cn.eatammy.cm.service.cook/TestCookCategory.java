package cn.eatammy.cm.service.cook;

import cn.eatammy.cm.domain.cook.CookCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath: spring-service.xml"})
public class TestCookCategory {
    @Autowired
    ICookCategoryService cookCategoryService;

    @Test
    public void testInsert4Test(){
        CookCategory cookCategory = new CookCategory();
        cookCategory.setCategoryName("早餐");
        cookCategory.setPriority(1);
        cookCategory.setCreator("胖麦");
        cookCategory.setCreateDate(new Date().getTime());
        cookCategory.setStatus(0);
        System.out.println(cookCategoryService.insert(cookCategory));
    }
}
