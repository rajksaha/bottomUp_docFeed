package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpDoctorsettings {

    private Integer id;
    private Integer doctorID;
    private Integer category;
    private Integer state;
    private Integer patientType;
    private Integer patientState;
    private Integer prescriptionStyle;
    private Integer hospitalID;
    private Integer photoSupport;
    private Integer personCodeInitial;
    private String pdfPage;

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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    public Integer getPatientState() {
        return patientState;
    }

    public void setPatientState(Integer patientState) {
        this.patientState = patientState;
    }

    public Integer getPrescriptionStyle() {
        return prescriptionStyle;
    }

    public void setPrescriptionStyle(Integer prescriptionStyle) {
        this.prescriptionStyle = prescriptionStyle;
    }

    public Integer getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(Integer hospitalID) {
        this.hospitalID = hospitalID;
    }

    public Integer getPhotoSupport() {
        return photoSupport;
    }

    public void setPhotoSupport(Integer photoSupport) {
        this.photoSupport = photoSupport;
    }

    public Integer getPersonCodeInitial() {
        return personCodeInitial;
    }

    public void setPersonCodeInitial(Integer personCodeInitial) {
        this.personCodeInitial = personCodeInitial;
    }

    public String getPdfPage() {
        return pdfPage;
    }

    public void setPdfPage(String pdfPage) {
        this.pdfPage = pdfPage;
    }
}
