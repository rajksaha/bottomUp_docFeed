app.controller('PastHistoryController', function($scope, $http, $modal, $rootScope, limitToFilter, $modalInstance, $filter, PastHistoryService) {
	
	$scope.relationList = [];

	$scope.history = {};
	
	$scope.addMoreButton = true;

    $scope.typeCode = "";
	
	
	$scope.historyData = {};
	$scope.historySetteingData = {};
	$scope.paientHistoryList = [];
	$scope.pageName = ""
	$scope.typeCode = "";
	$scope.addByName = false;

    $scope.pageNameList = ["M.H", "Obs History", "Gynaecological History", "Sub-fertility History", "Immunization History", "Others History", "Laparoscopy Findings", "Hospital Details"	];

    $scope.prescription = function () {
        $modalInstance.close(true);
    };

	/*Family History*/

    $scope.bringRelationList = function(){


        var dataString = "query=6";

        PastHistoryService.getRelationList.query({}, dataString).$promise.then(function(result) {
            if (result && result.success) {
                $scope.relationList = result;
            }else{
    
            }
        });

    };

    $scope.bringFamilyHistoryData = function(){

        $scope.bringRelationList();
        $scope.addMoreButton = true;
        var dataString = "query=0";

        PastHistoryService.getDiseaseFromFamilyHistory.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.historyList[1].itemList = result
                if ($scope.historyList[1].itemList.length == 0) {
                    $scope.addFamilyHistory();
                }
            } else {

            }
        });
    };

    $scope.addFamilyHistory = function (){

        angular.forEach($scope.historyList[1].itemList, function(value, key) {
            value.otherEditMode = true;
        });

        $scope.addMoreButton = false;

        $scope.familyHistoryData = {};

        $scope.familyHistoryData.relation = $scope.relationList[0];

        $scope.familyHistoryData.type = "Consanguinity";

        $scope.familyHistoryData.present = "Yes";

        $scope.familyHistoryData.detail = "";

        $scope.familyHistoryData.editMode = true;

        $scope.historyList[1].itemList.splice(0,0, $scope.familyHistoryData);
    };

    $scope.saveFamilyHistory = function(familyHistoryData){


        if(validator.validateForm("#validateReq","#lblMsg",null)) {
            var dataString = "";
            if(familyHistoryData.id){

                dataString = "query=" + 4 + '&diseaseName=' + familyHistoryData.diseaseName + '&relation=' + familyHistoryData.relation.id
                    + '&present=' + familyHistoryData.present + '&type=' + familyHistoryData.type + '&detail=' + familyHistoryData.detail + '&familyHistoryID=' + familyHistoryData.id;

            }else{
                dataString = "query=" + 1 + '&diseaseName=' + familyHistoryData.diseaseName + '&relation=' + familyHistoryData.relation.id
                    + '&present=' + familyHistoryData.present + '&type=' + familyHistoryData.type + '&detail=' + familyHistoryData.detail;
            }

            PastHistoryService.createDiseaseInPrescription.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    $scope.succcess = true;
                    $scope.error = false;
                    $scope.message = "Information Updated Successfully";
                    $scope.bringFamilyHistoryData();
                } else {

                }
            });

        }else{
            $scope.message = "";
            $scope.succcess = false;
            $scope.error = true;
        }

    };

    $scope.editFamilyHistory = function (familyHistoryData){

        angular.forEach($scope.familyHistoryList, function(value, key) {
            value.otherEditMode = true;
        });

        familyHistoryData.oterEditMode = false;
        familyHistoryData.editMode = true;

        angular.forEach($scope.relationList, function(value, key) {
            if(value.id == familyHistoryData.relation){
                familyHistoryData.relation = value;
            }
        });
    };

    $scope.addToPresFamily = function(data){


        if(data.addedToPres == 1){


            // var dataString = "query=" + 3 + "&familyHistoryID=" +  data.id;

            PastHistoryService.deleteDiseaseFromPrescription.remove({familyHistoryID: data.id}).$promise.then(function (result) {
                if (result && result.success) {
                    $scope.succcess = true;
                    $scope.error = false;
                    $scope.message = "Information Deleted From Prescription";
                    data.addedToPres = false;
                } else {

                }
            });

        }else{

            var dataString = "query=" + 2 + "&familyHistoryID=" + data.id;

            PastHistoryService.createDiseasePrescription.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    $scope.succcess = true;
                    $scope.error = false;
                    $scope.message = "Information Added To Prescription";
                    data.addedToPres = true;
                } else {

                }
            });
        }

    };

    $scope.cancelFamilyHistory  = function(){
        $scope.bringFamilyHistoryData();
    };

    $scope.deleteFamilyHistory = function(id){

        // var dataString = "query=" + 5 + "&familyHistoryID=" + id;

        PastHistoryService.deleteDiseaseAndHistory.remove({familyHistoryID: id}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.succcess = true;
                $scope.error = false;
                $scope.message = "Information Deleted Successfully";
                $scope.bringFamilyHistoryData();
            } else {

            }
        });
    };

    /*Family History Ends*/

    /*Past Disease*/
	
	
	$scope.savePastHistory = function(pastHistoryData){
		
		if(validator.validateForm("#validateReq","#lblMsg",null)) {
			
			 
			
			var dataString = "";
			if(pastHistoryData.id){
				
				dataString = "query=" + 4 + '&diseaseName=' + pastHistoryData.diseaseName + '&isPresent=' + pastHistoryData.isPresent + '&detail=' + pastHistoryData.detail + '&pastHistoryID=' + pastHistoryData.id;

			}else{
				dataString = "query=" + 1 + '&diseaseName=' + pastHistoryData.diseaseName + '&isPresent=' + pastHistoryData.isPresent + '&detail=' + pastHistoryData.detail;
			}
            
            PastHistoryService.createAndupdatePastPatientDisease.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    $scope.succcess = true;
                    $scope.error = false;
                    $scope.message = "Information Updated Successfully";
                    $scope.bringPastHistoryData();
                    $scope.bringCurrHistoryData();
                } else {

                }
            });
		}else{
			$scope.message = "";
			$scope.succcess = false;
			$scope.error = true;
		}
		
		
	};
	
	$scope.editPastHistory = function (pastHistoryData){
		angular.forEach($scope.pastHistoryList, function(value, key) {
			value.otherEditMode = true;
		});
		pastHistoryData.oterEditMode = false;
		pastHistoryData.editMode = true;
		
	};
	
	$scope.addToPresPast = function(data){
		
		
		if(data.addedToPres == 1){
			
			
			// var dataString = "query=" + 3 + "&pastHistoryID=" +  data.id;
            
            PastHistoryService.deletePastPrescritionDisease.remove({pastHistoryID: data.id}).$promise.then(function (result) {
                if (result && result.success) {
                    $scope.succcess = true;
                    $scope.error = false;
                    $scope.message = "Information Deleted From Prescription";
                    data.addedToPres = false;
                } else {

                }
            });
	        
	    }else{
			
			var dataString = "query=" + 2 + "&pastHistoryID=" + data.id;
	        
            PastHistoryService.updatePastPrescritionDisease.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    $scope.succcess = true;
                    $scope.error = false;
                    $scope.message = "Information Added To Prescription";
                    data.addedToPres = true;
                } else {

                }
            });
	    }
	    
		};
		
	$scope.cancelPastHistory  = function(){
		$scope.bringPastHistoryData();
	};

	$scope.deletePastHistory = function(id){
		
		// var dataString = "query=" + 5 + "&pastHistoryID=" + id;
        
        PastHistoryService.delAllPastDisease.remove({pastHistoryID: id}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.succcess = true;
                $scope.error = false;
                $scope.message = "Information Deleted Successfully";
                $scope.bringPastHistoryData();
            } else {

            }
        });
	};

    $scope.addPastHistory = function (isPresent) {

        angular.forEach($scope.historyList[0].itemList, function (value, key) {
            value.otherEditMode = true;
        });

        $scope.addMoreButton = false;

        $scope.pastHistoryData = {};

        $scope.pastHistoryData.isPresent = isPresent;

        $scope.pastHistoryData.detail = "";

        $scope.pastHistoryData.editMode = true;

        //$scope.historyList[0].itemList.splice(0, 0, $scope.pastHistoryData);
        $scope.historyList[0].itemList.push($scope.pastHistoryData);

    };

    $scope.bringPastHistoryData = function(){

        $scope.addMoreButton = true;
        var dataString = "query=0";

        PastHistoryService.getPastDisease.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.historyList[0].itemList = [];
                $scope.historyList[0].itemList = result;
            } else {

            }
        });
    };

    /*Past History End*/

    /*Drug History*/

    $scope.bringCurrentDrugList = function (){
        var dataString = {'status' : 1, 'query': 1};

        PastHistoryService.getCurrentDrugList.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.currentDrugList = result;
            } else {

            }
        });

    };

    $scope.bringOldDrugList = function (){


        var dataString = {'status' : 0,  'query': 1};

        PastHistoryService.getOldDrugList.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.oldDrugList = result;
            } else {

            }
        });

    };

    $scope.addDrug = function(status){

        $scope.showDrugAdvice = true;
        var data = {};

        data.drugName = "";
        data.editMode = true;
        $scope.masterUpdate = false;

        if(status == 1){
            angular.forEach($scope.currentDrugList, function(value, key) {
                value.otherEditMode = true;
            });

            $scope.currentDrugList.splice(0,0, data);
        }else{
            angular.forEach($scope.oldDrugList, function(value, key) {
                value.otherEditMode = true;
            });

            $scope.oldDrugList.splice(0,0, data);
        }
    };

    $scope.saveDrug = function(data, status) {

        var data = {'drugName': data.drugName, 'status': status, 'query': 2};

        PastHistoryService.updateDrug.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                if(status == 1){
                    $scope.bringCurrentDrugList();
                }else{
                    $scope.bringOldDrugList();
                }
            } else {

            }
        });
    };

    $scope.delDrug = function(data, status) {

        //var data = {'delId': data.drugHistoryID, 'query': 3};

        PastHistoryService.deleteDrug.remove({delId: data.drugHistoryID}).$promise.then(function (result) {
            if (result && result.success) {
                if(status == 1){
                    $scope.bringCurrentDrugList();
                }else{
                    $scope.bringOldDrugList();
                }
            } else {

            }
        });
    };

    $scope.addDrugToPres = function(data){

        if(data.addedToPres == 0){

            var dataStr = {'drugName': data.drugName, 'status': data.currentStatus, 'query': 7};

            PastHistoryService.createDrugPrescription.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    data.contentDetailID = result;
                    data.addedToPres = true;
                } else {
    
                }
            });

        }else{

            //var dataStr = {'contentDetailID': data.contentDetailID, 'query': 8};

            PastHistoryService.deleteDrugPrescription.remove({contentDetailID: data.contentDetailID}).$promise.then(function (result) {
                if (result && result.success) {
                    data.addedToPres = false;
                } else {
    
                }
            });
        }

    };


	$scope.getDisease = function(term) {
    	
    	var dataString = "query=" + 0 + "&data=" + term;
        
        return $http({
            method: 'POST',
            url: "rest/autoComplete/diagnosis",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function(result) {
        	$scope.diagnosisNameData = result.data;
        	return limitToFilter($scope.diagnosisNameData, 10);
        });
    };
    
  $scope.onSelectDisease = function(item, model, label){
  };





	$scope.initialiseTab = function () {

        $scope.historyList = [];

        var item = 1;
        var temp = {name : 'Medical History', id :item++};
        $scope.historyList.push(temp);

        temp = {name : 'Family History' , id :item++};
        $scope.historyList.push(temp);

        temp = {name : 'Drug History' , id :item++};
        $scope.historyList.push(temp);

        var dataString = "query=1";

        PastHistoryService.getMenu.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.menuDataList = result;
                angular.forEach($scope.menuDataList, function (value, key) {
                    if (value.isPopUp == 1 && value.inPrescription == 2) {
                        temp = { name: value.menuHeader, id: item++, typeCode: value.defaultName };
                        $scope.historyList.push(temp);
                    }
                });
            } else {

            }
        });





        /*temp = {name : 'Family History'};
        $scope.historyList.push(temp);*/

    };
	
	$scope.changeTab = function (history) {

		$scope.error = false;
		$scope.succcess = false;

		if(history.id == 1){
            $scope.bringPastHistoryData();
		}else if (history.id == 2){
            $scope.bringFamilyHistoryData();
		}else if(history.id == 3){
            $scope.bringCurrentDrugList();
            $scope.bringOldDrugList();
		}else {
            $scope.typeCode = history.typeCode;

            		var num = 0;
		
		if($scope.typeCode == "OBS"){
			num = 1;
		}else if ($scope.typeCode == "GYNAE") {
			num = 2;
		}else if ($scope.typeCode == "SUB-FERTILITY") {
			num = 3;
		}else if ($scope.typeCode == "IMMUNIZATION") {
			num = 4;
		}else if ($scope.typeCode == "OTHERS") {
			num = 5;
		}else if ($scope.typeCode == "LAPAROSCOPY") {
			num = 6;
		}else if ($scope.typeCode == "HOSPITAL") {
			num = 7;
		}
            $scope.pageName = $scope.pageNameList[num];
            $scope.bringHistoryDetail();
        }
    };

    $scope.bringHistoryDetail = function (){

        $scope.historySetteingData = {};

        var dataString = "query=0" + '&typeCode=' + $scope.typeCode;;

        PastHistoryService.getDetailsOfDoctorHistory.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.paientHistoryList = result;

                angular.forEach($scope.paientHistoryList, function (value, key) {
                    if (parseInt(value.savedHistorysID) > 0) {
                        value.addToPrescription = true;
                    }
                });
            } else {

            }
        });
    };

    $scope.getHistory = function(term) {

        var dataString = 'query=5'+ '&name=' + term + '&typeCode=' + $scope.typeCode;

        return $http({
            method: 'POST',
            url: "rest/autoComplete/history",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function(result) {
            $scope.historyData = result.data;
            return limitToFilter($scope.historyData, 10);
        });
    };

    $scope.onSelectHistory = function(item, model, label){
        $scope.historySetteingData.historyID = item.id;
        $scope.historySetteingData.shortName = item.shortName;
        $scope.addByName = true;
    };

    $scope.bringHistoryOption = function(historydata, term){


        var dataString = 'query=1'+ '&historyID=' + historydata.historyID + '&term=' + term;;


        return $http({
            method: 'POST',
            url: "rest/autoComplete/history",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function(result) {
            $scope.historyOption = result.data;
            return limitToFilter($scope.historyOption, 10);
        });
    };

    $scope.deleteHistoryFromSetting = function (id){

        var dataString = 'query=12'+ '&historySettingID=' + id;
        
        PastHistoryService.deleteSettingsOfDocHistory.remove({historySettingID: id}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringHistoryDetail();
            } else {

            }
        });
    };

    $scope.addHistoryToDoctorPref = function (){

        if(validator.validateForm("#historySetting","#lblMsg",null)) {
            if($scope.addByName == false){
                var dataString = 'query=6'+ '&historyName=' + $scope.historySetteingData.historyName + '&shortName=' + $scope.historySetteingData.shortName +  '&typeCode=' + $scope.typeCode;
                
                PastHistoryService.createHistoryToDocPref.query({}, dataString).$promise.then(function (result) {
                    if (result && result.success) {
                        $scope.addToDoctorPreference(result);
                    } else {
        
                    }
                });

            }else{
                $scope.addToDoctorPreference($scope.historySetteingData.historyID);
            }

        }else{
            alert("what");
        }
    };


    $scope.addToDoctorPreference = function (historyID){

        var hisID = parseInt(historyID);
        var displayOrder = 1;
        if($scope.paientHistoryList != undefined && $scope.paientHistoryList.length > 0){
            displayOrder = parseInt($scope.paientHistoryList[$scope.paientHistoryList.length -1].displayOrder) + 1;
        }

        var dataString = 'query=7'+ '&historyID=' + hisID + '&displayOrder=' + displayOrder;

        PastHistoryService.createSettingsOfDocPreference.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringHistoryDetail();
            } else {

            }
        });

    };


    $scope.saveHistory = function(){

        var prescribedHistory = $scope.paientHistoryList;

        angular.forEach(prescribedHistory, function(value, key) {
            if(parseInt(value.patientHistoryID) > 0 && value.historyResult){//Update
                var dataString = 'query=11'+ '&historyID=' + value.historyID + '&historyResult=' + value.historyResult ;
                
                PastHistoryService.updateHistoryOfPatient.query({}, dataString).$promise.then(function (result) {
                    if (result && result.success) {
                        
                    } else {
        
                    }
                });
            }else if(!parseInt(value.patientHistoryID) &&  value.historyResult){//ADD
                var dataString = 'query=10'+ '&historyID=' + value.historyID + '&historyResult=' + value.historyResult ;
                
                PastHistoryService.createHistoryOfPatient.query({}, dataString).$promise.then(function (result) {
                    if (result && result.success) {

                    } else {
        
                    }
                });
            }else if(parseInt(value.patientHistoryID) > 0 && value.historyResult == ""){//delete

                // var dataString = 'query=9'+ '&savedHistorysID=' + value.patientHistoryID;
                
                PastHistoryService.deleteHistoryOfPatient.query({savedHistorysID: value.patientHistoryID}).$promise.then(function (result) {
                    if (result && result.success) {

                    } else {
        
                    }
                });
            }
        });

        angular.forEach(prescribedHistory, function(value, key) {
            if(parseInt(value.savedHistorysID) > 0 && value.historyResult && value.addToPrescription){
                //do noting
            }else if(parseInt(value.savedHistorysID) > 0 && value.historyResult && !value.addToPrescription){

                // var dataString = 'query=4'+ '&savedHistorysID=' + value.savedHistorysID;
                
                PastHistoryService.deleteHistoryOfPrescription.remove({savedHistorysID: value.savedHistorysID}).$promise.then(function (result) {
                    if (result && result.success) {

                    } else {
        
                    }
                });

            }else if(parseInt(value.savedHistorysID) > 0 && value.historyResult == ""){


                // var dataString = 'query=4'+ '&savedHistorysID=' + value.savedHistorysID;
                PastHistoryService.deleteHistoryOfPrescription.remove({savedHistorysID: value.savedHistorysID}).$promise.then(function (result) {
                    if (result && result.success) {

                    } else {
        
                    }
                });

            }else if(!(parseInt(value.savedHistorysID) > 0) > 0 && value.historyResult == "" && value.addToPrescription){
                //do noting
            }else if(!(parseInt(value.savedHistorysID) > 0) && value.historyResult  && value.addToPrescription){

                var dataString = 'query=3'+ '&historyID=' + value.historyID;
               
                PastHistoryService.createPrescriptionHistory.query({}, dataString).$promise.then(function (result) {
                    if (result && result.success) {
                        
                    } else {
        
                    }
                });
            }
        });

        setTimeout(function() {
            $scope.$apply(function() {
                $scope.succcess = true;
                $scope.error = false;
                $scope.message = 'Information Saved Successfully';
            });
        }, 3000);

    };





  $scope.init = function () {
	  $scope.initialiseTab();
	  $scope.bringPastHistoryData();

  };

    $scope.init();

	
});