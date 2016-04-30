/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：菜谱											
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
import cn.eatammy.cm.dao.cook.ICookBookDAO;
import cn.eatammy.cm.domain.cook.CookBook;
import cn.eatammy.cm.domain.cook.CookBookEx;
import cn.eatammy.cm.param.cook.CookBookParam;
import cn.eatammy.cm.param.cook.MaterialParam;
import cn.eatammy.cm.param.cook.ProcessParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 《菜谱》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("CookBookServiceImpl")
public class CookBookServiceImpl extends AbstractCMPageService<ICMBaseDAO<CookBook>, CookBook> implements ICookBookService<ICMBaseDAO<CookBook>,CookBook>{
     @Autowired
     private ICookBookDAO cookBookDAO;


     @Autowired
     private IMaterialService materialService;

     @Autowired
     private IProcessService processService;


    @Override
    public ICMBaseDAO<CookBook> getDao() {
        return cookBookDAO;
    }



    @Override
    public Long saveCookBook(String user, CookBookParam cookBookParam, MaterialParam materialParam, ProcessParam processParam) {

        CookBook cookBook = new CookBook();
        try {
            cookBook.setName(cookBookParam.getName());
            cookBook.setDescription(cookBookParam.getDescription());
            cookBook.setTips(cookBookParam.getTips());
            cookBook.setMaterialId(materialService.saveMaterial(user,materialParam));
            cookBook.setProcessId(processService.saveProcess(user,processParam));
            cookBook.setCategoryId(cookBookParam.getCategoryId());
            //获取用户主键
//            cookBook.setUid(456L);
            cookBook.setCreateDate(System.currentTimeMillis());
            //获取创建人
            cookBook.setCreator(user);
            cookBook.setStatus(0);
            this.insert(cookBook);

        }catch (Exception e){
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());
        }

        return cookBook.getId();
    }





    @Override
    public CookBookEx findCookBookByCBid(Long cookBookId) {
        CookBookEx cookBookEx = null;
        //判断cookbookId是否为空
        if(cookBookId==null){
            throw new BizException(ERRORCODE.PARAM_ISNULL.getCode(),ERRORCODE.PARAM_ISNULL.getMessage());
        }

        try{
            cookBookEx = cookBookDAO.findCookBookInfoByCBid(cookBookId);
            if(cookBookEx==null){
                throw new BizException(ERRORCODE.RESULT_ISNULL.getCode(),ERRORCODE.RESULT_ISNULL.getMessage());
            }
        }catch (Exception e){
            if(e instanceof BizException){
                throw new BizException(ERRORCODE.RESULT_ISNULL.getCode(),ERRORCODE.RESULT_ISNULL.getMessage());
            }else {
                throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());
            }

        }

        return cookBookEx;
    }

    @Override
    public int deleteCookBookByCBid(Long cookBookId) {
        CookBook cookBook = findOne(CookBookParam.F_ID, cookBookId);

        if(cookBook == null){
            throw new BizException(ERRORCODE.RESULT_ISNULL.getCode(),ERRORCODE.RESULT_ISNULL.getMessage());
        }


        try {
            materialService.deleteById(cookBook.getMaterialId());
            materialService.deleteById(cookBook.getMaterialId());
            cookBookDAO.deleteById(cookBookId);
        }catch (Exception e){
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());
        }

        return 1;
    }

    @Override
    public int updateCookBook(String user, CookBookParam cookBookParam, MaterialParam materialParam, ProcessParam processParam) {
        try {
            materialParam.setId(cookBookParam.getMaterialId());
            processParam.setId(cookBookParam.getProcessId());

            materialService.updateMaterial(user,materialParam);
            processService.updateProcess(user,processParam);

            CookBook cookBook = this.findOne(CookBookParam.F_ID,cookBookParam.getId());
            cookBook.setName(cookBookParam.getName());
            cookBook.setDescription(cookBookParam.getDescription());
            cookBook.setTips(cookBookParam.getTips());
            cookBook.setCategoryId(cookBookParam.getCategoryId());
            cookBook.setCreateDate(System.currentTimeMillis());
            cookBook.setCreator(user);
            cookBook.setStatus(0);

            this.update(cookBook);

        }catch (Exception e){
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());
        }

        return 1;
    }


}