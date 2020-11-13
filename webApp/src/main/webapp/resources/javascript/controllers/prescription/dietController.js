app.controller('PrescriptionController.PrescribeDietController', function($scope, $http, $modalInstance, limitToFilter, $filter, dietData, PresSaveService) {

    $scope.dietData = {};

    if(dietData != null && dietData.id){
        $scope.dietData = dietData;
    }
    $scope.save = function(){
        if(validator.validateForm("#validateReq","#lblMsg_modal",null)) {
            var dataString = {};
            PresSaveService.setAndInContentDetail.query({}, dataString).$promise.then(function(result) {
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