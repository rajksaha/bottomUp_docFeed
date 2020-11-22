package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.service.docFeed.crud.PrescriptionAdviceService;
import com.bottomUp.service.docFeed.crud.PrescriptionComplainService;
import com.bottomUp.service.docFeed.crud.PrescriptionInvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raj on 11/13/2020.
 */
@Controller
@RequestMapping("/prescriptionDelete")
public class PrescriptionDeleteController extends BaseController{

    @Autowired
    private PrescriptionAdviceService prescriptionAdviceService;

    @Autowired
    private PrescriptionComplainService prescriptionComplainService;

    @Autowired
    private PrescriptionInvService prescriptionInvService;

    @RequestMapping(value = "/prescribedAdvice/{prescriptionAdviceID}", method = RequestMethod.DELETE)
    public void prescribedAdvice(@PathVariable("prescriptionAdviceID") Integer prescriptionAdviceID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("presAdviceID", prescriptionAdviceID);
        this.prescriptionAdviceService.delete(param);
    }

    @RequestMapping(value = "/prescribedComplain/{complainID}", method = RequestMethod.DELETE)
    public void prescribedComplain(@PathVariable("complainID") Integer complainID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("complainID", complainID);
        this.prescriptionComplainService.delete(param);
    }
}
