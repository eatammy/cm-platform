/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：商城评论表											
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

import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.business.IBusinessCommentDAO;
import cn.eatammy.cm.domain.business.BusinessComment;
import cn.eatammy.cm.service.business.IBusinessCommentService;
import cn.eatammy.cm.service.AbstractCMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《商城评论》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("BusinessCommentServiceImpl")
public class BusinessCommentServiceImpl extends AbstractCMPageService<ICMBaseDAO<BusinessComment>, BusinessComment> implements IBusinessCommentService<ICMBaseDAO<BusinessComment>,BusinessComment>{
    @Autowired
    private IBusinessCommentDAO businessCommentDAO;

    @Override
    public ICMBaseDAO<BusinessComment> getDao() {
        return businessCommentDAO;
    }

}