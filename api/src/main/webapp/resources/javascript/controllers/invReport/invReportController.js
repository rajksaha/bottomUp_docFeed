app.controller('invReportController', function($scope, $http, $modal, $rootScope, limitToFilter, $location, $upload,
                                               $filter,InvReportService, AttachmentService, $window) {
	
	$scope.patientData = {};
	$scope.oldAppoinmentList =[];
	$scope.invReportList = [];
	$scope.appoinmentData ={};
	$scope.patientStateList = [];

	$scope.sliceFileName = function(attachment){
	    var displayString = attachment.shortName;
        if(displayString.length > 20){
            displayString = displayString.substring(0, 12) + "..." +attachment.fileType;
        }
        return displayString;
    };
	
	$scope.bringPatientInfo = function(){
		var dataString = "query=0";
        InvReportService.getAppointmentDetail.query({}, {}).$promise.then(function(result) {
            $scope.appointmentData = result;
            $scope.bringPatientOldReport();
        });
	};

    
	$scope.bringPatientOldReport = function (){
        InvReportService.getDateInvReport.query({}, {patientID:$scope.appointmentData.patientID}).$promise.then(function (result) {
            $scope.oldReportList = result;
            if ($scope.oldReportList.length > 0) {
                $scope.invReportList = $scope.oldReportList[0];
                $scope.getInvReports($scope.oldReportList[0].reportDate, $scope.oldReportList[0].reportList);
            }
        });
    };
    
    $scope.getInvReports = function(reportDate, reportList){
        $scope.prescriptionViewDate = reportDate;
        $scope.invReportList = reportList;
        $scope.displayAttachment(reportList[0]);
    };

    $scope.displayAttachment = function (report) {
        var lastFile = report;
        if(lastFile.fileType == 'jpg' || lastFile.fileType == 'png' || lastFile.fileType == 'jpeg'){
            $scope.imageView = true;
            $scope.pdfView = false;
            $scope.imageLink = lastFile.contentUrl;

        }else{
            $scope.imageView = false;
            $scope.pdfView = true;
            $scope.imageLink = lastFile.contentUrl;
            $window.open(lastFile.contentUrl, '_blank');
        }
        $scope.showPrescriptionView = true;
    };



    $scope.addInvReport = function(){
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/invReport/addNewReport.html',
            windowClass: 'center-modal',
            controller: 'invReportController.AddReportController',
            resolve: {
                patientID: function () {
                    return $scope.appointmentData.patientID;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPatientOldReport();
        });
    };

	$scope.inIt = function (){
		$scope.bringPatientInfo();
		
	};
	
	(function(){
		$scope.inIt();
    })()

	
});

app.controller('invReportController.AddReportController', function($scope, $modalInstance, $http, patientID, $upload, $filter, AttachmentService) {

    $scope.reportDate = new Date();
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

        if($.inArray(extension, ['png','jpg','jpeg','zip','rar','pdf','xls','xlsx','doc','docx','ppt','pptx','csv']) == -1) {
            $scope.showErrorMessage("Supported file formats are png, jpg, jpeg, zip, rar, pdf, xls, xlsx, doc, docx, ppt, pptx and csv.");
            return false;
        }

        var fileSize = $scope.file.size / 1048576 ;
        if(fileSize > 5){
            $scope.showErrorMessage("Maximum file size limit is 5 MB");
            return false;
        }

        var model = {
            extension:extension,
            entityType :"INV_REPORT",
            entityID : patientID,
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
            $scope.uploading = false;
        }, function(response) {
            $scope.uploading = false;
        }, function(evt) {

        });
    };


    $scope.save = function (){
        if($scope.attachment && $scope.attachment.contentUrl){
            $scope.attachment.entityDate = $filter('date')($scope.reportDate, "yyyy-MM-dd");
            AttachmentService.save.query($scope.attachment).$promise.then(function(result) {
                $modalInstance.close(true);
            });
        }else{

        }
    };

    $scope.cancel = function (){
        $modalInstance.dismiss('cancel');
    };


});