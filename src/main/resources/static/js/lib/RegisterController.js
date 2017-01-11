/**
 * Created by g on 11.01.2017.
 */
angular.module("icluj", []).controller("RegisterController", function($scope){
    $scope.submit = function(){
        console.log($scope.username);
    };
});