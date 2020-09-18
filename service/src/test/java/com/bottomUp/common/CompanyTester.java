package com.bottomUp.common;

import com.bottomUp.BaseTest;
import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.CompanyData;
import com.bottomUp.service.common.CompanyService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by raj on 7/25/2020.
 */
@Controller
public class CompanyTester extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(CompanyTester.class);

    private CompanyService companyService = (CompanyService) applicationContext.getBean("companyService");

    @Test
    public void TestCompanyInsert()throws BottomUpException {

        try {
            CompanyData companyData = new CompanyData();
            companyData.setCompanyName("Bottom Up");
            companyData.setCompanyCode("bottomUp");
            companyService.create(companyData);

        }catch (Exception e){
            logger.info(e.getMessage());
        }



    }
}
