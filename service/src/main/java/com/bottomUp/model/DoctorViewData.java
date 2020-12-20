package com.bottomUp.model;

import com.bottomUp.domain.DoctorSettingData;
import com.bottomUp.domain.MenuSettingData;
import com.bottomUp.domain.PatientTypeData;
import com.bottomUp.domain.common.BaseData;

import java.util.List;

/**
 * Created by raj on 10/24/2020.
 */
public class DoctorViewData extends BaseData{

    private long userID;
    private long doctorID;
    private String doctorCode;
    private long hospitalID;

    private long userProfileID;
    private String userName;
    private String firstName;
    private String lastName;
    private Long companyID;
    private String sex;
    private String contactNo;
    private String emailAddress;

    private List<MenuSettingData> menuList;
    private DoctorSettingData doctorSettingData;
    private List<PatientTypeData> patientTypeList;


    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public long getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(long hospitalID) {
        this.hospitalID = hospitalID;
    }

    public long getUserProfileID() {
        return userProfileID;
    }

    public void setUserProfileID(long userProfileID) {
        this.userProfileID = userProfileID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<MenuSettingData> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuSettingData> menuList) {
        this.menuList = menuList;
    }

    public DoctorSettingData getDoctorSettingData() {
        return doctorSettingData;
    }

    public void setDoctorSettingData(DoctorSettingData doctorSettingData) {
        this.doctorSettingData = doctorSettingData;
    }

    public List<PatientTypeData> getPatientTypeList() {
        return patientTypeList;
    }

    public void setPatientTypeList(List<PatientTypeData> patientTypeList) {
        this.patientTypeList = patientTypeList;
    }
}
