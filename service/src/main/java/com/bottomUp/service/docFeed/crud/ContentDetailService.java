package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.model.DietData;
import com.bottomUp.myBatis.persistence.ContentDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utility.type.PrescriptionContentType;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class ContentDetailService {

    @Autowired
    private ContentDetailMapper contentDetailMapper;

    public void createByDietData(DietData dietData) throws BottomUpException{
        ContentDetailData contentDetailData = new ContentDetailData();
        contentDetailData.setEntityType(PrescriptionContentType.DIET.name());
        contentDetailData.setEntityID(dietData.getAppointmentID());
        contentDetailData.setShortName(dietData.getDietName());
        if(dietData.getDietID() == null){
            contentDetailMapper.create(contentDetailData);
        }else{
            contentDetailData.setContentDetailID(dietData.getDietID());
            contentDetailMapper.update(contentDetailData);
        }

    }

    public void create(ContentDetailData data) throws BottomUpException {
        this.contentDetailMapper.create(data);
    }

    public void update(ContentDetailData data) throws BottomUpException {
        this.contentDetailMapper.update(data);
    }

    public ContentDetailData getByID(Long ID)throws BottomUpException {
        return this.contentDetailMapper.getByID(ID);
    }

    public List<ContentDetailData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this .contentDetailMapper.getByParam(param);
    }

    public List<ContentDetailData> getDistinctShortName(Map<String, Object> param) throws BottomUpException {
        return this .contentDetailMapper.getDistinctShortName(param);
    }

    /*public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDetailMapper.delete(param);
    }*/
}
