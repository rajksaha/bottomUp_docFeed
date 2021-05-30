package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentVitalData;
import com.bottomUp.domain.PrescriptionVitalData;
import com.bottomUp.service.docFeed.crud.ContentVitalService;
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
@RequestMapping("/contentVital")
public class ContentVitalController extends BaseController {

    @Autowired
    private ContentVitalService contentVitalService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentVitalData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.contentVitalService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{vitalID}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentVitalData getByID(@PathVariable("vitalID") String vitalID, HttpServletRequest request) throws BottomUpException {
        return this.contentVitalService.getByID(vitalID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentVitalData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentVitalService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentVitalData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentVitalService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{vitalID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("vitalID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("vitalID", appointmentID);
        this.contentVitalService.delete(param);
    }
}
