app.controller('PrescribeNoteController', function($scope, $modal, $filter, $modalInstance, PresSaveService, noteData) {
	
	$scope.presNoteList = [];

	$scope.init = function () {
        if(noteData.presNoteList.length > 0){
            angular.forEach(noteData.presNoteList, function (value, key) {
                value.objNoteList = [];
                angular.forEach(value.noteList, function (note, key) {
                    value.objNoteList.push({text:note});
                });
            });
            $scope.presNoteList = noteData.presNoteList;
        }else{
            $scope.addNewHeader("No Header");
        }
    };

    $scope.save = function () {
        if(!$scope.headerError && validator.validateForm("#validateReq","#lblMsg_modal",null)) {
            angular.forEach($scope.presNoteList, function (value, key) {
                value.noteList = [];
                angular.forEach(value.objNoteList, function (note, key) {
                    value.noteList.push(note.text);
                });
            });
		var searchData = {};
		searchData.appointmentID = noteData.appointmentID;
		searchData.presNoteList = $scope.presNoteList;
            angular.forEach(searchData.presNoteList, function (note, key) {
                delete note.objNoteList;
            });
        PresSaveService.savePresNote.query({}, searchData).$promise.then(function (result) {
            $modalInstance.close(true);
        });
        }else{
            $scope.error = true;
        }
    };

    $scope.validateHeaderName = function (term) {
        var temp = $filter('filter')($scope.presNoteList, {header: term}, true);
        if(temp && temp.length > 1){
            $scope.headerError = true;
            $scope.error = true;
            $scope.errorMessage = "Duplicate Header Name not allowed";
        }else{
            $scope.headerError = false;
            $scope.error = false;
            $scope.errorMessage = "";
        }
    };

	$scope.addNewHeader = function (header) {
        var presNoteData = {};
        presNoteData.header = header;
        presNoteData.objNoteList = [];
        presNoteData.objNoteList.push({text:""});
        $scope.presNoteList.push(presNoteData);
    };

	$scope.close = function () {
        $modalInstance.close(true);
    };

	(function(){
		$scope.init();
    })()

	
});