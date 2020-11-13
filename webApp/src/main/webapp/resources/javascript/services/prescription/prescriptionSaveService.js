/**
 * Created by raj on 11/12/2020.
 */

app.service('PresSaveService', function ($resource) {
    return {

        saveDiagnosis : $resource('/api/rest/prescriptionSave/saveDiagnosis', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        saveComplain : $resource('/api/rest/prescriptionSave/saveComplain', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        saveDiet : $resource('/api/rest/prescriptionSave/saveDiet', {}, {
            'query':  {
                method:'POST',
                isArray:true
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
        updatePatientType : $resource('/api/rest/prescription/getUpInDelOfPtientDetail', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateAppointmentByState : $resource('/api/rest/prescription/updateAppointmentByState', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateDrugPrescriptionJson : $resource('/api/rest/prescription/updateDrugPrescriptionJson', {}, {
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
        updateComment : $resource('/api/rest/prescription/getUpInDelContentDetailByComment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        })
    };
});
