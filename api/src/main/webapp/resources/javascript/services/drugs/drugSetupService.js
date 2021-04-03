/**
 * Created by joy on 17/10/2020.
 */

app.service('DrugSetupService', function ($resource) {
    return {

        getDrugsTypeList : $resource('rest/contentDrugType/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getDrugsDayTypeList : $resource('rest/drugs/getDrugsDayTypeList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDrugsWhenTypeList : $resource('rest/drugs/getDrugsWhenTypeList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDrugsAdviceTypeList : $resource('rest/drugs/getDrugsAdviceTypeList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDrugCompanyList : $resource('rest/contentDrugCompany/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        create : $resource('rest/contentDrug/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        update : $resource('rest/contentDrug/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delete : $resource('/rest/contentDrug/delete/:drugID', {}, {
            'remove':  {
                method:'DELETE',
                params: {drugID: '@drugID'}
            }
        }),
        getDrugDefaultSetup : $resource('/rest/drugDefSetup/getDrugDefaultSetup/:drugID/:genericID', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {drugID: '@drugID', genericID: '@genericID'}
            }
        }),
        getGenericDefaultSetup : $resource('/rest/drugDefSetup/getGenericDefaultSetup/:genericID', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {genericID: '@genericID'}
            }
        }),
        createSetup : $resource('rest/drugDefSetup/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateSetup : $resource('rest/drugDefSetup/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteSetup : $resource('/rest/drugDefSetup/delete/:drugSettingID', {}, {
            'remove':  {
                method:'DELETE',
                params: {drugSettingID: '@drugSettingID'}
            }
        }),
        saveDrugGeneric : $resource('rest/contentDrugGeneric/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateDrugGeneric : $resource('rest/contentDrugGeneric/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDrugGeneric : $resource('/rest/contentDrugGeneric/delete/:genericID', {}, {
            'remove':  {
                method:'DELETE',
                params: {genericID: '@genericID'}
            }
        }),
        getCompDrugList : $resource('/rest/contentDrugGeneric/getCompDrug/:genericID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {genericID: '@genericID'}
            }
        }),
        updateGenericInfo : $resource('/rest/contentDrugGeneric/updateGeneric/:drugID/:genericID', {}, {
            'query':  {
                method:'PUT',
                isArray:false,
                params: {drugID: '@drugID', genericID: '@genericID'}
            }
        })

    };
});

