package com.bottomUp.service;

import com.bottomUp.BaseTest;
import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.AmazonS3BucketService;
import com.bottomUp.domain.PrescriptionDrugData;
import com.bottomUp.service.docFeed.OldPrescriptionService;
import com.bottomUp.service.docFeed.crud.PrescriptionDrugService;
import org.junit.Ignore;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 2/6/2021.
 */
public class PrescriptionDrugTest extends BaseTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionDrugTest.class);

    private AmazonS3BucketService s3BucketService = new AmazonS3BucketService();


    @Test
    public void selectInsert() throws BottomUpException {
        s3BucketService.deleteFileFromBucket("GROUP_ADVICE\\1\\8513024b-75dc-409e-9b32-5698de9ffac5.jpeg");
        System.out.println("check");
    }
}
