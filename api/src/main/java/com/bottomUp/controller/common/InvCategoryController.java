package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.InvCategoryData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.InvCategoryService;
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
@RequestMapping("/invCategory")
public class InvCategoryController extends BaseController {

    @Autowired
    private InvCategoryService invCategoryService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<InvCategoryData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.invCategoryService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{invCategoryID}"}, method = RequestMethod.GET)
    @ResponseBody
    public InvCategoryData getByID(@PathVariable("invCategoryID") Integer invCategoryID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.invCategoryService.getByID(Long.valueOf(invCategoryID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody InvCategoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data",  this.invCategoryService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody InvCategoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data",  this.invCategoryService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{invCategoryID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("invCategoryID") Integer invCategoryID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("invCategoryID", invCategoryID);
        this.invCategoryService.delete(param);
    }
}
