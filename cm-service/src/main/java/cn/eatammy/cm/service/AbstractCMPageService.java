package cn.eatammy.cm.service;

import cn.eatammy.cm.dao.ICMBaseDAO;
import cn.eatammy.common.domain.BaseDomain;
import cn.eatammy.common.service.impl.AbstractPageService;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */

public abstract class AbstractCMPageService<D extends ICMBaseDAO,T extends BaseDomain> extends AbstractPageService<D, T> {

}
