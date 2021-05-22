package com.bottomUp.domain.migration;

import org.joda.time.DateTime;
import software.amazon.ion.Decimal;

import java.util.Date;

/**
 * Created by user on 14-May-21.
 */
public class DumpPatient {

    private Integer patientID;
    private String patientCode;
    private String name;
    private Decimal age;
    private String sex;
    private String address;
    private String phone;
    private String occupation;
    private String referredBy;
    private DateTime date;
    private String hospitalName;
    private String bedNum;
    private String wardNum;
    private String headOfUnit;

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Decimal getAge() {
        return age;
    }

    public void setAge(Decimal age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
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
}
