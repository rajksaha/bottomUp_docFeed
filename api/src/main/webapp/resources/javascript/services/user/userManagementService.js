/**
 * Created by raj on 6/3/2016.
 */

app.service('UserManagementService', function ($resource) {
    return {

        // User Group
        getAllUserGroup: $resource('/rest/userGroup/getAllUserGroup', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        getGroupByCompanyID : $resource('/rest/userGroup/getGroupByCompanyID/companyID/:companyID', {}, {
            'query':  {
                method:'GET',
                params: {companyID : '@companyID'},
                isArray:true
            }
        }),
        saveUserGroup: $resource('/rest/userGroup/save', {}, {
            'query': {
                method: 'POST'
            }
        }),

        updateUserGroup : $resource('/rest/userGroup/update', {}, {
            'query': {
                method  : 'POST'
            }
        }),

        deleteUserGroup: $resource('/rest/userGroup/delete/:userGroupID', {}, {
            'remove': {
                method: 'DELETE',
                params  : {userGroupID: '@userGroupID'}
            }
        }),
        getUserGroup: $resource('/rest/user/getUserGroupForUser', {}, {
            'query': {
                method: 'POST',
                isArray:true
            }
        }),
        updateUserGroupAssignment: $resource('/rest/user/updateUserGroupAssignment', {}, {
            'query': {
                method: 'POST',
                isArray:false
            }
        }),
        getCompanyModulePermission: $resource('/rest/groupPermission/getCompanyModulePermission', {}, {
            'query': {
                method: 'POST',
                isArray:true
            }
        }),
        updateGroupPermission: $resource('/rest/groupPermission/updateGroupPermission', {}, {
            'query': {
                method: 'POST'
            }
        }),
        getDoctorCategory: $resource('/rest/contentDoctorCategory/getByParam', {}, {
            'query': {
                method: 'GET',
                isArray:true
            }
        }),
        getCompanyDoctor : $resource('/rest/doctor/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        })



    };
});
