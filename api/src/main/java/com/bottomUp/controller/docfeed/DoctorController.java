package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorData;
import com.bottomUp.service.docFeed.crud.DoctorService;
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
@RequestMapping("/doctor")
public class DoctorController extends BaseController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorData> getAll(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        if(this.getUserDetail().getUserProfilePermissionData().getPermissions().get("COMPANY_ADMIN")){
            params.put("companyID", this.getUserDetail().getCompanyData().getCompanyID());
        }
        return this.doctorService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{doctorID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorData getByID(@PathVariable("doctorID") String doctorID, HttpServletRequest request) throws BottomUpException {
        return this.doctorService.getByID(doctorID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorData doctorData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorService.create(doctorData);
        result.put("data", doctorData);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorData doctorData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorService.update(doctorData);
        result.put("doctorData", doctorData);
        return result;
    }

    @RequestMapping(value = "/delete/{doctorID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("doctorID") String doctorID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("doctorID", doctorID);
        this.doctorService.delete(param);
    }
}
