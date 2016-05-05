'use strict';

angular.module('posGlobal.mainView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mainView', {
    templateUrl: 'js/mainView/mainView.html',
    controller: 'mainViewCtrl'
  });
}])

.controller('mainViewCtrl', ['$scope', 'tickerService', 'accountService', 'opportunityService', 'stocksService',
  function($scope, tickerService, accountService, opportunityService, stocksService) {
   
      function graficoBolsa(canvasId, ticker) {
        canvasId = canvasId || 'myChart';
        tickerService.tickerData(ticker).then( function(dataPoints) {
	
	        var data = {
	            labels: ['L', 'M', 'X', 'J', 'V', 'L', 'M', 'X', 'J', 'V', 'L', 'M', 'X', 'J', 'V'],
	            datasets: [
	              {
	                  label: ticker,
	                  fillColor: "rgba(220,220,220,0.2)",
	                  strokeColor: "rgba(220,220,220,1)",
	                  pointColor: "rgba(220,220,220,1)",
	                  pointStrokeColor: "#fff",
	                  pointHighlightFill: "#fff",
	                  pointHighlightStroke: "rgba(220,220,220,1)",
	                  data: dataPoints
	              }
	            ]
	          };
	        var ctx = document.getElementById(canvasId).getContext("2d");
	        var chart = new Chart(ctx, {
	            type: 'line',
	      	    data: data,
	      	    options: {}
	        });
        });
      };

      function graficoHistorico(canvasId) {
      	var limit = 12;
      	var y = 8000;
      	var dataPoints = [];
      	for (var i = 0; i < limit; i += 1) {
      		y += (Math.random() * 8000 - 3000);
      		dataPoints.push(y);
      	}
        var data = {
            labels: ['M', 'J', 'J', 'A', 'S', 'O', 'N', 'D', 'E', 'F', 'M', 'A'],
            datasets: [
              {
                  label: 'Saldo',
                  fillColor: "rgba(0,220,0,0.2)",
                  strokeColor: "rgba(0,220,0,1)",
                  pointColor: "rgba(120,220,120,1)",
                  pointStrokeColor: "#fff",
                  pointHighlightFill: "#fff",
                  pointHighlightStroke: "rgba(120,120,120,1)",
                  data: dataPoints
              }
            ]
          };
        var ctx = document.getElementById(canvasId).getContext("2d");
        var chart = new Chart(ctx, {
            type: 'line',
      	    data: data,
      	    options: {}
        });
      };

      tickerService.tickers().then( function (data) {
    	  $scope.tickers = data;
          setTimeout(function () {
        	  $scope.tickers.forEach(function(ticker, index) {
                  graficoBolsa('myChart' + index, ticker);
            	  
              });
          }, 0);
      	}
      );

      stocksService.stocks().then( function (data) {
    	  $scope.stocks = data;
      	}
      );

      $scope.accounts = [];
      accountService.accountList().then( function (data) {
    	  var accountList = data;
    	  accountList.forEach(function(accountId) {
              accountService.accountMovements(accountId).then( function (movementsData) {
        		  var account = {
        				  accountId: accountId,
        				  movements: movementsData
        		  };
        		  $scope.accounts.push(account);
              });
    	  });
    	  
          
      	}
      );
      
      opportunityService.opportunity().then( function (data) {
    	  $scope.opportunity = data;
      	} 
      );

      graficoHistorico('saldoChart');
}]);