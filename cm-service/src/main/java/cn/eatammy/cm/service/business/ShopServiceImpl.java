/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商家表											
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
import cn.eatammy.cm.dao.business.IShopDAO;
import cn.eatammy.cm.dao.user.IUserDetailDAO;
import cn.eatammy.cm.domain.business.Shop;
import cn.eatammy.cm.param.business.ShopParam;
import cn.eatammy.cm.param.business.ShopParamEx;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 《商家》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("ShopServiceImpl")
public class ShopServiceImpl extends AbstractCMPageService<ICMBaseDAO<Shop>, Shop> implements IShopService<ICMBaseDAO<Shop>, Shop> {
    @Autowired
    private IShopDAO shopDAO;
    @Autowired
    private IUserDetailDAO userDetailDAO;

    @Override
    public ICMBaseDAO<Shop> getDao() {
        return shopDAO;
    }

    @Override
    public BizData4Page<Shop> queryPage(ShopParam param, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public String add(ShopParamEx paramEx, AccountDto accountDto) {
        if (!isExists(ShopParam.F_OwnerPaper, paramEx.getOwnerPaper())){  //  一个身份证号码只能申请一次
            Shop shop = new Shop();
            shop.setShopName(paramEx.getShopName());
            shop.setAddress(paramEx.getAddress());
            shop.setProvince(paramEx.getProvince());
            shop.setCity(paramEx.getCity());
            shop.setTown(paramEx.getTown());
            shop.setOwner(paramEx.getOwner());
            shop.setCode(paramEx.getCode());
            shop.setUid(paramEx.getUid());
            shop.setOwnerPaper(paramEx.getOwnerPaper());
            shop.setOwnerPaperPic(paramEx.getAuthImg1() + "," + paramEx.getAuthImg2());
            shop.setCategoryId(paramEx.getCategoryId());
            shop.setLinetTelephone(paramEx.getLinetTelephone());
            shop.setPhone(paramEx.getPhone());
            shop.setCreator(accountDto.getUid());
            shop.setCreateDate(System.currentTimeMillis());
            shop.setStatus(1);
            shopDAO.insert(shop);
            userDetailDAO.updateUserTypes(paramEx.getUid(), 2);
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }else{
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

    private boolean isExists(String property, Object value) {
        return this.findOne(property, value) != null;
    }
}