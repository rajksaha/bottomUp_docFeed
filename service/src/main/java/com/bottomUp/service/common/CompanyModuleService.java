package com.bottomUp.service.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.CompanyModuleData;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.domain.common.user.PermissionData;
import com.bottomUp.myBatis.persistence.CompanyModuleMapper;
import com.bottomUp.myBatis.persistence.ContentDetailMapper;
import com.bottomUp.myBatis.persistence.PermissionMapper;
import com.bottomUp.service.CompanyDefaultSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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

    @Autowired
    private ContentDetailMapper contentDetailMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    private void createPermissionForModule(String moduleID, String companyModuleID) throws BottomUpException{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("entityID", moduleID);
        params.put("entityType", "MODULE_PERMISSION");
        List<ContentDetailData> detailDataList = contentDetailMapper.getByParam(params);

        for(ContentDetailData content : detailDataList){
            PermissionData permissionData = new PermissionData();
            permissionData.setCompanyModuleID(companyModuleID);
            permissionData.setFunctionCode(content.getShortName());
            permissionData.setShortName(content.getLongDesc());
            permissionMapper.create(permissionData);
        }
    }

    public void create(CompanyModuleData data) throws BottomUpException {
        this.companyModuleMapper.create(data);
        this.createPermissionForModule(data.getModuleID(), data.getCompanyModuleID());
    }

    public void update(CompanyModuleData data) throws BottomUpException {
        this.companyModuleMapper.update(data);
    }

    public CompanyModuleData getByID(String ID)throws BottomUpException {
        return this.companyModuleMapper.getByID(ID);
    }

    public List<CompanyModuleData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.companyModuleMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.companyModuleMapper.delete(param);
    }
}
