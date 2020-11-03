/**
 * Created by joy on 20/10/2020.
 */

app.service('PrescribeByDiseaseService', function ($resource) {
    return {

        getDoctor : $resource('rest/prescribeByDisease/getDoctor', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getAndCreateDisease : $resource('rest/prescribeByDisease/getAndCreateDisease', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getSettingsDrug : $resource('rest/prescribeByDisease/getSettingsDrug', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getSettingsInv : $resource('rest/prescribeByDisease/getSettingsInv', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getSettingsAdvice : $resource('rest/prescribeByDisease/getSettingsAdvice', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        deleteSettingsAdvice : $resource('rest/prescribeByDisease/deleteSettingsAdvice/:advciceSettingID', {}, {
            'remove':  {
                method:'DELETE',
                params: {advciceSettingID: '@advciceSettingID'}
            }
        }),
        deleteSettingsInv : $resource('rest/prescribeByDisease/deleteSettingsInv/:invSettingID', {}, {
            'remove':  {
                method:'DELETE',
                params: {invSettingID: '@invSettingID'}
            }
        }),
        deleteSettingsDrugs : $resource('rest/prescribeByDisease/deleteSettingsDrugs/:drugSettingID', {}, {
            'remove':  {
                method:'DELETE',
                params: {drugSettingID: '@drugSettingID'}
            }
        }),
        getCategoryInv : $resource('rest/prescribeByDisease/getCategoryInv', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getInvAndDoctorInv : $resource('rest/prescribeByDisease/getInvAndDoctorInv', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        deleteInvSetting : $resource('rest/prescribeByDisease/deleteInvSetting/:invSettingId', {}, {
            'remove':  {
                method:'DELET',
                params: {invSettingId: '@invSettingId'}
            }
        }),
        createInvSetting : $resource('rest/prescribeByDisease/createInvSetting', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteAdviceSetting : $resource('rest/prescribeByDisease/deleteAdviceSetting/:settingID', {}, {
            'remove':  {
                method:'DELETE',
                params: {settingID: '@settingID'}
            }
        }),
        createAdviceSetting : $resource('rest/prescribeByDisease/createAdviceSetting', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createAdviceSettingByname : $resource('rest/prescribeByDisease/createAdviceSettingByname', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        getAdviceOfDoctor : $resource('rest/prescribeByDisease/getAdviceOfDoctor', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        })
    };
});

