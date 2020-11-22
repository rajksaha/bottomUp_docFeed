package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.domain.*;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.model.PatientViewData;
import com.bottomUp.service.docFeed.crud.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utility.type.PrescriptionContentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 10/20/2020.
 */
@Controller
@RequestMapping("/autoComplete")
public class AutoCompleteController extends BaseController{


    @Autowired
    private ContentAdviceService contentAdviceService;

    @Autowired
    private ContentSymptomService contentSymptomService;

    @Autowired
    private ContentDiseaseService contentDiseaseService;

    @Autowired
    private ContentDrugService contentDrugService;

    @Autowired
    private ContentInvService contentInvService;

    @Autowired
    private InvCategoryService invCategoryService;

    @Autowired
    private ContentVitalService contentVitalService;

    @Autowired
    private ContentVitalOptionService contentVitalOptionService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private HistoryOptionService historyOptionService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientTypeService patientTypeService;

    @Autowired
    private ContentDetailService contentDetailService;

    @RequestMapping(value = {"/advice"}, method = RequestMethod.POST)
    @ResponseBody
    public List<ContentAdviceData> advice(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        param.put("lang", searchData.getIntLang());
        param.put("type", searchData.getIntType());
        return contentAdviceService.getByParam(param);
    }

    @RequestMapping(value = {"/complain"}, method = RequestMethod.POST)
    @ResponseBody
    public List<ContentSymptomData> complain(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        return contentSymptomService.getByParam(param);
    }

    @RequestMapping(value = {"/inv"}, method = RequestMethod.POST)
    @ResponseBody
    public List<ContentInvData> inv(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        return contentInvService.getByParam(param);
    }

    @RequestMapping(value = {"/invCategory"}, method = RequestMethod.POST)
    @ResponseBody
    public List<InvCategoryData> invCategory(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        return invCategoryService.getByParam(param);
    }

    @RequestMapping(value = {"/disease"}, method = RequestMethod.POST)
    @ResponseBody
    public List<ContentDiseaseData> disease(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        return contentDiseaseService.getByParam(param);
    }

    @RequestMapping(value = {"/drug"}, method = RequestMethod.POST)
    @ResponseBody
    public List<ContentDrugData> drug(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        param.put("typeID", searchData.getIntType());
        return contentDrugService.getByParam(param);
    }

    @RequestMapping(value = {"/vital"}, method = RequestMethod.POST)
    @ResponseBody
    public List<ContentVitalData> vital(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        return contentVitalService.getByParam(param);
    }

    @RequestMapping(value = {"/vitalOption"}, method = RequestMethod.POST)
    @ResponseBody
    public List<ContentVitalOptionData> vitalOption(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        param.put("vitalID", searchData.getEntityID());
        return contentVitalOptionService.getByParam(param);
    }

    @RequestMapping(value = {"/history"}, method = RequestMethod.POST)
    @ResponseBody
    public List<HistoryData> history(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        return historyService.getByParam(param);
    }

    @RequestMapping(value = {"/historyOption"}, method = RequestMethod.POST)
    @ResponseBody
    public List<HistoryOptionData> historyOption(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        return historyOptionService.getByParam(param);
    }

    @RequestMapping(value = {"/patientSearch"}, method = RequestMethod.POST)
    @ResponseBody
    public List<PatientViewData> patientSearch(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put(searchData.getEntityType(), searchData.getTerm());
        param.put("term", searchData.getTerm());
        return patientService.patientSearch(param);
    }

    @RequestMapping(value = {"/patientType"}, method = RequestMethod.POST)
    @ResponseBody
    public List<PatientTypeData> patientType(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        return patientTypeService.getByParam(param);
    }

    @RequestMapping(value = {"/dietSearch"}, method = RequestMethod.POST)
    @ResponseBody
    public List<ContentDetailData> dietSearch(@RequestBody SearchData searchData) throws BottomUpException {
        Map<String, Object> param = new HashMap<>();
        param.put("term", searchData.getTerm());
        param.put("entityType", PrescriptionContentType.DIET);
        return contentDetailService.getDistinctShortName(param);
    }
}
