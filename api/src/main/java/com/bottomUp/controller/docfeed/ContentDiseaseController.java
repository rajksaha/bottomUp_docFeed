package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentDiseaseData;
import com.bottomUp.service.docFeed.crud.ContentDiseaseService;
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
@RequestMapping("/contentDisease")
public class ContentDiseaseController extends BaseController {

    @Autowired
    private ContentDiseaseService contentDiseaseService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDiseaseData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.contentDiseaseService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{diseaseId}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentDiseaseData getByID(@PathVariable("diseaseId") String diseaseId, HttpServletRequest request) throws BottomUpException {
        return this.contentDiseaseService.getByID(diseaseId);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDiseaseService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDiseaseService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{diseaseId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("diseaseId") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("diseaseId", appointmentID);
        this.contentDiseaseService.delete(param);
    }
}
