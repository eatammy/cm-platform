/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商城活动											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-05-18  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.service.activity;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.activity.IBusinessActivictyDAO;
import cn.eatammy.cm.domain.activity.BusinessActivicty;
import cn.eatammy.cm.param.activity.BusinessActivictyParam;
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
 * 《商城活动》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("BusinessActivictyServiceImpl")
public class BusinessActivictyServiceImpl extends AbstractCMPageService<ICMBaseDAO<BusinessActivicty>, BusinessActivicty> implements IBusinessActivictyService<ICMBaseDAO<BusinessActivicty>, BusinessActivicty> {
    @Autowired
    private IBusinessActivictyDAO businessActivictyDAO;

    @Override
    public ICMBaseDAO<BusinessActivicty> getDao() {
        return businessActivictyDAO;
    }

    @Override
    public BizData4Page queryPage(BusinessActivictyParam param, int pageNo, int pageSize) {
        List<BusinessActivicty> data = businessActivictyDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        int records = businessActivictyDAO.countEx(param.toMap());
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }

    @Override
    public String add(BusinessActivictyParam param, AccountDto currentUser) {
        BusinessActivicty businessActivicty = new BusinessActivicty();
        businessActivicty.setShopId(param.getShopId());
        businessActivicty.setActivityId(param.getActivityId());
        businessActivicty.setName(param.getName());
        businessActivicty.setPrice(param.getPrice());
        businessActivicty.setPicture(param.getPicture());
        businessActivicty.setScore(param.getScore());
        businessActivicty.setDescription(param.getDescription());
        businessActivicty.setStock(param.getStock());
        businessActivicty.setSale(param.getSale());
        businessActivicty.setStartTime(param.getStartTime());
        businessActivicty.setEndTime(param.getEndTime());
        businessActivicty.getRules();
        businessActivicty.setPNum(param.getPNum());
        businessActivicty.setCode(param.getCode());
        businessActivicty.setCreator(currentUser.getUid());
        businessActivicty.setCreateDate(System.currentTimeMillis());
        businessActivicty.setStatus(0);
        if(this.insert(businessActivicty) == 1){
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String update(BusinessActivictyParam param, AccountDto currentUser) {
        param.setLastModifier(currentUser.getUid());
        param.setLastModDate(System.currentTimeMillis());
        if(businessActivictyDAO.updateMap(param.toMap()) == 1){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}