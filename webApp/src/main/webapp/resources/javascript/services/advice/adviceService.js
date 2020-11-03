/**
 * Created by joy on 17/10/2020.
 */

app.service('AdviceService', function ($resource) {
    return {

        createAdvice : $resource('rest/advice/createAdvice', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createDoctorPreference: $resource('rest/advice/createDoctorPreference', {}, {
            'save': {
                method: 'POST',
                isArray: false
            }
        }),
        delAdviceSettings : $resource('rest/advice/delAdviceSettings/:adviceSettingID', {}, {
            'remove':  {
                method:'DELETE',
                params: {adviceSettingID: '@adviceSettingID'}
            }
        }),
        createAdviceToPresciption: $resource('rest/advice/createAdviceToPresciption', {}, {
            'save': {
                method: 'POST',
                isArray : false
            }
        }),
        delPrescibtionAdvice : $resource('rest/advice/delPrescibtionAdvice/:adviceID', {}, {
            'remove':  {
                method:'DELETE',
                params: {adviceID: '@adviceID'}
            }
        }),
        getPrescribedAdvice : $resource('rest/advice/getPrescribedAdvice', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        getDoctorInfo : $resource('rest/advice/getDoctorInfo', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        }),
        delDoctorAdvice : $resource('rest/advice/delDoctorAdvice/:adviceName/:pdf/:lang', {}, {
            'remove':  {
                method:'DELETE',
                params: {adviceName: '@adviceName', pdf: '@pdf', lang: '@lang'}
            }
        }),
    };
});