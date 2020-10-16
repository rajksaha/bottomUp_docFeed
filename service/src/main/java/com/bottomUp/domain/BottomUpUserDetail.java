package com.bottomUp.domain;

import com.bottomUp.domain.common.CompanyData;
import com.bottomUp.domain.common.user.UserProfilePermissionData;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by raj on 7/25/2020.
 */
public class BottomUpUserDetail extends User {

    public BottomUpUserDetail (String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    private UserProfilePermissionData userProfilePermissionData;

    private CompanyData companyData;

    private DoctorData doctorData;

    private PatientData patientData;

    private Long appointmentID;

    public UserProfilePermissionData getUserProfilePermissionData() {
        return userProfilePermissionData;
    }

    public void setUserProfilePermissionData(UserProfilePermissionData userProfilePermissionData) {
        this.userProfilePermissionData = userProfilePermissionData;
    }

    public CompanyData getCompanyData() {
        return companyData;
    }

    public void setCompanyData(CompanyData companyData) {
        this.companyData = companyData;
    }

    public Long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Long appointmentID) {
        this.appointmentID = appointmentID;
    }

    public DoctorData getDoctorData() {
        return doctorData;
    }

    public void setDoctorData(DoctorData doctorData) {
        this.doctorData = doctorData;
    }

    public PatientData getPatientData() {
        return patientData;
    }

    public void setPatientData(PatientData patientData) {
        this.patientData = patientData;
    }
}
