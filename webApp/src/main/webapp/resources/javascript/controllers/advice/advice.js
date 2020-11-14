app.controller('PrescribeAdviceController', function($scope, $http, $modal, $rootScope, limitToFilter, $modalInstance, appointmentData, DoctorService, PresSaveService) {
	

	$scope.adviceSettingData = {};
	$scope.selectedInvID = 0;
	$scope.advcieSettingData = [];
	$scope.adviceAdderData = {};
	$scope.invAdderData = {};
	$scope.addByName = false;
	
	$scope.doctorData = {};

    $scope.prescription = function () {
        $modalInstance.close(true);
    };
	
	$scope.adviceAdderData.lang = 0;

    $scope.getAdvcieName = function(term) {
        
    	var dataString = 'query=0'+ '&adviceName=' + term + '&lang=' + $scope.adviceAdderData.lang + '&type=' + $scope.doctorData.category;
        
        return $http({
            method: 'POST',
            url: "rest/autoComplete/advice",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function(result) {
        	$scope.invNameData = result.data;
        	return limitToFilter($scope.invNameData, 10);
        });

        
       // return $scope.products;
      };
      
	  $scope.onSelectAdviceName = function(item, model, label){
		  $scope.adviceAdderData.advcieID = item.id;
		  $scope.addByName = true;
	  };
	  
	$scope.prepareDoctorSettingData = function (addAnother){
		
		if(!$scope.addByName){
            var dataString = 'query=2'+ '&adviceName=' + $scope.adviceAdderData.name + '&type=' + $scope.doctorData.category + '&pdf=' + $scope.adviceAdderData.pdf + '&lang=' + $scope.adviceAdderData.lang;

            PresSaveService.createAdvice.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    if(addAnother){
                        $scope.adviceAdderData = {};
                        $scope.adviceAdderData.lang = 0;
                    }else{
                        $scope.addToDoctorPreference(result);
                    }
                } else {
                }
            });
			
		}else{
			
			$scope.addToDoctorPreference($scope.adviceAdderData.advcieID);
		}
	};
	
	$scope.addToDoctorPreference = function (adviceID){
		var displayOrder = 1;
		if($scope.advcieSettingData != undefined && $scope.advcieSettingData.length > 0){
			displayOrder = parseInt($scope.advcieSettingData[$scope.advcieSettingData.length -1].displayOrder) + 1;
		}
		var dataString = 'query=3'+ '&adviceID=' + parseInt(adviceID) + '&displayOrder=' + displayOrder;
		
		PresSaveService.createDoctorPreference.query({}, dataString).$promise.then(function (result) {
			if (result && result.success) {
				$scope.bringPrescribedAdvice();	
			} else {
			}
		});
		
	};
	
	$scope.delAdviceFromSetting = function (adviceSettingID){
		
		var dataString = 'query=6'+ '&adviceSettingID=' + adviceSettingID;
		
		PresSaveService.delAdviceSettings.query({}, dataString).$promise.then(function (result) {
			if (result && result.success) {
				$scope.bringPrescribedAdvice();
			} else {
			}
		});
	};
	
	$scope.deciderAdvice = function (addedInPrescription,advice){
		
		advice.addedToPrescription = addedInPrescription;
		if(addedInPrescription){
			$scope.addToPres(advice.adviceID);
		}else{
			$scope.deleteAdviceFromPrescibtion(advice.adviceID);
		}
	};
	
	$scope.addToPres = function (adviceID){
		PresSaveService.saveAdviceFromPref.query({}, {appointmentID: appointmentData.appointmentID, adviceID: adviceID}).$promise.then(function (result) {
            //$scope.bringPrescribedAdvice();
		});
	};
	
	$scope.deleteAdviceFromPrescibtion = function (adviceId){
		
		var dataString = 'query=5'+ '&adviceID=' + parseInt(adviceId);
		
		PresSaveService.delPrescibtionAdvice.query({}, dataString).$promise.then(function (result) {
            //$scope.bringPrescribedAdvice();
		});
	};

	$scope.bringPrescribedAdvice = function (){
		$scope.doctorPrefAdviceList = [];
		$scope.adviceAdderData.lang = 0;
        DoctorService.getDoctorPrefAdvice.query({}, {doctorID: appointmentData.doctorID, appointmentID : appointmentData.appointmentID}).$promise.then(function (result) {
            $scope.doctorPrefAdviceList = result;
		});
	};

    $scope.addAdvice = function (){
    		
    		var prescription = {};
    		var modalInstance = $modal.open({
    	        templateUrl: 'javascript/templates/advice/addAdviceModal.html',
    	        windowClass: 'fade in',
    	        
    	        controller: 'PrescribeAdviceController.AddAdvcieToDB',
    	        resolve: {
                    prescription: function () {
                        return prescription;
                    }
    	        },
    	        backdrop: 'static'
    	    });
    	    modalInstance.result.then(function(result) {
    	    	$scope.bringAdviceSettingData($scope.masterDiseaseData.diseaseID);
    	     });
    	    
    };

    $scope.inIt = function (){
        $scope.bringPrescribedAdvice();
    };

    $scope.inIt();

	
});

app.controller('PrescribeAdviceController.AddAdvcieToDB', function($scope, $modalInstance, data, $window, $location,limitToFilter, AdviceService) {
	
	$scope.postData = data;
	
	$scope.langSelector = 0;

	$scope.saveNewAdvice = function (){
			if(validator.validateForm("#validateReq","#lblMsg_modal",null)) {
				var dataString = "query=7" + "&adviceName=" + $scope.name + '&pdf=' + $scope.code + '&lang=' + $scope.langSelector;
				
				AdviceService.delDoctorAdvice.query({}, dataString).$promise.then(function (result) {
					if (result && result.success) {
						$modalInstance.dismiss('cancel');
					} else {
					}
				});
		        
			}else{
				$scope.error = true;
			}
		
    };
    
    

	
	$scope.cancel = function (){
		$modalInstance.dismiss('cancel');
	};
	
	
	
	
});