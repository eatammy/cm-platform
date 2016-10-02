package cn.eatammy.cm.service.goods;

import cn.eatammy.cm.domain.business.Goods;
import cn.eatammy.cm.domain.business.Shop;
import cn.eatammy.cm.param.business.ShopParam;
import cn.eatammy.cm.service.business.IGoodsService;
import cn.eatammy.cm.service.business.IShopService;
import cn.eatammy.common.utils.CommonUtils;
import cn.eatammy.common.utils.DataStatusEnum;
import cn.eatammy.common.utils.excel.ExcelDto;
import cn.eatammy.common.utils.excel.ExcelUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 郭旭辉 on 2016/9/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class TestGoods {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IShopService shopService;

    @Test
    public void testAddGoods() {
        InputStream is = null;
        try {
            is = new FileInputStream("d:\\goods.xlsx");
            List<ExcelDto> list = ExcelUtils.readExcel(ExcelDto.class, "goods.xlsx", is);
            //获取商店信息
            List<Shop> shops = shopService.findList(ShopParam.F_Status, 0);
            //封装商品信息
            Goods goods = null;
//            String shopCode = "30c34027c85255258ad4c44211dcee1e";
//            String creator = "557a5629d23351037c020d5a21b236fc";
            List<Goods> result = new ArrayList<>(list.size());
            Shop shop;
            for (ExcelDto excelDto : list) {
                int index= 0;
                while (index == 0){
                    index = new Random().nextInt(shops.size());
                }
                shop = shops.get(index);
                goods = new Goods();
                goods.setGoodsName(excelDto.getName());
                goods.setPrice(excelDto.getPrice());
                goods.setCode(CommonUtils.getUUID());
                goods.setShopId(shop.getCode());
                goods.setStock(excelDto.getStock());
                goods.setCategoryId(excelDto.getCategoryId());
                goods.setCreator(shop.getUid());
                goods.setCreateDate(CommonUtils.randomDate("2016-08-21", "2016-12-31").getTime());
                goods.setStatus(DataStatusEnum.ENABLED.getValue());
                result.add(goods);
            }
//            goodsService.add(result);
            System.out.println("ss");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
