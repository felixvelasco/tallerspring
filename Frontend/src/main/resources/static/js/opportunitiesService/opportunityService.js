'use strict';

angular
	.module('posGlobal.opportunityService', [])
	.factory('opportunityService', opportunityService);

tickerService.$inject = ['$http'];

function opportunityService ($http) {
	
    var service = {
    		opportunity: opportunity
        };
   return service;

   function getResponseData(response) {
       return response.data;
   }

   function opportunity() {
	   return $http.get('/opportunities')
	   		.then(getResponseData);
   };

}
