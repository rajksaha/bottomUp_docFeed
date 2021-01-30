app.controller('FollowUpChartController', function($scope, $http, $modal, $rootScope, limitToFilter, $location, $filter,
                                                   FollowUpChartService, FollowUpSetupService) {

    $scope.invNameData = [];
    $scope.invData = {};
    $scope.invFollowUpChart = [];
    $scope.followUpChartData = [];
    $scope.recentStart = 0;
    $scope.recentEnd = 0;
    $scope.patientAppoinmentList = [];
    $scope.followUpData = {};

    $scope.typeHeadSelected = false;



    $scope.bringFollowUpChart = function (){


        var dataString = "query=3";

        $http({
            method: 'POST',
            url: "phpServices/followUpChart/followUpChart.php",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function (result) {
            $scope.uniqueDateList = result;
            angular.forEach($scope.uniqueDateList, function(uniqueApp, key) {
                var filteredDate = $filter('date')(uniqueApp.entryDate, "yyyy-MM-dd");
                uniqueApp.followUpDataList = angular.copy($scope.patientFollowUpList);
                angular.forEach(uniqueApp.followUpDataList, function(value, key) {
                    var dataString = "query=2" +
                        "&patientFollowUpID=" + value.followUpSerttingID +
                        "&appID=" + uniqueApp.appID +
                        "&invID=" + value.invID +
                        "&entryDate=" + filteredDate;

                    $http({
                        method: 'POST',
                        url: "phpServices/followUpChart/followUpChart.php",
                        data: dataString,
                        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                    }).success(function (result) {
                        if(result && result.length > 0 && result[0].data != ""){
                            value.data = result[0].data;
                        }
                    });
                });
            });
        });
    };

    $scope.addToPrescription = function (result) {
        result.addedInPres = !result.addedInPres;
        if(result.addedInPres){
            var contentDetail = {};
            contentDetail.entityID = $scope.appointmentData.appointmentID;
            contentDetail.shortName = $filter('date')(result.entryDate, "yyyy-MM-dd");
            contentDetail.longDesc = result.jsonData;
            FollowUpChartService.addFollowUpToPres.query({}, contentDetail).$promise.then(function (result) {
                result.contentDetailID = result;
            });
        }else if(result.contentDetailID){
            FollowUpChartService.deleteFollowUpFromPres.remove({}, {contentDetailID: result.contentDetailID}).$promise.then(function (result) {
            });
        }
    };

    $scope.editFinding = function (uDate) {
        var followUp = uDate;
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/followUpChart/followUpSetupModal.html',
            windowClass: 'fade in',
            controller: 'PatientFollowUPController',
            resolve: {
                data: function () {
                    return followUp;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.init();
        });
    };

    $scope.addFollowUp = function () {

        var followUp = {};
        followUp.appointmentID = $scope.appointmentData.appointmentID;
        followUp.patientTypeID = $scope.appointmentData.patient.patientType;
        followUp.addedInPres = 0;
        followUp.entryDate = $scope.appointmentData.appDate;
        followUp.followUpDetailList = [];
        angular.forEach($scope.followUpData.docFollowUpList, function(value, key) {
            var jsonData = {};
            jsonData.followUpID = value.followUpSettingID;
            jsonData.followUpInvName = value.invName;
            jsonData.displayOrder = value.displayOrder;
            followUp.followUpDetailList.push(jsonData);
        });

        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/followUpChart/followUpSetupModal.html',
            windowClass: 'fade in',
            controller: 'PatientFollowUPController',
            resolve: {
                data: function () {
                    return followUp;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.init();
        });
    };

    $scope.displayStatus = function (invData, index){

        var maxIndex = 3;
        if(invData.maxLength){
            maxIndex = invData.maxLength;
        }else{
            invData.minLength = 0;
        }
        if(invData.minLength <= index && index <= maxIndex){
            return true;
        }else{
            return false;
        }
    };

    $scope.progressFlow = function (invData,increment){

        if(increment){
            if(invData.maxLength){
                invData.maxLength = invData.maxLength + 1;
                invData.minLength = invData.minLength + 1;
            }else{
                invData.maxLength = 4;
                invData.minLength = invData.minLength + 1;
            }
            invData.needPrevious  = true;


        }else{
            invData.maxLength = invData.maxLength - 1;
            invData.minLength = invData.minLength - 1;
            if(invData.minLength == 0){
                invData.needPrevious = false;
            }
        }

        if((invData.invReportList.length -1) == invData.maxLength){
            invData.noNeedNext = true;
        }else{
            invData.noNeedNext = false;
        }


    };



    $scope.addFollowUpINV = function () {

        var modalInstance = $modal.open({
            templateUrl: 'javascript/templates/followUpChart/invSelectorModal.html',
            windowClass: 'fade in',
            controller: 'InvSelectorController',
            resolve: {
                record: function () {
                    return {
                    };
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.init();
        });
    };

    $scope.init = function (){
        FollowUpSetupService.getFollowUpView.query({},{doctorID:$scope.appointmentData.doctorID,
            patientID:$scope.appointmentData.patientID,
            patientTypeID: $scope.appointmentData.patient.patientType,
            appointmentID: $scope.appointmentData.appointmentID,
        }).$promise.then(function (result) {
            $scope.followUpData = result;
        });
    };

    $scope.loadAppDetail = function (){
        FollowUpChartService.getAppointmentDetail.query({}, {}).$promise.then(function (result) {
            $scope.appointmentData = result;
            $scope.init();
        });
    };
    $scope.loadAppDetail();

});


app.controller('PatientFollowUPController', function($scope, $http, $modalInstance, data, $filter, FollowUpChartService) {
    $scope.followUp = data;
    $scope.save = function () {
        if($scope.followUp.entryDate) {
            $scope.followUp.entryDateString = $filter('date')($scope.followUp.entryDate, "yyyy-MM-dd");
            if($scope.followUp.resultID){
                FollowUpChartService.update.query({}, $scope.followUp).$promise.then(function (result) {
                    $modalInstance.close();
                });
            }else{
                FollowUpChartService.create.query({}, $scope.followUp).$promise.then(function (result) {
                    $modalInstance.close();
                });
            }

        }else{
            $scope.error = true;
            $scope.errorMessage = "Date field required"
        }
    };
    $scope.cancel = function(){
        $modalInstance.close();
    };

});

app.controller('InvSelectorController', function($scope, $http, $modalInstance, limitToFilter) {

    $scope.invName = "";

    $scope.getInvName = function(term) {

        var dataString = 'query=0'+ '&invName=' + term;

        return $http({
            method: 'POST',
            url: "phpServices/inv/invService.php",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function(result) {
            $scope.invNameData = result.data;
            return limitToFilter($scope.invNameData, 10);
        });


        // return $scope.products;
    };

    $scope.invData = {};
    $scope.onSelectInvName = function(item, model, label){
        $scope.invData = item;
    };

    $scope.save = function(addAnother){

        var dataString = 'query=1'+ '&invName=' + $scope.invData.name;

        $http({
            method: 'POST',
            url: "phpServices/followUpChart/followUpChart.php",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function (result) {
            if(addAnother){
                $scope.invData.name = "";
            }else{
                $modalInstance.close();
            }
        });
    };

    $scope.cancel = function(){
        $modalInstance.close();
    };


});