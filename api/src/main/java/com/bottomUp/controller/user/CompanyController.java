package com.bottomUp.controller.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.common.CompanyData;
import com.bottomUp.service.common.CompanyService;
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
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        List<CompanyData> dataList = this.companyService.getByParam(params);

        return this.buildResultForGrid(dataList, dataList.size(), params);
    }

    @RequestMapping(value = {"/getAllCompany"}, method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyData> getAllCompany(HttpServletRequest request) throws BottomUpException {
        return this.companyService.getByParam(null);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody CompanyData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.companyService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody CompanyData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.companyService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{companyID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("companyID") String companyID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("companyID",companyID);
        this.companyService.delete(param);
    }
}
