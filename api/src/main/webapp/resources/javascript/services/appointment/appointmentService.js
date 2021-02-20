/**
 * Created by raj on 10/10/2020.
 */

app.service('AppointmentService', function ($resource) {
    return {

        getByParam : $resource('/rest/appointment/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getDoctorData : $resource('/rest/appointment/getDoctorData', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDoctorDashboard : $resource('/rest/appointment/getDoctorDashboard', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        visitPatient : $resource('/rest/appointment/visitPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createAppointment : $resource('/rest/appointment/createAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createAppForNewPatient : $resource('/rest/appointment/createAppForNewPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createFollowUpApp : $resource('/rest/appointment/createFollowUpApp', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteAppointment : $resource('/rest/appointment/deleteAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateAppointment : $resource('/rest/appointment/updateAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        patientSearch : $resource('/rest/autoComplete/patientSearch', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        })

    };
});
