package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentDrugData;
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
@RequestMapping("/contentDrug")
public class ContentDrugController extends BaseController {

    @Autowired
    private ContentDrugService contentDrugService;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = this.parseParameter(request);
        List<ContentDrugData> dataList = this.contentDrugService.getByParam(params);
        return this.buildResultForGrid(dataList, contentDrugService.getCountByParam(params), params);
    }

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDrugData> getByParam(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        return this.contentDrugService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{drugID}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentDrugData getByID(@PathVariable("drugID") String drugID, HttpServletRequest request) throws BottomUpException {
        return this.contentDrugService.getByID(drugID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentDrugData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentDrugData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{drugID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("drugID") String drugID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugID", drugID);
        this.contentDrugService.delete(param);
    }
}
