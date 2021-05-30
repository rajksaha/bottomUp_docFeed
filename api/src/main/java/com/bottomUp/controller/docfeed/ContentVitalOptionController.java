package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.ContentVitalOptionData;
import com.bottomUp.service.docFeed.crud.ContentVitalOptionService;
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
@RequestMapping("/contentVitalOption")
public class ContentVitalOptionController extends BaseController {

    @Autowired
    private ContentVitalOptionService contentVitalOptionService;

    @RequestMapping(value = {"/getByVitalID/{vitalID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentVitalOptionData> getByVitalID(@PathVariable("vitalID") Long vitalID, HttpServletRequest request) throws BottomUpException {
        return this.contentVitalOptionService.getByVitalID(vitalID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ContentVitalOptionData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentVitalOptionService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ContentVitalOptionData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.contentVitalOptionService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{vitalOptionID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("vitalOptionID") String vitalOptionID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("vitalOptionID", vitalOptionID);
        this.contentVitalOptionService.delete(param);
    }
}
