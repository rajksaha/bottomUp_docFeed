package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.model.AttachmentData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 02/12/21.
 */
@Repository
public interface AttachmentMapper {

    void create(AttachmentData attachment) throws BottomUpException;

    void delete(String attachmentId) throws BottomUpException;

    AttachmentData getByID(String attachmentId) throws BottomUpException;

    List<AttachmentData> getAll(Map<String, Object> params) throws BottomUpException;

    List<AttachmentData> getPrescribedAttachment(Map<String, Object> params) throws BottomUpException;

    void update(AttachmentData attachment) throws BottomUpException;
}
