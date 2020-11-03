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
<<<<<<< HEAD
        deleteAppointment : $resource('rest/appointment/deleteAppointment/:appointmentID', {}, {
            'remove':  {
                method:'DELETE',
                params: {appointmentID: '@appointmentID'}
=======
        createAppForNewPatient : $resource('/api/rest/appointment/createAppForNewPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
>>>>>>> 03d8cfdde4a9723d8bef3ba2f89e82d798e8005d
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
