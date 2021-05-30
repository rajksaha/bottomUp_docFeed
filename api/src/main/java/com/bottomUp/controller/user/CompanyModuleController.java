package com.bottomUp.controller.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.common.CompanyModuleData;
import com.bottomUp.service.common.CompanyModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/1/2016.
 */
@Controller
@RequestMapping("/companyModule")
public class CompanyModuleController extends BaseController {

    @Autowired
    private CompanyModuleService companyModuleService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        List<CompanyModuleData> dataList = this.companyModuleService.getByParam(params);

        return this.buildResultForGrid(dataList, dataList.size(), params);
    }


    @RequestMapping(value = {"/getAllCompanyModule"}, method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyModuleData> getAllCompany(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("companyID", this.getUserDetail().getUserProfilePermissionData().getCompanyID());
        return this.companyModuleService.getByParam(params);
    }


    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody CompanyModuleData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.companyModuleService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody CompanyModuleData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.companyModuleService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{companyModuleID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("companyModuleID") String companyModuleID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("companyModuleID",companyModuleID);
        this.companyModuleService.delete(param);
    }
}
