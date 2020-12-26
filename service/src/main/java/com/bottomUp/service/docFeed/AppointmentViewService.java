package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.PatientData;
import com.bottomUp.model.AppointmentViewData;
import com.bottomUp.model.DoctorDashboardData;
import com.bottomUp.myBatis.persistence.AppointmentMapper;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utility.type.AppointmentStatusType;
import utility.type.AppointmentType;

import java.sql.Time;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 10/29/2020.
 */
@Service
@Transactional
public class AppointmentViewService {


    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private PatientViewService patientViewService;


    public void createForNewPatient(AppointmentViewData viewData, Long companyID) throws BottomUpException{

        PatientData patientData = patientViewService.create(viewData.getPatient(), companyID);
        AppointmentData appointmentData = new AppointmentData();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(viewData, appointmentData);
        appointmentData.setPatientID(patientData.getPatientID());
        if(appointmentData.getAppDate() == null ){
            DateTime now = new DateTime();
            appointmentData.setAppDate(now.toDate());
            appointmentData.setAppTime(Time.valueOf("" + now.getHourOfDay() + ":" + now.getMinuteOfHour()
                    + ":" + now.getSecondOfMinute() ));
        }
        appointmentData.setStatus(AppointmentStatusType.NEW.getIntValue());
        appointmentData.setAppointmentType(AppointmentType.NEW_APP.getIntValue());
        appointmentMapper.create(appointmentData);
    }

    public void createForFollowUpPatient(AppointmentViewData viewData) throws BottomUpException{
        patientViewService.update(viewData.getPatient());
        AppointmentData appointmentData = new AppointmentData();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(viewData, appointmentData);
        if(appointmentData.getAppDate() == null ){
            DateTime now = new DateTime();
            appointmentData.setAppDate(now.toDate());
            appointmentData.setAppTime(Time.valueOf("" + now.getHourOfDay() + ":" + now.getMinuteOfHour()
                    + ":" + now.getSecondOfMinute() ));
        }
        appointmentData.setStatus(AppointmentStatusType.NEW.getIntValue());
        appointmentData.setAppointmentType(AppointmentType.OLD_APP.getIntValue());
        appointmentMapper.create(appointmentData);
    }

    public DoctorDashboardData getDoctorDashboard(Map<String, Object> params)throws BottomUpException{
        List<AppointmentViewData> viewDataList = appointmentMapper.getAppPatientDetail(params);

        DoctorDashboardData viewData = new DoctorDashboardData();
        viewData.setNumOfMalePatient(0);
        viewData.setNumOfFemalePatient(0);
        viewData.setNumOfNewPatient(0);
        viewData.setNumOfOldPatient(0);
        viewData.setNumOfReportPatient(0);
        viewData.setNumOfFreePatient(0);
        for(AppointmentViewData data : viewDataList){
            if(data.getPatient().getSex().equalsIgnoreCase("Male")){
                viewData.setNumOfMalePatient(viewData.getNumOfMalePatient() +1);
            }else{
                viewData.setNumOfFemalePatient(viewData.getNumOfFemalePatient() +1);
            }

            if(data.getAppointmentType().equals(AppointmentType.NEW_APP.getIntValue())){
                viewData.setNumOfNewPatient(viewData.getNumOfNewPatient() +1);
            }else if(data.getAppointmentType().equals(AppointmentType.OLD_APP.getIntValue())){
                viewData.setNumOfOldPatient(viewData.getNumOfOldPatient() +1);
            }else if(data.getAppointmentType().equals(AppointmentType.REPORT.getIntValue())){
                viewData.setNumOfReportPatient(viewData.getNumOfReportPatient() +1);
            }else if(data.getAppointmentType().equals(AppointmentType.FREE.getIntValue())){
                viewData.setNumOfFreePatient(viewData.getNumOfFreePatient() +1);
            }else if(data.getAppointmentType().equals(AppointmentType.FAMILY.getIntValue())){
                //viewData.setNumOfNewPatient(viewData.getNumOfNewPatient() +1);
            }
        }
        return viewData;
    }
}
