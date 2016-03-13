/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：菜谱分类表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-13  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.service.cook;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.cook.ICookCategoryDAO;
import cn.eatammy.cm.domain.cook.CookCategory;
import cn.eatammy.cm.service.AbstractCMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《菜谱分类》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("CookCategoryServiceImpl")
public class CookCategoryServiceImpl extends AbstractCMPageService<ICMBaseDAO<CookCategory>, CookCategory> implements ICookCategoryService<ICMBaseDAO<CookCategory>,CookCategory>{
    @Autowired
    private ICookCategoryDAO cookCategoryDAO;

    @Override
    public ICMBaseDAO<CookCategory> getDao() {
        return cookCategoryDAO;
    }

}