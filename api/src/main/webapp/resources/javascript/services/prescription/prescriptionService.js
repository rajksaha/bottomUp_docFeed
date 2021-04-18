/**
 * Created by joy on 21/15/2020.
 */

app.service('PrescriptionService', function ($resource) {
    return {
        getDoctorMenu : $resource('/rest/menuSetting/getByDoctorID/:doctorID', {}, {
            'query':  {
                method:'GET',
                isArray: true,
                params: {doctorID: '@doctorID'}
            }
        }),
        getPrescriptionInfo : $resource('/rest/prescription/getPrescriptionInfo/:appointmentID', {}, {
            'query':  {
                method:'GET',
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedComplain : $resource('/rest/prescription/getPrescribedComplain/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedInv : $resource('/rest/prescription/getPrescribedInv/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedAdvice : $resource('/rest/prescription/getPrescribedAdvice/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray: true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedVital : $resource('/rest/prescription/getPrescribedVital/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedNextVisit : $resource('/rest/prescription/getPrescribedNextVisit/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedRefDoc : $resource('/rest/prescriptionReference/getByAppointmentID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedDiagnosis : $resource('/rest/prescription/getPrescribedDiagnosis/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedPastHistory : $resource('/rest/prescription/getPrescribedPastHistory/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedFamilyHistory : $resource('/rest/prescription/getPrescribedFamilyHistory/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedDiet : $resource('/rest/prescription/getPrescribedDiet/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedOldDrugs : $resource('/rest/prescription/getPrescribedOldDrugs/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedCurrentDrug : $resource('/rest/prescription/getPrescribedCurrentDrug/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedHistory : $resource('/rest/prescription/getHistoryInfo/:patientID/:appointmentID/:typeCode', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {patientID: '@patientID', appointmentID: '@appointmentID', typeCode: '@typeCode'}
            }
        }),
        getPrescribedComment : $resource('/rest/prescription/getPrescribedComment/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getPrescribedDrug : $resource('/rest/prescription/getPrescribedDrug/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        // Used So Far
        getInformationOfPatient : $resource('/rest/prescription/getInformationOfPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getTypeOfAppointment : $resource('/rest/prescription/getTypeOfAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getCurrentAppointment : $resource('/rest/appointment/getCurrentAppointment', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        getRecordOfClinical : $resource('/rest/prescription/getRecordOfClinical/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID'}
            }
        }),
        getDetailOfClinical : $resource('/rest/prescription/getDetailOfClinical', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getContentDetailByDocId : $resource('/rest/prescription/getContentDetailByDocId', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDrugDayTypeList : $resource('/rest/prescription/getDrugDayTypeList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getInvDetail : $resource('/rest/invCategory/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getPresAdvTemp : $resource('/rest/prescription/getPresAdvTemp/:appointmentID/:doctorID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {appointmentID: '@appointmentID', doctorID: '@doctorID'}
            }
        }),


        //Delete zone
        saveNextVisit : $resource('/rest/prescriptionNextVisit/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deletePresDocRefer : $resource('/rest/prescriptionReference/delete/:prescriptionReferenceID', {}, {
            'remove':  {
                method:'DELETE',
                params: {prescriptionReferenceID: '@prescriptionReferenceID'}
            }
        }),
        delDrugHistoryById: $resource('/rest/patientDrugHistory/delDrugHistoryById/:contentDetailID', {}, {
            'remove': {
                method: 'DELETE',
                params  : {contentDetailID: '@contentDetailID'}
            }
        }),
        delClinicalHistoryById : $resource('/rest/contentDetail/delete/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                params: {contentDetailID: '@contentDetailID'}
            }
        }),
        deletePrescribedInv : $resource('/rest/prescriptionInv/delete/:presInvID', {}, {
            'remove':  {
                method:'DELETE',
                params: {presInvID: '@presInvID'}
            }
        }),
        deletePastHistory : $resource('/rest/prescription/deletePastHistory/:pastHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {pastHistoryID: '@pastHistoryID'}
            }
        }),
        deleteFamilyHistory : $resource('/rest/prescription/deleteFamilyHistory/:familyHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {familyHistoryID: '@familyHistoryID'}
            }
        }),
        deletePrescribedVital : $resource('/rest/prescription/deletePrescribedVital/:prescribedVitalID', {}, {
            'remove':  {
                method:'DELETE',
                params: {prescribedVitalID: '@prescribedVitalID'}
            }
        }),
        deletePrescribedComplain : $resource('/rest/prescriptionDelete/prescribedComplain/:complainID', {}, {
            'remove':  {
                method:'DELETE',
                params: {complainID: '@complainID'}
            }
        }),
        deletePrescribedHistory : $resource('/rest/prescription/delete/:savedHistorysID', {}, {
            'remove':  {
                method:'DELETE',
                params: {savedHistorysID: '@savedHistorysID'}
            }
        }),
        deletePrescribedAdvice : $resource('/rest/prescriptionAdvice/delete/:prescriptionAdviceID', {}, {
            'remove':  {
                method:'DELETE',
                params: {prescriptionAdviceID: '@prescriptionAdviceID'}
            }
        }),
        deletePrescribedDrug : $resource('/rest/prescription/deletePrescribedDrug/:drugPrescribeID', {}, {
            'remove':  {
                method:'DELETE',
                params: {drugPrescribeID: '@drugPrescribeID'}
            }
        }),
        deleteFollowUpFromPres : $resource('/rest/contentDetail/delete/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                params: {contentDetailID: '@contentDetailID'}
            }
        }),
        deletePresAdvTemp : $resource('/rest/contentDetail/delete/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                params: {contentDetailID: '@contentDetailID'}
            }
        }),
        getMedicalReport : $resource('/rest/prescription/getMedicalReport/:appointmentID', {}, {
            'query':  {
                method:'GET',
                params: {appointmentID: '@appointmentID'}
            }
        })
    };
});
