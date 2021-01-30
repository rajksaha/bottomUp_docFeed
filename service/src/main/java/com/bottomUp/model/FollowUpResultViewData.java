package com.bottomUp.model;

import com.bottomUp.domain.DoctorFollowUpSettingData;
import com.bottomUp.domain.FollowUpResultData;

import java.util.List;

/**
 * Created by raj on 1/29/2021.
 */
public class FollowUpResultViewData {

    private List<DoctorFollowUpSettingData> docFollowUpList;

    private List<FollowUpResultData> patientFollowUpList;

    public List<DoctorFollowUpSettingData> getDocFollowUpList() {
        return docFollowUpList;
    }

    public void setDocFollowUpList(List<DoctorFollowUpSettingData> docFollowUpList) {
        this.docFollowUpList = docFollowUpList;
    }

    public List<FollowUpResultData> getPatientFollowUpList() {
        return patientFollowUpList;
    }

    public void setPatientFollowUpList(List<FollowUpResultData> patientFollowUpList) {
        this.patientFollowUpList = patientFollowUpList;
    }
}
