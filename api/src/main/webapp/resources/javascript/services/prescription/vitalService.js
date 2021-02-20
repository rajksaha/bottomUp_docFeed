/**
 * Created by joy on 21/15/2020.
 */

app.service('VitalService', function ($resource) {
    return {
        getVitalDoctorDetail : $resource('/rest/doctorVitalSetting/getByDoctorVitalInfo/{d}', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        addToPreference : $resource('/rest/doctorVitalSetting/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        savePrescribedVital : $resource('/rest/prescriptionVital/save/{appointmentID}', {}, {
            'query':  {
                method:'POST',
                isArray:false,
                params: {appointmentID: '@appointmentID'}
            }
        }),

        /////////////////////////////////`
        createDoctorVitalSettings : $resource('/rest/vital/createDoctorVitalSettings', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDoctorVitalSettings : $resource('/rest/vital/deleteDoctorVitalSettings/:vitalSettingID', {}, {
            'remove':  {
                method:'DELETE',
                params: {vitalSettingID: '@vitalSettingID'}
            }
        }),
        getVitalOptionList : $resource('/rest/vital/getVitalOptionList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        createVitalOption : $resource('/rest/vital/createVitalOption', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateVitalPrescription : $resource('/rest/vital/updateVitalPrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteVitalprescription : $resource('/rest/vital/deleteVitalprescription/:prescribedVitalID', {}, {
            'remove':  {
                method:'DELETE',
                params: {prescribedVitalID: '@prescribedVitalID'}
            }
        })
    };
});
