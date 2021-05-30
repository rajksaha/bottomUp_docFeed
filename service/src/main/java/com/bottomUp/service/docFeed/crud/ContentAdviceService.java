package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentAdviceData;
import com.bottomUp.domain.ContentSymptomData;
import com.bottomUp.myBatis.persistence.ContentAdviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class ContentAdviceService {

    @Autowired
    private ContentAdviceMapper contentAdviceMapper;

    public String getInsert(String adviceName) throws BottomUpException{
        ContentAdviceData adviceData = contentAdviceMapper.getByName(adviceName);
        if(adviceData == null){
            adviceData = new ContentAdviceData();
            adviceData.setAdvice(adviceName);
            contentAdviceMapper.create(adviceData);
        }
        return adviceData.getAdviceID();
    }

    public void create(ContentAdviceData data) throws BottomUpException {
        this.contentAdviceMapper.create(data);
    }

    public void update(ContentAdviceData data) throws BottomUpException {
         this.contentAdviceMapper.update(data);
    }

    public ContentAdviceData getByID(String ID)throws BottomUpException {
        return this.contentAdviceMapper.getByID(ID);
    }

    public List<ContentAdviceData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentAdviceMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentAdviceMapper.delete(param);
    }
}
