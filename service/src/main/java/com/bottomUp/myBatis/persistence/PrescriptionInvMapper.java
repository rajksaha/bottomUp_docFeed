package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionInvData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionInvMapper {

    public PrescriptionInvData create(PrescriptionInvData data) throws BottomUpException;

    public PrescriptionInvData update(PrescriptionInvData data) throws BottomUpException;

    public PrescriptionInvData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionInvData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
