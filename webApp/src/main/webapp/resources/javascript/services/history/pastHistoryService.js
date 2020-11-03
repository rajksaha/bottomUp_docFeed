/**
 * Created by joy on 19/10/2020.
 */

app.service('PastHistoryService', function ($resource) {
    return {

        getRelationList : $resource('rest/pastHistory/getRelationList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDiseaseFromFamilyHistory : $resource('rest/pastHistory/getDiseaseFromFamilyHistory', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        createDiseaseInPrescription : $resource('rest/pastHistory/createDiseaseInPrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDiseaseFromPrescription : $resource('rest/pastHistory/deleteDiseaseFromPrescription/:familyHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {familyHistoryID: '@familyHistoryID'}
            }
        }),
        createDiseasePrescription : $resource('rest/pastHistory/createDiseasePrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDiseaseAndHistory : $resource('rest/pastHistory/deleteDiseaseAndHistory/:familyHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {familyHistoryID: '@familyHistoryID'}
            }
        }),
        createAndupdatePastPatientDisease : $resource('rest/pastHistory/createAndupdatePastPatientDisease', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deletePastPrescritionDisease : $resource('rest/pastHistory/deletePastPrescritionDisease/:pastHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {pastHistoryID: '@pastHistoryID'}
            }
        }),
        updatePastPrescritionDisease : $resource('rest/pastHistory/updatePastPrescritionDisease', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delAllPastDisease : $resource('rest/pastHistory/delAllPastDisease/:pastHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                params: {pastHistoryID: '@pastHistoryID'}
            }
        }),
        getPastDisease : $resource('rest/pastHistory/getPastDisease', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getCurrentDrugList : $resource('rest/pastHistory/getCurrentDrugList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getOldDrugList : $resource('rest/pastHistory/getOldDrugList', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        updateDrug : $resource('rest/pastHistory/updateDrug', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDrug : $resource('rest/pastHistory/deleteDrug/:delId', {}, {
            'remove':  {
                method:'DELETE',
                params: {delId: '@delId'}
            }
        }),
        createDrugPrescription : $resource('rest/pastHistory/createDrugPrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDrugPrescription : $resource('rest/pastHistory/deleteDrugPrescription/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                params: {contentDetailID: '@contentDetailID'}
            }
        }),
        getMenu : $resource('rest/pastHistory/getMenu', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDetailsOfDoctorHistory : $resource('rest/pastHistory/getDetailsOfDoctorHistory', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        deleteSettingsOfDocHistory : $resource('rest/pastHistory/deleteSettingsOfDocHistory/:historySettingID', {}, {
            'remove':  {
                method:'DELETE',
                params: {historySettingID: '@historySettingID'}
            }
        }),
        createHistoryToDocPref : $resource('rest/pastHistory/createHistoryToDocPref', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createSettingsOfDocPreference : $resource('rest/pastHistory/createSettingsOfDocPreference', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateHistoryOfPatient : $resource('rest/pastHistory/updateHistoryOfPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createHistoryOfPatient : $resource('rest/pastHistory/createHistoryOfPatient', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteHistoryOfPatient : $resource('rest/pastHistory/deleteHistoryOfPatient/:savedHistorysID', {}, {
            'remove':  {
                method:'DELETE',
                params: {savedHistorysID: '@savedHistorysID'}
            }
        }),
        deleteHistoryOfPrescription : $resource('rest/pastHistory/deleteHistoryOfPrescription/:savedHistorysID', {}, {
            'remove':  {
                method:'DELETE',
                params: {savedHistorysID: '@savedHistorysID'}
            }
        }),
        createPrescriptionHistory : $resource('rest/pastHistory/createPrescriptionHistory', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        })
    };
});

