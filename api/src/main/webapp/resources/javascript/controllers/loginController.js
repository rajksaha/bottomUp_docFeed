app.controller('LoginController', function($scope, $rootScope, $filter, $state, $http, $timeout, $location, ApplicationService) {

	$scope.username = "";
	$scope.password = "";
	$scope.userNotexist = false;
	$scope.passwordErr = false;
	$scope.error = false;
	$scope.errorMessage = "";
	$scope.slideImages = [];	
	var data1 = {"contentURL":'resources/images/slides/slide1.jpg'};
	var data2 = {"contentURL":'resources/images/slides/slide2.jpg'};
	var data3 = {"contentURL":'resources/images/slides/slide3.jpg'};
	var data4 = {"contentURL":'resources/images/slides/slide4.jpg'};
	var data5 = {"contentURL":'resources/images/slides/slide5.jpg'};
	var data6 = {"contentURL":'resources/images/slides/slide6.jpg'};
	var data7 = {"contentURL":'resources/images/slides/slide7.jpg'};
	//$scope.slideImages = {"contentURL":'images/slides/slide1.jpg',"contentURL":'images/slides/slide1.jpg',"contentURL":'images/slides/slide1.jpg',"contentURL":'images/slides/slide1.jpg',"contentURL":'images/slides/slide1.jpg'};
	
	$scope.slideImages.push(data1);
	$scope.slideImages.push(data2);
	$scope.slideImages.push(data3);
	$scope.slideImages.push(data4);
	$scope.slideImages.push(data5);
	$scope.slideImages.push(data6);
	$scope.slideImages.push(data7);
	
	$timeout(function() {
		angular.element('#slides').superslides({
			play: 5000,
			animation: 'fade',
			pagination: true
		});
    }, 100);


    $scope.credentials = {};
    $scope.login = function () {
        if(validator.validateForm("#loginFormID",".validatorMsg",null)) {
            $scope.$emit('event:loginRequest', $scope.credentials.username, $scope.credentials.password, function() {
                ApplicationService.getAppData.query().$promise.then(function(result) {
                    $rootScope.userData = result.userData;
                    if($rootScope.userData.permissions.SUPER_ADMIN || $rootScope.userData.permissions.COMPANY_ADMIN){
                        $state.go('root.userHome');
					}else{
                        $state.go('root.appointment');
					}
                });
            });
        }

    };


    $scope.forgetPassword = function(){
        $state.go('forgetPassword');
    };

    if($rootScope.userData && $rootScope.userData.userID && $rootScope.userData.userID > 0){
        $state.go('root.appointment');
    }
}); 