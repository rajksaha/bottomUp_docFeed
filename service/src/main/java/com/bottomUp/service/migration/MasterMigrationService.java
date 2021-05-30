package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by raj on 5/22/2021.
 */
@Service
@Transactional(rollbackFor = BottomUpException.class)
public class MasterMigrationService {

    @Autowired
    private DumpPatientService dumpPatientService;


}
