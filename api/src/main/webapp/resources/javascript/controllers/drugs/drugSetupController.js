/**
 * Created by raj on 5/21/2016.
 */
app.controller('DrugSetupController', function($scope, $rootScope, $state, $http, limitToFilter, $modal, $filter,
                                               $timeout, $location, DrugSetupService, DrugService, JsonService) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.drugSetup = {};
    $scope.showForm = false;
    $scope.editObj = {};
    $scope.moduleList = [];
    $scope.companyList = [];


    //reloading the grid
    $scope.reloadList = false;
    $scope.refreshList = function () {
        $scope.reloadList = !$scope.reloadList;
        $scope.dataSourceConfig.params.refresh = $scope.reloadList;
    };

    $scope.searchParam = {};
    $scope.search = function() {
        $scope.dataSourceConfig.params = angular.copy($scope.searchParam);
    };

    // column definition
    $scope.columnDefinition = [
        {columnHeaderDisplayName: 'Company Drug Name', displayProperty: 'drugName', sortKey: 'drugName'},
        {columnHeaderDisplayName: 'Drug Strength', displayProperty: 'strength', sortKey: 'strength'},
        {columnHeaderDisplayName: 'Drug Type', displayProperty: 'drugTypeName', sortKey: 'typeID'},
        {columnHeaderDisplayName: 'Generic Name', displayProperty: 'genericDrugName', sortKey: 'genericID'},
        {columnHeaderDisplayName: 'Company Name', displayProperty: 'companyName', sortKey: 'companyID'},
        {columnHeaderDisplayName: 'Action', templateUrl: 'action_template', width: '5em'}
    ];

    //datasource configuration
    $scope.dataSourceConfig = {
        url: '/rest/contentDrug/getAll',
        method: "GET",
        params: {},
        paginationConfig: {
            response: {
                totalItems: 'count',
                itemsLocation: 'list'
            }
        }
    };

    $scope.getGenericDrug = function(term) {
        var dataString = {};
        dataString.term = term;
        return $http({
            method: 'POST',
            url: "/rest/autoComplete/genericDrug",
            data: dataString
        }).then(function(result) {
            $scope.content = result.data;
            return limitToFilter($scope.content, 10);
        });
    };

    $scope.save = function(drugSetup) {
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            DrugSetupService.create.query({}, drugSetup ).$promise.then(function(result) {
                if(result && result.success) {
                    $scope.showSuccessMessage("Information saved successfully");
                    $scope.drugSetup = {};
                    $scope.refreshList();
                    $scope.showForm = false;
                } else {
                    $scope.showErrorMessage(result.message);
                }
            });
        }

    };

    $scope.update = function(drugSetup){
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            DrugSetupService.update.query({}, drugSetup).$promise.then(function(result) {
                if(result && result.success) {
                    $scope.showSuccessMessage("Information updated successfully");
                    $scope.drugSetup = {};
                    $scope.refreshList();
                    $scope.showForm = false;
                } else {
                    $scope.showErrorMessage(result.message);
                }
            });
        }
    };

    $scope.delete = function(drugSetup){

        DrugSetupService.deletedrugSetup.remove({drugSetupID : drugSetup.drugSetupID} ).$promise.then(function(result) {
            $scope.refreshList();
            $scope.showSuccessMessage("Information deleted successfully");
        });
    };

    $scope.showErrorMessage = function(message){
        $scope.hasError = true;
        $scope.hasSuccess = false;
        $scope.message = message;
    };

    $scope.showSuccessMessage = function(message){
        $scope.hasError = false;
        $scope.hasSuccess = true;
        $scope.message = message;
    };

    $scope.hideMessage = function(){
        $scope.hasError = false;
        $scope.hasSuccess = false;
    };

    $scope.edit = function(drugSetup){
        $scope.drugSetup = {};
        angular.copy(drugSetup, $scope.editObj);
        angular.copy(drugSetup, $scope.drugSetup);
        $scope.hideMessage();
        $scope.showForm = true;
    };

    $scope.reset = function(){
        angular.copy($scope.editObj, $scope.drugSetup);
        $scope.hideMessage();
    };

    $scope.add = function(){
        $scope.editObj = {};
        $scope.reset();
        $scope.showForm = true;
    };

    $scope.cancel = function(){
        $scope.reset();
        $scope.showForm = false;
    };

    $scope.backToList = function() {
        $scope.cancel();
    };

    $scope.init = function(){
        DrugSetupService.getDrugsTypeList.query({}, {} ).$promise.then(function(result) {
            $scope.drugTypeList = result;
        });
        DrugSetupService.getDrugCompanyList.query({}, {} ).$promise.then(function(result) {
            $scope.drugCompanyList = result;
        });
    };

    $scope.init();

    $scope.setup = function (drugSetup) {
        var drugData = drugSetup;
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/drugs/drugSetupModal.html',
            windowClass: 'fade in',
            controller: 'DrugSetupController.DrugDefaultSetupController',
            resolve: {
                drugData: function () {
                    return drugData;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
        });
    };

});

app.controller('DrugSetupController.DrugDefaultSetupController', function($scope, $http, $filter, $modalInstance,
                                                                           limitToFilter, JsonService,
                                                                           drugData, DrugService, DrugSetupService) {
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

            DrugSetupService.getDrugDefaultSetup.query({}, {drugID:drugData.drugID,
                genericID:drugData.genericID == null ? 0 : drugData.genericID}).$promise.then(function (result) {
                if(result && result.drugSettingID){
                    $scope.editPrep(result, drugData);
                }else{
                    $scope.addPrep();
                }
            });

        });
    };

    $scope.editPrep = function (result, drugData) {
        $scope.drugData = {};
        $scope.drugData = result;
        $scope.drugData.drugName = drugData.drugName;
        $scope.drugData.drugType = drugData.typeID;
        $scope.drugData.drugTypeID = drugData.typeID;
        $scope.drugData.genericID = drugData.genericID;
        $scope.drugData.entryType = "REG";
        $scope.inItDrugsType($scope.drugData.periodList);
    };

    $scope.addPrep = function (){
        $scope.drugData = {};
        $scope.drugData.entryType = "REG";
        $scope.drugData.drugID = drugData.drugID;
        $scope.drugData.drugName = drugData.drugName;
        $scope.drugData.drugType = drugData.typeID;
        $scope.drugData.drugTypeID = drugData.typeID;
        $scope.drugData.genericID = drugData.genericID;
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
            var presDrugData = $scope.prepareDrugSaveData(isAnother);
            if(presDrugData.drugSettingID){
                $scope.updateSetup(presDrugData);
            }else{
                $scope.createSetup(presDrugData);
            }
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
        delete presDrugData.drugName;
        $scope.stringDoseMaker(presDrugData.periodList);
        return presDrugData;
    };

    $scope.createSetup = function (presDrugData) {
        DrugSetupService.createSetup.query({}, presDrugData).$promise.then(function (result) {
            $modalInstance.close();
        });
    };

    $scope.updateSetup = function (presDrugData) {
        DrugSetupService.updateSetup.query({}, presDrugData).$promise.then(function (result) {
            $modalInstance.close();
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
    $scope.bringPrescribedDrugs();
});