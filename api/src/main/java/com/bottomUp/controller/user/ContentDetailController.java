package com.bottomUp.controller.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.model.DrugHistory;
import com.bottomUp.service.docFeed.crud.ContentDetailService;
import org.apache.poi.ss.usermodel.ConditionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utility.type.PrescriptionContentType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 11/22/2020.
 */
@Controller
@RequestMapping("/contentDetail")
public class ContentDetailController extends BaseController{

    @Autowired
    private ContentDetailService contentDetailService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getAll(HttpServletRequest request) throws BottomUpException {
        return this.contentDetailService.getByParam(null);
    }

    @RequestMapping(value = {"/getByParam/{entityType}/{entityID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getByParam(@PathVariable("entityType") String entityType, @PathVariable("entityID") Long entityID) throws BottomUpException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("entityType", entityType);
        params.put("entityID", entityID);
        return this.contentDetailService.getByParam(params);
    }

    @RequestMapping(value = {"/saveDrugHistory"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveDrugHistory(@RequestBody DrugHistory data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("contentDetailID", this.contentDetailService.createByDrugHistory(data));
        return result;
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentDetailData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        this.contentDetailService.create(data);
        result.put("contentDetailID", data.getContentDetailID());
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentDetailData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDetailService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{contentDetailID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("contentDetailID") Long contentDetailID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("contentDetailID",contentDetailID);
        this.contentDetailService.delete(param);
    }
}
