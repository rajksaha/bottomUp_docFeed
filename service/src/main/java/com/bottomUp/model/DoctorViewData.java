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

    private String userID;
    private String doctorID;
    private String doctorCode;
    private String hospitalID;

    private String userProfileID;
    private String userName;
    private String firstName;
    private String lastName;
    private String companyID;
    private String sex;
    private String contactNo;
    private String emailAddress;

    private List<MenuSettingData> menuList;
    private DoctorSettingData doctorSettingData;
    private List<PatientTypeData> patientTypeList;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getUserProfileID() {
        return userProfileID;
    }

    public void setUserProfileID(String userProfileID) {
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

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
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
