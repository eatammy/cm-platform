/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2005-2016 广东全通教育股份有限公司. 保留所有权利.					
{  创建人：  郭旭辉
{  审查人：
{  模块：食谱制作步骤表											
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
import cn.eatammy.cm.dao.cook.IProcessDAO;
import cn.eatammy.cm.domain.cook.Process;
import cn.eatammy.cm.param.cook.ProcessParam;
import cn.eatammy.cm.service.AbstractCMPageService;
import cn.eatammy.common.exception.BizException;
import cn.eatammy.common.utils.ERRORCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《食谱制作步骤》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("ProcessServiceImpl")
public class ProcessServiceImpl extends AbstractCMPageService<ICMBaseDAO<Process>, Process> implements IProcessService<ICMBaseDAO<Process>,Process>{
    @Autowired
    private IProcessDAO processDAO;

    @Override
    public ICMBaseDAO<Process> getDao() {
        return processDAO;
    }


     @Override
     public Long saveProcess(String user, ProcessParam processParam) {
         Process process = new Process();
         try {
             process.setProcess(processParam.getProcess());
             process.setProcessUrl(processParam.getProcessUrl());
             process.setCreateDate(System.currentTimeMillis());
             process.setCreator(user);
             process.setStatus(0);
             this.insert(process);
         }catch (Exception e){
             throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());

         }

         return process.getId();
     }

     @Override
     public int updateProcess(String user, ProcessParam processParam) {
         try {
             Process process = this.findOne(ProcessParam.F_ID,processParam.getId());
             process.setProcess(processParam.getProcess());
             process.setProcessUrl(processParam.getProcessUrl());
             process.setLastModDate(System.currentTimeMillis());
             process.setLastModifier(user);
             process.setStatus(0);
             this.update(process);
         }catch (Exception e){
             throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());
         }
         return 1;
     }
 }