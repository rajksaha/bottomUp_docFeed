package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentDrugCompanyData;
import com.bottomUp.service.docFeed.crud.ContentDrugCompanyService;
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
@RequestMapping("/contentDrugCompany")
public class ContentDrugCompanyController extends BaseController {

    @Autowired
    private ContentDrugCompanyService contentDrugCompanyService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDrugCompanyData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.contentDrugCompanyService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{drugCompanyID}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentDrugCompanyData getByID(@PathVariable("drugCompanyID") String drugCompanyID, HttpServletRequest request) throws BottomUpException {
        return this.contentDrugCompanyService.getByID(drugCompanyID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentDrugCompanyData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugCompanyService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentDrugCompanyData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugCompanyService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{drugCompanyID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("drugCompanyID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugCompanyID", appointmentID);
        this.contentDrugCompanyService.delete(param);
    }
}
