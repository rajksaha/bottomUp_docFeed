package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentDiseaseData;
import com.bottomUp.domain.ContentSymptomData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentSymptomMapper;
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
public class ContentSymptomService {

    @Autowired
    private ContentSymptomMapper contentSymptomMapper;

    public Long createByName(String symptomName) throws BottomUpException{
        ContentSymptomData symptomData = contentSymptomMapper.getByName(symptomName);
        if(symptomData == null){
            symptomData = new ContentSymptomData();
            symptomData.setSymptomName(symptomName);
            contentSymptomMapper.create(symptomData);
        }
        return symptomData.getSymptomID();
    }

    public void create(ContentSymptomData data) throws BottomUpException {
        contentSymptomMapper.create(data);
    }

    public void update(ContentSymptomData  data) throws BottomUpException {
        contentSymptomMapper.update(data);
    }

    public ContentSymptomData getByID(Long ID)throws BottomUpException {
        return this.contentSymptomMapper.getByID(ID);
    }

    public ContentSymptomData getByName(String symptomName)throws BottomUpException {
        return this.contentSymptomMapper.getByName(symptomName);
    }

    public List<ContentSymptomData > getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentSymptomMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentSymptomMapper.delete(param);
    }
}
