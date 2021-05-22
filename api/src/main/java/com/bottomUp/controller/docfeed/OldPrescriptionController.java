package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.PatientData;
import com.bottomUp.service.docFeed.OldPrescriptionService;
import com.bottomUp.service.docFeed.crud.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 2/1/2021.
 */
@Controller
@RequestMapping("/oldPres")
public class OldPrescriptionController extends BaseController{

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private OldPrescriptionService oldPrescriptionService;

    @RequestMapping(value = {"/getAppHistory/{patientID}/{doctorID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<AppointmentData> getAppHistory(@PathVariable("patientID") Long patientID,
                                        @PathVariable("doctorID") Long doctorID,
                                        HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("patientID", patientID);
        params.put("doctorID", doctorID);
        params.put("notAppointmentID", this.getUserDetail().getAppointmentID());
        params.put("orderByAppDate", true);
        return this.appointmentService.getByParam(params);
    }

    @RequestMapping(value = {"/addItemToPres/{itemCode}/{itemID}/{newAppointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public void addItemToPrescription(@PathVariable("itemCode") String itemCode,
                                        @PathVariable("itemID") Long itemID,
                                        @PathVariable("newAppointmentID") Long newAppointmentID,
                                        HttpServletRequest request) throws BottomUpException {
        this.oldPrescriptionService.copyByItem(itemCode, itemID, newAppointmentID);

    }

    @RequestMapping(value = {"/addBulkToPres/{itemCode}/{oldAppointmentID}/{newAppointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public void addBulkToPrescription(@PathVariable("itemCode") String itemCode,
                                      @PathVariable("oldAppointmentID") Long oldAppointmentID,
                                      @PathVariable("newAppointmentID") Long newAppointmentID,
                                      HttpServletRequest request) throws BottomUpException {

        this.oldPrescriptionService.copyItemsByAppointmentID(itemCode, oldAppointmentID, newAppointmentID);

    }

    @RequestMapping(value = {"/copyPrescription/{oldAppointmentID}/{newAppointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public void copyPrescription(@PathVariable("oldAppointmentID") Long oldAppointmentID,
                                 @PathVariable("newAppointmentID") Long newAppointmentID,
                                 HttpServletRequest request) throws BottomUpException {
        this.oldPrescriptionService.copyPrescription(oldAppointmentID, newAppointmentID);
    }
}
