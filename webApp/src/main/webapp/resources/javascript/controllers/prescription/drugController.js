app.controller('PrescriptionController.PrescribeDrugsController', function($scope, $http, $filter, $modalInstance,
                                                                           limitToFilter, JsonService, appointmentData,
                                                                           drugData, DrugService) {

    $scope.drugTypeList =[];
    $scope.drugNumOfDayList = JsonService.numberList;
    $scope.drugDayTypeList =JsonService.dayTypeList;
    $scope.drugtimesADayList = JsonService.timesADay;
    $scope.drugWhenTypeList =[];
    $scope.drugAdviceTypeList =[];
    $scope.drugDoseList =[];
    $scope.drugData = {};
    $scope.drugPeriodicDoseList = [];
    $scope.enteredDrugDoseList = [];
    $scope.addByName = false;
    $scope.doseList = [];

    $scope.drugNameList = {};

    $scope.cancelDrug = function (){
        $modalInstance.close();
    };

    $scope.bringPrescribedDrugs = function (){

        if(drugData.presDrugID){
            DrugService.getNewPresDrug.query({}, {}).$promise.then(function (result) {
                $scope.drugTypeList = result.drugTypeList;
                $scope.drugWhenTypeList = result.drugWhenTypeList;
                $scope.drugWhenTypeList.unshift({whenTypeID:null,bangla:"--Select--"});
                $scope.drugAdviceTypeList = result.drugAdviceTypeList;
                $scope.drugAdviceTypeList.unshift({drugAdviceID:null,bangla:"--Select--"});
                $scope.drugData = {};
                $scope.drugData = drugData;
                //$scope.populateDose($scope.drugData.periodList);
                $scope.inItDrugsType($scope.drugData.periodList);
            });
        }else{
            DrugService.getNewPresDrug.query({}, {}).$promise.then(function (result) {
                $scope.drugTypeList = result.drugTypeList;
                $scope.drugWhenTypeList = result.drugWhenTypeList;
                $scope.drugWhenTypeList.unshift({whenTypeID:null,bangla:"--Select--"});
                $scope.drugAdviceTypeList = result.drugAdviceTypeList;
                $scope.drugAdviceTypeList.unshift({drugAdviceID:null,bangla:"--Select--"});
                $scope.drugData = {};
                $scope.drugData.presNum = drugData.presNum;
                $scope.drugData.drugType = $scope.drugTypeList[0];
                $scope.drugData.drugTypeID = $scope.drugTypeList[0].drugTypeID;
                $scope.drugData.drugTimeID = 3;
                $scope.drugData.drugWhenID = null;
                $scope.drugData.drugAdviceID = null;
                $scope.drugData.periodList = [];
                $scope.drugData.periodList.push($scope.createEmptyDose());
                $scope.inItDrugsType($scope.drugData.periodList);
            });
        }
    };

    $scope.onSelectDrugName = function(item, model, label){
        $scope.drugData.drugID = item.drugID;
        $scope.drugData.drugName = item.drugName;
        $scope.drugData.drugStrength = item.strength;
        DrugService.getDrugDefaultSetup.query({}, {doctorID: appointmentData.doctorID, drugID: item.drugID}).$promise.then(function (result) {
            $scope.doctorDrugData = result;
            if($scope.doctorDrugData && $scope.doctorDrugData.periodList){
                $scope.drugData.drugTimeID = result.drugTimeID;
                $scope.drugData.drugWhenID = result.drugWhenID;
                $scope.drugData.drugAdviceID = result.drugAdviceID;
                $scope.drugData.periodList = result.periodList;
                $scope.inItDrugsType($scope.drugData.periodList);
            }
        });
    };

    $scope.createEmptyDose = function () {
        return {drugDayTypeList : $scope.drugDayTypeList,
            drugNumOfDayList : $scope.drugNumOfDayList,
            doseDataList: [] ,
            numOfDay : 7,
            durationType : 1,
            dose: '' };
    };

    $scope.timeChanger = function (preiod){
        $scope.drugData.periodList = [];
        if($scope.drugData.drugTimeID == -1){
            for(var i = 0; i < preiod; i++){
                $scope.drugData.periodList.push($scope.createEmptyDose());
            }
            $scope.drugData.preodicValue = preiod;
        }else{
            $scope.drugData.periodList.push($scope.createEmptyDose());
        }
        $scope.inItDrugsType($scope.drugData.periodList);
    };

    $scope.inItDrugsType = function (periodList){
        var selectedDrugType = $filter('filter')($scope.drugTypeList, {drugTypeID: $scope.drugData.drugTypeID}, true)[0];
        $scope.drugData.drugType = selectedDrugType;
        $scope.periodDoseHandler(selectedDrugType.unit, periodList);
    };

    $scope.periodDoseHandler = function (unit, periodList){
        var selectedTimesADay = $scope.drugData.drugTimeID;
        if(selectedTimesADay == -1){
            $scope.drugData.preodicValue = periodList.length;
            var selectedTimesADay = 3;
        }
        angular.forEach(periodList, function(period, key) {
            if(!period.doseDataList){
                period.doseDataList = [];
                period.drugDayTypeList = $scope.drugDayTypeList;
                period.drugNumOfDayList = $scope.drugNumOfDayList;
            }
            $scope.doseHandler(unit, period.doseDataList, selectedTimesADay, period.dose);
        });
    };

    $scope.doseHandler = function (unit, doseDataList, selectedTimesADay, dose){
        var val = parseFloat(unit);
        if(dose != ''){
            $scope.enteredDrugDoseList = dose.split('-');
        }
        var sameAs = selectedTimesADay;
        if(sameAs == -2){
            selectedTimesADay = 1;
        }

        for(var i = 0; i< selectedTimesADay; i++){
            if($scope.enteredDrugDoseList.length > 0 && sameAs != -2){
                var data = {"value" : $scope.enteredDrugDoseList[i]};
                unit = $scope.enteredDrugDoseList[i];
            }else if($scope.enteredDrugDoseList.length == 0 && sameAs != -2){
                var data = {"value" : val};
                unit = val;
            }else if($scope.enteredDrugDoseList.length == 0 && sameAs == -2){
                var data = {"value" : '', "isSameAs" : true};
                unit = val;
            }else if($scope.enteredDrugDoseList.length > 0 && sameAs == -2){
                var data = {"value" : $scope.enteredDrugDoseList[i], "isSameAs" : true};
                unit = val;
            }

            doseDataList.push(data);
        }
        $scope.enteredDrugDoseList = [];
    };

    $scope.doseChanger = function (change, doseDataList){

        angular.forEach(doseDataList, function(data, key) {
            var val = parseFloat(data.value);
            data.value = val + change;

        });

    };

    $scope.saveDrug = function(isAnother) {
        if($scope.drugData.drugName) {
            $scope.prepareDrugSaveData(isAnother);
        }else{
            $scope.errorMessage = "Please Select Drug Name";
            $scope.error = true;
            $("#drugName").addClass('has-error');
        }
    };

    $scope.prepareDrugSaveData = function(isAnother){
        var doseUnit = "";
        var presDrugData = {};
        angular.copy($scope.drugData, presDrugData);
        if(presDrugData.optionalInitial != undefined && presDrugData.optionalInitial){
            presDrugData.drugDoseUnit = presDrugData.drugType.optionalUnitInitial;
        }else{
            presDrugData.drugDoseUnit = presDrugData.drugType.unitInitial;
        }
        delete presDrugData.drugType;
        delete presDrugData.optionalInitial;
        $scope.stringDoseMaker(presDrugData.periodList);
        presDrugData.appointmentID = appointmentData.appointmentID;
        presDrugData.doctorID = appointmentData.doctorID;
        DrugService.save.query({}, presDrugData).$promise.then(function (result) {
                if(isAnother){
                    $scope.drugData = {};
                    $scope.bringPrescribedDrugs();
                }else{
                    $modalInstance.close();
                }
        });
    };

    $scope.stringDoseMaker = function (periodList){
        angular.forEach(periodList, function(period, key) {
            if(period.doseDataList && period.doseDataList.length > 0){
                period.dose = period.doseDataList.reduce(function (a, b) {return (a.value || a) + "-" + b.value})
            }else{
                period.dose = "";
            }
            delete period.doseDataList;
            delete period.drugDayTypeList;
            delete period.drugNumOfDayList;

        });
    };



    $scope.deleteDrugFromDB = function(){

        var dataString = "query=10" + '&drugID=' + $scope.drugData.drugID;

        DrugService.deleteDrugById.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedDrugs();
            } else {

            }
        });

    };

    $scope.editDrugName = function(){


        var dataString = "query=11" + '&drugID=' + $scope.drugData.drugID + '&drugName=' + $scope.drugData.drugName;

        DrugService.updateDrugByName.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                if(drugData.id){
                    $modalInstance.close();
                }else{
                    $scope.bringPrescribedDrugs();
                }            
            } else {

            }
        });
    };

    $scope.getDrugName = function(term) {
        var searchData = {};
        searchData.term = term;
        searchData.intType = $scope.drugData.drugTypeID;
        return $http({
            method: 'POST',
            url: "/api/rest/autoComplete/drug",
            data: searchData
        }).then(function(result) {
            $scope.drugNameList = result.data;
            return limitToFilter($scope.drugNameList, 10);
        });
    };

    //maybe not needed anymore

    $scope.bringBasic = function () {
        DrugService.getTypeOfDrug.query({}, {}).$promise.then(function (result) {
            $scope.drugTypeList = result;
        });
        DrugService.getTypeOfDrugWhen.query({}, {}).$promise.then(function (result) {
            $scope.drugWhatTypeList = result;
        });

        DrugService.getTypeOfDrugAdvice.query({}, {}).$promise.then(function (result) {
            $scope.drugAdviceTypeList = result;
        });
    };

    $scope.bringdrugsDayTypeList = function (addMode, typeID, timeID){

        var dataString = "query=1";

        DrugService.getTypeOfDrugDay.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.drugDayTypeList = result;

                if (addMode) {
                    var periodicData = { drugDayTypeList: $scope.drugDayTypeList, drugNumOfDayList: $scope.drugNumOfDayList, doseDataList: [], numOfDay: 7, durationType: 1, dose: '' };
                    $scope.drugData.preiodicList.push(periodicData);

                    $scope.inItDrugsType(addMode, typeID, timeID, $scope.drugData.preiodicList);
                } else {

                    angular.forEach($scope.drugData.preiodicList, function (value, key) {

                        value.drugDayTypeList = $scope.drugDayTypeList;
                        value.drugNumOfDayList = $scope.drugNumOfDayList;
                        value.doseDataList = [];
                    });
                    $scope.inItDrugsType(addMode, typeID, timeID, $scope.drugData.preiodicList);
                }
            } else {

            }
        });

    };

    $scope.doseMaker = function (unit, numOfTime, change){

        var drugDoseList = [];

        var val = parseFloat(unit) + change;
        var data = {"value" : val};
        for(var i = 0; i< numOfTime; i++){
            if($scope.enteredDrugDoseList.length > 0){
                var data = {"value" : $scope.enteredDrugDoseList[i]};
                unit = $scope.enteredDrugDoseList[i];
            }else{
                var data = {"value" : val};
                unit = val;
            }

            drugDoseList.push(data);
        }
        $scope.enteredDrugDoseList = [];


        $scope.bringDrugsDayType(true , null, drugDoseList);
    };

    $scope.bringDrugsDayType = function (addMood, selectedDayTypeID, doseDataList){

        var dataString = "query=1";

        DrugService.getTypeOfDrugDayByDose.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.drugDayTypeList = result;


                if (addMood) {

                    var drugDoseData = { drugDayTypeList: $scope.drugDayTypeList, drugNumOfDayList: $scope.drugNumOfDayList, drugDoseList: doseDataList };
                    $scope.drugData.doseList.push(drugDoseData);

                } else {
                    angular.forEach($scope.drugDayTypeList, function (value, key) {
                        if (value.id == selectedDayTypeID) {
                            $scope.drugData.dayType = value;
                        }
                    });
                }
            } else {

            }
        });
    };

    $scope.bringdrugsWhatType = function (addMood, selectedWhatTypeID){

        var dataString = "query=2";

        DrugService.getTypeOfDrugWhen.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.drugWhatTypeList = result;
                if (addMood) {
                    $scope.drugData.whatType = $scope.drugWhatTypeList[0];
                } else {
                    angular.forEach($scope.drugWhatTypeList, function (value, key) {
                        if (value.id == selectedWhatTypeID) {
                            $scope.drugData.whatType = value;
                        }
                    });
                }
            } else {

            }
        });

    };

    $scope.bringdrugsAdviceType = function (addMood, selectedAdviceTypeID){

        var dataString = "query=3";

        DrugService.getTypeOfDrugAdvice.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.drugAdviceTypeList = result;
                if (addMood) {
                    $scope.drugData.adviceType = $scope.drugAdviceTypeList[0];
                } else {
                    angular.forEach($scope.drugAdviceTypeList, function (value, key) {
                        if (value.drugAdviceID == selectedAdviceTypeID) {
                            $scope.drugData.adviceType = value;
                        }
                    });
                }
            } else {

            }
        });

    };

    $scope.bringPrescribedDrugs();

    $scope.saveToDoctorDrugSetting = function(){


        var drugType = $scope.drugData.drugType.id;
        var drugName =  $scope.drugData.drugName;

        var drugTime = $scope.drugData.timesADay.code;

        var doseUnit = "";
        if($scope.drugData.optionalInitial != undefined && $scope.drugData.optionalInitial){
            doseUnit = $scope.drugData.drugType.optionalUnitInitial;
        }else{
            doseUnit = $scope.drugData.drugType.unitInitial;
        }

        var drugWhen = $scope.drugData.whatType.id;

        var drugAdvice = $scope.drugData.adviceType.drugAdviceID;


        var query = 14;

        if($scope.drugData.drugStr == undefined){
            $scope.drugData.drugStr = '';
        }

        var dataString = 'drugType='+ drugType +'&drugName='+ drugName +'&drugStr='+ $scope.drugData.drugStr + '&drugTime='+ drugTime +'&doseUnit='+ doseUnit + '&drugWhen='+ drugWhen +'&drugAdvice='+ drugAdvice +'&query=' + query;

        DrugService.deleteDocDrugCreateDocDrug.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                doctorDrugID = result;
                angular.forEach($scope.drugData.preiodicList, function (preiodicData, key) {

                    var drugDose = "";

                    for (var i = 0; i < preiodicData.doseDataList.length; i++) {
                        if (i == 0) {
                            drugDose = preiodicData.doseDataList[i].value;
                        } else {
                            drugDose = drugDose + " - " + preiodicData.doseDataList[i].value;
                        }
                    }

                    var durationType = preiodicData.durationDayType.id;

                    var numOfDay = null;

                    if (durationType < 5) {
                        numOfDay = preiodicData.dataNumOFDay.value;
                    }

                    var dataString = "query=15" + '&doctorDrugID=' + doctorDrugID + '&dose=' + drugDose + '&numOfDay=' + numOfDay + '&durationType=' + durationType;

                    DrugService.createDoctorDrugDose.query({}, dataString).$promise.then(function (result) {
                        if (result && result.success) {

                        } else {

                        }
                    });

                });
            } else {

            }
        });
    };


});