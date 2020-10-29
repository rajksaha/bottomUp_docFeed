package com.bottomUp.domain.common.user;


import com.bottomUp.domain.common.BaseData;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by raj on 4/28/2016.
 */
public class UserProfileData extends BaseData {


    private Long userProfileID;
    private String userName;
    private Long userID;
    private String firstName;
    private String lastName;
    private String employeeCode;
    private String emailAddress;
    private Integer status;
    private Long companyID;
    private String contactNo;
    private Timestamp dateOfBirth;
    private Long doctorID;
    private String sex;
    private String JsonString;
    private Boolean isCompanyAdmin;
    private Integer isDoctor;
    private String doctorCode;

    private List<CompanyLevelData> companyLevelList;
    private List<UserGroupAssignmentData> groupAssignmentList;
    private List<UserGroupData> userGroupList;

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public Long getUserProfileID() {
        return userProfileID;
    }

    public void setUserProfileID(Long userProfileID) {
        this.userProfileID = userProfileID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Long doctorID) {
        this.doctorID = doctorID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJsonString() {
        return JsonString;
    }

    public void setJsonString(String jsonString) {
        JsonString = jsonString;
    }

    public Boolean getCompanyAdmin() {
        return isCompanyAdmin;
    }

    public void setCompanyAdmin(Boolean companyAdmin) {
        isCompanyAdmin = companyAdmin;
    }

    public List<CompanyLevelData> getCompanyLevelList() {
        return companyLevelList;
    }

    public void setCompanyLevelList(List<CompanyLevelData> companyLevelList) {
        this.companyLevelList = companyLevelList;
    }

    public List<UserGroupAssignmentData> getGroupAssignmentList() {
        return groupAssignmentList;
    }

    public void setGroupAssignmentList(List<UserGroupAssignmentData> groupAssignmentList) {
        this.groupAssignmentList = groupAssignmentList;
    }

    public List<UserGroupData> getUserGroupList() {
        return userGroupList;
    }

    public void setUserGroupList(List<UserGroupData> userGroupList) {
        this.userGroupList = userGroupList;
    }

    public Integer getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(Integer isDoctor) {
        this.isDoctor = isDoctor;
    }
}
