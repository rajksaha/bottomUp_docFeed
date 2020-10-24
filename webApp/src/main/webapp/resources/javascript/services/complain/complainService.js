/**
 * Created by joy on 17/10/2020.
 */

app.service('ComplainService', function ($resource) {
    return {

        getDrugDayType : $resource('rest/complain/getDrugDayType', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        updateComplain: $resource('rest/complain/updateComplain', {}, {
            'query': {
                method: 'POST',
                isArray : false
            }
        }),
        
    };
});