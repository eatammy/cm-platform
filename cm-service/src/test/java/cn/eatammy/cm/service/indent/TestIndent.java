package cn.eatammy.cm.service.indent;

import cn.eatammy.cm.domain.business.Goods;
import cn.eatammy.cm.domain.business.Indent;
import cn.eatammy.cm.domain.business.IndentRelation;
import cn.eatammy.cm.domain.business.Shop;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.service.business.IGoodsService;
import cn.eatammy.cm.service.business.IIndentRelationService;
import cn.eatammy.cm.service.business.IIndentService;
import cn.eatammy.cm.service.business.IShopService;
import cn.eatammy.cm.service.user.IUserDetailService;
import cn.eatammy.common.utils.CommonUtils;
import cn.eatammy.common.utils.DataStatusEnum;
import cn.eatammy.common.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 郭旭辉 on 2016/9/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class TestIndent {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IIndentService indentService;
    @Autowired
    private IIndentRelationService relationService;
    @Autowired
    private IUserDetailService userDetailService;
    @Autowired
    private IShopService shopService;

    @Test
    public void addIndents() {
        int num = new Random().nextInt(100) + 1;
        for (int i = 0; i < 100; i++) {
            addIndent();
        }
    }

//    @Test
    public void addIndent() {
        //随机获取1-10条商品
        int num = 1 + (int) (Math.random() * ((10 - 1) + 1));
        List<Goods> goodsList = goodsService.getRandomGoodses(num);
        //随机获取一个用户
        UserDetail user = userDetailService.getRandomUser();
        long time = CommonUtils.randomDate("2017-01-01", "2017-04-30").getTime();
        String address = "海角七号";
        //组装订单
        Indent indent = new Indent();
        indent.setUid(user.getCode());
        indent.setSerialNumber(MD5Utils.getMD5(String.valueOf(time)));
        indent.setAddress(address);
        indent.setProvince(getProvince());
        indent.setIsTraded(getIsTraded());
        indent.setCreator(user.getCode());
        indent.setCreateDate(time);
        indent.setStatus(DataStatusEnum.ENABLED.getValue());
        indent.setTotal(0d);
        double sum = 0;
        //组装订单关系
        List<IndentRelation> relations = new ArrayList<>(goodsList.size());
        IndentRelation indentRelation;
        List<Shop> shops = new ArrayList<>(goodsList.size());
        Shop shop = null;
        for (Goods goods : goodsList) {
            indentRelation = new IndentRelation();
            indentRelation.setShopId(goods.getShopId());
            indentRelation.setGoodsId(goods.getCode());
            //数量1-20
            indentRelation.setNum(new Random().nextInt(20) + 1);
            indentRelation.setPrice(indentRelation.getNum() * goods.getPrice());
            sum += indentRelation.getPrice();

            goods.setStock(goods.getStock() - indentRelation.getNum());
            goods.setSale(goods.getSale() + indentRelation.getNum());
            if (indent.getIsTraded() == 1) { //更新商家的销售额
                shop = new Shop();
                shop.setCode(goods.getShopId());
                shop.setIncome4Sum(indentRelation.getPrice());
                shops.add(shop);
            }
            relations.add(indentRelation);
        }
        indent.setTotal(sum);

        //添加订单
        if (indentService.add(indent) > 0) {
            //添加关系
            for (IndentRelation indentRelation1 : relations) {
                indentRelation1.setIndentId(indent.getId());
            }
            //插入关系
            relationService.addRelations(relations);

           if(indent.getIsTraded() == 1){
               // 更新库存
               goodsService.updateGoodsStock(goodsList);

               //更新商家销售额
               shopService.updateShopIncome(shops);
           }
        }
    }


    /**
     * 付款状态，设置付款状态为65%-80%，未付款为20%-35%概率
     *
     * @return 返回，状态，0：未付款，1：已付款
     */
    private Integer getIsTraded() {
        int flag = new Random().nextInt(2);
        if (flag == 0) {
            return Math.random() <= 0.65 ? 1 : 0;
        } else {
            return Math.random() <= 0.8 ? 1 : 0;
        }
    }

    private Integer getProvince() {
        int[] hotArea = new int[]{9,10,11,13,18,19,27,28,29};
        int[] weight = {55, 45};
        int sum = 0;
        int result = 0;
        boolean flag = false;
        int random = new Random().nextInt(100);
        for (int i = 0; i < weight.length; i++) {
            sum += weight[i];
            if (random <= sum) {
                break;
            }else{
                flag = true;
            }
        }
        if(flag){//随机取一个
            while (result == 0) {
                result = (int) (Math.random() * 35);
            }
            result = (int) (Math.random() * 35) ;
        }else{  //在热门地区取一个
            result = hotArea[new Random().nextInt(hotArea.length)];
        }
        return result;
    }

    public static void main(String[] args){
//        System.out.println(new Random().nextInt(9));
//        for(int i=0;i<100;i++){
//            System.out.println( getProvices());
//        }
    }
}
