package com.bottomUp.myBatis.persistence;



import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.domain.common.user.UserData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 4/29/2016.
 */
public interface ContentDetailMapper {


    public void create(ContentDetailData data) throws BottomUpException;

    public void selectInsert(Map<String, Object> param) throws BottomUpException;

    public void update(ContentDetailData data) throws BottomUpException;

    public ContentDetailData getByID(String userProfileID) throws BottomUpException;

    public List<ContentDetailData> getByParam(Map<String, Object> param) throws BottomUpException;

    public List<ContentDetailData> getDistinctShortName(Map<String, Object> param) throws BottomUpException;

    public List<ContentDetailData> getChildContentInfo(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;

    public List<UserData> getDuplicateApprover(Map<String, Object> param) throws BottomUpException;
}
