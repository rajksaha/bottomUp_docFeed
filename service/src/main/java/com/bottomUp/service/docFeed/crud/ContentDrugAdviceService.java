package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentDrugAdviceData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentDrugAdviceMapper;
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
public class ContentDrugAdviceService {

    @Autowired
    private ContentDrugAdviceMapper contentDrugAdviceMapper;

    public void create(ContentDrugAdviceData data) throws BottomUpException {
        contentDrugAdviceMapper.create(data);
    }

    public void update(ContentDrugAdviceData data) throws BottomUpException {
        contentDrugAdviceMapper.update(data);
    }

    public ContentDrugAdviceData getByID(Long ID)throws BottomUpException {
        return this.contentDrugAdviceMapper.getByID(ID);
    }

    public List<ContentDrugAdviceData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentDrugAdviceMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDrugAdviceMapper.delete(param);
    }
}
