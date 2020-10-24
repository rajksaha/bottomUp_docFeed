/**
 * Created by joy on 21/15/2020.
 */

app.service('ComplainService', function ($resource) {
    return {

        getDayTypeDrug : $resource('rest/complain/getDayTypeDrug', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        })
    };
});

