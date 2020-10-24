package com.bottomUp.service.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.CompanyData;
import com.bottomUp.myBatis.persistence.CompanyMapper;
import com.bottomUp.service.CompanyDefaultSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/1/2016.
 */

@Service
@Transactional(rollbackFor = BottomUpException.class)
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyDefaultSetupService companyDefaultSetupService;

    public void create(CompanyData data) throws BottomUpException {
        companyMapper.create(data);
        companyDefaultSetupService.createAdminPermissionForCompany(data);
    }



    public void update(CompanyData data) throws BottomUpException {
        companyMapper.update(data);
    }

    public CompanyData getByID(Long ID)throws BottomUpException {
        return this.companyMapper.getByID(ID);
    }

    public List<CompanyData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.companyMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.companyMapper.delete(param);
    }
}
