/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：食谱原材料表											
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

package cn.eatammy.cm.service.cook;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.dao.cook.IMaterialDAO;
import cn.eatammy.cm.domain.cook.Material;
import cn.eatammy.cm.param.cook.MaterialParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 《食谱原材料》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("MaterialServiceImpl")
public class MaterialServiceImpl extends AbstractCMPageService<ICMBaseDAO<Material>, Material> implements IMaterialService<ICMBaseDAO<Material>,Material>{
    @Autowired
    private IMaterialDAO materialDAO;

    @Override
    public ICMBaseDAO<Material> getDao() {
        return materialDAO;
    }

    @Override
    public Long saveMaterial(String user, MaterialParam materialParam) {
        Material material = new Material();
        try {

            material.setMaterialNames(materialParam.getMaterialNames());
            material.setDosage(materialParam.getDosage());
            material.setCreateDate(System.currentTimeMillis());
            material.setCreator(user);
            material.setStatus(0);
            this.insert(material);
        }catch (Exception e){
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());
        }


        return material.getId();
    }

    @Override
    public int updateMaterial(String user, MaterialParam materialParam) {
        try {
            Material material = this.findOne(MaterialParam.F_ID,materialParam.getId());
            material.setMaterialNames(materialParam.getMaterialNames());
            material.setDosage(materialParam.getDosage());
            material.setLastModDate(System.currentTimeMillis());
            material.setLastModifier(user);
            material.setStatus(0);
            this.update(material);
        }catch (Exception e){
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());
        }


        return 1;
    }

    @Override
    public Material findMaterial() {
        return null;
    }


}