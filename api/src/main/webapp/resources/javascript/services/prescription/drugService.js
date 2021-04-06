/**
 * Created by joy on 21/15/2020.
 */

app.service('DrugService', function ($resource) {
    return {
        getReqContent : $resource('/rest/prescriptionDrug/getReqContent', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        getDrugDefaultSetup : $resource('/rest/drugDefSetup/getDrugDefaultSetup/:drugID/:genericID', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {drugID: '@drugID', genericID: '@genericID'}
            }
        }),
        getTypeOfDrugDay : $resource('/rest/contentDrugType/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getTypeOfDrug : $resource('/rest/contentDrugType/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getTypeOfDrugDayByDose : $resource('/rest/drug/getTypeOfDrugDayByDose', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getTypeOfDrugAdvice : $resource('/rest/contentDrugAdvice/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getTypeOfDrugWhen : $resource('/rest/contentWhenType/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        createPeriodOfDose : $resource('/rest/drug/createPeriodOfDose', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        save : $resource('/rest/prescriptionDrug/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDrugById : $resource('/rest/drug/deleteDrugById/:drugID', {}, {
            'remove':  {
                method:'DELETE',
                params: {drugID: '@drugID'}
            }
        }),
        updateDrugByName : $resource('/rest/drug/updateDrugByName', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createDoctorDrugDose : $resource('/rest/drug/createDoctorDrugDose', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDocDrugCreateDocDrug : $resource('/rest/drug/deleteDocDrugCreateDocDrug/:drugType/:drugName/:drugStr/:drugTime/:doseUnit/:drugWhen/:drugAdvice', {}, {
            'query':  {
                method:'POST',
                params: {drugType: '@drugType', drugName: '@drugName', drugStr: '@drugStr', drugTime: '@drugTime', doseUnit: '@doseUnit', drugWhen: '@drugWhen', drugAdvice: '@drugAdvice'}
            }
        }),
        getCompDrugList : $resource('/rest/contentDrugGeneric/getCompDrug/:genericID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {genericID: '@genericID'}
            }
        })
    };
});