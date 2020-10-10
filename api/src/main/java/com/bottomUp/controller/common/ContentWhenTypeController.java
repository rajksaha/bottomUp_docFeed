package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentWhenTypeData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.ContentWhenTypeService;
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
@RequestMapping("/contentWhenType")
public class ContentWhenTypeController extends BaseController {

    @Autowired
    private ContentWhenTypeService contentWhenTypeService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentWhenTypeData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.contentWhenTypeService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{whenTypeID}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentWhenTypeData getByID(@PathVariable("whenTypeID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.contentWhenTypeService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentWhenTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentWhenTypeService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentWhenTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentWhenTypeService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{whenTypeID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("whenTypeID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("whenTypeID", appointmentID);
        this.contentWhenTypeService.delete(param);
    }
}
