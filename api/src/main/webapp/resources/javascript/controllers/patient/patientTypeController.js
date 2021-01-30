app.controller('PatientTypeController', function($scope, $http, $modalInstance, limitToFilter, $filter, record, FollowUpSetupService) {
    $scope.patientTypeList = record.patientTypeList;
    $scope.globalAdd = true;
    $scope.doctorTypeID = record.doctorTypeID;

    if(!$scope.patientTypeList || $scope.patientTypeList.length == 0){
        var emptyData = {};
        emptyData.editMode = true;
        $scope.patientTypeList.push(emptyData);
        $scope.globalAdd = false;
    }

    $scope.itemSave = function (patientType) {
        if(!patientType.typeName){
            $scope.error = true;
            $scope.errorMessage = "Name is mandatory";
            return false;
        }
        var patientTypeData = {};
        patientTypeData.typeName = patientType.typeName;
        patientTypeData.doctorType = $scope.doctorTypeID;
        if(patientType.patientTypeID){
            patientTypeData.patientTypeID = patientType.patientTypeID;
            FollowUpSetupService.updatePatientType.query({}, patientTypeData).$promise.then(function (result) {
                patientType.editMode = false;
            });
        }else{
            FollowUpSetupService.createPatientType.query({}, patientTypeData).$promise.then(function (result) {
                patientType.patientTypeID = result.patientTypeID;
                patientType.editMode = false;
            });
        }
        $scope.globalAdd = true;
        $scope.error = false;
    };

    $scope.deletePatientType = function (patientTypeID, index) {
        FollowUpSetupService.deletePatientType.remove({}, {patientTypeID:patientTypeID}).$promise.then(function (result) {
            $scope.patientTypeList.splice(index, 1);
        });
    };

    $scope.add = function () {
        var emptyData = {};
        emptyData.editMode = true;
        $scope.patientTypeList.push(emptyData);
        $scope.globalAdd = false;
    };

    $scope.cancel = function () {

        if(!$scope.globalAdd){
            $scope.patientTypeList.splice($scope.patientTypeList.length - 1, 1);
        }
        $modalInstance.close($scope.patientTypeList);
    };
});