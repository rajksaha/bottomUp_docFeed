package com.bottomUp.common.type;

/**
 * Created by raj on 7/25/2020.
 */
public enum EmailAttachmentType {
    PDF("application/pdf"),
    CSV("application/csv"),
    DOC("application/msword"),
    XLS("application/excel"),
    ZIP("application/zip");

    private String mimeType;

    EmailAttachmentType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
