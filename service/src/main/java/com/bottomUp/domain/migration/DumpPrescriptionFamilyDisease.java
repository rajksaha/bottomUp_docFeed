package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpPrescriptionFamilyDisease {

    private Integer id;
    private Integer appointMentID;
    private Integer familyDiseaseID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppointMentID() {
        return appointMentID;
    }

    public void setAppointMentID(Integer appointMentID) {
        this.appointMentID = appointMentID;
    }

    public Integer getFamilyDiseaseID() {
        return familyDiseaseID;
    }

    public void setFamilyDiseaseID(Integer familyDiseaseID) {
        this.familyDiseaseID = familyDiseaseID;
    }
}
