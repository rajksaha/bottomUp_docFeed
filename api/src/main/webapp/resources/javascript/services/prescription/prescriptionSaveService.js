/**
 * Created by raj on 11/12/2020.
 */

app.service('PresSaveService', function ($resource) {
    return {

        saveDiagnosis : $resource('/rest/prescriptionSave/saveDiagnosis', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        saveComplain : $resource('/rest/prescriptionSave/saveComplain', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        saveDiet : $resource('/rest/prescriptionSave/saveDiet', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        savePrescribedVital : $resource('/rest/prescriptionVital/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createPrescribedInv : $resource('/rest/prescriptionInv/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createPrescribedAdvice : $resource('/rest/prescriptionAdvice/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updatePrescribedInv : $resource('/rest/prescriptionInv/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        saveInvFromPref : $resource('/rest/prescriptionSave/saveInvFromPref/:appointmentID/:invID', {}, {
            'query':  {
                method:'POST',
                isArray: true,
                params: {appointmentID: '@appointmentID', invID: '@invID'}
            }
        }),
        saveAdviceFromPref : $resource('/rest/prescriptionSave/saveAdviceFromPref/:appointmentID/:adviceID', {}, {
            'query':  {
                method:'POST',
                isArray: true,
                params: {appointmentID: '@appointmentID', adviceID: '@adviceID'}
            }
        }),
        savePresDoctorRefer : $resource('/rest/prescriptionReference/create', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        savePresNote : $resource('/rest/prescriptionSave/savePresNote', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateAppStatus : $resource('/rest/appointment/updateStatus', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateDrugPrescriptionJson : $resource('/rest/prescription/updateDrugPrescriptionJson', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        updateAppoinmentStatusByApointmentNo : $resource('/rest/prescription/updateAppoinmentStatusByApointmentNo', {}, {
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
        updateComment : $resource('/rest/prescription/getUpInDelContentDetailByComment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        })
    };
});
