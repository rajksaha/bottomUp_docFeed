app.controller('PrescriptionController.PrescribeDietController', function($scope, $http, $modalInstance, limitToFilter, $filter, record, DietService) {

    $scope.dietData = {};

    if(record.dietData.id){
        $scope.dietData = record.dietData;
    }else{
        $scope.dietData = {};
    }
    $scope.dietNameData = {};

    $scope.diagnosisNote = "";

    $scope.save = function(){

        if(validator.validateForm("#validateReq","#lblMsg_modal",null)) {

            var dataString = "";
            if($scope.dietData.id){

                dataString = "query=" + 3 + '&dietName=' + $scope.dietData.dietName + '&id=' + $scope.dietData.id;

            }else{
                dataString = "query=" + 2 + '&dietName=' + $scope.dietData.dietName;
            }

            DietService.setAndInContentDetail.query({}, dataString).$promise.then(function(result) {
                if (result && result.success) {
                    $modalInstance.close(true);
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

    $scope.getDiet = function(term) {

        var dataString = "query=" + 0 + "&data=" + term;

        return $http({
            method: 'POST',
            url: "rest/autoComplete/diet",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function(result) {
            $scope.dietNameData = result.data;
            return limitToFilter($scope.dietNameData, 10);
        });
    };

    $scope.onSelectDisease = function(item, model, label){
        $scope.dietData.dietName = item.name;
    };


});