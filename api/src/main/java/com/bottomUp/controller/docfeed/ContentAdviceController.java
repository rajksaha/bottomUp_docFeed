package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentAdviceData;
import com.bottomUp.model.AttachmentData;
import com.bottomUp.service.common.AttachmentService;
import com.bottomUp.service.docFeed.crud.ContentAdviceService;
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
@RequestMapping("/contentAdvice")
public class ContentAdviceController extends BaseController {

    @Autowired
    private ContentAdviceService contentAdviceService;

    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentAdviceData> getAll(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        return this.contentAdviceService.getByParam(params);
    }

    @RequestMapping(value = {"/getGroupAdvice"}, method = RequestMethod.GET)
    @ResponseBody
    public List<AttachmentData> getGroupAdvice(HttpServletRequest request) throws BottomUpException {
        return this.attachmentService.getDoctorGroupAdvice(this.getUserDetail().getDoctorData().getDoctorID());
    }

    @RequestMapping(value = {"/getByID/{adviceId}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentAdviceData getByID(@PathVariable("adviceId") String adviceId, HttpServletRequest request) throws BottomUpException {
        return this.contentAdviceService.getByID(adviceId);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentAdviceService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentAdviceService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{adviceId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("adviceId") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("adviceId", appointmentID);
        this.contentAdviceService.delete(param);
    }
}
