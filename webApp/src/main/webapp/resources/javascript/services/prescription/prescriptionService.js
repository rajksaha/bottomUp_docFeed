/**
 * Created by joy on 21/15/2020.
 */

app.service('PrescriptionService', function ($resource) {
    return {

        deleteAndCreateNextVisit : $resource('rest/prescription/deleteAndCreateNextVisit', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createRefferedDoctor : $resource('rest/prescription/createRefferedDoctor', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createReferncePrescription : $resource('rest/prescription/createReferncePrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteReferncePrescription : $resource('rest/prescription/deleteReferncePrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getInformationOfPatient : $resource('rest/prescription/getInformationOfPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getSettingsOfMenu : $resource('rest/prescription/getSettingsOfMenu', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getAppUserAccessList : $resource('rest/prescription/getAppUserAccessList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getPatientTypeByDocType : $resource('rest/prescription/getPatientTypeByDocType', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getTypeOfAppointmentList : $resource('rest/prescription/getTypeOfAppointmentList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getAllDocInfo : $resource('rest/prescription/getAllDocInfo', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getUpInDelOfPtientDetail : $resource('rest/prescription/getUpInDelOfPtientDetail', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        updateAppointmentByState : $resource('rest/prescription/updateAppointmentByState', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getPatientAppointment : $resource('rest/prescription/getPatientAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getRecordOfClinical : $resource('rest/prescription/getRecordOfClinical', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDetailOfClinical : $resource('rest/prescription/getDetailOfClinical', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getContentDetailByDiet : $resource('rest/prescription/getContentDetailByDiet', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getPrescriptionHistoryById : $resource('rest/prescription/getPrescriptionHistoryById', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getContentDetailByOldDrugs : $resource('rest/prescription/getContentDetailByOldDrugs', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getContentDetailByCurrentDrugs : $resource('rest/prescription/getContentDetailByCurrentDrugs', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        delDrugHistoryById : $resource('rest/prescription/delDrugHistoryById', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delClinicalHistoryById : $resource('rest/prescription/delClinicalHistoryById', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delInvPrescriptionById : $resource('rest/prescription/delInvPrescriptionById', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getUpInDelContentDetailByComment : $resource('rest/prescription/getUpInDelContentDetailByComment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getContentDetailByComment : $resource('rest/prescription/getContentDetailByComment', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDrugPrescriptionByAppoinmentId : $resource('rest/prescription/getDrugPrescriptionByAppoinmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        updateDrugPrescriptionJson : $resource('rest/prescription/updateDrugPrescriptionJson', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getInvPrescriptionByAppointmentId : $resource('rest/prescription/getInvPrescriptionByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getAdvicePrescriptionByAppointmentId : $resource('rest/prescription/getAdvicePrescriptionByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getVitalPrescriptionByAppointmentId : $resource('rest/prescription/getVitalPrescriptionByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getComplainPrescriptionByAppointmentId : $resource('rest/prescription/getComplainPrescriptionByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDrugDayTypeList : $resource('rest/prescription/getDrugDayTypeList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDrugDayTypeList : $resource('rest/prescription/getDrugDayTypeList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getNextVistPrescriptionnByAppointmentId : $resource('rest/prescription/getNextVistPrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getRefferedDoctorPrescriptionnByAppointmentId : $resource('rest/prescription/getRefferedDoctorPrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getDiagnosisPrescriptionnByAppointmentId : $resource('rest/prescription/getDiagnosisPrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getPastDiseasePrescriptionnByAppointmentId : $resource('rest/prescription/getPastDiseasePrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        delPatientAndPrescriptionDisease : $resource('rest/prescription/delPatientAndPrescriptionDisease', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getFamityHistoryPrescriptionnByAppointmentId : $resource('rest/prescription/getFamityHistoryPrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        delFamilyHistoryDisease : $resource('rest/prescription/delFamilyHistoryDisease', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delPrescribedVital : $resource('rest/prescription/delPrescribedVital', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delComplainById : $resource('rest/prescription/delComplainById', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delPrescriptionHistoryById : $resource('rest/prescription/delPrescriptionHistoryById', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delPrescriptionAdviceById : $resource('rest/prescription/delPrescriptionAdviceById', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delPrescriptionDrugById : $resource('rest/prescription/delPrescriptionDrugById', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getContentDetailByDocId : $resource('rest/prescription/getContentDetailByDocId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        updateAppoinmentStatusByApointmentNo : $resource('rest/prescription/updateAppoinmentStatusByApointmentNo', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updatePatientByAll : $resource('-', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        })
    };
});

