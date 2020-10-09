package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.FollowUpResultData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.FollowUpResultService;
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

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<FollowUpResultData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.followUpResultService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{resultID}"}, method = RequestMethod.GET)
    @ResponseBody
    public FollowUpResultData getByID(@PathVariable("resultID") Integer resultID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.followUpResultService.getByID(Long.valueOf(resultID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody FollowUpResultData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.followUpResultService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody FollowUpResultData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.followUpResultService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{resultID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("resultID") Integer resultID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("resultID", resultID);
        this.followUpResultService.delete(param);
    }
}
