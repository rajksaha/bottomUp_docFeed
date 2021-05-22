package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpSettingsAdvice {

    private Integer id;
    private Integer doctorID;
    private Integer diseaseID;
    private Integer adviceID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(Integer diseaseID) {
        this.diseaseID = diseaseID;
    }

    public Integer getAdviceID() {
        return adviceID;
    }

    public void setAdviceID(Integer adviceID) {
        this.adviceID = adviceID;
    }
}
