app.controller('FollowUpSetupController', function($scope, $http, $modal, $filter, $rootScope, limitToFilter, $location,
                                                   FollowUpSetupService) {

	$scope.invNameData = [];
	$scope.invData = {};
	$scope.invFollowUpChart = [];
	$scope.followUpChartData = [];
	$scope.recentStart = 0;
	$scope.recentEnd = 0;
	$scope.patientAppoinmentList = [];
	$scope.patientTypeID = null;
    $scope.followUpInvName = "";
    $scope.doctorTypeId = null;
	
	$scope.typeHeadSelected = false;

    $scope.vm = {
        list: []
    };
	
    $scope.getInvName = function(term) {
        
    	var dataString = {};
    	dataString.term = term;
        
        return $http({
            method: 'POST',
            url: "/api/rest/autoComplete/inv",
            data: dataString
        }).then(function(result) {
        	$scope.invNameData = result.data;
        	return limitToFilter($scope.invNameData, 10);
        });

        
       // return $scope.products;
      };

    $scope.getPatientType = function () {
        FollowUpSetupService.getPatientType.query({}, {}).$promise.then(function(result) {
            $scope.patientTypeList = result;
        });
    };
      
	  $scope.onSelectInvName = function(item, model, label){
		  $scope.invData.id = item.id;
          $scope.followUpInvName = item.name;
		  $scope.typeHeadSelected = true;
	  };

	  $scope.addInvToFollowUp = function(followUpInvName){

	      if(followUpInvName == ""){
            alert("Please Key-in Inv Name to proceed");
            return false;
          }
          var dataString = {};
          dataString.invName = followUpInvName;
          dataString.patientTypeID = $scope.patientTypeID;
          dataString.doctorID = $rootScope.userData.profileData.doctorData.doctorID;
            FollowUpSetupService.create.query({}, dataString).$promise.then(function(result) {
                $scope.followUpInvName = "";
                $scope.bringFollowUpChart($scope.patientTypeID);
            });
	  };
	  
	  $scope.delete = function(followUpSettingID){
            FollowUpSetupService.delete.remove({}, {followUpSettingID:followUpSettingID}).$promise.then(function(result) {
                $scope.bringFollowUpChart($scope.patientTypeID);
            });
	  };

	  $scope.bringFollowUpChart = function (patientTypeID) {
          $scope.followUpInvName = "";
          $scope.patientTypeID = patientTypeID;

          FollowUpSetupService.getFollowUpChart.query({}, {doctorID:$rootScope.userData.profileData.doctorData.doctorID,
              patientTypeID: patientTypeID}).$promise.then(function (result) {
              $scope.followUpList = result;

              $scope.vm = {
                  list: $scope.followUpList
              };
          });
      };

    $scope.$watch('vm', function(newValue, oldValue) {
        if (oldValue && oldValue.list && oldValue.list.length > 0 && newValue !== oldValue) {

            var dOrder = 1;
            angular.forEach(newValue.list, function (value, key) {
                value.displayOrder = dOrder++;
            });
            var searchData = {};
            searchData.followUpSettingList = $scope.filterByDifference(oldValue.list, newValue.list);
            $scope.followUpList = newValue.list;

            if(searchData.followUpSettingList && searchData.followUpSettingList.length > 0){
                FollowUpSetupService.updateDisplayOrder.query({}, searchData).$promise.then(function (result) {});
            }
        }
    }, true);

    $scope.filterByDifference = function (array1, array2) {
        var array3 = [];
        angular.forEach(array1, function(value1, key1) {
            var item = $filter('filter')(array2, {followUpSettingID: value1.followUpSettingID}, true)[0];
            if(item && item.displayOrder != value1.displayOrder){
                var data ={};
                data.followUpSettingID = item.followUpSettingID;
                data.displayOrder = item.displayOrder;
                array3.push(data);
            }
        });

        return array3;
    };
	  
	  
	$scope.inIt = function (){
        $scope.getPatientType();
	};

    $scope.managePatientType = function () {
        var data = {};
        data.patientTypeList = angular.copy($scope.patientTypeList);
        data.doctorTypeID = $rootScope.userData.profileData.doctorData.categoryID;
        var patientTypeData = {};
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/patient/patientType.html',
            windowClass: 'fade in',
            size: 'sm',
            controller: 'PatientTypeController',
            resolve: {
                    record: function () {
                        return data;
                    }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.getPatientType();
        });
    };

	$scope.inIt();

	
});