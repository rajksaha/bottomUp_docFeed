/**
 * Created by raj on 10/10/2020.
 */

app.service('DoctorService', function ($resource) {
    return {

        getAppData : $resource('/api/rest/doctor/get', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        getDoctorPrefInv : $resource('/api/rest/doctorPreferenceInv/getDoctorPrefInv/:doctorID/:appointmentID/:categoryID', {}, {
            'query':  {
                method:'GET',
                isArray: true,
                params: {doctorID: '@doctorID', appointmentID: '@appointmentID', categoryID: '@categoryID'}
            }
        }),
        getDoctorPrefAdvice : $resource('/api/rest/doctorPreferenceAdvice/getDoctorPrefAdvice/:doctorID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray: true,
                params: {doctorID: '@doctorID', appointmentID: '@appointmentID'}
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
