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
        })

    };
});
