package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentDrugData;
import com.bottomUp.domain.ContentDrugGenericData;
import com.bottomUp.domain.common.CompanyData;
import com.bottomUp.service.docFeed.crud.ContentDrugGenericService;
import com.bottomUp.service.docFeed.crud.ContentDrugService;
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
@RequestMapping("/contentDrugGeneric")
public class ContentDrugGenericController extends BaseController {

    @Autowired
    private ContentDrugGenericService contentDrugGenericService;

    @Autowired
    private ContentDrugService contentDrugService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = this.parseParameter(request);
        List<ContentDrugGenericData> dataList = this.contentDrugGenericService.getByParam(params);
        return this.buildResultForGrid(dataList, dataList.size(), params);
    }

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDrugGenericData> getByParam(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<String, Object>();
        return this.contentDrugGenericService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{genericID}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentDrugGenericData getByID(@PathVariable("genericID") String genericID, HttpServletRequest request) throws BottomUpException {
        return this.contentDrugGenericService.getByID(genericID);
    }

    @RequestMapping(value = {"/getCompDrug/{genericID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDrugData> getCompDrug(@PathVariable("genericID") String genericID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("genericID", genericID);
        return this.contentDrugService.getByParam(param);
    }

    @RequestMapping(value = {"/updateGeneric/{drugID}/{genericID}"}, method = RequestMethod.PUT)
    @ResponseBody
    public void updateGeneric(@PathVariable("drugID") String drugID,
                                               @PathVariable("genericID") String genericID,
                                               HttpServletRequest request) throws BottomUpException {
        this.contentDrugService.updateGeneric(drugID, genericID.equals("0")? null: genericID, this.getUserDetail().getUsername());
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentDrugGenericData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugGenericService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentDrugGenericData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugGenericService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{genericID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("genericID") String genericID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("genericID", genericID);
        this.contentDrugGenericService.delete(param);
    }
}
