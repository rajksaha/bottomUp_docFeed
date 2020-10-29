/**
 * Created by raj on 10/10/2020.
 */

app.service('AppointmentService', function ($resource) {
    return {

        getByParam : $resource('/api/rest/appointment/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getDoctorData : $resource('/api/rest/appointment/getDoctorData', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getAppoinmentType : $resource('/api/rest/appointment/getAppoinmentType', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        visitPatient : $resource('/api/rest/appointment/visitPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createAppointment : $resource('/api/rest/appointment/createAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createAppForNewPatient : $resource('/api/rest/appointment/createAppForNewPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteAppointment : $resource('/api/rest/appointment/deleteAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateAppointment : $resource('/api/rest/appointment/updateAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        })

    };
});
