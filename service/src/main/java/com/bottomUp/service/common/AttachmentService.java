package com.bottomUp.service.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.InvReportDateData;
import com.bottomUp.model.AttachmentData;
import com.bottomUp.myBatis.persistence.AttachmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by raj on 02/12/21.
 */
@Service
@Transactional(rollbackFor = BottomUpException.class)
public class AttachmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttachmentService.class);

    @Autowired
    private AttachmentMapper attachmentMapper;

    public List<InvReportDateData> getInvReportDetail(Long patientID) throws BottomUpException{
        List<InvReportDateData> reportList = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("entityType", "INV_REPORT");
        params.put("entityID", patientID);
        List<AttachmentData> attachmentList = attachmentMapper.getAll(params);
        Map<Date, List<AttachmentData>> resultParam = new HashMap<>();
        for(AttachmentData attachment: attachmentList){
            List<AttachmentData> innerList = resultParam.get(attachment.getEntityDate());
            if(innerList == null){
                innerList = new ArrayList<>();
            }
            innerList.add(attachment);
            resultParam.put(attachment.getEntityDate(), innerList);
        }

        for (Map.Entry<Date, List<AttachmentData>> entry : resultParam.entrySet()) {
            InvReportDateData data = new InvReportDateData();
            data.setReportDate(entry.getKey());
            data.setReportList(entry.getValue());
            reportList.add(data);
        }

        return reportList;
    }

    public List<AttachmentData> getDoctorGroupAdvice(String doctorID) throws BottomUpException{
        Map<String, Object> params = new HashMap<>();
        params.put("entityType", "GROUP_ADVICE");
        params.put("entityID", doctorID);
        return attachmentMapper.getAll(params);
    }


    public void create(AttachmentData attachment) throws BottomUpException {
        this.attachmentMapper.create(attachment);
    }

    public void delete(String attachmentId) throws BottomUpException {
        this.attachmentMapper.delete(attachmentId);
    }

    public AttachmentData getByID(String attachmentId) throws BottomUpException {
        return this.attachmentMapper.getByID(attachmentId);
    }

    public List<AttachmentData> getAll(Map<String, Object> params) throws BottomUpException {
        return this.attachmentMapper.getAll(params);
    }

    public List<AttachmentData> getPrescribedAttachment(Map<String, Object> params) throws BottomUpException{
        return this.attachmentMapper.getPrescribedAttachment(params);
    }

    public void update(AttachmentData attachment)  throws BottomUpException {
        this.attachmentMapper.update(attachment);
    }
}
