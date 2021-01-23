/**
 * Created by raj on 5/21/2016.
 */
app.controller('ContentMenuSetupController', function($scope, $rootScope, $filter, $state, $http, $timeout, $location, MenuService, UserManagementService) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.menuSetup = {};
    $scope.showForm = false;
    $scope.editObj = {};
    $scope.menuList = [];
    $scope.menuSetupList = [];


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
        {columnHeaderDisplayName: 'Menu Name', displayProperty: 'menuHeader', sortKey: 'menuHeader'},
        {columnHeaderDisplayName: 'Display Order', displayProperty: 'displayOrder', sortKey: 'displayOrder'},
        {columnHeaderDisplayName: 'Action', templateUrl: 'action_template', width: '5em'}
    ];

    //datasource configuration
    $scope.dataSourceConfig = {
        url: '/api/rest/menuSetting/getAll',
        method: "GET",
        params: {},
        paginationConfig: {
            response: {
                totalItems: 'count',
                itemsLocation: 'list'
            }
        }
    };

    $scope.save = function(menuSetup) {
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            if(!$rootScope.userData.permissions['DOCTOR']){
                menuSetup.doctorID = $scope.selectedDocID;
            }
            MenuService.createMenuSetup.query({}, menuSetup ).$promise.then(function(result) {
                if(result && result.success) {
                    $scope.showSuccessMessage("Information saved successfully");
                    $scope.menuSetup = {};
                    $scope.refreshList();
                    $scope.showForm = false;
                } else {
                    $scope.showErrorMessage(result.message);
                }
            });
        }

    };

    $scope.update = function(menuSetup){
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            if(!$rootScope.userData.permissions['DOCTOR']){
                menuSetup.doctorID = $scope.selectedDocID;
            }
            MenuService.updateMenuSetup.query({}, menuSetup ).$promise.then(function(result) {
                if(result && result.success) {
                    $scope.showSuccessMessage("Information updated successfully");
                    $scope.menuSetup = {};
                    $scope.refreshList();
                    $scope.showForm = false;
                } else {
                    $scope.showErrorMessage(result.message);
                }
            });
        }
    };

    $scope.delete = function(menuSetup){

        MenuService.deleteMenuSetup.remove({menuSettingID : menuSetup.menuSettingID} ).$promise.then(function(result) {
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

    $scope.edit = function(menuSetup){
        $scope.menuSetup = {};
        angular.copy(menuSetup, $scope.editObj);
        angular.copy(menuSetup, $scope.menuSetup);
        $scope.hideMessage();
        $scope.showForm = true;
    };

    $scope.reset = function(){
        angular.copy($scope.editObj, $scope.menuSetup);
        $scope.hideMessage();
    };

    $scope.add = function(){
        $scope.editObj = {};
        $scope.menuSetup = {};
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

    $scope.loadMenu = function (selectedDocID) {
        $scope.searchParam.doctorID = selectedDocID;
        $scope.selectedDocID = selectedDocID;
        $scope.search();
        var temp = $filter('filter')($scope.doctorList, {doctorID:selectedDocID}, true)[0];
        $scope.selectedDocCategoryID = temp.categoryID;
        MenuService.getByCategory.query({}, {categoryID:$scope.selectedDocCategoryID} ).$promise.then(function(result) {
            $scope.menuList = result;
        });
    };

    $scope.init = function(){
        if(!$rootScope.userData.permissions['DOCTOR']){
            UserManagementService.getCompanyDoctor.query({}, {}).$promise.then(function(result) {
                $scope.doctorList = result;
                $scope.selectedDocID = null;
            });
        }else{
            MenuService.getMenuByParam.query({}, {}).$promise.then(function(result) {
                $scope.menuList = result;
            });
        }
    };

    $scope.init();

});