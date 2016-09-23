package cn.eatammy.cm.service.cook;

import cn.eatammy.cm.domain.sys.Category;
import cn.eatammy.cm.service.sys.ICategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class TestCookCategory {

    @Autowired
    private ICategoryService categoryService;

    @Test
    @Transactional(rollbackFor = {Exception.class})
    public void insert(){
        Category category  = new Category();
        category.setName("测试1");
        category.setPriority(1);
        category.setType(4);
        category.setCreator("557a5629d23351037c020d5a21b236fc");
        category.setCreateDate(System.currentTimeMillis());
        category.setStatus(0);
        categoryService.add(category);
    }
}
