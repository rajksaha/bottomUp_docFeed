package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentDrugCompanyData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentDrugCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class ContentDrugCompanyService {

    @Autowired
    private ContentDrugCompanyMapper contentDrugCompanyMapper;

    public ContentDrugCompanyData create(ContentDrugCompanyData data) throws BottomUpException {
        return this.contentDrugCompanyMapper.create(data);
    }

    public ContentDrugCompanyData update(ContentDrugCompanyData  data) throws BottomUpException {
        return this.contentDrugCompanyMapper.update(data);
    }

    public ContentDrugCompanyData  getByID(Long ID)throws BottomUpException {
        return this.contentDrugCompanyMapper.getByID(ID);
    }

    public List<ContentDrugCompanyData > getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentDrugCompanyMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDrugCompanyMapper.delete(param);
    }
}
