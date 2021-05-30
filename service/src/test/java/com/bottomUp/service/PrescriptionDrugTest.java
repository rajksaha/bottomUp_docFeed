package com.bottomUp.service;

import com.bottomUp.BaseTest;
import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.AmazonS3BucketService;
import com.bottomUp.domain.ContentAdviceData;
import com.bottomUp.domain.ContentDiseaseData;
import com.bottomUp.domain.PrescriptionDrugData;
import com.bottomUp.domain.migration.DumpPatientDetail;
import com.bottomUp.service.docFeed.OldPrescriptionService;
import com.bottomUp.service.docFeed.crud.ContentAdviceService;
import com.bottomUp.service.docFeed.crud.ContentDiseaseService;
import com.bottomUp.service.docFeed.crud.PrescriptionDrugService;
import com.bottomUp.service.migration.ContentMigrationService;
import org.junit.Ignore;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by raj on 2/6/2021.
 */
public class PrescriptionDrugTest extends BaseTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionDrugTest.class);

    private ContentAdviceService contentAdviceService = (ContentAdviceService) applicationContext.getBean("contentAdviceService");

    private ContentDiseaseService contentDiseaseService = (ContentDiseaseService) applicationContext.getBean("contentDiseaseService");

    private ContentMigrationService contentMigrationService = (ContentMigrationService) applicationContext.getBean("contentMigrationService");


    @Test
    public void selectInsert() throws BottomUpException {
        ContentDiseaseData adviceData = new ContentDiseaseData();
        adviceData.setDiseaseName("UUID TEST 222");
        contentDiseaseService.create(adviceData);
        System.out.println("check");
    }

    @Test
    public void get() throws BottomUpException {
        contentMigrationService.migrateAdvice();
        System.out.println("");
    }
}
