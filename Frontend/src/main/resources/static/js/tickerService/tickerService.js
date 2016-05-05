'use strict';

angular
	.module('posGlobal.tickerService', [])
	.factory('tickerService', tickerService);

tickerService.$inject = ['$http'];

function tickerService ($http) {
	
    var service = {
    		tickers: tickers,
    		tickerData: tickerData
        };
   return service;

   function getResponseData(response) {
       return response.data;
   }

   function tickers() {
	   return $http.get('/ticker')
	   		.then(getResponseData);
   };

   function tickerData(ticker, limit) {
	   return $http.get('/ticker/' + ticker + "/historic")
  		.then(getResponseData);
   };
}
