/**
 * Created by joy on 17/10/2020.
 */

app.service('FollowUpChartService', function ($resource) {
    return {

        getAppointmentDetail : $resource('/rest/appointment/getCurrAppDetail', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        create : $resource('/rest/followUpResult/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        update : $resource('/rest/followUpResult/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        addFollowUpToPres : $resource('/rest/followUpResult/addFollowUpToPres', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteFollowUpFromPres : $resource('/rest/contentDetail/delete/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                params: {contentDetailID: '@contentDetailID'}
            }
        })
    };
});

