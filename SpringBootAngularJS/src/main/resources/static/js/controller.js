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
			if(response.data=="Successful!")
			{
				//$("form").hide();
				$scope.postResultMessage = true;
				console.log($scope.firstname);
				myFunction();
				var s=document.getElementById("name");
				s.value="Hi"; 
			}
			else
			{
				$window.alert("Check username and password");
				$scope.postResultMessage = false;
			}
			//$window.alert(response.data);
			}, function error(response) {
			//$window.alert("Check username and password");
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
		//$scope.firstname = "";
		//$scope.lastname = "";
		
	}
});


function myFunction() {
	
	console.log("myFunction");
	
	document.getElementById("form").style="display:none";
	document.getElementById("img").style="display:none";
	
	
}
app.controller('getcontroller', function($scope, $http, $location) {
	var s,r;
	$scope.getfunction = function(){
		console.log("getallcustomer")
		var url = $location.absUrl() + "getallcustomer";
		
		$http.get(url).then(function (response) {
			 s=response.data;
			 $scope.response =s;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
	}
	/*$scope.selected = [];
	$scope.exist = function(item){
	return $scope.selected.indexOf(item) > -1;
	}*/
	$scope.getSaved = function(){
		console.log("getcustomer")
		var url = $location.absUrl() + "getSaved";
		var r;
		var config = {
                headers : {
                    'Accept': '*/*'
                }
        }
		var data =$scope.firstname;
		
		$http.post(url, data, config).then(function (response) {
			console.log("hello");
			r=response.data;
			$scope.response1 =r;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
	}
	$scope.toggleSelection = function(item){
		var my_date=new Date();
		var month=parseInt(my_date.getMonth())+1;
		var String=my_date.getDate()+"-"+month+"-"+my_date.getFullYear();
		var str=my_date.getHours()+":"+my_date.getMinutes();
		console.log(month);
		console.log($scope.firstname);
		console.log(item.stockName);
		console.log(String);
		console.log(item.nsePrice);
		console.log(item.bsePrice);
		console.log(item.profit);
var url = $location.absUrl() + "saveData";
		
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
            stockName: item.stockName,
            date: String,
            time: str,
            userId: $scope.firstname,
            nsePrice: item.nsePrice,
            bsePrice: item.bsePrice,
            profit: item.profit
        };
		
		$http.post(url, data, config).then(function (response) {
			if(response.data=="successful")
			{
				console.log("inserted");
			}
			else
			{
				console.log("failed")
			}
			//$window.alert(response.data);
			}, function error(response) {
			//$window.alert("Check username and password");
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});