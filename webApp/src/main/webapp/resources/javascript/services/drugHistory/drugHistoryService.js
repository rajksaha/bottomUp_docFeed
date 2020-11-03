/**
 * Created by joy on 17/10/2020.
 */

app.service('DrugHistoryService', function ($resource) {
    return {

        getDrugHistory : $resource('rest/drugHistory/getDrugHistory', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        createDrugHistory : $resource('rest/drugHistory/createDrugHistory', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        saveDrugHistoryList : $resource('rest/drugHistory/saveDrugHistoryList', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDrugHistory : $resource('rest/drugHistory/deleteDrugHistory/:delId', {}, {
            'remove':  {
                method:'DELETE',
                params: {delId: '@delId'}
            }
        }),
        addContentDetail : $resource('rest/drugHistory/addContentDetail', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delContentDetail : $resource('rest/drugHistory/delContentDetail/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                params: {contentDetailID: '@contentDetailID'}
            }
        }),
    };
});

