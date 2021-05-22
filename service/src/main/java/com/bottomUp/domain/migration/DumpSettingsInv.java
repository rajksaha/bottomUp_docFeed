package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpSettingsInv {

    private Integer id;
    private Integer doctorID;
    private Integer diseaseID;
    private Integer invID;
    private String note;
    private Integer checked;

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

    public Integer getInvID() {
        return invID;
    }

    public void setInvID(Integer invID) {
        this.invID = invID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }
}
