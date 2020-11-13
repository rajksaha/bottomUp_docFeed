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
        getDoctorPrefInv : $resource('/api/rest/doctorPreferenceInv/getDoctorPrefInv/:doctorID', {}, {
            'query':  {
                method:'GET',
                params: {doctorID: '@doctorID'}
            }
        }),
        getDoctorPrefAdvice : $resource('/api/rest/doctorPreferenceAdvice/getDoctorPrefAdvice/:doctorID', {}, {
            'query':  {
                method:'GET',
                params: {doctorID: '@doctorID'}
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
