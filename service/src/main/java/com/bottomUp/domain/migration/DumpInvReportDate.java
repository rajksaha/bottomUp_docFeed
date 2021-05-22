package com.bottomUp.domain.migration;

import java.util.Date;

/**
 * Created by user on 14-May-21.
 */
public class DumpInvReportDate {

    private Integer invReportDateId;
    private Integer patientId;
    private Date reportDate;
    private String reportLocation;
    private String fileName;
    private String ext;

    public Integer getInvReportDateId() {
        return invReportDateId;
    }

    public void setInvReportDateId(Integer invReportDateId) {
        this.invReportDateId = invReportDateId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportLocation() {
        return reportLocation;
    }

    public void setReportLocation(String reportLocation) {
        this.reportLocation = reportLocation;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
