package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.*;
import com.bottomUp.domain.migration.*;
import com.bottomUp.service.docFeed.crud.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by raj on 5/22/2021.
 */
@Service
@Transactional(rollbackFor = BottomUpException.class)
public class ContentMigrationService {

    @Autowired
    private ContentAdviceService contentAdviceService;
    @Autowired
    private DumpAdviceService dumpAdviceService;
    @Autowired
    private ContentSymptomService contentSymptomService;
    @Autowired
    private DumpSymptomService dumpSymptomService;
    @Autowired
    private ContentDiseaseService contentDiseaseService;
    @Autowired
    private DumpDiseaseService dumpDiseaseService;
    @Autowired
    private ContentDrugService contentDrugService;
    @Autowired
    private DumpDrugService dumpDrugService;
    @Autowired
    private ContentInvService contentInvService;
    @Autowired
    private DumpInvService dumpInvService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private DumpHistoryService dumpHistoryService;
    @Autowired
    private HistoryOptionService historyOptionService;
    @Autowired
    private DumpHistoryOptionService dumpHistoryOptionService;

    public void migrateAdvice() throws BottomUpException{
        Map<String, Object> param = new HashMap<String, Object>();
        List<ContentAdviceData> adviceDataList = contentAdviceService.getByParam(param);

        Map<String, ContentAdviceData> currMap = adviceDataList.stream().collect(
                Collectors.toMap(x -> x.getAdvice(), x -> x));

        List<DumpAdvice> oldAdviceData = dumpAdviceService.getByParam(param);

        for(DumpAdvice advice: oldAdviceData){
            if(currMap.get(advice.getAdvice()) == null){
                ContentAdviceData adviceData = new ContentAdviceData();
                adviceData.setLang(advice.getLang());
                adviceData.setType(advice.getType());
                adviceData.setAdvice(advice.getAdvice());
                adviceData.setPdf(advice.getAdvice());
                contentAdviceService.create(adviceData);
            }
        }

    }

    public void migrateSymptom() throws BottomUpException{
        Map<String, Object> param = new HashMap<String, Object>();
        List<ContentSymptomData> symptomDataList = contentSymptomService.getByParam(param);

        Map<String, ContentSymptomData> currMap = symptomDataList.stream().collect(
                Collectors.toMap(x -> x.getSymptomName(), x -> x));

        List<DumpSymptom> symptomList = dumpSymptomService.getByParam(param);

        for(DumpSymptom data: symptomList){
            if(currMap.get(data.getName()) == null){
                ContentSymptomData tempData = new ContentSymptomData();
                tempData.setSymptomName(data.getName());
                contentSymptomService.create(tempData);
            }
        }

    }

    public void migrateDisease() throws BottomUpException{
        Map<String, Object> param = new HashMap<String, Object>();
        List<ContentDiseaseData> diseaseDataList = contentDiseaseService.getByParam(param);

        Map<String, ContentDiseaseData> currMap = diseaseDataList.stream().collect(
                Collectors.toMap(x -> x.getDiseaseName(), x -> x));

        List<DumpDisease> diseaseList = dumpDiseaseService.getByParam(param);

        for(DumpDisease data: diseaseList){
            if(currMap.get(data.getName()) == null){
                ContentDiseaseData tempData = new ContentDiseaseData();
                tempData.setDiseaseName(data.getName());
                contentDiseaseService.create(tempData);
            }
        }

    }

    public void migrateInv() throws BottomUpException{
        Map<String, Object> param = new HashMap<String, Object>();
        List<ContentInvData> invDataList = contentInvService.getByParam(param);

        Map<String, ContentInvData> currMap = invDataList.stream().collect(
                Collectors.toMap(x -> x.getName(), x -> x));

        List<DumpInv> dumpInvList = dumpInvService.getByParam(param);

        for(DumpInv data: dumpInvList){
            if(currMap.get(data.getName()) == null){
                ContentInvData tempData = new ContentInvData();
                tempData.setName(data.getName());
                //tempData.setCategoryID(data.getCategoryID());
                contentInvService.create(tempData);
            }
        }

    }

    public void migrateHistory() throws BottomUpException{
        Map<String, Object> param = new HashMap<String, Object>();
        List<HistoryData> historyDataList = historyService.getByParam(param);
        List<HistoryOptionData> historyOptionDataList = historyOptionService.getByParam(param);
        List<DumpHistory> dumpHistoryList = dumpHistoryService.getByParam(param);
        List<DumpHistoryOption> dumpHistoryOptionList = dumpHistoryOptionService.getByParam(param);

        for(DumpHistory data: dumpHistoryList){
            List<HistoryData> tempList = historyDataList.stream()
                    .filter(item -> item.getTypeCode().equals(data.getTypeCode())
                            && item.getName().equals(data.getName()))
                    .collect(Collectors.toList());

            if(tempList == null || tempList.size() == 0){
                HistoryData tempData = new HistoryData();
                tempData.setTypeCode(data.getTypeCode());
                tempData.setName(data.getName());
                tempData.setShortName(data.getShortName());
                historyService.create(tempData);
            }
        }

    }

    public void migrateDrug() throws BottomUpException{
        Map<String, Object> param = new HashMap<String, Object>();
        List<ContentDrugData> drugDataList = contentDrugService.getByParam(param);
        List<DumpDrug> dumpDrugList = dumpDrugService.getByParam(param);

        for(DumpDrug data: dumpDrugList){

            List<ContentDrugData> tempList = drugDataList.stream()
                    .filter(item -> item.getDrugName().equals(data.getDrugName())
                            && item.getTypeID().equals(data.getTypeID())
                            && item.getStrength().equals(data.getStrength()))
                    .collect(Collectors.toList());

            if(tempList == null || tempList.size() == 0){
                ContentDrugData temp = new ContentDrugData();
                temp.setDrugName(data.getDrugName());
                temp.setStrength(data.getStrength());
                temp.setTypeID(data.getTypeID());
                //temp.setCompanyID(data.getCompanyID());
                contentDrugService.create(temp);
            }
        }

    }




}
