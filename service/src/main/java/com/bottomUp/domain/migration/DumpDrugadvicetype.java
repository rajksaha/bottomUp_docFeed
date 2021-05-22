package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpDrugadvicetype {

    private Integer id;
    private Integer doctorType;
    private String  bangla;
    private String  english;
    private String  pdf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(Integer doctorType) {
        this.doctorType = doctorType;
    }

    public String getBangla() {
        return bangla;
    }

    public void setBangla(String bangla) {
        this.bangla = bangla;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
}
