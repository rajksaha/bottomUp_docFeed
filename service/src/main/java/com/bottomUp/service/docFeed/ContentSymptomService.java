package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentSymptomData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentSymptomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class ContentSymptomService {

    @Autowired
    private ContentSymptomMapper contentSymptomMapper;

    public ContentSymptomData create(ContentSymptomData data) throws BottomUpException {
        return this.contentSymptomMapper.create(data);
    }

    public ContentSymptomData update(ContentSymptomData  data) throws BottomUpException {
        return this.contentSymptomMapper.update(data);
    }

    public ContentSymptomData  getByID(Long ID)throws BottomUpException {
        return this.contentSymptomMapper.getByID(ID);
    }

    public List<ContentSymptomData > getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentSymptomMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentSymptomMapper.delete(param);
    }
}
