/**
 * Created by raj on 5/21/2016.
 */
app.controller('MenuController', function($scope, $rootScope, $state, $http, $timeout, $location, UserManagementService, MenuService) {

    $scope.hasError = false;
    $scope.hasSuccess = false;
    $scope.message = "";
    $scope.menu = {};
    $scope.showForm = false;
    $scope.editObj = {};
    $scope.menuList = [];

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
        {columnHeaderDisplayName: 'Menu Name', displayProperty: 'defaultName', sortKey: 'defaultName'},
        {columnHeaderDisplayName: 'Show in Pop-up', templateUrl: 'popUp_template', sortKey: 'isPopUp'},
        {columnHeaderDisplayName: 'Show in Header', templateUrl: 'header_template', sortKey: 'isPopUp'},
        {columnHeaderDisplayName: 'Action', templateUrl: 'action_template', width: '5em'}
    ];

    //datasource configuration
    $scope.dataSourceConfig = {
        url: '/rest/menu/getAll',
        method: "GET",
        params: {},
        paginationConfig: {
            response: {
                totalItems: 'count',
                itemsLocation: 'list'
            }
        }
    };

    $scope.save = function(menu) {
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            MenuService.createMenu.query({}, menu ).$promise.then(function(result) {
                if(result && result.success) {
                    $scope.showSuccessMessage("Information saved successfully");
                    $scope.menu= {};
                    $scope.refreshList();
                    $scope.showForm = false;
                } else {
                    $scope.showErrorMessage(result.message);
                }
            });
        }

    };

    $scope.update = function(menu){
        $scope.hideMessage();
        if(validator.validateForm("#validationRequired",".validatorMsg",null)) {
            MenuService.updateMenu.query({}, menu ).$promise.then(function(result) {
                if(result && result.success) {
                    $scope.showSuccessMessage("Information updated successfully");
                    $scope.menu = {};
                    $scope.refreshList();
                    $scope.showForm = false;
                } else {
                    $scope.showErrorMessage(result.message);
                }
            });
        }
    };

    $scope.delete = function(menu){

        MenuService.deleteMenu.remove({menuID : menu.menuID} ).$promise.then(function(result) {
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

    $scope.edit = function(menu){
        $scope.menuSetup = {};
        angular.copy(menu, $scope.editObj);
        angular.copy(menu, $scope.menu);
        $scope.hideMessage();
        $scope.showForm = true;
    };

    $scope.reset = function(){
        angular.copy($scope.editObj, $scope.menu);
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
        UserManagementService.getDoctorCategory.query({}, {}).$promise.then(function(result) {
            $scope.doctorCategoryList = result;
        });
    };

    $scope.init();

});