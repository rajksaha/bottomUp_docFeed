/**
 * Created by raj on 10/10/2020.
 */

app.service('DoctorService', function ($resource) {
    return {

        getAppData : $resource('/rest/doctor/get', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        getDoctorPrefInv : $resource('/rest/doctorPreferenceInv/getDoctorPrefInv/:doctorID/:appointmentID/:categoryID', {}, {
            'query':  {
                method:'GET',
                isArray: true,
                params: {doctorID: '@doctorID', appointmentID: '@appointmentID', categoryID: '@categoryID'}
            }
        }),
        getDoctorPrefAdvice : $resource('/rest/doctorPreferenceAdvice/getDoctorPrefAdvice/:doctorID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray: true,
                params: {doctorID: '@doctorID', appointmentID: '@appointmentID'}
            }
        }),
        getDoctorPrefVital : $resource('/rest/doctorVitalSetting/getByDoctorVitalInfo/:doctorID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray: true,
                params: {doctorID: '@doctorID', appointmentID: '@appointmentID'}
            }
        }),
        getDoctorDetail : $resource('/rest/prescription/getDoctorDetail/:doctorID', {}, {
            'query':  {
                method:'GET',
                params: {doctorID: '@doctorID'}
            }
        }),
        createPrefInv : $resource('/rest/doctorPreferenceInv/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createPrefAdvice : $resource('/rest/doctorPreferenceAdvice/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createPrefVital : $resource('/rest/doctorVitalSetting/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deletePrefInv : $resource('/rest/doctorPreferenceInv/delete/:invPreferenceID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {invPreferenceID: '@invPreferenceID'}
            }
        }),
        deletePrefAdvice : $resource('/rest/doctorPreferenceAdvice/delete/:advicePreferenceID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {advicePreferenceID: '@advicePreferenceID'}
            }
        }),
        deletePrefVital : $resource('/rest/doctorVitalSetting/delete/:vitalSettingID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {vitalSettingID: '@vitalSettingID'}
            }
        })
    };
});
