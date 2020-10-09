package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentAdviceData;
import com.bottomUp.myBatis.persistence.ContentAdviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class ContentAdviceService {

    @Autowired
    private ContentAdviceMapper contentAdviceMapper;

    public ContentAdviceData create(ContentAdviceData data) throws BottomUpException {
        return this.contentAdviceMapper .create(data);
    }

    public ContentAdviceData update(ContentAdviceData data) throws BottomUpException {
        return this.contentAdviceMapper.update(data);
    }

    public ContentAdviceData getByID(Long ID)throws BottomUpException {
        return this.contentAdviceMapper .getByID(ID);
    }

    public List<ContentAdviceData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentAdviceMapper .getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentAdviceMapper .delete(param);
    }
}
