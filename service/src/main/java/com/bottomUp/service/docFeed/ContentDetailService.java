package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.myBatis.persistence.ContentDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class ContentDetailService {

    @Autowired
    private ContentDetailMapper contentDetailMapper;

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

    /*public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDetailMapper.delete(param);
    }*/
}
