/**
 * Created by joy on 17/10/2020.
 */

app.service('FollowUpChartService', function ($resource) {
    return {

        getAppointmentDetail : $resource('/api/rest/appointment/getCurrAppDetail', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        create : $resource('/api/rest/followUpResult/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        update : $resource('/api/rest/followUpResult/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        addFollowUpToPres : $resource('/api/rest/followUpResult/addFollowUpToPres', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteFollowUpFromPres : $resource('/api/rest/contentDetail/delete/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                params: {contentDetailID: '@contentDetailID'}
            }
        })
    };
});

