/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：订单											
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
import cn.eatammy.cm.dao.business.IIndentDAO;
import cn.eatammy.cm.dao.business.IIndentRelationDAO;
import cn.eatammy.cm.dao.business.IShopDAO;
import cn.eatammy.cm.domain.business.Indent;
import cn.eatammy.cm.domain.business.IndentRelation;
import cn.eatammy.cm.param.business.IndentParamEx;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 《订单》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("IndentServiceImpl")
public class IndentServiceImpl extends AbstractCMPageService<ICMBaseDAO<Indent>, Indent> implements IIndentService<ICMBaseDAO<Indent>, Indent> {
    @Autowired
    private IIndentDAO indentDAO;
    @Autowired
    private IIndentRelationDAO indentRelationDAO;
    @Autowired
    private IShopDAO shopDAO;

    @Override
    public ICMBaseDAO<Indent> getDao() {
        return indentDAO;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String add(IndentParamEx paramEx, AccountDto accountDto) {
        //构建订单
        Indent indent = new Indent();
        indent.setUid(paramEx.getUid());
        indent.setSerialNumber(System.currentTimeMillis());
        indent.setAddress(paramEx.getAddress());
        indent.setTotal(paramEx.getTotal());
        indent.setIsTraded(0);
        indent.setCreator(accountDto.getUid());
        indent.setCreateDate(System.currentTimeMillis());
        indent.setStatus(0);
        indentDAO.insert(indent);

        //构建订单关系表
        List<IndentRelation> indentRelations = new ArrayList<>();
        IndentRelation indentRelation;
        String[] args;
        for (String detail : paramEx.getDetails()) {
            args = detail.split(":");
            indentRelation = new IndentRelation();
            indentRelation.setIndentId(indent.getId());
            indentRelation.setShopId(paramEx.getShopId());
            indentRelation.setGoodsId(Long.parseLong(args[0]));
            indentRelation.setNum(Integer.parseInt(args[1]));
            indentRelation.setPrice(Double.parseDouble(args[2]));
            indentRelations.add(indentRelation);
        }
        indentRelationDAO.insertRelations(indentRelations);

        //更新商家额度
        shopDAO.updateIncome(paramEx.getTotal());
        return RETURNCODE.ADD_COMPLETE.getMessage();
    }
}