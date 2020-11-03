/**
 * Created by joy on 21/15/2020.
 */

app.service('PrescriptionService', function ($resource) {
    return {

        deleteAndCreateNextVisit : $resource('rest/prescription/deleteAndCreateNextVisit/:nextVisitDate/:numOfDay/:dayType/:nextVisitType', {}, {
            'remove':  {
                method:'DELETE',
                params: {nextVisitDate: '@nextVisitDate', numOfDay: '@numOfDay', dayType: '@dayType', nextVisitType: '@nextVisitType'} 
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
            'remove':  {
                method:'DELETE',
                params: {}
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
        delDrugHistoryById: $resource('rest/prescription/delDrugHistoryById/:contentDetailID', {}, {
            'remove': {
                method: 'DELETE',
                params  : {contentDetailID: '@contentDetailID'}
            }
        }),
        delClinicalHistoryById : $resource('rest/prescription/delClinicalHistoryById/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                params: {contentDetailID: '@contentDetailID'} 
            }
        }),
        delInvPrescriptionById : $resource('rest/prescription/delInvPrescriptionById/:id', {}, {
            'remove':  {
                method:'DELETE',
                params: {id: '@id'}
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
        delPatientAndPrescriptionDisease : $resource('rest/prescription/delPatientAndPrescriptionDisease/:pastHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {pastHistoryID: '@pastHistoryID'}
            }
        }),
        getFamityHistoryPrescriptionnByAppointmentId : $resource('rest/prescription/getFamityHistoryPrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        delFamilyHistoryDisease : $resource('rest/prescription/delFamilyHistoryDisease/:familyHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {familyHistoryID: '@familyHistoryID'}
            }
        }),
        delPrescribedVital : $resource('rest/prescription/delPrescribedVital/:prescribedVitalID', {}, {
            'remove':  {
                method:'DELETE',
                params: {prescribedVitalID: '@prescribedVitalID'}
            }
        }),
        delComplainById : $resource('rest/prescription/delComplainById/:id', {}, {
            'remove':  {
                method:'DELETE',
                params: {id: '@id'}
            }
        }),
        delPrescriptionHistoryById : $resource('rest/prescription/delPrescriptionHistoryById/:savedHistorysID', {}, {
            'remove':  {
                method:'DELETE',
                params: {savedHistorysID: '@savedHistorysID'}
            }
        }),
        delPrescriptionAdviceById : $resource('rest/prescription/delPrescriptionAdviceById/:adviceID', {}, {
            'remove':  {
                method:'DELETE',
                params: {adviceID: '@adviceID'}
            }
        }),
        delPrescriptionDrugById : $resource('rest/prescription/delPrescriptionDrugById/:drugPrescribeID', {}, {
            'remove':  {
                method:'DELETE',
                params: {drugPrescribeID: '@drugPrescribeID'}
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

