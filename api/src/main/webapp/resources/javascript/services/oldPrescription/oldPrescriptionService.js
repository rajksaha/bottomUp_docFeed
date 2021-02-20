/**
 * Created by joy on 19/10/2020.
 */

app.service('OldPrescriptionService', function ($resource) {
    return {

        getAppointmentDetail : $resource('/rest/appointment/getCurrAppDetail', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        getAppointment : $resource('/rest/oldPres/getAppHistory/:patientID/:doctorID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {patientID: '@patientID', doctorID: '@doctorID'}
            }
        }),
        addItemToPres : $resource('/rest/oldPres/addItemToPres/:itemCode/:itemID/:newAppointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {itemCode: '@itemCode', itemID: '@itemID', newAppointmentID: '@newAppointmentID'}
            }
        }),
        addBulkToPres : $resource('/rest/oldPres/addBulkToPres/:itemCode/:oldAppointmentID/:newAppointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {itemCode: '@itemCode', oldAppointmentID: '@oldAppointmentID', newAppointmentID: '@newAppointmentID'}
            }
        }),
        copyPrescription : $resource('/rest/oldPres/copyPrescription/:oldAppointmentID/:newAppointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {oldAppointmentID: '@oldAppointmentID', newAppointmentID: '@newAppointmentID'}
            }
        }),
        copyComment : $resource('/rest/contentDetail/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        })
    };
});

