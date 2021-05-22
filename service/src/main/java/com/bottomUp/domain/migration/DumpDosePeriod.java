package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpDosePeriod {

    private Integer drugPrescribeID;
    private String dose;
    private Double numOfDay;
    private Integer durationType;

    public Integer getDrugPrescribeID() {
        return drugPrescribeID;
    }

    public void setDrugPrescribeID(Integer drugPrescribeID) {
        this.drugPrescribeID = drugPrescribeID;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Double getNumOfDay() {
        return numOfDay;
    }

    public void setNumOfDay(Double numOfDay) {
        this.numOfDay = numOfDay;
    }

    public Integer getDurationType() {
        return durationType;
    }

    public void setDurationType(Integer durationType) {
        this.durationType = durationType;
    }
}
