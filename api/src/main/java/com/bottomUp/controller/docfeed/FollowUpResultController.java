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
    public FollowUpResultData getByID(@PathVariable("resultID") String resultID, HttpServletRequest request) throws BottomUpException {
        return this.followUpResultService.getByID(resultID);
    }

    @RequestMapping(value = {"/getFollowUpView/{doctorID}/{patientID}/{patientTypeID}/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public FollowUpResultViewData getFollowUpView(@PathVariable("doctorID") String doctorID,
                                                  @PathVariable("patientID") String patientID,
                                                  @PathVariable("patientTypeID") String patientTypeID,
                                                  @PathVariable("appointmentID") String appointmentID,
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
    public String updateAddedInPres(@RequestBody ContentDetailData data) throws BottomUpException {
        return this.contentDetailService.addFollowUpToPres(data);
    }

    @RequestMapping(value = "/delete/{resultID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("resultID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("resultID", appointmentID);
        this.followUpResultService.delete(param);
    }
}
