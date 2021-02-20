/**
 * Created by joy on 19/10/2020.
 */

app.service('InvReportService', function ($resource) {
    return {

        getAppointmentDetail : $resource('/rest/appointment/getCurrAppDetail', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        getDateInvReport : $resource('/rest/invReport/getDateInvReport/:patientID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {patientID: '@patientID'}
            }
        }),
        getInvReportDate : $resource('/rest/invReport/getInvReportDate', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getInvReportDateLocation : $resource('/rest/invReport/getInvReportDateLocation', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        })
    };
});

