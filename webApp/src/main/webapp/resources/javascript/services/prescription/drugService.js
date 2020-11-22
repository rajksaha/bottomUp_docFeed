/**
 * Created by joy on 21/15/2020.
 */

app.service('DrugService', function ($resource) {
    return {

        getTypeOfDrugDay : $resource('/api/rest/contentDrugType/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getTypeOfDrug : $resource('/api/rest/contentDrugType/getByParam', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getTypeOfDrugDayByDose : $resource('/api/rest/drug/getTypeOfDrugDayByDose', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getTypeOfDrugWhen : $resource('/api/rest/drug/getTypeOfDrugWhen', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getTypeOfDrugAdvice : $resource('/api/rest/drug/getTypeOfDrugAdvice', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        createPeriodOfDose : $resource('/api/rest/drug/createPeriodOfDose', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createAndUpdateDrugPrescription : $resource('/api/rest/drug/createAndUpdateDrugPrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDrugById : $resource('/api/rest/drug/deleteDrugById/:drugID', {}, {
            'remove':  {
                method:'DELETE',
                params: {drugID: '@drugID'}
            }
        }),
        updateDrugByName : $resource('/api/rest/drug/updateDrugByName', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getDoctorDrugById : $resource('/api/rest/drug/getDoctorDrugById', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createDoctorDrugDose : $resource('/api/rest/drug/createDoctorDrugDose', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDocDrugCreateDocDrug : $resource('/api/rest/drug/deleteDocDrugCreateDocDrug/:drugType/:drugName/:drugStr/:drugTime/:doseUnit/:drugWhen/:drugAdvice', {}, {
            'query':  {
                method:'POST',
                params: {drugType: '@drugType', drugName: '@drugName', drugStr: '@drugStr', drugTime: '@drugTime', doseUnit: '@doseUnit', drugWhen: '@drugWhen', drugAdvice: '@drugAdvice'}
            }
        })
    };
});