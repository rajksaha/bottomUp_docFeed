package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.PatientData;
import com.bottomUp.model.AppointmentViewData;
import com.bottomUp.myBatis.persistence.AppointmentMapper;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;

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
        if(appointmentData.getDate() == null ){
            DateTime now = new DateTime();
            appointmentData.setDate(now.toDate());
            appointmentData.setTime(Time.valueOf("" + now.getHourOfDay() + ":" + now.getMinuteOfHour()
                    + ":" + now.getSecondOfMinute() ));
        }
        appointmentData.setStatus(1);
        appointmentData.setAppointmentType(1);
        appointmentMapper.create(appointmentData);

    }
}