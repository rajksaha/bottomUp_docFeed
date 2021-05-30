/**
 * Created by raj on 1/6/16.
 */

app.controller('MenuController', function($scope, $state, $modal, $rootScope) {
    $scope.changeState = function (url){
        $state.go(url);
        $('.sidebar,.sidebar-container').removeClass('active'); $('body').removeClass('sidebar-active');
    };

    $scope.changePassword = function(){
        $('.sidebar,.sidebar-container').removeClass('active'); $('body').removeClass('sidebar-active');
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/user/changePasswordModal.html',
            controller: 'ChangePasswordModal',
            backdrop: "static",
            windowClass: 'fade in ',
            resolve: {
                modalConfig: function () {
                    return $rootScope.userData;
                }
            }
        });

        modalInstance.result.then(function(result) {
            $scope.hasError = false;
            $scope.hasSuccess = true;
            $scope.message = result;
        });

    };
});

app.controller('ChangePasswordModal', function($scope, $modalInstance, $timeout, $filter, $rootScope, modalConfig, UserSetupService) {

    $scope.userData = modalConfig;



    $scope.save = function(){

        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            var userData = {};
            userData.password = $scope.password;
            userData.userID = $scope.userData.userID;
            UserSetupService.updateUserPassword.query({}, userData).$promise.then(function(result) {
                if(result && result.success) {

                    $modalInstance.close("Password changed Successfully");
                } else {
                }
            });
        }
    };
    $scope.cancel = function (){
        $modalInstance.dismiss('cancel');
    };


});
