/**
 * Created by joy on 19/10/2020.
 */

app.service('GroupAdviceService', function ($resource) {
    return {

        getGroupAdvice : $resource('/rest/contentAdvice/getGroupAdvice', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        delete : $resource('/rest/attachment/delete', {}, {
            'remove': {
                method: 'POST',
                isArray: false
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

