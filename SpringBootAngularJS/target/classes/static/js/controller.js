var app = angular.module('testApp', []);
app.controller('userController', function($scope, $http, $location,$window) {
	$scope.submitForm = function(){
		var url = $location.absUrl() + "postcustomer";
		
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
            firstname: $scope.firstname,
            lastname: $scope.lastname
        };
		
		$http.post(url, data, config).then(function (response) {
			/*if(response.data=="Successful!")//can this be a condition??
			{
				document.write("<button>currentstock</button>");
				document.write("<button>Savedstock</button>");
			}*/
			//$window.alert(response.data);
			$scope.postResultMessage = response.data;
			}, function error(response) {
			//$window.alert("Check username and password");
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
		$scope.firstname = "";
		$scope.lastname = "";
		
	}
});

/*app.controller('getcontroller', function($scope, $http, $location) {
	$scope.getfunction = function(){
		var url = $location.absUrl() + "getallcustomer";
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});*/