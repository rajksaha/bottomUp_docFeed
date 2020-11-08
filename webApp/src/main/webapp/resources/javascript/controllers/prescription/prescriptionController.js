app.controller('PrescriptionController', function($scope, $http, $modal, $rootScope, limitToFilter, $location, $filter, $window, JsonService, $upload, PrescriptionService) {

    $scope.menuDataList = [];
    $scope.patientData = {};
    $scope.doctorData = {};
    $scope.patientTypeList =[];
    $scope.appoinmentData ={};
    $scope.patientStateList = [];

    $scope.refferedAdderData = {};

    $scope.prescribedDrugList = [];
    $scope.prescribedInvData = [];
    $scope.prescribedComplainData = [];
    $scope.prescribedAdviceData = [];


    $scope.numberOfPrescribedDrugs = 0;
    $scope.numberOfInvAdded = 0;
    $scope.menuState = true;



    $scope.prescribedVitalData = [];
    $scope.hideMenu= false;

    $scope.bringAppoinmentInfo = function (){
        PrescriptionService.getPrescriptionInfo.query({}, {appointmentID: $scope.appoinmentData.appointmentID}).$promise.then(function (result) {
            $scope.diagnosisData = result.diagnosis;
            $scope.prescribedDrugList = result.drug;
            $scope.prescribedInvData = result.inv;
            $scope.prescribedComplainData = result.complain;
            $scope.prescribedAdviceData = result.advice;
            $scope.prescribedVitalData = result.vital;
            $scope.familyDiseaseList = result.family;

            $scope.pastDiseaseList = result.family;
            $scope.familyDiseaseList = result.family;
            $scope.familyDiseaseList = result.family;
            $scope.familyDiseaseList = result.family;
        });
        $scope.bringPrescribedHistory($scope.appoinmentData.appointmentID, $scope.appoinmentData.patientID);
        $scope.bringPrescribedDrugHistory($scope.appoinmentData.appointmentID);
        $scope.bringPrescribedRefferedDoctor($scope.appoinmentData.appointmentID);
        $scope.bringPrescribedComment($scope.appoinmentData.appointmentID);
        $scope.bringPrescribedNextVisit($scope.appoinmentData.appointmentID);
        $scope.bringClinicalRecord($scope.appoinmentData.appointmentID);
        $scope.bringDietInfo($scope.appoinmentData.appointmentID);
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

        if(complain.durationID < 5){
            data = data + " " + complain.durationNum + " " + complain.durationType
        }
        if(complain.durationID == 7){
            data = data + " " + complain.durationType
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
        //alert('fuhh....')

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
                $scope.bringPrescribedRefferedDoctor($scope.appoinmentData.appointmentID);
            } else {

            }
        });
    };

    $scope.deleteReffredDoctor = function(redDocID){

        //var dataString = 'query=12';

        PrescriptionService.deleteReferncePrescription.remove({}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedRefferedDoctor($scope.appoinmentData.appointmentID);
            } else {

            }
        });
    };

    $scope.bringPatientInfo = function(){

        var dataString = "query=0";

        PrescriptionService.getInformationOfPatient.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.patientData = result;
            } else {

            }
        });
    };

    $scope.bringMenu = function(ID){
        PrescriptionService.getDoctorMenu.query({}, {doctorID: ID}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.menuDataList = result;
                $scope.bringAppointmentInfo();
            } else {

            }
        });

    };

    $scope.menuPopUp = function (popUp) {
        if(popUp = 'history'){
            $scope.historyModal();
        }

    };

    $scope.bringDoctorInfo = function (){

        var dataString = "query=2";

        PrescriptionService.getAppUserAccessList.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.userAccessInfo = result;
                $rootScope.userAccessInfo = $scope.userAccessInfo;
            } else {
                $location.path("/login");
            }
        });

        dataString = "query=0";

        PrescriptionService.getAllDocInfo.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.doctorData = result;
                if ($scope.doctorData.patientType == 1) {

                    dataString = "query=2" + "&doctorType=" + $scope.doctorData.category;

                    PrescriptionService.getPatientTypeByDocType.query({}, dataString).$promise.then(function (result) {
                        if (result && result.success) {
                            $scope.patientTypeList = result;
                            $scope.bringPatientInfo();
                        } else {

                        }
                    });

                    dataString = "query=5";

                    PrescriptionService.getTypeOfAppointmentList.query({}, dataString).$promise.then(function (result) {
                        if (result && result.success) {
                            $scope.patientStateList = result;
                        } else {

                        }
                    });
                }
            } else {

            }
        });
    };

    $scope.hasAccess = function(accessKey){
        if($scope.userAccessInfo){
            if($scope.userAccessInfo.userType == 'DOCTOR'){return true;}
            var temp = $filter('filter')($scope.userAccessInfo.accessList, {accessCode: accessKey}, true)[0];
            return temp == null ? false : true;
        }

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

        PrescriptionService.getUpInDelOfPtientDetail.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.patientData.type = patientType.id;
            } else {

            }
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
        PrescriptionService.getAppointmentInfo.query({}, {}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.appoinmentData = result;
                $scope.bringAppoinmentInfo();
            } else {

            }
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
        var dataString = "query=11" + '&appointmentID=' + appointmentID + '&contentType=' + 'DIET';

        PrescriptionService.getContentDetailByDiet.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.dietData.id = result[0].contentDetailID;
                $scope.dietData.dietName = result[0].detail;
            } else {

            }
        });
    };


    $scope.historyList = [];

    $scope.bringPrescribedHistory = function(appointmentID, patientID){
        $scope.historyList = [];
        angular.forEach($scope.menuDataList, function(value, key) {
            if(value.inPrescription == 2){
                var dataString = "query=5" + '&typeCode='+ value.defaultName  + '&appointmentID=' + appointmentID + '&patientID=' + patientID;

                PrescriptionService.getPrescriptionHistoryById.query({}, dataString).$promise.then(function (result) {
                    if (result && result.success) {
                        if(result){
                            var historyData = {};
                            historyData.headerName = value.menuHeader;
                            historyData.prescribedHistoryList = result;
                            $scope.historyList.push(historyData);
                        }
                    } else {

                    }
                });
            }
        });

    };

    $scope.drugHistory = [];

    $scope.bringPrescribedDrugHistory = function(appointmentID){

        $scope.drugHistory = [];

        var dataString = "query=11" + '&appointmentID=' + appointmentID + '&contentType=' + 'OLDDRUGS';

        PrescriptionService.getContentDetailByOldDrugs.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                if(result && result.length > 0){
                    var historyData = {};
                    historyData.headerName = "Old Drugs";
                    historyData.prescribedDrugList = result;
                    $scope.drugHistory.push(historyData);
                }
            } else {

            }
        });

        var dataString = "query=11" + '&appointmentID=' + appointmentID + '&contentType=' + 'CURRDRUGS';

        PrescriptionService.getContentDetailByCurrentDrugs.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                if(result && result.length > 0){
                    var historyData = {};
                    historyData.headerName = "Current Drugs";
                    historyData.prescribedDrugList = result;
                    $scope.drugHistory.push(historyData);
                }
            } else {

            }
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

        PrescriptionService.getUpInDelContentDetailByComment.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {

            } else {

            }
        });
    };


    $scope.bringPrescribedComment = function (appointmentID){

        var dataString = "query=11" + '&appointmentID=' + appointmentID + '&contentType=' + 'COMMENT';

        PrescriptionService.getContentDetailByComment.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                if(result && result.length > 0){
                    $scope.commentText = result[0].detail;
                }
            } else {

            }
        });
    };
    $scope.bringPresCribedDrugs = function (appointmentID){

        var dataString = "query=0" + '&appointmentID=' + appointmentID;

        PrescriptionService.getDrugPrescriptionByAppoinmentId.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
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
            } else {

            }
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

        $scope.invAdderData = {};

        var dataString = "query=1" + '&appointmentID=' + appointmentID;

        PrescriptionService.getInvPrescriptionByAppointmentId.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.prescribedInvData = result;
                $scope.numberOfInvAdded = $scope.prescribedInvData.length;
            } else {

            }
        });
    };

    $scope.bringPrescribedAdvice = function(appointmentID){

        var dataString = "query=2" + '&appointmentID=' + appointmentID;

        PrescriptionService.getAdvicePrescriptionByAppointmentId.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.prescribedAdviceData = result;
            } else {

            }
        });

    };

    $scope.bringPrescribedVital = function(appointmentID){

        var dataString = "query=3" + '&appointmentID=' + appointmentID;

        PrescriptionService.getVitalPrescriptionByAppointmentId.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.prescribedVitalData = result;
            } else {

            }
        });

    };

    $scope.bringPrescribedComplain = function(appointmentID){

        var dataString = "query=4" + '&appointmentID=' + appointmentID;

        PrescriptionService.getComplainPrescriptionByAppointmentId.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.prescribedComplainData = result;
            } else {

            }
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




        var dataString = "query=7" + '&appointmentID=' + appointmentID;

        PrescriptionService.getNextVistPrescriptionnByAppointmentId.query({}, dataString).$promise.then(function (result) {
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

    $scope.bringPrescribedRefferedDoctor = function (appointmentID){

        var dataString = "query=8" + '&appointmentID=' + appointmentID;

        PrescriptionService.getRefferedDoctorPrescriptionnByAppointmentId.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.refferedDoctorData = result;
            } else {

            }
        });
    };


    $scope.diagnosisData = {};

    $scope.bringPresCribedDiagnosis = function (appointmentID){

        var dataString = "query=6" + '&appointmentID=' + appointmentID;

        PrescriptionService.getDiagnosisPrescriptionnByAppointmentId.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.diagnosisData = result;
            } else {

            }
        });
    };

    $scope.pastDiseaseList = [];

    $scope.bringPrescribedPastHistory = function (appointmentID){

        var dataString = "query=9" + '&appointmentID=' + appointmentID;

        PrescriptionService.getPastDiseasePrescriptionnByAppointmentId.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.pastDiseaseList = result;
            } else {

            }
        });
    };

    $scope.deletePastHistory = function(id){

        var dataString = "query=" + 5 + "&pastHistoryID=" + id;

        PrescriptionService.delPatientAndPrescriptionDisease.remove({pastHistoryID: id}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedPastHistory($scope.appoinmentData.appointmentID);
            } else {

            }
        });
    };

    $scope.familyDiseaseList = [];

    $scope.bringPrescribedFamilyHistory = function (appointmentID){

        var dataString = "query=10" + '&appointmentID=' + appointmentID;

        PrescriptionService.getFamityHistoryPrescriptionnByAppointmentId.query({}, dataString).$promise.then(function (result) {
            if (result && result.success) {
                $scope.familyDiseaseList = result;
            } else {

            }
        });
    };

    $scope.deleteFamilyHistory = function(id){

        var dataString = "query=" + 5 + "&familyHistoryID=" + id;

        PrescriptionService.delFamilyHistoryDisease.remove({familyHistoryID: id}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedFamilyHistory($scope.appoinmentData.appointmentID);
            } else {

            }
        });
    };

    $scope.deleteVitalFromPrescibtion = function(id){

        var dataString = 'query=9'+ '&prescribedVitalID=' + id;

        PrescriptionService.delPrescribedVital.remove({prescribedVitalID: id}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedVital($scope.appoinmentData.appointmentID);
            } else {

            }
        });
    };

    $scope.deleteCCFromPresciption = function(id){

        //var data = {'id': id, 'query': 4};

        PrescriptionService.delComplainById.remove({id: id}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedComplain($scope.appoinmentData.appointmentID);
            } else {

            }
        });
    };

    $scope.deleteHistory = function(data){
        // var dataString = 'query=4'+ '&savedHistorysID=' + data.id;
        PrescriptionService.delPrescriptionHistoryById.remove({savedHistorysID: data.id}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedHistory($scope.appoinmentData.appointmentID, $scope.appoinmentData.patientID);
            } else {
            }
        });
    };

    $scope.deleteAdviceFromPresciption = function (adviceId){
        //var dataString = 'query=5'+ '&adviceID=' + parseInt(adviceId);
        PrescriptionService.delPrescriptionAdviceById.remove({adviceID: parseInt(adviceId)}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPrescribedAdvice($scope.appoinmentData.appointmentID);
            } else {

            }
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
            templateUrl: 'javascript/templates/inv/invModal.html',
            windowClass: 'fade in',
            controller: 'PrescribeInvController',
            size: 'lg',
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedInv($scope.appoinmentData.appointmentID);
        });
    };

    $scope.adviceModal = function () {

        var modalInstance = $modal.open({
            templateUrl: 'javascript/templates/advice/adviceModal.html',
            windowClass: 'fade in',
            controller: 'PrescribeAdviceController',
            size: 'lg',
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedAdvice($scope.appoinmentData.appointmentID);
        });
    };

    $scope.addVital = function () {

        var modalInstance = $modal.open({
            templateUrl: 'javascript/templates/prescription/vitalModal.html',
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
            templateUrl: 'javascript/templates/history/pastHistory.html',
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


    $scope.addCCToPrescription = function(){

        var copmplainData = {};

        var modalInstance = $modal.open({
            templateUrl: 'javascript/templates/complain/complain.html',
            windowClass: 'center-modal',
            controller: 'PrescriptionController.PrescribeComplainController',
            resolve: {
                record: function () {
                    return {
                        copmplainData
                    };
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPrescribedComplain($scope.appoinmentData.appointmentID);
        });
    };

    $scope.editPatientInfo = function () {

        var data= $scope.patientData;
        var modalInstance = $modal.open({
            templateUrl: 'javascript/templates/appointment/addNewPatient.html',
            windowClass: 'center-modal',
            controller: 'PrescriptionController.UpdatePatientInfoController',
            resolve: {
                data: function () {
                    return {
                        data
                    };
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPatientInfo();
        });
    };

    $scope.editFromPresciption = function (copmplainData){


        var modalInstance = $modal.open({
            templateUrl: 'javascript/templates/complain/complain.html',
            windowClass: 'fade in',

            controller: 'PrescriptionController.PrescribeComplainController',
            resolve: {
                record: function () {
                    return {
                        copmplainData
                    };
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
            templateUrl: 'javascript/templates/drugs/drugModalNew.html',
            windowClass: 'fade in',

            controller: 'PrescriptionController.PrescribeDrugsController',
            resolve: {
                record: function () {
                    return {
                        drugData
                    };
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPresCribedDrugs($scope.appoinmentData.appointmentID);
        });

    };

    $scope.editDrugsFromPresciption = function(drugDataDB){

        var drugData = {};

        drugData = drugDataDB;

        var modalInstance = $modal.open({
            templateUrl: 'javascript/templates/drugs/drugModalNew.html',
            windowClass: 'fade in',
            controller: 'PrescriptionController.PrescribeDrugsController',
            resolve: {
                record: function () {
                    return {
                        drugData
                    };
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringPresCribedDrugs($scope.appoinmentData.appointmentID);
        });

    };

    $scope.deletePrescribedDrug = function(drugPrescribeID){

        var dataString = "query=7" + '&drugPrescribeID=' + drugPrescribeID;

        PrescriptionService.delPrescriptionDrugById.remove({drugPrescribeID: drugPrescribeID}).$promise.then(function (result) {
            if (result && result.success) {
                $scope.bringPresCribedDrugs($scope.appoinmentData.appointmentID);
            } else {

            }
        });

    };


    $scope.printPreview = function (){
        if(!$rootScope.defaultPdf){
            var dataString = "query=20" + '&doctorID=' + $scope.doctorData.doctorID;

            PrescriptionService.getContentDetailByDocId.query({}, dataString).$promise.then(function (result) {
                if (result && result.success) {
                    if(result && result.length > 1){
                        var modalInstance = $modal.open({
                            templateUrl: 'javascript/templates/prescription/pdfSelection.html',
                            windowClass: 'fade in',
                            controller: 'PrescriptionController.PdfSelectionController',
                            resolve: {
                                record: function () {
                                    return {
                                        result
                                    };
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

    $scope.performDiganosis = function (diagnosisData) {

        var modalInstance = $modal.open({
            templateUrl: 'javascript/templates/diagnosis/diagnosis.html',
            windowClass: 'fade in',
            size: 'sm',
            controller: 'PrescriptionController.PrescribeDiagnosisController',
            resolve: {
                record: function () {
                    return {
                        diagnosisData
                    };
                }
            },
            backdrop: 'static'
        });
        modalInstance.result.then(function(result) {
            $scope.bringAppoinmentInfo();
        });
    };

    $scope.performDiet = function (dietData) {

        var modalInstance = $modal.open({
            templateUrl: 'javascript/templates/diet/diet.html',
            windowClass: 'fade in',
            size: 'sm',
            controller: 'PrescriptionController.PrescribeDietController',
            resolve: {
                record: function () {
                    return {
                        dietData
                    };
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
        $scope.bringDoctorInfo();
        $scope.bringMenu();
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