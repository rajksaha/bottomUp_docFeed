package com.bottomUp.common;

import com.bottomUp.BaseTest;
import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.service.common.CompanyService;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by raj on 7/25/2020.
 */
public class CompanyTester extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(CompanyTester.class);

    @Test
    public void TestCompanyInsert()throws BottomUpException {

        try {
            CompanyService companyService = new CompanyService();
            companyService.create(null);
        }catch (Exception e){
            logger.info(e.getMessage());
        }



    }
}
