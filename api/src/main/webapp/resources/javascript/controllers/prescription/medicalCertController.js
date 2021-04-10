app.controller('PrescriptionController.MedicalCertController', function($scope, $http, $window, $modalInstance, limitToFilter,
                                                                        $filter, appointmentID, PrescriptionService, PresSaveService) {

    $scope.medicalCertData = {};

    PrescriptionService.getMedicalReport.query({appointmentID:appointmentID},  $scope.dietData).$promise.then(function(result) {
        if(result && result.medicalCertID){
            $scope.medicalCertData = result;
        }else{
            $scope.medicalCertData.appointmentID = appointmentID;
            $scope.medicalCertData.startDate = new Date();
            $scope.medicalCertData.endDate = new Date();
        }

    });

    $scope.save = function(){
        if(validator.validateForm("#validateReq","#lblMsg_modal",null)) {
            if($scope.medicalCertData.medicalCertID){
                PresSaveService.updateMedCert.query({},  $scope.medicalCertData).$promise.then(function(result) {
                    $modalInstance.close(true);
                });
            }else{
                PresSaveService.createMedCert.query({},  $scope.medicalCertData).$promise.then(function(result) {
                    $scope.medicalCertData = result;
                });
            }
        }else{
            $scope.error = true;
        }
    };

    $scope.printMedicalCert = function(){
        $window.open("http://localhost/prescription/api/medChart.php?appointmentID=" + appointmentID, '_blank');
    };

    $scope.cancel = function(){
        $modalInstance.dismiss('cancel');
    };
});