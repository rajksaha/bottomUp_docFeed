/**
 * Created by raj on 5/21/2016.
 */
app.controller('GroupAdviceController', function($scope, $rootScope, $modal, $http, $timeout, $location, GroupAdviceService) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.adviceTemplate = {};
    $scope.showForm = false;
    $scope.editObj = {};
    $scope.attachmentList = [];

    $scope.getGroupAdvice = function () {
        GroupAdviceService.getGroupAdvice.query().$promise.then(function(result) {
            $scope.attachmentList = result;
        });
    };

    $scope.delete = function(attachmentID, contentUrl){
        var attach = {};
        attach.attachmentID = attachmentID;
        var data = contentUrl.split("https://docfeedimagebucket.s3.ap-southeast-1.amazonaws.com/")[1];
        attach.shortName = data.replaceAll("%5C","\\");
        GroupAdviceService.delete.remove(attach).$promise.then(function(result) {
            $scope.getGroupAdvice();
        });
    };

    $scope.getGroupAdvice();

    $scope.add = function () {
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/advice/groupAdviceUploadModal.html',
            windowClass: 'fade in',
            size: 'sm',
            controller: 'GroupAdviceController.PrescribeDiagnosisController',
            resolve: {
                entityID: function () {
                    return $rootScope.userData.profileData.doctorData.doctorID;
                },
                entityType: function () {
                    return "GROUP_ADVICE";
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.getGroupAdvice();
        });
    };
});

app.controller('GroupAdviceController.PrescribeDiagnosisController', function($scope, $modalInstance, $http, entityID,
                                                                              entityType, $upload, $filter, AttachmentService) {

    $scope.templateName = null;
    $scope.error = false;
    $scope.errorMessage = "";

    $scope.showErrorMessage = function (message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.hideErrorMessage = function (message) {
        $scope.error = false;
        $scope.errorMessage = "";
    };

    $scope.onFileSelect = function($files){
        $scope.hideErrorMessage();
        $scope.file = $files[0];
        var extension = $scope.file.name.split('.').pop().toLowerCase();

        if($.inArray(extension, ['png','jpg','jpeg']) == -1) {
            $scope.showErrorMessage("Supported file formats are png, jpg and jpeg.");
            return false;
        }

        var fileSize = $scope.file.size / 1048576 ;
        if(fileSize > 5){
            $scope.showErrorMessage("Maximum file size limit is 5 MB");
            return false;
        }

        var model = {
            extension:extension,
            entityType :entityType,
            entityID : entityID,
            description: ''
        };

        $scope.uploading = true;
        $upload.upload({
            url : '/rest/attachment/upload',
            method: 'POST',
            data :model,
            file: $scope.file
        }).then(function(response) {
            $scope.attachment = response.data.attachment;
            $scope.uploading = false;
        }, function(response) {
            $scope.uploading = false;
        }, function(evt) {

        });
    };


    $scope.save = function (){
        if($scope.templateName && $scope.attachment && $scope.attachment.contentUrl){
            $scope.attachment.description = $scope.templateName;
            AttachmentService.save.query($scope.attachment).$promise.then(function(result) {
                if(result){
                    $modalInstance.close(true);
                }
            });
        }else{
            $scope.showErrorMessage("Template Name and Image both are mandatory");
        }
    };

    $scope.cancel = function (){
        $modalInstance.dismiss('cancel');
    };


});