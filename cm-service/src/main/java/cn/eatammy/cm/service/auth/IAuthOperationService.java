/*
{*****************************************************************************
{  吃咩主平台 v1.0													
{  版权信息 (c) 2016-2016 郭旭辉-詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：权限操作表											
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
import cn.eatammy.cm.domain.auth.AuthOperation;
import cn.eatammy.cm.domain.auth.AuthOperationEx;
import cn.eatammy.cm.param.auth.AuthOperationParam;
import cn.eatammy.cm.service.ICMBaseService;
import cn.eatammy.common.domain.AccountDto;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.common.domain.BizData4Page;
import cn.eatammy.common.service.IPageService;
import java.util.List;
import java.util.Map;

/**
 * 《权限操作》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IAuthOperationService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends ICMBaseService<D, T>, IPageService<D, T> {


    /**
     * 分页查询数据
     * @param param     功能参数实体
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，分页列表
     */
    BizData4Page<AuthOperationEx> queryPageEx(AuthOperationParam param, int pageNo, int pageSize);

    /**
     * 新增功能
     * @param authOperation 功能参数实体
     * @param accountDto    当前操作者
     * @return  返回，操作码
     */
    String add(AuthOperation authOperation, AccountDto accountDto);

    /**
     * 更新功能信息
     * @param authOperation     功能实体参数
     * @param accountDto        当前操作用户
     * @return 返回，操作码
     */
    String update(AuthOperation authOperation, AccountDto accountDto);

    /**
     * 启用、停用功能
     * @param id            功能id
     * @param accountDto    当前操作用户
     * @return 返回，操作码
     */
    String disableOrEnable(long id, AccountDto accountDto);

    /**
     * 单个删除功能
     * @param id    功能id
     * @return 返回，操作码
     */
    String deleteOne(long id);

    /**
     * 获取用户当前身份的操作列表
     * @param userCode  用户code
     * @param userType  用户身份值
     * @return
     */
    Map<String, List<String>> getOperation(String userCode, int userType);

    /**
     * 判断模块下是否存在改权限代码
     * @param moduleCode    模块代码
     * @param authCode      权限代码
     * @return  返回，true：存在，false：不存在
     */
    Boolean isExistAuthCode(String moduleCode, String authCode);


}