/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：分类表											
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

package cn.eatammy.cm.service.sys;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.sys.ICategoryDAO;
import cn.eatammy.cm.domain.sys.Category;
import cn.eatammy.cm.param.sys.CategoryParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.PageUtils;
import cn.eatammy.common.utils.RETURNCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 《分类》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("CategoryServiceImpl")
public class CategoryServiceImpl extends AbstractCMPageService<ICMBaseDAO<Category>, Category> implements ICategoryService<ICMBaseDAO<Category>, Category> {
    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public ICMBaseDAO<Category> getDao() {
        return categoryDAO;
    }

    @Override
    public String add(CategoryParam param, AccountDto accountDto) {
        if (!isExist(param.F_Name, param.getName())) {
            Category category = new Category();
            category.setName(param.getName());
            category.setPriority(param.getPriority());
            category.setType(param.getType());
            category.setStatus(0);
            category.setCreator(accountDto.getUid());
            category.setCreatorName(accountDto.getNickname());
            category.setCreateDate(System.currentTimeMillis());
            categoryDAO.insert(category);
            return RETURNCODE.ADD_COMPLETE.getMessage();
        } else {
            throw new BizException(ERRORCODE.CATEGORY_EXIST.getCode(), ERRORCODE.CATEGORY_EXIST.getMessage());
        }
    }

    @Override
    public BizData4Page<Category> queryPage(String name, Integer type, Integer status, int pageNo, int pageSize) {
        List<Category> data = categoryDAO.queryListEx(name, type, status, (pageNo - 1) * pageSize, pageSize);
        int records = categoryDAO.countEx(name, type, status);
        return PageUtils.toBizData4Page(data,pageNo, pageSize, records);
    }

    @Override
    public boolean isExist(String property, Object value) {
        return this.findOne(property, value) == null ? false : true;
    }
}