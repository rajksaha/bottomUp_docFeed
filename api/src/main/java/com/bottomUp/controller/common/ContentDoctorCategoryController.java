package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentDoctorCategoryData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.ContentDoctorCategoryService;
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
@RequestMapping("/contentDoctorCategory")
public class ContentDoctorCategoryController extends BaseController {

    @Autowired
    private ContentDoctorCategoryService contentDoctorCategoryService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDoctorCategoryData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.contentDoctorCategoryService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{categoryId}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentDoctorCategoryData getByID(@PathVariable("categoryId") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.contentDoctorCategoryService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentDoctorCategoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDoctorCategoryService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentDoctorCategoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDoctorCategoryService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("categoryId") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("categoryId", appointmentID);
        this.contentDoctorCategoryService.delete(param);
    }
}
