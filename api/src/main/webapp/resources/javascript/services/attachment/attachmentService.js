/**
 * Created by raj on 02/12/21.
 */

app.service('AttachmentService', function ($resource) {
    return {
        getAll : $resource('/rest/attachment/getAll/entity/:entityType/entityID/:entityID', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        save : $resource('/rest/attachment/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        savePatientImage : $resource('/rest/attachment/savePatientImage', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        delete : $resource('/rest/attachment/delete/:attachmentID', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        }),
        download : $resource('/rest/attachment/download/:attachmentId', {}, {
            'query':  {
                method:'GET',
                isArray:false,
                params: {attachmentId: '@attachmentId'}
            }
        }),
        verify : $resource('/rest/attachment/verify/:attachmentID', {}, {
            'query':  {
                method:'GET',
                isArray:false
            }
        })
    };
});
