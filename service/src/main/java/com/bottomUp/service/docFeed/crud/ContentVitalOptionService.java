package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentVitalOptionData;
import com.bottomUp.myBatis.persistence.ContentVitalOptionMapper;
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
public class ContentVitalOptionService {

    @Autowired
    private ContentVitalOptionMapper contentVitalOptionMapper;

    public void create(ContentVitalOptionData data) throws BottomUpException {
        contentVitalOptionMapper.create(data);
    }

    public void update(ContentVitalOptionData data) throws BottomUpException {
        contentVitalOptionMapper.update(data);
    }

    public ContentVitalOptionData getByID(String ID)throws BottomUpException {
        return this.contentVitalOptionMapper.getByID(ID);
    }

    public List<ContentVitalOptionData> getByVitalID(Long ID)throws BottomUpException {
        return this.contentVitalOptionMapper.getByVitalID(ID);
    }

    public List<ContentVitalOptionData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentVitalOptionMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentVitalOptionMapper.delete(param);
    }
}
