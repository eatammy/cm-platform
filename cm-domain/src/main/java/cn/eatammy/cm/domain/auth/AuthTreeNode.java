package cn.eatammy.cm.domain.auth;

import java.io.Serializable;

/**
 * Created by 郭旭辉 on 2016/8/17.
 * 模块操作节点实体
 */
public class AuthTreeNode  implements Serializable{
    private static final long serialVersionUID = -5158608228071514126L;

    private String code;
    private String name;
    //父节点
    private String pCode;
    //是否有子节点
    private Boolean isParent;

    public AuthTreeNode() {
    }

    public AuthTreeNode( String code,String name, String pCode, Boolean isParent) {
        this.code = code;
        this.name = name;
        this.pCode = pCode;
        this.isParent = isParent;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
