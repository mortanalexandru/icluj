/**
 * Created by g on 01.03.2017.
 */
angular.module("icluj", []).controller("HomeController", function($scope, $http){
    $scope.user = {};
    $scope.submit = function(){
        console.log($scope.user);
        if($scope.loginForm.$valid ) {
            login();
        }
    };
});