package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentDrugAdviceData;
import com.bottomUp.service.docFeed.crud.ContentDrugAdviceService;
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
@RequestMapping("/contentDrugAdvice")
public class ContentDrugAdviceController extends BaseController {

    @Autowired
    private ContentDrugAdviceService contentDrugAdviceService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDrugAdviceData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.contentDrugAdviceService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{drugAdviceID}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentDrugAdviceData getByID(@PathVariable("drugAdviceID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.contentDrugAdviceService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentDrugAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugAdviceService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentDrugAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugAdviceService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{drugAdviceID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("drugAdviceID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugAdviceID", appointmentID);
        this.contentDrugAdviceService.delete(param);
    }
}
