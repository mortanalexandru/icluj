/**
 * Created by g on 11.01.2017.
 */
angular.module("icluj", ['file-model']).controller("RegisterController", function($scope, $http){
    $scope.user = {};
    $scope.submit = function(){
        console.log($scope.user);
        if($scope.registerForm.$valid ) {
            if(isRetypePasswordValid()) {
                saveUser();
                $scope.showRetypeError=false;
            }
            else{
                $scope.showRetypeError=true;
            }
        }
    };
    function isRetypePasswordValid(){
        if($scope.user.password == $scope.retypePassword)
            return true;
        else
            return false;
    }
    function saveUser(){
    	$scope.user.image=$scope.image.name;
        $http({
            method : "POST",
            url : "/saveUser",
            data:  $scope.user
        }).then(function mySucces(response) {
            $scope.myWelcome = response.data;
        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });
    	uploadImage($scope.image);
    }
    
    function uploadImage(file){
        $http({
            method : "POST",
            url : "/file",
            data:  {"file":file}
        }).then(function mySucces(response) {
            $scope.myWelcome = response.data;
        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });
    }
    

});