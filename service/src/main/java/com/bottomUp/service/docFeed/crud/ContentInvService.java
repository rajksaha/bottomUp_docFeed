package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentInvData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentInvMapper;
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
public class ContentInvService {

    @Autowired
    private ContentInvMapper contentInvMapper;

    public void create(ContentInvData data) throws BottomUpException {
        contentInvMapper.create(data);
    }

    public void update(ContentInvData data) throws BottomUpException {
        contentInvMapper.update(data);
    }

    public ContentInvData getByID(Long ID)throws BottomUpException {
        return this.contentInvMapper.getByID(ID);
    }

    public List<ContentInvData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentInvMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentInvMapper.delete(param);
    }
}
