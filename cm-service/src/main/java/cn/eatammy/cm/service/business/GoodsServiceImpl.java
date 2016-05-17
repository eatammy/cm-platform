/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商品信息表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-23  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.service.business;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.business.IGoodsDAO;
import cn.eatammy.cm.domain.business.Goods;
import cn.eatammy.cm.domain.business.GoodsEx;
import cn.eatammy.cm.param.business.GoodsParam;
import cn.eatammy.cm.param.business.GoodsParamEx;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.PageUtils;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 《商品信息》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("GoodsServiceImpl")
public class GoodsServiceImpl extends AbstractCMPageService<ICMBaseDAO<Goods>, Goods> implements IGoodsService<ICMBaseDAO<Goods>, Goods> {
    @Autowired
    private IGoodsDAO goodsDAO;

    @Override
    public ICMBaseDAO<Goods> getDao() {
        return goodsDAO;
    }

    @Override
    public BizData4Page queryPage(GoodsParamEx paramEx, int pageNo, int pageSize) {
        List<GoodsEx> data = goodsDAO.queryPageEx(paramEx.toMap(), (pageNo - 1) * pageNo, pageSize);
        int records = goodsDAO.countEx(paramEx.toMap());
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }

    @Override
    public String add(GoodsParam param, AccountDto currentUser) {
        if(! isExists(param.F_GoodsName, param.getGoodsName())){
            Goods goods = new Goods();
            goods.setGoodsName(param.getGoodsName());
            goods.setPrice(param.getPrice());
            goods.setCode(param.getCode());
            goods.setShopId(param.getShopId());
            goods.setStock(param.getStock());
            goods.setSale(0);
            goods.setDescription(param.getDescription());
            goods.setPicture(param.getPicture());
            goods.setCategoryId(param.getCategoryId());
            goods.setCreator(currentUser.getUid());
            goods.setCreateDate(System.currentTimeMillis());
            goods.setStatus(0);
            if(goodsDAO.insert(goods) == 1){
                return RETURNCODE.ADD_COMPLETE.getMessage();
            }
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        } else{
            throw new BizException(ERRORCODE.GOODSNAME_EXISTS.getCode(), ERRORCODE.GOODSNAME_EXISTS.getMessage());
        }
    }

    private boolean isExists(String property, Object value){
        return this.findOne(property, value) != null;
    }
}