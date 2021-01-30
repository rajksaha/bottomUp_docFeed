/**
 * Created by joy on 18/10/2020.
 */

app.service('FollowUpSetupService', function ($resource) {
    return {

        getPatientType : $resource('/api/rest/patientType/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getFollowUpView : $resource('/api/rest/followUpResult/getFollowUpView/:doctorID/:patientID/:patientTypeID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {doctorID: '@doctorID', patientID: '@patientID', patientTypeID: '@patientTypeID', appointmentID: '@appointmentID'}
            }
        }),
        getFollowUpChart : $resource('/api/rest/doctorFollowUpSetting/getByPatientType/:doctorID/:patientTypeID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {doctorID: '@doctorID', patientTypeID: '@patientTypeID'}
            }
        }),
        create : $resource('/api/rest/doctorFollowUpSetting/create', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delete : $resource('/api/rest/doctorFollowUpSetting/delete/:followUpSettingID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {followUpSettingID: '@followUpSettingID'}
            }
        }),
        updateDisplayOrder : $resource('/api/rest/doctorFollowUpSetting/updateDisplayOrder', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createPatientType : $resource('/api/rest/patientType/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updatePatientType : $resource('/api/rest/patientType/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deletePatientType : $resource('/api/rest/patientType/delete/:patientTypeID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {patientTypeID: '@patientTypeID'}
            }
        })
    };
});

