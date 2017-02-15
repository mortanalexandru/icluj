/**
 * Created by g on 09.02.2017.
 */
angular.module("icluj", []).controller("LoginController", function($scope, $http){
    $scope.user = {};
    $scope.submit = function(){
        console.log($scope.user);
        if($scope.loginForm.$valid ) {
            login();
        }
    };
    function login(){
        $http({
            method : "POST",
            url : "/login",
            data:  $scope.user
        }).then(function mySucces(response) {
                if(response.data)
                    window.location.href = "/profile";
        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });
    }

});
