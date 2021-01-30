package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.FollowUpResultData;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.model.FollowUpResultViewData;
import com.bottomUp.service.docFeed.crud.ContentDetailService;
import com.bottomUp.service.docFeed.crud.FollowUpResultService;
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
@RequestMapping("/followUpResult")
public class FollowUpResultController extends BaseController {

    @Autowired
    private FollowUpResultService followUpResultService;

    @Autowired
    private ContentDetailService contentDetailService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<FollowUpResultData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.followUpResultService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{resultID}"}, method = RequestMethod.GET)
    @ResponseBody
    public FollowUpResultData getByID(@PathVariable("resultID") Integer companyID, HttpServletRequest request) throws BottomUpException {
        return this.followUpResultService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/getFollowUpView/{doctorID}/{patientID}/{patientTypeID}/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public FollowUpResultViewData getFollowUpView(@PathVariable("doctorID") Long doctorID,
                                                  @PathVariable("patientID") Long patientID,
                                                  @PathVariable("patientTypeID") Integer patientTypeID,
                                                  @PathVariable("appointmentID") Long appointmentID,
                                                  HttpServletRequest request) throws BottomUpException {
        return this.followUpResultService.generateFollowUpView(doctorID, patientID, patientTypeID, appointmentID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody FollowUpResultData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.followUpResultService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody FollowUpResultData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.followUpResultService.update(data);
        return result;
    }

    @RequestMapping(value = {"/addFollowUpToPres"}, method = RequestMethod.POST)
    @ResponseBody
    public Long updateAddedInPres(@RequestBody ContentDetailData data) throws BottomUpException {
        return this.contentDetailService.addFollowUpToPres(data);
    }

    @RequestMapping(value = "/delete/{resultID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("resultID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("resultID", appointmentID);
        this.followUpResultService.delete(param);
    }
}
