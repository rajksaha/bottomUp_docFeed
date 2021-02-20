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
        getDoctorMenu : $resource('/rest/prescription/getDoctorMenu', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getDoctorPrefAdvice : $resource('/rest/doctorPreferenceAdvice/getDoctorPrefAdvice/:doctorID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {doctorID: '@doctorID', appointmentID: '@appointmentID'}
            }
        }),
        getDoctorPrefInv : $resource('/rest/doctorPreferenceInv/getDoctorPrefInv/:doctorID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
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
        })

    };
});
