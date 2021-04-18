package com.bottomUp.model;

import com.bottomUp.domain.common.BaseData;

import java.util.Date;

/**
 * Created by raj on 02/12/21.
 */
public class AttachmentData extends BaseData {

    private Long attachmentID;
    private String entityType;
    private Integer entityID;
    private String description;
    private String shortName;
    private String contentUrl;
    private String fileType;
    private String label;
    private String sortOrder;
    private Date entityDate;
    private Integer status;
    private Long contentDetailID;
    private Integer addedInPres;

    public Long getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(Long attachmentID) {
        this.attachmentID = attachmentID;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Integer getEntityID() {
        return entityID;
    }

    public void setEntityID(Integer entityID) {
        this.entityID = entityID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getEntityDate() {
        return entityDate;
    }

    public void setEntityDate(Date entityDate) {
        this.entityDate = entityDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAddedInPres() {
        return addedInPres;
    }

    public void setAddedInPres(Integer addedInPres) {
        this.addedInPres = addedInPres;
    }

    public Long getContentDetailID() {
        return contentDetailID;
    }

    public void setContentDetailID(Long contentDetailID) {
        this.contentDetailID = contentDetailID;
    }
}
