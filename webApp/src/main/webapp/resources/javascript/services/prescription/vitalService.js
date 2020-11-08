/**
 * Created by joy on 21/15/2020.
 */

app.service('VitalService', function ($resource) {
    return {

        createVitalToDoctorPreference : $resource('rest/vital/createVitalToDoctorPreference', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createDoctorVitalSettings : $resource('rest/vital/createDoctorVitalSettings', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDoctorVitalSettings : $resource('rest/vital/deleteDoctorVitalSettings/:vitalSettingID', {}, {
            'remove':  {
                method:'DELETE',
                params: {vitalSettingID: '@vitalSettingID'}
            }
        }),
        getVitalDoctorDetail : $resource('rest/vital/getVitalDoctorDetail', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getVitalOptionList : $resource('rest/vital/getVitalOptionList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        createVitalOption : $resource('rest/vital/createVitalOption', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateVitalPrescription : $resource('rest/vital/updateVitalPrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createVitalPrescription : $resource('rest/vital/createVitalPrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteVitalprescription : $resource('rest/vital/deleteVitalprescription/:prescribedVitalID', {}, {
            'remove':  {
                method:'DELETE',
                params: {prescribedVitalID: '@prescribedVitalID'}
            }
        })
    };
});
