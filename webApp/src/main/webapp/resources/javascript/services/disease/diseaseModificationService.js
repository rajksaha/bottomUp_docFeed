/**
 * Created by joy on 17/10/2020.
 */

app.service('DiseaseModificationService', function ($resource) {
    return {

        getDiseasesList : $resource('rest/disease/getDiseasesList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),

        delDisease : $resource('rest/disease/delDisease/:disease_id', {}, {
            'remove':  {
                method:'DELETE',
                params: {disease_id: '@disease_id'}
            }
        }),

        updateDisease : $resource('rest/disease/updateDisease', {}, {
            'query': {
                method  : 'POST',
                isArray : false
            }
        }),
        
    };
});

