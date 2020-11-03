/**
 * Created by raj on 10/10/2020.
 */

app.service('AppointmentService', function ($resource) {
    return {

        getAccessInfo : $resource('rest/appointment/getAccessInfo', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDoctorData : $resource('rest/appointment/getDoctorData', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getAppoinmentType : $resource('rest/appointment/getAppoinmentType', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        makePrescription : $resource('rest/appointment/makePrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createAppointment : $resource('rest/appointment/createAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteAppointment : $resource('rest/appointment/deleteAppointment/:appointmentID', {}, {
            'remove':  {
                method:'DELETE',
                params: {appointmentID: '@appointmentID'}
            }
        }),
        updateAppointment : $resource('rest/appointment/updateAppointment', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),

    };
});
