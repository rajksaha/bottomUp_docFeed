/**
 * Created by joy on 21/15/2020.
 */

app.service('DiagnosisService', function ($resource) {
    return {

        getDiseaseInDiagnosis : $resource('rest/diagnosis/getDiseaseInDiagnosis', {}, {
            'query':  {
                method:'POST',
                isArray:true
            }
        })
    };
});

