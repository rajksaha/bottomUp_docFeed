/**
 * Created by joy on 21/15/2020.
 */

app.service('PrescriptionService', function ($resource) {
    return {

        deleteAndCreateNextVisit : $resource('/api/rest/prescription/deleteAndCreateNextVisit/:nextVisitDate/:numOfDay/:dayType/:nextVisitType', {}, {
            'remove':  {
                method:'DELETE',
                params: {nextVisitDate: '@nextVisitDate', numOfDay: '@numOfDay', dayType: '@dayType', nextVisitType: '@nextVisitType'}
            }
        }),
        createRefferedDoctor : $resource('/api/rest/prescription/createRefferedDoctor', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createReferncePrescription : $resource('/api/rest/prescription/createReferncePrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteReferncePrescription : $resource('/api/rest/prescription/deleteReferncePrescription', {}, {
            'remove':  {
                method:'DELETE',
                params: {}
            }
        }),
        getInformationOfPatient : $resource('/api/rest/prescription/getInformationOfPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getDoctorMenu : $resource('/api/rest/prescription/getDoctorMenu', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getAppUserAccessList : $resource('/api/rest/prescription/getAppUserAccessList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getTypeOfAppointment : $resource('/api/rest/prescription/getTypeOfAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getUpInDelOfPtientDetail : $resource('/api/rest/prescription/getUpInDelOfPtientDetail', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        updateAppointmentByState : $resource('/api/rest/prescription/updateAppointmentByState', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getCurrentAppointment : $resource('/api/rest/appointment/getCurrentAppointment', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        getRecordOfClinical : $resource('/api/rest/prescription/getRecordOfClinical', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDetailOfClinical : $resource('/api/rest/prescription/getDetailOfClinical', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getContentDetailByDiet : $resource('/api/rest/prescription/getContentDetailByDiet', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getPrescriptionHistoryById : $resource('/api/rest/prescription/getPrescriptionHistoryById', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getContentDetailByOldDrugs : $resource('/api/rest/prescription/getContentDetailByOldDrugs', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getContentDetailByCurrentDrugs : $resource('/api/rest/prescription/getContentDetailByCurrentDrugs', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        delDrugHistoryById: $resource('/api/rest/prescription/delDrugHistoryById/:contentDetailID', {}, {
            'remove': {
                method: 'DELETE',
                params  : {contentDetailID: '@contentDetailID'}
            }
        }),
        delClinicalHistoryById : $resource('/api/rest/prescription/delClinicalHistoryById/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                params: {contentDetailID: '@contentDetailID'}
            }
        }),
        delInvPrescriptionById : $resource('/api/rest/prescription/delInvPrescriptionById/:id', {}, {
            'remove':  {
                method:'DELETE',
                params: {id: '@id'}
            }
        }),
        getUpInDelContentDetailByComment : $resource('/api/rest/prescription/getUpInDelContentDetailByComment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getContentDetailByComment : $resource('/api/rest/prescription/getContentDetailByComment', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDrugPrescriptionByAppoinmentId : $resource('/api/rest/prescription/getDrugPrescriptionByAppoinmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        updateDrugPrescriptionJson : $resource('/api/rest/prescription/updateDrugPrescriptionJson', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getInvPrescriptionByAppointmentId : $resource('/api/rest/prescription/getInvPrescriptionByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getAdvicePrescriptionByAppointmentId : $resource('/api/rest/prescription/getAdvicePrescriptionByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getVitalPrescriptionByAppointmentId : $resource('/api/rest/prescription/getVitalPrescriptionByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getComplainPrescriptionByAppointmentId : $resource('/api/rest/prescription/getComplainPrescriptionByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDrugDayTypeList : $resource('/api/rest/prescription/getDrugDayTypeList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getNextVistPrescriptionnByAppointmentId : $resource('/api/rest/prescription/getNextVistPrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getRefferedDoctorPrescriptionnByAppointmentId : $resource('/api/rest/prescription/getRefferedDoctorPrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getDiagnosisPrescriptionnByAppointmentId : $resource('/api/rest/prescription/getDiagnosisPrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getPastDiseasePrescriptionnByAppointmentId : $resource('/api/rest/prescription/getPastDiseasePrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        delPatientAndPrescriptionDisease : $resource('/api/rest/prescription/delPatientAndPrescriptionDisease/:pastHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {pastHistoryID: '@pastHistoryID'}
            }
        }),
        getFamityHistoryPrescriptionnByAppointmentId : $resource('/api/rest/prescription/getFamityHistoryPrescriptionnByAppointmentId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        delFamilyHistoryDisease : $resource('/api/rest/prescription/delFamilyHistoryDisease/:familyHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {familyHistoryID: '@familyHistoryID'}
            }
        }),
        delPrescribedVital : $resource('/api/rest/prescription/delPrescribedVital/:prescribedVitalID', {}, {
            'remove':  {
                method:'DELETE',
                params: {prescribedVitalID: '@prescribedVitalID'}
            }
        }),
        delComplainById : $resource('/api/rest/prescription/delComplainById/:id', {}, {
            'remove':  {
                method:'DELETE',
                params: {id: '@id'}
            }
        }),
        delPrescriptionHistoryById : $resource('/api/rest/prescription/delPrescriptionHistoryById/:savedHistorysID', {}, {
            'remove':  {
                method:'DELETE',
                params: {savedHistorysID: '@savedHistorysID'}
            }
        }),
        delPrescriptionAdviceById : $resource('/api/rest/prescription/delPrescriptionAdviceById/:adviceID', {}, {
            'remove':  {
                method:'DELETE',
                params: {adviceID: '@adviceID'}
            }
        }),
        delPrescriptionDrugById : $resource('/api/rest/prescription/delPrescriptionDrugById/:drugPrescribeID', {}, {
            'remove':  {
                method:'DELETE',
                params: {drugPrescribeID: '@drugPrescribeID'}
            }
        }),
        getContentDetailByDocId : $resource('/api/rest/prescription/getContentDetailByDocId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        updateAppoinmentStatusByApointmentNo : $resource('/api/rest/prescription/updateAppoinmentStatusByApointmentNo', {}, {
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
        }),
        getPrescriptionInfo : $resource('/api/rest/prescription/getPrescriptionInfo/:appointmentID', {}, {
            'query':  {
                method:'GET',
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getDoctorDetail : $resource('/api/rest/prescription/getDoctorDetail/:doctorID', {}, {
            'query':  {
                method:'GET',
                params: {doctorID: '@doctorID'}
            }
        })
    };
});
