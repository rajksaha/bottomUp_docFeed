package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.domain.PresNoteData;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.model.DietData;
import com.bottomUp.model.DrugHistory;
import com.bottomUp.myBatis.persistence.ContentDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utility.type.PrescriptionContentType;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void saveNote(SearchData searchData) throws BottomUpException{
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("entityType", PrescriptionContentType.NOTE.toString());
        param.put("entityID", searchData.getAppointmentID());
        contentDetailMapper.delete(param);
        for(PresNoteData note: searchData.getPresNoteList()){
            for (String text : note.getNoteList()){
                ContentDetailData detailData = new ContentDetailData();
                detailData.setEntityType(PrescriptionContentType.NOTE.toString());
                detailData.setEntityID(searchData.getAppointmentID());
                detailData.setShortName(note.getHeader());
                detailData.setLongDesc(text);
                contentDetailMapper.create(detailData);
            }
        }
    }

    public void addAdvTemplateInPres(ContentDetailData contentDetailData) throws BottomUpException{
        contentDetailData.setEntityType(PrescriptionContentType.GROUP_ADVICE.name());
        this.contentDetailMapper.create(contentDetailData);
    }

    public String createByDrugHistory(DrugHistory drugHistory) throws BottomUpException{
        ContentDetailData contentDetailData = new ContentDetailData();
        if(drugHistory.getCurrentStatus() == 1){
            contentDetailData.setEntityType(PrescriptionContentType.CURRENT_DRUG.name());
        }else{
            contentDetailData.setEntityType(PrescriptionContentType.OLD_DRUG.name());
        }
        contentDetailData.setEntityID(drugHistory.getAppointmentID());
        contentDetailData.setShortName(drugHistory.getDrugName());
        if(drugHistory.getDrugHistoryID() == null){
            contentDetailMapper.create(contentDetailData);
        }else{
            contentDetailData.setContentDetailID(drugHistory.getDrugHistoryID());
            contentDetailMapper.update(contentDetailData);
        }
        return contentDetailData.getContentDetailID();
    }

    public String addFollowUpToPres(ContentDetailData detailData) throws BottomUpException{
        detailData.setEntityType(PrescriptionContentType.FOLLOW_UP.name());
        contentDetailMapper.create(detailData);
        return detailData.getContentDetailID();
    }

    public void create(ContentDetailData data) throws BottomUpException {
        this.contentDetailMapper.create(data);
    }

    public void update(ContentDetailData data) throws BottomUpException {
        this.contentDetailMapper.update(data);
    }

    public ContentDetailData getByID(String ID)throws BottomUpException {
        return this.contentDetailMapper.getByID(ID);
    }

    public List<ContentDetailData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this .contentDetailMapper.getByParam(param);
    }

    public List<ContentDetailData> getDistinctShortName(Map<String, Object> param) throws BottomUpException {
        return this .contentDetailMapper.getDistinctShortName(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDetailMapper.delete(param);
    }
}
