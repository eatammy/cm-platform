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

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.user.IBuddyListDAO;
import cn.eatammy.cm.dao.user.IUserDetailDAO;
import cn.eatammy.cm.domain.user.BuddyList;
import cn.eatammy.cm.domain.user.UserDetail;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 《好友列表（cm_user_buddyList）》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("BuddyListServiceImpl")
public class BuddyListServiceImpl extends AbstractCMPageService<ICMBaseDAO<BuddyList>, BuddyList> implements IBuddyListService<ICMBaseDAO<BuddyList>, BuddyList> {
    @Autowired
    private IBuddyListDAO buddyListDAO;

    @Autowired
    private IUserDetailDAO userDetailDAO;

    @Override
    public ICMBaseDAO<BuddyList> getDao() {
        return buddyListDAO;
    }

    @Override
    public String attachOne(long uid, long buddyUid, AccountDto currentUser) {
        UserDetail buddy = userDetailDAO.fetch(buddyUid);
        BuddyList buddyList = new BuddyList();
        buddyList.setUid(uid);
        buddyList.setBuddyUid(buddyUid);
        buddyList.setBuddyName(buddy.getNickname());
        buddyList.setBuddyHeadIcon(buddy.getHeadIcon());
        buddyList.setCreator(currentUser.getUid());
        buddyList.setCreateDate(System.currentTimeMillis());
        buddyList.setStatus(0);
        if( buddyListDAO.insert(buddyList) == 1){
            int r1 = userDetailDAO.updateAttentions(1, uid);
             int r2 = userDetailDAO.updateFuns(1, buddyUid);
            return RETURNCODE.ATTACH_SUCCESS.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String inattach(long uid, long buddyUid) {
        if(buddyListDAO.deleteOne(uid, buddyUid) == 1){
            userDetailDAO.updateAttentions(-1, uid);
            userDetailDAO.updateFuns(-1, buddyUid);
            return RETURNCODE.INATTACH_SUCCESS.getMessage();
        }
        throw  new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}