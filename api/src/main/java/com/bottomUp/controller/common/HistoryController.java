package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.HistoryData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.HistoryService;
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
@RequestMapping("/History")
public class HistoryController extends BaseController {

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<HistoryData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.historyService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{historyID}"}, method = RequestMethod.GET)
    @ResponseBody
    public HistoryData getByID(@PathVariable("historyID") Integer historyID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.historyService.getByID(Long.valueOf(historyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody HistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.historyService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody HistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.historyService.create(data));
        return result;
    }

    @RequestMapping(value = "/delete/{historyID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("historyID") Integer historyID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("historyID", historyID);
        this.historyService.delete(param);
    }
}
