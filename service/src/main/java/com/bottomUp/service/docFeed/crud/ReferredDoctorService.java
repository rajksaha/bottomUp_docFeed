package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ReferredDoctorData;
import com.bottomUp.myBatis.persistence.ReferredDoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class ReferredDoctorService {

    @Autowired
    private ReferredDoctorMapper referredDoctorMapper;

    public Long createByName(String docName, String address) throws BottomUpException{
        ReferredDoctorData refDoc = null;
        Map<String, Object> param = new HashMap<>();
        param.put("doctorName", docName);
        List<ReferredDoctorData> refDocList = referredDoctorMapper.getByParam(param);
        if(refDocList != null && refDocList.size() > 0){
            refDoc = refDocList.get(0);
            if(!refDoc.getDoctorAddress().equals(address)){
                refDoc.setDoctorAddress(address);
                referredDoctorMapper.update(refDoc);
            }
        }else{
            refDoc = new ReferredDoctorData();
            refDoc.setDoctorName(docName);
            refDoc.setDoctorAddress(address);
            referredDoctorMapper.create(refDoc);
        }
        return refDoc.getReferredDoctorID();
    }

    public void create(ReferredDoctorData data) throws BottomUpException {
        referredDoctorMapper.create(data);
    }

    public void update(ReferredDoctorData data) throws BottomUpException {
        referredDoctorMapper.update(data);
    }

    public ReferredDoctorData getByID(Long ID)throws BottomUpException {
        return this.referredDoctorMapper.getByID(ID);
    }

    public List<ReferredDoctorData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.referredDoctorMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.referredDoctorMapper.delete(param);
    }
}
