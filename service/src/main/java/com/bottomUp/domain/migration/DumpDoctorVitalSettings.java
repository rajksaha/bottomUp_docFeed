package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpDoctorVitalSettings {

    private Integer id;
    private Integer doctorID;
    private Integer vitalID;
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

    public Integer getVitalID() {
        return vitalID;
    }

    public void setVitalID(Integer vitalID) {
        this.vitalID = vitalID;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
