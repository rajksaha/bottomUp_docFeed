package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpDoctorDrugDose {

    private Integer doctorDrugDoseID;
    private Integer doctorDrugID;
    private String dose;
    private Integer numOfDay;
    private Integer durationType;

    public Integer getDoctorDrugDoseID() {
        return doctorDrugDoseID;
    }

    public void setDoctorDrugDoseID(Integer doctorDrugDoseID) {
        this.doctorDrugDoseID = doctorDrugDoseID;
    }

    public Integer getDoctorDrugID() {
        return doctorDrugID;
    }

    public void setDoctorDrugID(Integer doctorDrugID) {
        this.doctorDrugID = doctorDrugID;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Integer getNumOfDay() {
        return numOfDay;
    }

    public void setNumOfDay(Integer numOfDay) {
        this.numOfDay = numOfDay;
    }

    public Integer getDurationType() {
        return durationType;
    }

    public void setDurationType(Integer durationType) {
        this.durationType = durationType;
    }
}
