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

import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.business.IIndentDAO;
import cn.eatammy.cm.domain.business.Indent;
import cn.eatammy.cm.service.business.IIndentService;
import cn.eatammy.cm.service.AbstractCMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《订单》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("IndentServiceImpl")
public class IndentServiceImpl extends AbstractCMPageService<ICMBaseDAO<Indent>, Indent> implements IIndentService<ICMBaseDAO<Indent>,Indent>{
    @Autowired
    private IIndentDAO indentDAO;

    @Override
    public ICMBaseDAO<Indent> getDao() {
        return indentDAO;
    }

}