/*
{*****************************************************************************
{  主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商务流量表（cm_bi_business_flow）											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-09-01  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.service.bi;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.bi.IBusinessFlowDAO;
import cn.eatammy.cm.domain.bi.BusinessFlow;
import cn.eatammy.cm.service.AbstractCMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《商务流量表（cm_bi_business_flow）》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("BusinessFlowServiceImpl")
public class BusinessFlowServiceImpl extends AbstractCMPageService<ICMBaseDAO<BusinessFlow>, BusinessFlow> implements IBusinessFlowService<ICMBaseDAO<BusinessFlow>,BusinessFlow>{
    @Autowired
    private IBusinessFlowDAO businessFlowDAO;

    @Override
    public ICMBaseDAO<BusinessFlow> getDao() {
        return businessFlowDAO;
    }

}