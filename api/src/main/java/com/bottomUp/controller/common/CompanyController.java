package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.common.CompanyData;
import com.bottomUp.service.common.CompanyService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 7/25/2020.
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;


    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashedMap();

        List<CompanyData> companyDataList = companyService.getByParam(params);
        return companyDataList;
    }


}
