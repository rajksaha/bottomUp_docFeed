package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpSettingsDoseDrug {

    private Integer drugSettingID;
    private String dose;
    private Integer numOfDay;
    private Integer durationType;

    public Integer getDrugSettingID() {
        return drugSettingID;
    }

    public void setDrugSettingID(Integer drugSettingID) {
        this.drugSettingID = drugSettingID;
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
