package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.PatientDrugHistoryData;


import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientDrugHistoryMapper {

    public void create(PatientDrugHistoryData data) throws BottomUpException;

    public void update(PatientDrugHistoryData data) throws BottomUpException;

    public PatientDrugHistoryData getByID(String ID) throws BottomUpException;

    public List<PatientDrugHistoryData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
