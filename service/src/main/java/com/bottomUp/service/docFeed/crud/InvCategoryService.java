package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.InvCategoryData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.InvCategoryMapper;
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
public class InvCategoryService {

    @Autowired
    private InvCategoryMapper invCategoryMapper;

    public void create(InvCategoryData data) throws BottomUpException {
        invCategoryMapper.create(data);
    }

    public void update(InvCategoryData data) throws BottomUpException {
        invCategoryMapper.update(data);
    }

    public InvCategoryData getByID(String ID)throws BottomUpException {
        return this.invCategoryMapper.getByID(ID);
    }

    public List<InvCategoryData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.invCategoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.invCategoryMapper.delete(param);
    }
}
