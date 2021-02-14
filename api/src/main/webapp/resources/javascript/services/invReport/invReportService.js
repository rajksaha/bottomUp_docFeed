/**
 * Created by joy on 19/10/2020.
 */

app.service('InvReportService', function ($resource) {
    return {

        getAppointmentDetail : $resource('/api/rest/appointment/getCurrAppDetail', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        getDateInvReport : $resource('/api/rest/invReport/getDateInvReport/:patientID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {patientID: '@patientID'}
            }
        }),
        getInvReportDate : $resource('/api/rest/invReport/getInvReportDate', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getInvReportDateLocation : $resource('/api/rest/invReport/getInvReportDateLocation', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        })
    };
});

