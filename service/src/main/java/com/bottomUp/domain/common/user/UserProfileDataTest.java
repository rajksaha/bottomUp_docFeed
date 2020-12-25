package com.bottomUp.domain.common.user;

import com.bottomUp.domain.common.BaseData;

import java.util.Date;
import java.util.List;

/**
 * Created by raj on 12/22/2020.
 */
public class UserProfileDataTest extends BaseData{

    private Long userProfileID;
    private String userName;
    private Long userID;
    private String firstName;
    private String lastName;
    private String employeeCode;
    private String emailAddress;
    private String address;
    private Integer status;
    private Long companyID;
    private String contactNo;
    private Date dateOfBirth;
    private Long doctorID;
    private String sex;
    private String JsonString;
    private Integer companyAdmin;
    private Integer isDoctor;
    private String doctorCode;

    private List<CompanyLevelData> companyLevelList;
    private List<UserGroupAssignmentData> groupAssignmentList;
    private List<UserGroupData> userGroupList;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public Integer getCompanyAdmin() {
        return companyAdmin;
    }

    public void setCompanyAdmin(Integer companyAdmin) {
        this.companyAdmin = companyAdmin;
    }

    public Integer getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(Integer isDoctor) {
        this.isDoctor = isDoctor;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
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
}
