package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpDoctorAdviceSettings {

    private Integer id;
    private Integer doctorID;
    private Integer adviceID;
    private Integer displayOrder;

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

    public Integer getAdviceID() {
        return adviceID;
    }

    public void setAdviceID(Integer adviceID) {
        this.adviceID = adviceID;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
