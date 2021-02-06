app.controller('OldPrescriptionController', function($scope, $http, $modal, $filter, $rootScope, limitToFilter, $location,
                                                     PrescriptionService, OldPrescriptionService, JsonService) {
	
	$scope.patientData = {};
	$scope.oldAppointmentList =[];
	$scope.appoinmentData ={};
	$scope.patientStateList = [];
    $scope.prescribedComplainData = [];
    $scope.prescribedMHData = [];
    $scope.prescribedOBSData = [];
    $scope.diagnosisData = {};
    $scope.prescribedComplainData = [];
    $scope.prescribedMHData = [];
    $scope.prescribedOBSData = [];
    $scope.diagnosisData = {};
    $scope.clinicalRecordList = [];
    $scope.historyList = [];
    $scope.appointmentData = {};

    $scope.prescribedAdviceList = [];
    $scope.prescribedInvList = [];
    $scope.prescribedComplainList = [];
	
	$scope.bringAppDetail = function(){
        OldPrescriptionService.getAppointmentDetail.query({}, {}).$promise.then(function (result) {
            $scope.appointmentData = result;
            $scope.bringPatientOldPrescription();
            $scope.bringMenu();
        });
	};

	$scope.bringPatientOldPrescription = function (){
        OldPrescriptionService.getAppointment.query({}, {patientID: $scope.appointmentData.patientID,
            doctorID: $scope.appointmentData.doctorID}).$promise.then(function (result) {
            $scope.oldAppointmentList = result;
            if ($scope.oldAppointmentList.length > 0) {
                $scope.viewPrescription($scope.oldAppointmentList[0]);
            }
        });
    };

    $scope.getComplainString = function (complain) {
        var data = complain.symptomName;
        if(complain.durationType != null && complain.durationType < 5){
            data = data + " " + complain.durationNum + " " + JsonService.dayTypeList[complain.durationType - 1].engName;
        }
        if(complain.durationType == 7){
            data = data + " " + JsonService.dayTypeList[complain.durationType].engName;
        }
        return data;
    };
	
    $scope.bringMenu = function(){
        PrescriptionService.getDoctorMenu.query({}, {doctorID: $scope.appointmentData.doctorID}).$promise.then(function (result) {
            $scope.menuDataList = result;
        });
    };
    $scope.viewPrescription = function (appData) {
        PrescriptionService.getPrescriptionInfo.query({}, {appointmentID: appData.appointmentID}).$promise.then(function (result) {
            $scope.diagnosisData = result.diagnosis;
            $scope.dietData = result.diet;
            $scope.prescribedDrugList = result.drug;
            $scope.prescribedInvList = result.inv;
            $scope.prescribedComplainList = result.complain;
            $scope.prescribedAdviceList = result.advice;
            $scope.prescribedVitalList = result.vital;
            $scope.referredDoctorDataList = result.reference;
            if(!result.reference ||  result.reference.length == 0){
                $scope.referredAdderData = {};
                $scope.referredAdderData.isEmpty = true;
            }
            $scope.pastDiseaseList = $filter('filter')(result.pastDisease, {isPresent: 0}, true);
            $scope.coMorList = $filter('filter')(result.pastDisease, {isPresent: 1}, true);
            $scope.familyDiseaseList = result.familyHistory;
            $scope.currentDrugHistoryList = result.currentDrugHistory;
            $scope.oldDrugHistoryList = result.oldDrugHistory;
            if(result.newtVisit &&  result.newtVisit.length > 0){
                $scope.nextVisitData = result.newtVisit[0];
            }
            $scope.presNoteList = result.comment;
        });
        $scope.bringPrescribedHistory(appData.appointmentID, appData.patientID);
        $scope.bringClinicalRecord(appData.appointmentID);
    	$scope.showPrescriptionView = true;
    	$scope.prescriptionViewDate = appData.appDate;
        $scope.selectedAppointmentID = appData.appointmentID;
    };

    $scope.bringPrescribedHistory = function(appointmentID, patientID){
        angular.forEach($scope.menuDataList, function(value, key) {
            if(value.inPrescription == 2){
                PrescriptionService.getPrescribedHistory.query({}, {patientID: patientID,
                    appointmentID:appointmentID,
                    typeCode: value.defaultName}).$promise.then(function (result) {
                    var historyData = {};
                    historyData.headerName = value.menuHeader;
                    historyData.prescribedHistoryList = result;
                    $scope.historyList.push(historyData);
                });
            }
        });
    };

    $scope.bringClinicalRecord = function (appointmentID) {
        PrescriptionService.getRecordOfClinical.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.clinicalRecordList = result;
            angular.forEach($scope.clinicalRecordList, function(value, key) {
                value.followUpDetailList = angular.fromJson(value.longDesc);
            });
        });
    };

    $scope.addSingle = function (itemCode, itemID){
        OldPrescriptionService.addItemToPres.query({}, {itemCode: itemCode, itemID: itemID,
            newAppointmentID: $scope.appointmentData.appointmentID}).$promise.then(function (result) {

        });
    };

    $scope.addBulk = function (itemCode){
        OldPrescriptionService.addBulkToPres.query({}, {itemCode: itemCode,
            oldAppointmentID: $scope.selectedAppointmentID,
            newAppointmentID: $scope.appointmentData.appointmentID}).$promise.then(function (result) {

        });

    };

    $scope.masterAddToPrescription = function (){
        OldPrescriptionService.copyPrescription.query({}, {oldAppointmentID: $scope.selectedAppointmentID,
            newAppointmentID: $scope.appointmentData.appointmentID}).$promise.then(function (result) {

        });
    };

	$scope.inIt = function (){
		$scope.bringAppDetail();
	};
	
	(function(){
		$scope.inIt();
    })()

	
});


app.controller('OldPrescriptionController.ViewPrescriptionController', function($scope, $modalInstance, data, $http) {
	
	
	$(".modal-dialog").addClass('finalStepWidth');
	angular.element(".modal-dialog").addClass('finalStepWidth');
	$scope.$apply();
	
	
	
	$scope.cancelNewPatient = function (){
		$modalInstance.dismiss('cancel');
	};
	
	
});