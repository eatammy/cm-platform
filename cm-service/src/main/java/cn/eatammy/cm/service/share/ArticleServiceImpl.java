/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：美食忆文											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-14  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.service.share;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.share.IArticleDAO;
import cn.eatammy.cm.domain.share.Article;
import cn.eatammy.cm.service.AbstractCMPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《美食忆文》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("ArticleServiceImpl")
public class ArticleServiceImpl extends AbstractCMPageService<ICMBaseDAO<Article>, Article> implements IArticleService<ICMBaseDAO<Article>,Article>{
    @Autowired
    private IArticleDAO articleDAO;

    @Override
    public ICMBaseDAO<Article> getDao() {
        return articleDAO;
    }

}