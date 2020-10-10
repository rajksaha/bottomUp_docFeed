package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentVitalOptionData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.ContentVitalOptionService;
import com.bottomUp.service.docFeed.ContentVitalService;
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
@RequestMapping("/contentVitalOption")
public class ContentVitalOptionController extends BaseController {

    @Autowired
    private ContentVitalOptionService contentVitalOptionService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentVitalOptionData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.contentVitalOptionService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{vitalOptionID}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentVitalOptionData getByID(@PathVariable("vitalOptionID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.contentVitalOptionService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentVitalOptionData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentVitalOptionService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentVitalOptionData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentVitalOptionService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{vitalOptionID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("vitalOptionID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("vitalOptionID", appointmentID);
        this.contentVitalOptionService.delete(param);
    }
}
