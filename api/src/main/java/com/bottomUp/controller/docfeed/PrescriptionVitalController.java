package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.  PrescriptionVitalData;
import com.bottomUp.service.docFeed.crud.PrescriptionVitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 8/9/2020.
 */
@Controller
@RequestMapping("/prescriptionVital")
public class PrescriptionVitalController extends BaseController {

    @Autowired
    private PrescriptionVitalService prescriptionVitalService;

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionVitalService.save(searchData.getVitalList(), searchData.getAppointmentID());
        return result;
    }

    @RequestMapping(value = "/delete/{presVitalID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("presVitalID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("  presVitalID", appointmentID);
        this.prescriptionVitalService.delete(param);
    }
}
