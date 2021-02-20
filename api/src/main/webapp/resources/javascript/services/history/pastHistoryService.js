/**
 * Created by joy on 19/10/2020.
 */

app.service('PastHistoryService', function ($resource) {
    return {

        getRelationList : $resource('/rest/contentRelation/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getDiseaseFromFamilyHistory : $resource('/rest/patientFamilyHistory/getByPatientID/:patientID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {patientID: '@patientID'}
            }
        }),
        saveFamilyHistory : $resource('/rest/patientFamilyHistory/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteFamilyHistory : $resource('/rest/patientFamilyHistory/delete/:familyHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {familyHistoryID: '@familyHistoryID'}
            }
        }),
        addFamilyHistoryInPres : $resource('/rest/prescriptionFamilyDisease/addFamilyHistoryInPres/:familyHistoryID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {familyHistoryID: '@familyHistoryID', appointmentID: '@appointmentID'}
            }
        }),
        deleteFamilyHistoryInPres : $resource('/rest/prescriptionFamilyDisease/delete/:presFamilyDiseaseID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {presFamilyDiseaseID: '@presFamilyDiseaseID'}
            }
        }),

        //past disease

        getPastDisease : $resource('/rest/patientPastDisease/getByPatientID/:patientID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {patientID: '@patientID'}
            }
        }),
        savePastHistory : $resource('/rest/patientPastDisease/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deletePastDisease : $resource('/rest/patientPastDisease/delete/:patientPastDiseaseID', {}, {
            'query':  {
                method:'POST',
                isArray:false,
                params: {patientPastDiseaseID: '@patientPastDiseaseID'}
            }
        }),
        deletePastHistoryFromPres : $resource('/rest/prescriptionPastDisease/delete/:presPastDiseaseID', {}, {
            'query':  {
                method:'DELETE',
                isArray:false,
                params: {presPastDiseaseID: '@presPastDiseaseID'}
            }
        }),
        addPassHistoryInPres : $resource('/rest/prescriptionPastDisease/add/:patientPastDiseaseID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {patientPastDiseaseID: '@patientPastDiseaseID', appointmentID: '@appointmentID'}
            }
        }),

        /////////////////// Past history end /////////////////////////////////////////

    /////////////////// Drug history start /////////////////////////////////////////

        getCurrentDrugList : $resource('/rest/patientDrugHistory/getByPatientID/:patientID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {patientID: '@patientID'}
            }
        }),
        saveDrugHistory : $resource('/rest/patientDrugHistory/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDrugHistory : $resource('/rest/patientDrugHistory/delete/:drugHistoryID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {drugHistoryID: '@drugHistoryID'}
            }
        }),
        addDrugPresInPres : $resource('/rest/contentDetail/saveDrugHistory', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteDrugPresFromPres : $resource('/rest/contentDetail/delete/:contentDetailID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {contentDetailID: '@contentDetailID'}
            }
        }),

        /////////////////// Drug history end /////////////////////////////////////////

        getMenu : $resource('/rest/pastHistory/getMenu', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),


        getCustomHistoryDetail : $resource('/rest/doctorHistorySetting/getByPatient/:doctorID/:patientID/:appointmentID/:typeCode', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {doctorID: '@doctorID', patientID: '@patientID', appointmentID: '@appointmentID', typeCode: '@typeCode'}
            }
        }),
        deleteCustomHistory : $resource('/rest/doctorHistorySetting/delete/:historySettingID', {}, {
            'query':  {
                method:'DELETE',
                isArray:false,
                params: {historySettingID: '@historySettingID'}
            }
        }),
        createHistoryToDocPref : $resource('/rest/doctorHistorySetting/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createSettingsOfDocPreference : $resource('/rest/doctorHistorySetting/createSettingsOfDocPreference', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        saveCustomHistory : $resource('/rest/patientHistory/saveCustomHistory', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteHistoryOfPrescription : $resource('/rest/pastHistory/deleteHistoryOfPrescription', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createPrescriptionHistory : $resource('/rest/pastHistory/createPrescriptionHistory', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        })
    };
});

