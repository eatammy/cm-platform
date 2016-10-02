/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：订单关系表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-06-13  郭旭辉        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/

package cn.eatammy.cm.service.business;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.business.IIndentRelationDAO;
import cn.eatammy.cm.domain.business.IndentRelation;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import cn.eatammy.common.utils.RETURNCODE;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 《订单关系》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("IndentRelationServiceImpl")
public class IndentRelationServiceImpl extends AbstractCMPageService<ICMBaseDAO<IndentRelation>, IndentRelation> implements IIndentRelationService<ICMBaseDAO<IndentRelation>,IndentRelation>{
    @Autowired
    private IIndentRelationDAO indentRelationDAO;

    @Override
    public ICMBaseDAO<IndentRelation> getDao() {
        return indentRelationDAO;
    }

    @Override
    public String addRelations(@Param("list") List<IndentRelation> relationList) {
        if(indentRelationDAO.insertRelations(relationList) > 0){
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}