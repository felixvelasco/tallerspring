'use strict';

angular
	.module('posGlobal.accountService', [])
	.factory('accountService', accountService);

accountService.$inject = ['$http'];

function accountService ($http) {
	
    var service = {
    		accountList: accountList,
    		accountMovements: accountMovements
        };
   return service;

   function getResponseData(response) {
       var result = response.data;
       if(result && Array === result.constructor) {
    	   result.forEach(function(element) {
        	   if (element.fecha) {
        		   element.fecha = new Date(element.fecha);
               }
    	   });
       }

       
       return result;
   }

   function accountList() {
	   return $http.get('/account')
	   		.then(getResponseData);
   };

   function accountMovements(accountId, limit) {
	   return $http.get('/account/' + accountId + "/movements")
  		.then(getResponseData);
   };
}
