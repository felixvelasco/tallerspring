'use strict';

angular
	.module('posGlobal.stocksService', [])
	.factory('stocksService', stocksService);

tickerService.$inject = ['$http'];

function stocksService ($http) {
	
    var service = {
    		stocks: stocks
        };
   return service;

   function getResponseData(response) {
       return response.data;
   }

   function stocks() {
	   return $http.get('/stocks')
	   		.then(getResponseData);
   };

}
