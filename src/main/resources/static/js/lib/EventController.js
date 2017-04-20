angular.module("icluj", []).controller("EventController", function($scope, $window, $http){
	    var getEvent = function(id){
	    	var p = $http({
	    		params:{
	    			"id": id
	    		},
	    		url:"/getEvent",
	    		method:"GET"
	    	});
	    	p.then(function mySucces(response){
	    		if(response.data){
	    			$scope.event=response.data;
	    		};
	    	});
	    };
	    
	    var getUrlParam = function(url, paramName){
	    	var vars = [], hash;
			var hashes = url.slice(url.indexOf('?') + 1).split("#")[0].split('&');
			for (var i = 0; i < hashes.length; i++) {
				hash = hashes[i].split('=');
				vars.push(hash[0]);
				vars[hash[0]] = hash[1];
			}
			return vars[paramName];
	    };
	    var id = getUrlParam($window.location.href, "id");
	    getEvent(id);
	    
	    $scope.claim=function(){
	    	$http({
	    		data:id,
	    		url:"/claimEvent",
	    		method:"POST"
	    	}).then(function mySucces(response){
	    		$scope.event.attended=response.data;
	    	});
	    }
});
