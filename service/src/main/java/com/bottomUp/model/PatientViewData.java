package com.bottomUp.model;

import com.bottomUp.domain.common.BaseData;
import utility.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by raj on 10/24/2020.
 */
public class PatientViewData extends BaseData {

    private long patientID;
    private long userID;
    private String patientCode;
    private Integer patientType;
    private String patientTypeName;
    private String occupation;
    private String referredBy;
    private String hospitalName;
    private String bedNum;
    private String wardNum;
    private String headOfUnit;
    private long userProfileID;
    private Integer age;
    private Integer currentAge;
    private Date dateOfBirth;
    private String userName;
    private String firstName;
    private String lastName;
    private Long companyID;
    private String sex;
    private String contactNo;
    private String emailAddress;
    private String address;
    private String imageURL;

    public Integer getCurrentAge() {
        if(this.dateOfBirth != null){
            return DateUtil.getNoOfDays(this.dateOfBirth, new Date()) / 365;
        }
        return null;
    }

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getUserProfileID() {
        return userProfileID;
    }

    public void setUserProfileID(long userProfileID) {
        this.userProfileID = userProfileID;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    public String getWardNum() {
        return wardNum;
    }

    public void setWardNum(String wardNum) {
        this.wardNum = wardNum;
    }

    public String getHeadOfUnit() {
        return headOfUnit;
    }

    public void setHeadOfUnit(String headOfUnit) {
        this.headOfUnit = headOfUnit;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    public String getPatientTypeName() {
        return patientTypeName;
    }

    public void setPatientTypeName(String patientTypeName) {
        this.patientTypeName = patientTypeName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
