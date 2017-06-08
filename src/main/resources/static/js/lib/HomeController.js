/**
 * Created by g on 01.03.2017.
 */
angular.module("icluj", ['ngMap']).controller("HomeController", function($scope, $http,$window, NgMap){

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
    setTimeout(getLocation,30000);
    
    
    
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
    
    $scope.openEvent=function(id, lat, long){
    	
    	if(getDistanceFromLatLonInKm(lat, long, $scope.latitude, $scope.longitude)<=25){
    	$window.location.href="/event?id="+id;
    	}
    console.log(getDistanceFromLatLonInKm(lat, long, $scope.latitude, $scope.longitude));
    }

    function getDistanceFromLatLonInKm(lat1,lon1,lat2,lon2) {
    	  var R = 6371; // Radius of the earth in km
    	  var dLat = deg2rad(lat2-lat1);  // deg2rad below
    	  var dLon = deg2rad(lon2-lon1); 
    	  var a = 
    	    Math.sin(dLat/2) * Math.sin(dLat/2) +
    	    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
    	    Math.sin(dLon/2) * Math.sin(dLon/2)
    	    ; 
    	  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
    	  var d = R * c; // Distance in km
    	  return d*1000;
    	}

    	function deg2rad(deg) {
    	  return deg * (Math.PI/180)
    	}
});