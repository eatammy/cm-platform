/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：访问控制表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-08-09  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{*****************************************************************************	
*/

package cn.eatammy.cm.service.auth;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.auth.IAuthAclDAO;
import cn.eatammy.cm.domain.auth.AuthAcl;
import cn.eatammy.cm.service.AbstractCMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 《访问控制》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("AuthAclServiceImpl")
public class AuthAclServiceImpl extends AbstractCMPageService<ICMBaseDAO<AuthAcl>, AuthAcl> implements IAuthAclService<ICMBaseDAO<AuthAcl>,AuthAcl>{
    @Autowired
    private IAuthAclDAO authAclDAO;

    @Override
    public ICMBaseDAO<AuthAcl> getDao() {
        return authAclDAO;
    }

    @Override
    public List<String> queryResourceCode(Integer subjectType, String subjectCode) {
        return authAclDAO.queryResourceCode(subjectType, subjectCode);
    }
}