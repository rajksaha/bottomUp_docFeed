package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpRefferedDoctor {

    private Integer id;
    private String doctorName;
    private String doctorAdress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorAdress() {
        return doctorAdress;
    }

    public void setDoctorAdress(String doctorAdress) {
        this.doctorAdress = doctorAdress;
    }
}
