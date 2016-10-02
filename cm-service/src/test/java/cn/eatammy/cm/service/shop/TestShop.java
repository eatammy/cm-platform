package cn.eatammy.cm.service.shop;

import cn.eatammy.cm.dao.business.IShopDAO;
import cn.eatammy.cm.dao.user.IUserDetailDAO;
import cn.eatammy.cm.domain.business.Shop;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.common.utils.CommonUtils;
import cn.eatammy.common.utils.DataStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郭旭辉 on 2016/9/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class TestShop {

    @Autowired
    private IUserDetailDAO userDao;
    @Autowired
    private IShopDAO shopDAO;

    @Test
    public void addShop() {
        //查询用户
        List<UserDetail> users = userDao.queryPage4BI(101, 50);

        //组装商店信息
        List<Shop> shops = new ArrayList<>();
        Shop shop = new Shop();
        String owerPaperPic = "http://o6kyy6co9.bkt.clouddn.com/30c34027c85255258ad4c44211dcee1e_1,http://o6kyy6co9.bkt.clouddn.com/30c34027c85255258ad4c44211dcee1e_2";
        String owerPaper = "43156316461635165";
        for (UserDetail user : users) {
            shop = new Shop();
            shop.setShopName(user.getNickname() + "的店");
            shop.setAddress("海角七号");
            shop.setOwner(user.getNickname());
            shop.setCode(CommonUtils.getUUID());
            shop.setUid(user.getCode());
            shop.setOwnerPaper(user.getCode());
            shop.setOwnerPaperPic(owerPaperPic);
            shop.setCategoryId(9);
            shop.setCreator(user.getCode());
            shop.setCreateDate(CommonUtils.randomDate("2016-05-01", "2016-12-31").getTime());
            shop.setStatus(DataStatusEnum.DISABLED.getValue());
            shops.add(shop);
        }
        //插入商店
//        shopDAO.insertBatch(shops);
    }
}
