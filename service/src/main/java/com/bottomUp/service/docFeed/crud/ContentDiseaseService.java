package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentDiseaseData;
import com.bottomUp.domain.ContentSymptomData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentDiseaseMapper;
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
public class ContentDiseaseService {

    @Autowired
    private ContentDiseaseMapper contentDiseaseMapper;

    public Long getInsert(String diseaseName) throws BottomUpException{

        ContentDiseaseData diseaseData = contentDiseaseMapper.getByName(diseaseName);
        if(diseaseData == null){
            diseaseData = new ContentDiseaseData();
            diseaseData.setDiseaseName(diseaseName);
            contentDiseaseMapper.create(diseaseData);
        }
        return diseaseData.getDiseaseID();
    }

    public void create(ContentDiseaseData data) throws BottomUpException {
        contentDiseaseMapper.create(data);
    }

    public void update(ContentDiseaseData data) throws BottomUpException {
        contentDiseaseMapper.update(data);
    }

    public ContentDiseaseData getByID(Long ID)throws BottomUpException {
        return this.contentDiseaseMapper.getByID(ID);
    }

    public ContentDiseaseData getByName(String name)throws BottomUpException {
        return this.contentDiseaseMapper.getByName(name);
    }

    public List<ContentDiseaseData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentDiseaseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDiseaseMapper.delete(param);
    }
}
