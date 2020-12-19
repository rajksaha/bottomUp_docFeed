package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentDurationTypeData;
import com.bottomUp.service.docFeed.crud.ContentDurationTypeService;
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
@RequestMapping("/contentDayType")
public class ContentDayTypeController extends BaseController {

    @Autowired
    private ContentDurationTypeService contentDayTypeService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDurationTypeData> getAll(HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = new HashMap<>();

        return this.contentDayTypeService.getByParam(null);
    }

    @RequestMapping(value = {"/getByID/{dayTypeId}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentDurationTypeData getByID(@PathVariable("dayTypeId") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.contentDayTypeService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentDurationTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDayTypeService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentDurationTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDayTypeService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{dayTypeId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("dayTypeId") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("dayTypeId", appointmentID);
        this.contentDayTypeService.delete(param);
    }
}
