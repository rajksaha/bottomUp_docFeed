app.controller('AttachmentController', function($scope,$rootScope, $http, $timeout, patientData, $upload,
                                                $modal, $location,AttachmentService, $modalInstance) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.isEditMode = false;

    /*****************************
     * Attachment Functionality
     *****************************/
    $scope.attachmentList = [];
    $scope.attachment = {
        description : ''
    };
    $scope.activeTab = true;
    $scope.uploading = false;

    $scope.file = '';

    $scope.makeSnapshot = function () {
        Webcam.snap( function(data_uri) {
            // display results in page
            document.getElementById('results').innerHTML =
                '<img id="imageprev" src="'+data_uri+'"/>';
        } );
        $scope.photoBooth = false;
        $scope.savePhotoButton = true;
        $scope.clearPhotoButton = true;
        var fileName = patientData.firstName + '.jpg';
        var base64image = dataURLtoFile(document.getElementById("imageprev").src, fileName);
        var files = [];
        files.push(base64image);
        $scope.onFileSelect(files);
    };

    $scope.clearPhoto = function () {
        document.getElementById('results').innerHTML = '';
        $scope.clearPhotoButton = false;
    };

    $scope.configure = function () {
        $scope.imageUpload = false;
        $scope.takePhoto = true;
        $scope.photoBooth = true;
        $scope.clearPhoto();
        $timeout(function() {
            Webcam.set({
                width: 320,
                height: 240,
                image_format: 'jpeg',
                jpeg_quality: 90
            });
            Webcam.attach( '#my_camera' );
            $scope.takePhotoButton = true;
        }, 100); // 5000 ms execution

    };

    $scope.onFileSelect = function($files){
        $scope.hideErrorMessage();
        $scope.file = $files[0];
        var extension = $scope.file.name.split('.').pop().toLowerCase();

        if($.inArray(extension, ['png','jpg','jpeg']) == -1) {
            $scope.showErrorMessage("Supported file formats are png, jpg, jpeg.");
            return false;
        }

        var fileSize = $scope.file.size / 1048576 ;
        if(fileSize > 5){
            $scope.showErrorMessage("Maximum file size limit is 5 MB");
            return false;
        }

        var model = {
            extension:extension,
            entityType :"PATIENT_IMG",
            entityID : patientData.patientID,
            description: ''
        };

        $scope.uploading = true;
        $upload.upload({
            url : '/api/rest/attachment/upload',
            method: 'POST',
            data :model,
            file: $scope.file
        }).then(function(response) {
            $scope.attachment = response.data.attachment;
            /*if($scope.imageUpload){
                $scope.imageURL = "http://file://" + $scope.attachment.contentUrl + "?timestamp=" + new Date().getTime();
                $scope.imageUpload = false;
            }*/
            $scope.uploading = false;
        }, function(response) {
            $scope.uploading = false;
        }, function(evt) {

        });
    };

    $scope.showErrorMessage = function (message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.hideErrorMessage = function (message) {
        $scope.error = false;
        $scope.errorMessage = "";
    };

    $scope.closeModal = function(){
        $modalInstance.close(false);
    };

    $scope.resetInputFile = function() {
        var elems = document.getElementsByTagName('input');
        for (var i = 0; i < elems.length; i++) {
            if (elems[i].type == 'file') {
                elems[i].value = null;
            }
        }
        $scope.attachment = {
            description : ''
        };
    };


    $scope.saveAttachment = function(){
        if($scope.attachment && $scope.attachment.contentUrl) {
            AttachmentService.savePatientImage.query($scope.attachment).$promise.then(function(result) {
                $modalInstance.close(true);
            });
        }else {
            $scope.showErrorMessage("Please Take a Photo or Upload a Photo");
        }
    };

    $scope.inIt = function (){
        if(patientData.imageURL == null){
            $scope.configure();

        }else{
            $scope.imageURL = patientData.imageURL;
        }

    };

    $scope.inIt();

});

function dataURLtoFile(dataurl, filename) {
    var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
    while(n--){
        u8arr[n] = bstr.charCodeAt(n);
    }
    return new File([u8arr], filename, {type:mime});
}