package cn.eatammy.common.utils.auth;

import cn.eatammy.cm.domain.auth.AuthModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Created by 郭旭辉 on 2016/8/13.
 * 权限工具类
 */
public class AuthUtils {
    //树根代码
    public static final String AUTHROOTCODE = "0";

    /**
     *  把指定的权限模块数据构建成一棵权限树（兄弟节点间按priority字段排序）
     * @param sourceList        权限模块数据
     * @param pCode             父节点（根节点为0）
     * @param includeSelf       是否包含自身，true：是，false：否
     * @return 返回，权限树
     */
    public static List<AuthModule> buildAuthModuleTree(List<AuthModule> sourceList, String pCode, Boolean includeSelf){
        List<AuthModule> resultList = new ArrayList<>();        //结果集
        List<AuthModule> authModuleList = new ArrayList<>();    //兄弟结果集合
        for(AuthModule authModule : sourceList){
            if(authModule.getPCode().equals(pCode)){
                authModuleList.add(authModule);
            }
            if(includeSelf && authModule.getCode().equals(pCode)){
                resultList.add(authModule);
            }
        }
        //兄弟节点间按priority字段排序（多于一个是才需要排序）
        if(authModuleList.size()>1){
            Collections.sort(authModuleList, new Comparator<AuthModule>() {
                @Override
                public int compare(AuthModule o1, AuthModule o2) {
                    return o1.getPriority().compareTo(o2.getPriority());
                }
            });
        }
        for(AuthModule authModule: authModuleList){
            resultList.add(authModule);
            resultList.addAll(buildAuthModuleTree(sourceList, authModule.getCode(), false));
        }
        return resultList;
    }
}
