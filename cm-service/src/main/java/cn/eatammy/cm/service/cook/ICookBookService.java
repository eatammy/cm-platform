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

import cn.eatammy.cm.domain.cook.*;
import cn.eatammy.cm.param.cook.CookBookParam;
import cn.eatammy.cm.param.cook.MaterialParam;
import cn.eatammy.cm.param.cook.ProcessParam;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.service.IPageService;


 /**
 * 《菜谱》 业务逻辑服务接口
 * @author 郭旭辉
 *
 */
public interface ICookBookService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>,IPageService<D, T>{

      /**
       * 保存单个食谱
       * @param user  用户参数实体
       * @param cookBookParam  食谱参数实体
       * @param materialParam  原材料参数实体
       * @param processParam   步骤参数实体
       * @return 成功放回插入该条记录的id
       */
        Long saveCookBook(String user,CookBookParam cookBookParam, MaterialParam materialParam,
                           ProcessParam processParam);


     /**
      * 根据菜谱id找到菜谱的扩展实例
      * @param cookBookId 食谱id
      * @return 返回菜谱的扩展实例
      */
        CookBookEx findCookBookByCBid(Long cookBookId);

     /**
      * 根据食谱id删除食谱
      * @param cookBookId 食谱id
      * @return  返回， 0：失败，1：成功
      */
        int deleteCookBookByCBid(Long cookBookId);

     /**
      * 更新食谱信息
      * @param user 用户信息
      * @param cookBookParam 食谱参数实体
      * @param materialParam 原材料参数实体
      * @param processParam 食谱制作步骤参数实体
      * @return 成功返回1，否则抛出异常
      */
        int updateCookBook(String user,CookBookParam cookBookParam, MaterialParam materialParam,
                           ProcessParam processParam);
}