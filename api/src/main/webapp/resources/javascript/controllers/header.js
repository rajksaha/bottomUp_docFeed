/**
 * Created by raj on 1/6/16.
 */
app.controller('HeaderController', function($scope, $rootScope,$state, $location, $timeout, $modal, $http, AuthenticationService, UserSetupService) {

    $scope.dateString = new Date();
    $rootScope.baseApiUrl = 'http://localhost:8080/api/rest';
    $scope.logout = function () {
        AuthenticationService.logout().then(function() {
            $rootScope.userData = {};
            $location.path('/login');
            $scope.$emit('event:clearStatus');
        });
    };

    $scope.goUserHome = function () {
        $state.go('root.userHome');
    };

    $scope.toggoleButton = function () {
        $state.go('root.appointment');
    };



    $scope.home = function () {
        $location.path('/home');
        $scope.$emit('event:clearStatus');
    };

    $scope.showMenu = function () {
        //angular.element('#sidebar-left').toggleClass('active');
        angular.element('body').toggleClass('sidebar-active').find('#body-sidebar-left').toggleClass('active');
    };


    $rootScope.$on('event:logout', function() {
        $scope.logout();
    });

});

