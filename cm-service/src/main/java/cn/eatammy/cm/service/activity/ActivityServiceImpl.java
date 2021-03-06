/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：活动表											
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
import cn.eatammy.cm.dao.activity.IActivityDAO;
import cn.eatammy.cm.domain.activity.Activity;
import cn.eatammy.cm.domain.activity.ActivityEx;
import cn.eatammy.cm.param.activity.ActivityParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.PageUtils;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
 /**
 * 《活动》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("ActivityServiceImpl")
public class ActivityServiceImpl extends AbstractCMPageService<ICMBaseDAO<Activity>, Activity> implements IActivityService<ICMBaseDAO<Activity>,Activity>{
    @Autowired
    private IActivityDAO activityDAO;

    @Override
    public ICMBaseDAO<Activity> getDao() {
        return activityDAO;
    }

     @Override
     public BizData4Page queryPage(ActivityParam param, int pageNo, int pageSize) {
         List<ActivityEx> data = activityDAO.queryPageEx(param.toMap(), (pageNo -1) * pageSize, pageSize);
         int records = activityDAO.countEx(param.toMap());
         return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
     }

     @Override
     public String add(ActivityParam param, AccountDto accountDto) {
         Activity activity = new Activity();
         activity.setName(param.getName());
         activity.setCategoryId(param.getCategoryId());
         activity.setStartTime(param.getStartTime());
         activity.setEndTime(param.getEndTime());
         activity.setStatus(1);     //默认为审核状态
         activity.setCreator(accountDto.getUid());
         activity.setCreateDate(System.currentTimeMillis());
         if (activityDAO.insert(activity) == 1){
             return RETURNCODE.ADD_COMPLETE.getMessage();
         }else{
             throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
         }
     }

     @Override
     public String update(ActivityParam param, AccountDto accountDto) {
         param.setLastModifier(accountDto.getUid());
         param.setLastModDate(System.currentTimeMillis());
         if(this.updateMap(param.toMap()) == 1){
             return RETURNCODE.UPDATE_COMPLETE.getMessage();
         }else{
             throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
         }
     }

     @Override
     @Transactional(rollbackFor = {Exception.class})
     public String disableOrEnable(long id, int status) {
         if (activityDAO.updateStatus(id, status) == 1){
             return RETURNCODE.SUCCESS_COMPLETE.getMessage();
         }
         throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }
 }