/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：回复表											
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

package cn.eatammy.cm.service.share;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.share.IShareReplyDAO;
import cn.eatammy.cm.domain.share.ShareReply;
import cn.eatammy.cm.service.AbstractCMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《回复》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("ShareReplyServiceImpl")
public class ShareReplyServiceImpl extends AbstractCMPageService<ICMBaseDAO<ShareReply>, ShareReply> implements IShareReplyService<ICMBaseDAO<ShareReply>,ShareReply>{
    @Autowired
    private IShareReplyDAO shareReplyDAO;

    @Override
    public ICMBaseDAO<ShareReply> getDao() {
        return shareReplyDAO;
    }

}