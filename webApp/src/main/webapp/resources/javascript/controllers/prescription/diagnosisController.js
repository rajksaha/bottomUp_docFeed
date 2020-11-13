app.controller('PrescriptionController.PrescribeDiagnosisController', function($scope, $http, $modalInstance, limitToFilter, $filter, diagnosisData, PresSaveService) {

    $scope.diagnosisData = {};

    if($scope.diagnosisData.diagnosisID){
        $scope.diagnosisData = diagnosisData;
    }

    $scope.save = function(){
        if(validator.validateForm("#validateReq","#lblMsg_modal",null)) {
            PresSaveService.saveDiagnosis.query({}, $scope.diagnosisData).$promise.then(function(result) {
                if (result && result.success) {
                    $modalInstance.close();
                }else{
        
                }
            });
        }else{
            $scope.error = true;
        }
    };

    $scope.cancel = function(){
        $modalInstance.dismiss('cancel');
    };

    $scope.getDisease = function(term) {
        var dataString = {};
        dataString.term = term;

        return $http({
            method: 'POST',
            url: "/api/rest/autoComplete/disease",
            data: dataString
        }).then(function(result) {
            $scope.diagnosisNameData = result.data;
            return limitToFilter($scope.diagnosisNameData, 10);
        });
    };


});