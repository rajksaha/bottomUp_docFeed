package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentRelationData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class ContentRelationService {

    @Autowired
    private ContentRelationMapper contentRelationMapper;

    public ContentRelationData create(ContentRelationData data) throws BottomUpException {
        return this.contentRelationMapper.create(data);
    }

    public ContentRelationData update(ContentRelationData data) throws BottomUpException {
        return this.contentRelationMapper.update(data);
    }

    public ContentRelationData getByID(Long ID)throws BottomUpException {
        return this.contentRelationMapper.getByID(ID);
    }

    public List<ContentRelationData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentRelationMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentRelationMapper.delete(param);
    }
}
