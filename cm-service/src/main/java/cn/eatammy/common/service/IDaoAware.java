package cn.eatammy.common.service;

import cn.eatammy.common.dao.IBaseDAO;
import cn.eatammy.common.domain.BaseDomain;

/**
 * Created by 郭旭辉 on 2016/3/13.
 * 业务主对象DAO注入
 */
/*
    @authot simagle
*/
public interface IDaoAware<D extends IBaseDAO, T extends BaseDomain> {
    public D getDao();
}
