package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentDrugData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentDrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class ContentDrugService {

    @Autowired
    private ContentDrugMapper contentDrugMapper;

    public ContentDrugData create(ContentDrugData data) throws BottomUpException {
        return this.contentDrugMapper.create(data);
    }

    public ContentDrugData update(ContentDrugData data) throws BottomUpException {
        return this.contentDrugMapper.update(data);
    }

    public ContentDrugData getByID(Long ID)throws BottomUpException {
        return this.contentDrugMapper.getByID(ID);
    }

    public List<ContentDrugData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentDrugMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDrugMapper.delete(param);
    }
}
