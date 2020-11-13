/**
 * Created by joy on 21/15/2020.
 */

app.service('DrugService', function ($resource) {
    return {

        getTypeOfDrugDay : $resource('rest/drug/getTypeOfDrugDay', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getTypeOfDrug : $resource('rest/drug/getTypeOfDrug', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getTypeOfDrugDayByDose : $resource('rest/drug/getTypeOfDrugDayByDose', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getTypeOfDrugWhen : $resource('rest/drug/getTypeOfDrugWhen', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getTypeOfDrugAdvice : $resource('rest/drug/getTypeOfDrugAdvice', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        createPeriodOfDose : $resource('rest/drug/createPeriodOfDose', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createAndUpdateDrugPrescription : $resource('rest/drug/createAndUpdateDrugPrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDrugById : $resource('rest/drug/deleteDrugById/:drugID', {}, {
            'remove':  {
                method:'DELETE',
                params: {drugID: '@drugID'}
            }
        }),
        updateDrugByName : $resource('rest/drug/updateDrugByName', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getDoctorDrugById : $resource('rest/drug/getDoctorDrugById', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createDoctorDrugDose : $resource('rest/drug/createDoctorDrugDose', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDocDrugCreateDocDrug : $resource('rest/drug/deleteDocDrugCreateDocDrug/:drugType/:drugName/:drugStr/:drugTime/:doseUnit/:drugWhen/:drugAdvice', {}, {
            'query':  {
                method:'POST',
                params: {drugType: '@drugType', drugName: '@drugName', drugStr: '@drugStr', drugTime: '@drugTime', doseUnit: '@doseUnit', drugWhen: '@drugWhen', drugAdvice: '@drugAdvice'}
            }
        })
    };
});