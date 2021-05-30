package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentVitalData;
import com.bottomUp.domain.DoctorVitalSettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentVitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class ContentVitalService {

    @Autowired
    private ContentVitalMapper contentVitalMapper;

    public String getInsert(DoctorVitalSettingData settingData) throws BottomUpException{
        ContentVitalData contentVitalData = contentVitalMapper.getByName(settingData.getVitalName());
        if(contentVitalData == null){
            contentVitalData = new ContentVitalData();
            contentVitalData.setVitalName(settingData.getVitalName());
            contentVitalData.setShortName(settingData.getShortName());
            contentVitalData.setVitalUnit(settingData.getVitalUnit());
            contentVitalMapper.create(contentVitalData);
        }
        return contentVitalData.getVitalID();
    }

    public void create(ContentVitalData data) throws BottomUpException {
        contentVitalMapper.create(data);
    }

    public void update(ContentVitalData  data) throws BottomUpException {
        contentVitalMapper.update(data);
    }

    public ContentVitalData  getByID(String ID)throws BottomUpException {
        return this.contentVitalMapper.getByID(ID);
    }

    public ContentVitalData  getByName(String name)throws BottomUpException {
        return this.contentVitalMapper.getByName(name);
    }

    public List<ContentVitalData > getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentVitalMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentVitalMapper.delete(param);
    }
}
