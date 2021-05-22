package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpContentdetail {

    private Integer contentDetailID;
    private String contentType;
    private Integer entityID;
    private String detail;
    private String code;

    public Integer getContentDetailID() {
        return contentDetailID;
    }

    public void setContentDetailID(Integer contentDetailID) {
        this.contentDetailID = contentDetailID;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getEntityID() {
        return entityID;
    }

    public void setEntityID(Integer entityID) {
        this.entityID = entityID;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
