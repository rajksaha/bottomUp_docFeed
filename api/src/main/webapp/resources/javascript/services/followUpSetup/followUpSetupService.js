/**
 * Created by joy on 18/10/2020.
 */

app.service('FollowUpSetupService', function ($resource) {
    return {

        getPatientType : $resource('/rest/patientType/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getFollowUpView : $resource('/rest/followUpResult/getFollowUpView/:doctorID/:patientID/:patientTypeID/:appointmentID', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {doctorID: '@doctorID', patientID: '@patientID', patientTypeID: '@patientTypeID', appointmentID: '@appointmentID'}
            }
        }),
        getFollowUpChart : $resource('/rest/doctorFollowUpSetting/getByPatientType/:doctorID/:patientTypeID', {}, {
            'query':  {
                method:'GET',
                isArray:true,
                params: {doctorID: '@doctorID', patientTypeID: '@patientTypeID'}
            }
        }),
        create : $resource('/rest/doctorFollowUpSetting/create', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delete : $resource('/rest/doctorFollowUpSetting/delete/:followUpSettingID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {followUpSettingID: '@followUpSettingID'}
            }
        }),
        updateDisplayOrder : $resource('/rest/doctorFollowUpSetting/updateDisplayOrder', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        createPatientType : $resource('/rest/patientType/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updatePatientType : $resource('/rest/patientType/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deletePatientType : $resource('/rest/patientType/delete/:patientTypeID', {}, {
            'remove':  {
                method:'DELETE',
                isArray:false,
                params: {patientTypeID: '@patientTypeID'}
            }
        })
    };
});

