package edu.hhu.domain;

import java.io.Serializable;

public class GoodsType implements Serializable {
	private static final long serialVersionUID = 1L;
    private Integer typeId;
    private String typeName;
    private Integer typePid;
    private Integer typeLv;
    private String typePath;
    
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getTypePid() {
        return typePid;
    }

    public void setTypePid(Integer typePid) {
        this.typePid = typePid;
    }

    public Integer getTypeLv() {
        return typeLv;
    }

    public void setTypeLv(Integer typeLv) {
        this.typeLv = typeLv;
    }

    public String getTypePath() {
        return typePath;
    }

    public void setTypePath(String typePath) {
        this.typePath = typePath == null ? null : typePath.trim();
    }
}