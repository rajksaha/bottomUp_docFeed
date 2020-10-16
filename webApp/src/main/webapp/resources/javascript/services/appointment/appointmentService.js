/**
 * Created by raj on 10/10/2020.
 */

app.service('AppointmentService', function ($resource) {
    return {

        getByParam : $resource('rest/appointment/getByParam', {}, {
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
        getByID : $resource('rest/appointment/getByID/appointmentID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                params: {appointmentID : '@appointmentID'},
                isArray:false
            }
        }),
        create: $resource('rest/appointment/save', {}, {
            'save': {
                method: 'POST',
                isArray : false
            }
        }),
        update : $resource('rest/appointment/update', {}, {
            query: {
                method  : 'POST',
                isArray : false
            }
        }),
        delete : $resource('rest/appointment/delete/:appointmentID', {}, {
            'remove':  {
                method:'DELETE',
                params: {appointmentID : '@appointmentID'}
            }
        })

    };
});
