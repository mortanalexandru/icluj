/**
 * Created by g on 01.03.2017.
 */
angular.module("icluj", ['ngMap']).controller("HomeController", function($scope, $http, NgMap){

    $scope.longitude = 23.590957;
    $scope.latitude = 46.769457;
	
    NgMap.getMap().then(function(map) {
        console.log(map.getCenter());
        console.log('markers', map.markers);
        console.log('shapes', map.shapes);
      });
    
    var getLocation = function() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(setPosition);
        } 
    };
    var setPosition = function(position) {
        $scope.longitude = position.coords.longitude;
        $scope.latitude = position.coords.latitude;
        $scope.$apply();
    };
    
    getLocation();
    
    
    var getEvents = function(){
    	$http({
            method : "GET",
            url : "/getEvents"
        }).then(function mySucces(response) {
                if(response.data){
                    $scope.events = response.data;
                };
        });
    	
    };
    
    getEvents();

});