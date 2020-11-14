app.controller('PrescriptionController', function($scope, $http, $modal, $rootScope, limitToFilter, $location, $filter, $window, JsonService, $upload, PrescriptionService, PatientService, PresSaveService, DoctorService) {

    $scope.menuDataList = [];
    $scope.patientData = {};
    $scope.doctorData = {};
    $scope.patientTypeList =[];
    $scope.appoinmentData ={};
    $scope.patientStateList = [];

    $scope.refferedAdderData = {};

    $scope.prescribedDrugList = [];
    $scope.prescribedInvData = [];
    $scope.prescribedComplainList = [];
    $scope.prescribedAdviceData = [];
    $scope.historyList = [];
    $scope.pastDiseaseList = [];
    $scope.familyDiseaseList = [];
    $scope.drugHistory = [];
    $scope.diagnosisData = {};


    $scope.numberOfPrescribedDrugs = 0;
    $scope.numberOfInvAdded = 0;
    $scope.menuState = true;



    $scope.prescribedVitalList = [];
    $scope.hideMenu= false;

    $scope.bringAppointmentDetail = function (){
        PrescriptionService.getPrescriptionInfo.query({}, {appointmentID: $scope.appoinmentData.appointmentID}).$promise.then(function (result) {
            $scope.diagnosisData = result.diagnosis;
            $scope.dietData = result.diet;
            $scope.prescribedDrugList = result.drug;
            $scope.prescribedInvData = result.inv;
            $scope.prescribedComplainList = result.complain;
            $scope.prescribedAdviceData = result.advice;
            $scope.prescribedVitalList = result.vital;
            $scope.refferedDoctorDataList = result.reference;
        });
        //$scope.bringPrescribedHistory($scope.appoinmentData.appointmentID, $scope.appoinmentData.patientID);
        // $scope.bringPrescribedDrugHistory($scope.appoinmentData.appointmentID);
        //
        //$scope.bringPrescribedReferredDoctor($scope.appoinmentData.appointmentID);
        //
        // $scope.bringPrescribedComment($scope.appoinmentData.appointmentID);
        //
        // $scope.bringPrescribedNextVisit($scope.appoinmentData.appointmentID);
        // $scope.bringClinicalRecord($scope.appoinmentData.appointmentID);
    };

    $scope.hoverIn = function(){
        this.hoverState = true;
    };

    $scope.hoverOut = function(){
        this.hoverState = false;
    };

    $scope.toggoleButton = function () {
        $scope.hideMenu = !$scope.hideMenu;
    };

    $scope.getComplainString = function (complain) {

        var data = complain.symptomName;

        if(complain.durationType != null && complain.durationType < 5){
            data = data + " " + complain.durationNum + " " + JsonService.dayTypeList[complain.durationType - 1].engName;
        }
        if(complain.durationType == 7){
            data = data + " " + JsonService.dayTypeList[complain.durationType].engName;
        }

        return data;
    };
    $scope.onFileSelect = function($files){
        $scope.file = $files[0];
        $scope.uploading = true;
        $scope.hasCsvError = false;

        $upload.upload({
            url : 'phpServices/prescription/savePhoto.php',
            method: 'POST',
            data : {},
            file: $scope.file
        }).then(function(result) {
            $scope.bringPatientInfo();
        }, function(result) {
            $scope.uploading = false;
        }, function(evt) {

        });
    };

    $scope.fixNextVisit = function (){
        $scope.nextVisitData.needSaveButton = false;

        var filteredDate = "";
        var numOfDay = 0;
        var dayType = 0;

        if($scope.nextVisitData.nextVisitType == 2){
            numOfDay = $scope.nextVisitData.numOfDay.value;
            dayType = $scope.nextVisitData.dayType.id;
        }else{
            filteredDate = $filter('date')($scope.nextVisitData.date, "yyyy-MM-dd");
            $scope.nextVisitData.nextVisitType = 1;
        }

        //var dataString = "query=8" + "&nextVisitDate=" + filteredDate + "&numOfDay=" + numOfDay + "&dayType=" + dayType + "&nextVisitType=" + $scope.nextVisitData.nextVisitType;

        PrescriptionService.deleteAndCreateNextVisit.remove({nextVisitDate: filteredDate, numOfDay: numOfDay, dayType: dayType, nextVisitType: $scope.nextVisitData.nextVisitType}).$promise.then(function(result) {
            if (result && result.success) {

            }else{

            }
        });
    };

    $scope.refDoc = {};

    $scope.getClinicalNote = function(term) {
        var dataString = 'query=22'+ '&detail=' + term;
        return $http({
            method: 'POST',
            url: "rest/autoComplete/prescription",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function(result) {
            $scope.content = result.data;
            return limitToFilter($scope.content, 10);
        });
    };

    $scope.getRefDoctor = function(term) {
        var dataString = 'query=9'+ '&refDocName=' + term;
        return $http({
            method: 'POST',
            url: "rest/autoComplete/prescription",
            data: dataString,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function(result) {
            $scope.refDoc = result.data;
            return limitToFilter($scope.refDoc, 10);
        });
    };

    $scope.onSelectRefDocotor = function(item, model, label){
        $scope.refferedAdderData.doctorAdress = item.doctorAdress;
        $scope.refferedAdderData.refDocID = item.id;
    };

    $scope.saveReffredDoctor = function(refDocData){
        if (refDocData.refDocID) {
            $scope.addReffredDoctor(refDocData.refDocID);
        } else {
            var dataString = 'query=10' + '&refDocName=' + refDocData.doctorName + '&refDocAdress=' + refDocData.doctorAdress;
            PrescriptionService.createRefferedDoctor.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    $scope.addReffredDoctor(result);
                } else {

                }
            });
        }
    };

    $scope.addReffredDoctor = function(doctorID){

        var dataString = 'query=11' + '&refDocID=' + parseInt(doctorID);

        PrescriptionService.createReferncePrescription.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedReferredDoctor($scope.appoinmentData.appointmentID);
            } else {

            }
        });
    };

    $scope.deleteReffredDoctor = function(redDocID){
        PrescriptionService.deleteReferncePrescription.remove({}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedReferredDoctor($scope.appoinmentData.appointmentID);
            } else {

            }
        });
    };

    $scope.bringDoctorInfo = function (doctorID){
        DoctorService.getDoctorDetail.query({}, {doctorID:doctorID}).$promise.then(function (result) {
            $scope.doctorData = result.doctorData;
            $scope.patientStateList = result.appointmentType;
        });
    };

    $scope.bringPatientInfo = function(patientID){
        PatientService.getPatientDetail.query({}, {patientID:patientID}).$promise.then(function (result) {
            $scope.patientData = result;
        });
    };

    $scope.menuPopUp = function (popUp) {
        if(popUp = 'history'){
            $scope.historyModal();
        }
    };

    $scope.hasAccess = function(accessKey){
        if($rootScope.userData.permissions['DOCTOR'] || $rootScope.userData.permissions[accessKey]){
            return true;
        }
        return false;
    };

    $scope.hasAccessMenu = function(main){
        if($scope.userAccessInfo){
            if($scope.userAccessInfo.userType == 'DOCTOR'){return true;}
            var temp = $filter('filter')($scope.userAccessInfo.accessList, {parentAccessID: main}, true)[0];
            return temp == null ? false : true;
        }
    };

    $scope.checkPatientType = function (type, id) {

        if(type == id){
            return true;
        }else{
            return false;
        }
    };


    $scope.changePatientType = function(patientType){
        var dataString = "query=3" + "&patientType=" + patientType.id + "&patientID=" + $scope.patientData.patientID;
        PresSaveService.updatePatientType.query({}, dataString).$promise.then(function (result) {
            $scope.patientData.type = patientType.id;
        });
    };

    $scope.changePatientState = function (patientState){

        var dataString = "query=6" + "&patientState=" + patientState.id;

        PrescriptionService.updateAppointmentByState.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.appoinmentData.appointmentType = patientState.id;
            } else {

            }
        });
    };


    $scope.bringAppointmentInfo = function (){
        PrescriptionService.getCurrentAppointment.query({}, {}).$promise.then(function (result) {
            $scope.appoinmentData = result;
            $scope.bringDoctorInfo($scope.appoinmentData.doctorID);
            $scope.bringPatientInfo($scope.appoinmentData.patientID);
            $scope.bringAppointmentDetail();
        });
    };

    $scope.clinicalRecordList = [];
    $scope.bringClinicalRecord = function (appointmentID) {
        var dataString = "query=12" + '&appointmentID=' + appointmentID + '&contentType=' + 'CLINICAL_RECORD';
        PrescriptionService.getRecordOfClinical.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.clinicalRecordList = result;
                angular.forEach($scope.clinicalRecordList, function (value, key) {
                    var dataString = "query=13" + '&appointmentID=' + appointmentID + '&contentType=' + 'CLINICAL_RECORD' + '&code=' + value.code;
                    PrescriptionService.getDetailOfClinical.query({}, dataString).$promise.then(function (result) {
                        if (result && result.success) {
                            value.followUpList = data;
                        } else {
                        }
                    });
                });
            } else {

            }
        });
    };

    $scope.bringDietInfo = function (appointmentID) {
        PrescriptionService.getPrescribedDiet.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            if(result && result.length == 1){
                $scope.dietData.id = result[0].contentDetailID;
                $scope.appointmentID = result[0].entityID;
                $scope.dietData.dietName = result[0].shortName;
            }
        });
    };
    $scope.bringPrescribedHistory = function(appointmentID, patientID){
        angular.forEach($scope.doctorData.menuDataList, function(value, key) {
            if(value.inPrescription == 2){
                PrescriptionService.getPrescribedHistory.query({}, {patientID: patientID, appointmentID:appointmentID, typeCode: value.defaultName}).$promise.then(function (result) {
                    var historyData = {};
                    historyData.headerName = value.menuHeader;
                    historyData.prescribedHistoryList = result;
                    $scope.historyList.push(historyData);
                });
            }
        });

    };

    $scope.bringPrescribedDrugHistory = function(appointmentID){
        $scope.drugHistory = [];
        PrescriptionService.getPrescribedOldDrugs.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            var historyData = {};
            historyData.headerName = "Old Drugs";
            historyData.prescribedDrugList = result;
            $scope.drugHistory.push(historyData);
        });
        PrescriptionService.getPrescribedCurrentDrug.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            var historyData = {};
            historyData.headerName = "Current Drugs";
            historyData.prescribedDrugList = result;
            $scope.drugHistory.push(historyData);
        });

    };

    $scope.removeDrugHistory = function (data){

        PrescriptionService.delDrugHistoryById.remove({ contentDetailID: data.contentDetailID}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedDrugHistory($scope.appoinmentData.appointmentID);
            } else {

            }
        });

    };

    $scope.removeClinicalHistory = function (data){

        //var dataString = "query=19" + '&contentDetailID=' + data.contentDetailID;

        PrescriptionService.delClinicalHistoryById.remove({contentDetailID: data.contentDetailID}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringClinicalRecord($scope.appoinmentData.appointmentID);
            } else {

            }
        });

    };

    $scope.deleteInvFromPresciption = function (id){

        // var dataString = 'query=5'+ '&id=' + id;

        PrescriptionService.delInvPrescriptionById.query({id: id}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedInv($scope.appoinmentData.appointmentID);
            } else {

            }
        });
    };

    $scope.updateCommentText = function (commentText){

        var dataString = "query=17" + '&comment=' + commentText;

        PresSaveService.updateComment.query({}, dataString).$promise.then(function (result) {

        });
    };


    $scope.bringPrescribedComment = function (appointmentID){
        PrescriptionService.getPrescribedComment.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            if (result && result.success) {
                if(result && result.length > 0){
                    $scope.commentText = result[0].detail;
                }
            } else {

            }
        });
    };
    $scope.bringPrescribedDrugs = function (appointmentID){
        PrescriptionService.getPrescribedDrug.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.prescribedDrugList = result;
            angular.forEach($scope.prescribedDrugList, function (value, key) {
                if (value.drugTimeID == -4) {
                    value.preiodicList[0].dose = "সপ্তাহে ১ বার";
                } else if (value.drugTimeID == -5) {
                    value.preiodicList[0].dose = "মাসে ১ বার";
                } if (value.drugTimeID == -6) {
                    value.preiodicList[0].dose = "বছরে ১ বার";
                }
            });
            $scope.vm = {
                list: $scope.prescribedDrugList
            };
        });
    };

    $scope.vm = {
        list: []
    };

    $scope.$watch('vm', function(newValue, oldValue) {
        if (oldValue && oldValue.list && oldValue.list.length > 0 && newValue !== oldValue) {
            var temp = {};
            temp.drugList = newValue.list;
            var dataString = 'jsonString=' + JSON.stringify(temp);

            PrescriptionService.updateDrugPrescriptionJson.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    console.log("done" + result);
                } else {

                }
            });
        }
    }, true);


    $scope.bringPrescribedInv = function (appointmentID){
        PrescriptionService.getPrescribedInv.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.prescribedInvData = result;
            $scope.numberOfInvAdded = $scope.prescribedInvData.length;
        });
    };

    $scope.bringPrescribedAdvice = function(appointmentID){
        PrescriptionService.getPrescribedAdvice.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.prescribedAdviceData = result;
        });
    };

    $scope.bringPrescribedVital = function(appointmentID){
        PrescriptionService.getPrescribedVital.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.prescribedVitalList = result;
        });
    };

    $scope.bringPrescribedComplain = function(appointmentID){
        PrescriptionService.getPrescribedComplain.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.prescribedComplainList = [];
            $scope.prescribedComplainList = result;
        });
    };

    $scope.nextVisitData = {};

    $scope.bringPrescribedNextVisit = function (appointmentID){
        $scope.dayList = JsonService.numberList;
        $scope.bringDayType = function (addMood, selectedDay, selectedDayTypeID){
            var dataString = "query=1";
            PrescriptionService.getDrugDayTypeList.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    $scope.dayTypeList = result;
                    $scope.dayTypeList.splice(5, 1);
                    $scope.dayTypeList.splice(4, 1);
                    if(addMood){
                        $scope.nextVisitData.numOfDay = $scope.dayList[7];
                        $scope.nextVisitData.dayType = $scope.dayTypeList[0];
                    }else{
                        angular.forEach($scope.dayTypeList, function(value, key) {
                            if(value.id == selectedDayTypeID){
                                $scope.nextVisitData.dayType = value;
                            }
                        });
                        angular.forEach($scope.dayList, function(data, key) {
                            if(data.value == selectedDay){
                                $scope.nextVisitData.numOfDay = data;
                            }
                        });
                    }
                } else {

                }
            });

        };


        PrescriptionService.getPrescribedNextVisit.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            if (result && result.success) {
                if(result.date){
                    $scope.nextVisitData = result;
                    if($scope.nextVisitData.nextVisitType == 2){
                        $scope.nextVisitData.date = "";
                        $scope.bringDayType(false, $scope.nextVisitData.numOfDay, $scope.nextVisitData.dayType);
                    }else{
                        $scope.bringDayType(true, null);
                    }
                }else{
                    $scope.nextVisitData = {};
                    $scope.nextVisitData.date = "";
                    $scope.bringDayType(true, null);
                }
            } else {

            }
        });
    };

    $scope.refferedDoctorData = {};

    $scope.bringPrescribedReferredDoctor = function (appointmentID){
        PrescriptionService.getPrescribedRefDoc.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.refferedDoctorData = result;
        });
    };


    $scope.bringPrescribedDiagnosis = function (appointmentID){
        PrescriptionService.getPrescribedDiagnosis.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.diagnosisData = result;
        });
    };

    $scope.bringPrescribedPastHistory = function (appointmentID){
        PrescriptionService.getPrescribedPastHistory.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.pastDiseaseList = result;
        });
    };

    $scope.deletePastHistory = function(id){
        PrescriptionService.deletePastHistory.remove({pastHistoryID: id}).$promise.then(function (result) {
            $scope.bringPrescribedPastHistory($scope.appoinmentData.appointmentID);
        });
    };



    $scope.bringPrescribedFamilyHistory = function (appointmentID){
        PrescriptionService.getPrescribedFamilyHistory.query({}, {appointmentID:appointmentID}).$promise.then(function (result) {
            $scope.familyDiseaseList = result;
        });
    };

    $scope.deleteFamilyHistory = function(id){
        PrescriptionService.deleteFamilyHistory.remove({familyHistoryID: id}).$promise.then(function (result) {
            $scope.bringPrescribedFamilyHistory($scope.appoinmentData.appointmentID);
        });
    };

    $scope.deleteVital = function(presVitalId, index){
        PrescriptionService.deletePrescribedVital.remove({prescribedVitalID: presVitalId}).$promise.then(function (result) {
            $scope.prescribedComplainList.splice(index, 1);
        });
    };

    $scope.deleteComplain = function(complainID, index){
        PrescriptionService.deletePrescribedComplain.remove({complainID: complainID}).$promise.then(function (result) {
            $scope.prescribedComplainList.splice(index, 1);
        });
    };

    $scope.deleteHistory = function(data){
        PrescriptionService.deletePrescribedHistory.remove({savedHistorysID: data.id}).$promise.then(function (result) {
            $scope.bringPrescribedHistory($scope.appoinmentData.appointmentID, $scope.appoinmentData.patientID);
        });
    };

    $scope.deleteAdviceFromPresciption = function (prescriptionAdviceID){
        PrescriptionService.deletePrescribedAdvice.remove({prescriptionAdviceID: prescriptionAdviceID}).$promise.then(function (result) {
            $scope.bringPrescribedAdvice($scope.appoinmentData.appointmentID);
        });
    };



    $scope.print = function (){
        $scope.printPreview();
        /*if($scope.diagnosisData.diseaseID){


         var dataString = "query=13" + '&diseaseID=' + $scope.diagnosisData.diseaseID + '&doctorID=' + $scope.doctorData.doctorID;

         $http({
         method: 'POST',
         url: "phpServices/prescription/prescriptionHelperService.php",
         data: dataString,
         headers: {'Content-Type': 'application/x-www-form-urlencoded'}
         }).success(function (result) {
         if(parseInt(result) == -1){

         var prescriptionSettingData = {};
         prescriptionSettingData.diseaseID = $scope.diagnosisData.diseaseID;
         prescriptionSettingData.diseaseName = $scope.diagnosisData.diseaseName;
         prescriptionSettingData.doctorID = $scope.doctorData.doctorID;

         var modalInstance = $modal.open({
         templateUrl: 'javascript/templates/prescription/prescriptionSetting.html',
         windowClass: 'fade in',
         controller: 'PrescriptionController.PrescriptionSettingController',
         resolve: {
         data: function () {
         return {
         prescriptionSettingData
         };
         }
         },
         backdrop: 'static'
         });
         modalInstance.result.then(function(result) {
         $scope.printPreview();
         });


         }else{
         $scope.printPreview();
         }
         });

         }else{
         $scope.printPreview();
         }*/
    };
    $scope.invModal = function () {

        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/inv/invModal.html',
            windowClass: 'fade in',
            controller: 'PrescribeInvController',
            size: 'lg',
            resolve: {
                appointmentData: function () {
                    return $scope.appoinmentData;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedInv($scope.appoinmentData.appointmentID);
        });
    };

    $scope.adviceModal = function () {
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/advice/adviceModal.html',
            windowClass: 'fade in',
            controller: 'PrescribeAdviceController',
            size: 'lg',
            resolve: {
                appointmentData: function () {
                    return $scope.appoinmentData;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedAdvice($scope.appoinmentData.appointmentID);
        });
    };

    $scope.addVital = function () {
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/prescription/vitalModal.html',
            windowClass: 'fade in',
            controller: 'PrescribeVitalController',
            size: 'lg',
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedVital($scope.appoinmentData.appointmentID);
        });
    };

    $scope.historyModal = function () {
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/history/pastHistory.html',
            windowClass: 'fade in',
            controller: 'PastHistoryController',
            size: 'lg',
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedHistory($scope.appoinmentData.appointmentID, $scope.appoinmentData.patientID);
            $scope.bringPrescribedPastHistory($scope.appoinmentData.appointmentID);
            $scope.bringPrescribedFamilyHistory($scope.appoinmentData.appointmentID);
            $scope.bringPrescribedDrugHistory($scope.appoinmentData.appointmentID);
        });
    };


    $scope.addComplain = function(){
        var complainData ={};
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/complain/complain.html',
            windowClass: 'center-modal',
            controller: 'PrescriptionController.PrescribeComplainController',
            resolve: {
                complainData: function () {
                    return complainData;
                },
                appointmentID: function () {
                    return $scope.appoinmentData.appointmentID;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedComplain($scope.appoinmentData.appointmentID);
        });
    };

    $scope.editPatientInfo = function () {
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/appointment/addNewPatient.html',
            windowClass: 'center-modal',
            controller: 'PrescriptionController.UpdatePatientInfoController',
            resolve: {
                modalConfig: function () {
                    return $scope.patientData;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPatientInfo();
        });
    };

    $scope.editComplain = function (complainData){
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/complain/complain.html',
            windowClass: 'fade in',
            controller: 'PrescriptionController.PrescribeComplainController',
            resolve: {
                complainData: function () {
                    return complainData;
                },
                appointmentID: function () {
                    return $scope.appoinmentData.appointmentID;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedComplain($scope.appoinmentData.appointmentID);
        });
    };

    $scope.addDrugsToPrescription = function(){
        var drugData = {};
        drugData.presNum = $scope.prescribedDrugList.length + 1;
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/drugs/drugModalNew.html',
            windowClass: 'fade in',
            controller: 'PrescriptionController.PrescribeDrugsController',
            resolve: {
                modalConfig: function () {
                    return drugData;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedDrugs($scope.appoinmentData.appointmentID);
        });

    };

    $scope.editDrugsFromPresciption = function(drugDataDB){

        var drugData = {};

        drugData = drugDataDB;

        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/drugs/drugModalNew.html',
            windowClass: 'fade in',
            controller: 'PrescriptionController.PrescribeDrugsController',
            resolve: {
                modalConfig: function () {
                    return drugData;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedDrugs($scope.appoinmentData.appointmentID);
        });

    };

    $scope.deletePrescribedDrug = function(drugPrescribeID){
        PrescriptionService.deletePrescribedDrug.remove({drugPrescribeID: drugPrescribeID}).$promise.then(function (result) {
            $scope.bringPrescribedDrugs($scope.appoinmentData.appointmentID);
        });
    };


    $scope.printPreview = function (){
        if(!$rootScope.defaultPdf){
            var dataString = "query=20" + '&doctorID=' + $scope.doctorData.doctorID;

            PrescriptionService.getContentDetailByDocId.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    if(result && result.length > 1){
                        var modalInstance = $modal.open({
                            templateUrl: 'resources/javascript/templates/prescription/pdfSelection.html',
                            windowClass: 'fade in',
                            controller: 'PrescriptionController.PdfSelectionController',
                            resolve: {
                                modalConfig: function () {
                                    return result;
                                }
                            },
                            backdrop: 'static'
                        });
                        modalInstance.result.then(function(modalResult) {
                            $rootScope.defaultPdf = modalResult.code;
                            $scope.openPdf(modalResult.code);
                        });

                    }else if(result && result.length == 1) {
                        $rootScope.defaultPdf = result[0].code;
                        $scope.openPdf(result[0].code);
                    }else{
                        $rootScope.defaultPdf = "default";
                        $scope.openPdf("default");
                    }
                } else {

                }
            });
        }else {
            $scope.openPdf($rootScope.defaultPdf);
        }
    };

    $scope.openPdf = function(pdf){
        var dataString = "query=15";

        PrescriptionService.updateAppoinmentStatusByApointmentNo.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $window.open("mpdf/" + pdf + ".php", '_blank');
                $location.path("/appointment");
            } else {

            }
        });
    };

    $scope.performDiagnosis = function () {

        if($scope.diagnosisData == null){
            $scope.diagnosisData = {};
            $scope.diagnosisData.appointmentID = $scope.appoinmentData.appointmentID;
        }
        var diagnosisData = {};
        angular.copy($scope.diagnosisData, diagnosisData);
        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/diagnosis/diagnosis.html',
            windowClass: 'fade in',
            size: 'sm',
            controller: 'PrescriptionController.PrescribeDiagnosisController',
            resolve: {
                diagnosisData: function () {
                    return diagnosisData;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringAppointmentDetail();
        });
    };

    $scope.performDiet = function () {

        if($scope.dietData == null){
            $scope.dietData = {};
            $scope.dietData.appointmentID = $scope.appoinmentData.appointmentID;
        }
        var dietData = {};
        angular.copy($scope.dietData, dietData);

        var modalInstance = $modal.open({
            templateUrl: 'resources/javascript/templates/diet/diet.html',
            windowClass: 'fade in',
            size: 'sm',
            controller: 'PrescriptionController.PrescribeDietController',
            resolve: {
                dietData: function () {
                    return dietData;
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringDietInfo($scope.appoinmentData.appointmentID);
        });
    };

    $scope.patientInfoEdit = false;


    $scope.cancelPatientInfo = function(){
        $scope.patientInfoEdit = false;
    };

    $scope.inIt = function (){
        $scope.bringAppointmentInfo();
    };

    $scope.inIt();


});

app.controller('PrescriptionController.UpdatePatientInfoController', function($scope, $modalInstance, data, $http) {

    $scope.patientData = {};
    $scope.patientData = data.data;
    $scope.error = false;
    $scope.errorMessage = "";


    $scope.save = function (){

        if(validator.validateForm("#validateReq","#lblMsg_modal",null)) {
            var dataString = 'name='+ $scope.patientData.name +
                '&age='+ $scope.patientData.age +
                '&address='+ $scope.patientData.address +
                '&sex=' + $scope.patientData.sex +
                '&phone='+ $scope.patientData.phone+
                '&occupation='+ $scope.patientData.occupation +
                '&referredBy='+ $scope.patientData.referredBy +
                '&hospitalName='+ $scope.patientData.hospitalName +
                '&bedNum='+ $scope.patientData.bedNum +
                '&wardNum='+ $scope.patientData.wardNum +
                '&headOfUnit='+ $scope.patientData.headOfUnit +
                '&id='+ $scope.patientData.patientID +
                '&query=16';

            PrescriptionService.updatePatientByAll.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    $modalInstance.close(true);
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