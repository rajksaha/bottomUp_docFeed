/**
 * Created by raj on 1/6/16.
 */

app.controller('MenuController', function($scope, $state) {
    $scope.changeState = function (url){
        $state.go(url);
        $('.sidebar,.sidebar-container').removeClass('active'); $('body').removeClass('sidebar-active');
    };
});
