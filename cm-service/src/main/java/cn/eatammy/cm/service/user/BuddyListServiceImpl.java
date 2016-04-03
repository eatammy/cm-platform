/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：好友列表（cm_user_buddyList）											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-04-03  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.service.user;

import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.user.IBuddyListDAO;
import cn.eatammy.cm.domain.user.BuddyList;
import cn.eatammy.cm.service.user.IBuddyListService;
import cn.eatammy.cm.service.AbstractCMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《好友列表（cm_user_buddyList）》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("BuddyListServiceImpl")
public class BuddyListServiceImpl extends AbstractCMPageService<ICMBaseDAO<BuddyList>, BuddyList> implements IBuddyListService<ICMBaseDAO<BuddyList>,BuddyList>{
    @Autowired
    private IBuddyListDAO buddyListDAO;

    @Override
    public ICMBaseDAO<BuddyList> getDao() {
        return buddyListDAO;
    }

}