app.controller('PrescriptionController.PrescribeDrugsController', function($scope, $http, $filter, $modalInstance,
                                                                           limitToFilter, JsonService, appointmentData,
                                                                           drugData, DrugService) {

    $scope.drugTypeList =[];
    $scope.drugNumOfDayList = [];
    $scope.durationTypeList = [];
    $scope.doseTypeList = [];
    $scope.drugWhenTypeList =[];
    $scope.drugAdviceTypeList =[];
    $scope.drugDoseList =[];
    $scope.drugData = {};
    $scope.drugPeriodicDoseList = [];
    $scope.enteredDrugDoseList = [];
    $scope.addByName = false;
    $scope.doseList = [];

    $scope.drugByCompany = true;
    $scope.drugCompanyList = [];

    $scope.drugNameList = {};

    $scope.cancelDrug = function (){
        $modalInstance.close();
    };

    $scope.bringPrescribedDrugs = function () {
        DrugService.getReqContent.query({}, {}).$promise.then(function (result) {
            $scope.drugTypeList = result.drugTypeList;
            $scope.drugWhenTypeList = result.drugWhenTypeList;
            $scope.drugWhenTypeList.unshift({whenTypeID:null,bangla:"--Select--"});
            $scope.drugAdviceTypeList = result.drugAdviceTypeList;
            $scope.drugAdviceTypeList.unshift({drugAdviceID:null,bangla:"--Select--"});
            $scope.drugNumOfDayList = JsonService.numberList;
            $scope.durationTypeList = result.durationTypeList;
            $scope.doseTypeList = result.doseTypeList;

            if(drugData.presDrugID){
                $scope.editPrep();
            }else{
                $scope.addPrep();
            }
        });
    };

    $scope.editPrep = function () {
        $scope.drugData = {};
        $scope.drugData = drugData;
        $scope.inItDrugsType($scope.drugData.periodList);
    };

    $scope.addPrep = function (){
        $scope.drugData = {};
        $scope.drugData.presNum = drugData.presNum;
        $scope.drugData.drugType = $scope.drugTypeList[0];
        $scope.drugData.drugTypeID = $scope.drugTypeList[0].drugTypeID;
        $scope.drugData.doseTypeCode = 3;
        $scope.drugData.drugWhenID = null;
        $scope.drugData.drugAdviceID = null;
        $scope.drugData.periodList = [];
        $scope.drugData.periodList.push($scope.createEmptyDose());
        $scope.inItDrugsType($scope.drugData.periodList);
    };

    $scope.createEmptyDose = function () {
        return {durationTypeList : $scope.durationTypeList,
            drugNumOfDayList : $scope.drugNumOfDayList,
            doseDataList: [] ,
            numOfDay : 7,
            durationType : 1,
            dose: '' };
    };

    $scope.timeChanger = function (preiod){
        $scope.drugData.periodList = [];
        if($scope.drugData.doseTypeCode == -1){
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
        var selectedTimesADay = $scope.drugData.doseTypeCode;
        if(selectedTimesADay == -1){
            $scope.drugData.preodicValue = periodList.length;
            var selectedTimesADay = 3;
        }
        angular.forEach(periodList, function(period, key) {
            if(!period.doseDataList){
                period.doseDataList = [];
                period.durationTypeList = $scope.durationTypeList;
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
            delete period.durationTypeList;
            delete period.drugNumOfDayList;

        });
    };

    $scope.getDrugName = function(term) {
        var searchData = {};
        searchData.term = term;
        searchData.intType = $scope.drugData.drugTypeID;
        return $http({
            method: 'POST',
            url: "/rest/autoComplete/drug",
            data: searchData
        }).then(function(result) {
            $scope.drugNameList = result.data;
            return limitToFilter($scope.drugNameList, 10);
        });
    };

    $scope.onSelectDrugName = function(drugID, drugName, strength, genericID){
        $scope.drugData.drugID = drugID;
        $scope.drugData.drugName = drugName;
        $scope.drugData.drugStrength = strength;
        $scope.drugData.genericID = genericID;
        $scope.drugData.hasDefaultSetup = 0;
        DrugService.getDrugDefaultSetup.query({}, {drugID: drugID, genericID: genericID ? genericID : 0}).$promise.then(function (result) {
            $scope.doctorDrugData = result;
            if($scope.doctorDrugData && $scope.doctorDrugData.periodList){
                $scope.drugData.hasDefaultSetup = 1;
                $scope.drugData.doseTypeCode = result.doseTypeCode;
                $scope.drugData.drugWhenID = result.drugWhenID;
                $scope.drugData.drugAdviceID = result.drugAdviceID;
                $scope.drugData.periodList = result.periodList;
                $scope.inItDrugsType($scope.drugData.periodList);
            }
        });
    };

    $scope.selectCompanyDrug = function (compDrug) {
        $scope.onSelectDrugName(compDrug.drugID, compDrug.drugName, compDrug.strength, compDrug.genericID);
    };

    $scope.selectCompanyDrugByID = function (drugID) {
        $scope.selectCompanyDrug($filter('filter')($scope.drugCompanyList, {drugID: drugID}, true)[0]);
    };

    $scope.getDrugGenericName = function(term) {
        var searchData = {};
        searchData.term = term;
        searchData.intType = $scope.drugData.drugTypeID;
        return $http({
            method: 'POST',
            url: "/rest/autoComplete/genericDrug",
            data: searchData
        }).then(function(result) {
            $scope.genericNameList = result.data;
            return limitToFilter($scope.genericNameList, 10);
        });
    };

    $scope.onSelectGenericName = function(item, model, label){
        $scope.drugData.genericID = item.genericID;
        DrugService.getCompDrugList.query({}, {genericID: item.genericID}).$promise.then(function (result) {
            $scope.drugCompanyList = result;
            if($scope.drugCompanyList != null && $scope.drugCompanyList.length > 0){
                $scope.drugData.drugID = $scope.drugCompanyList[0].drugID;
                $scope.selectCompanyDrug($scope.drugCompanyList[0]);
            }
        });
    };

    $scope.clearCompanyName = function () {
        $scope.drugData.drugID = null;
        $scope.drugData.drugName = null;
        $scope.drugData.drugStrength = null;
        $scope.drugData.hasDefaultSetup = 0;
        $scope.drugData.genericID = null;
    };

    $scope.clearGenericName = function () {
        $scope.drugData.genericDrugName = null;
        $scope.drugData.drugID = null;
        $scope.drugData.drugName = null;
        $scope.drugData.drugStrength = null;
        $scope.drugData.hasDefaultSetup = 0;
        $scope.drugData.genericID = null;
    };

    //maybe not needed anymore

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