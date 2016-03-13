package cn.eatammy.cm.service;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.common.service.IBaseService;
import cn.eatammy.common.service.IPageService;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */
/*
    @authot simagle
*/
public interface ICMBaseService<D extends ICMBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T>, IPageService<D, T>{
}
