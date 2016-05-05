'use strict';

// Declare app level module which depends on views, and components
angular.module('posGlobal', [
  'ngRoute',
  'posGlobal.mainView',
  'posGlobal.tickerService',
  'posGlobal.accountService'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/mainView'});
}]);