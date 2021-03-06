package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentDrugTypeData;
import com.bottomUp.service.docFeed.crud.ContentDrugTypeService;
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
@RequestMapping("/contentDrugType")
public class ContentDrugTypeController extends BaseController {

    @Autowired
    private ContentDrugTypeService contentDrugTypeService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDrugTypeData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.contentDrugTypeService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{drugTypeID}"}, method = RequestMethod.GET)
    @ResponseBody
    public ContentDrugTypeData getByID(@PathVariable("drugTypeID") String drugTypeID, HttpServletRequest request) throws BottomUpException {
        return this.contentDrugTypeService.getByID(drugTypeID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentDrugTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugTypeService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentDrugTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentDrugTypeService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{drugTypeID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("drugTypeID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugTypeID", appointmentID);
        this.contentDrugTypeService.delete(param);
    }
}
