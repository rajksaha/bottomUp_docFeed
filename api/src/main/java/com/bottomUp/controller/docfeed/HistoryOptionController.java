package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.HistoryOptionData;
import com.bottomUp.service.docFeed.crud.HistoryOptionService;
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
@RequestMapping("/historyOption")
public class HistoryOptionController extends BaseController {

    @Autowired
    private HistoryOptionService historyOptionService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<HistoryOptionData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.historyOptionService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{historyID}"}, method = RequestMethod.GET)
    @ResponseBody
    public HistoryOptionData getByID(@PathVariable("historyID") String historyID, HttpServletRequest request) throws BottomUpException {
        return this.historyOptionService.getByID(historyID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody HistoryOptionData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.historyOptionService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody HistoryOptionData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.historyOptionService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{historyID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("historyID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("historyID", appointmentID);
        this.historyOptionService.delete(param);
    }
}
