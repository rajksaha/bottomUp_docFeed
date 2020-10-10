package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentDoctorCategoryData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentDoctorCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class ContentDoctorCategoryService {

    @Autowired
    private ContentDoctorCategoryMapper contentDoctorCategoryMapper;

    public void create(ContentDoctorCategoryData data) throws BottomUpException {
        contentDoctorCategoryMapper.create(data);
    }

    public void update(ContentDoctorCategoryData data) throws BottomUpException {
        contentDoctorCategoryMapper.update(data);
    }

    public ContentDoctorCategoryData getByID(Long ID)throws BottomUpException {
        return this.contentDoctorCategoryMapper.getByID(ID);
    }

    public List<ContentDoctorCategoryData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentDoctorCategoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDoctorCategoryMapper.delete(param);
    }
}
