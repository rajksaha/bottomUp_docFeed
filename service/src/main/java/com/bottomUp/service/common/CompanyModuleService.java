package com.bottomUp.service.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.CompanyModuleData;
import com.bottomUp.myBatis.persistence.CompanyModuleMapper;
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
public class CompanyModuleService {

    /*@Autowired
    private CompanyDefaultSetupService companyDefaultSetupService;*/

    @Autowired
    private CompanyModuleMapper companyModuleMapper;

    public void create(CompanyModuleData data) throws BottomUpException {
        this.companyModuleMapper.create(data);
        //companyDefaultSetupService.createDefaultPermissionAndGroupForModule(data);
    }

    public void update(CompanyModuleData data) throws BottomUpException {
        this.companyModuleMapper.update(data);
    }

    public CompanyModuleData getByID(Integer ID)throws BottomUpException {
        return this.companyModuleMapper.getByID(ID);
    }

    public List<CompanyModuleData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.companyModuleMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.companyModuleMapper.delete(param);
    }
}
