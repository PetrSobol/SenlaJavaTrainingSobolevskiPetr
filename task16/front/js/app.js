angular.module('onlinebooksshop', [ 'ui.router' ,'ui.bootstrap']).config(
		function(       $stateProvider, $urlRouterProvider,CONSTANT) {
			$stateProvider.state('customer', {
				url : "/customer",
				templateUrl : "view/customer.html",
				controller : "HttpCustomerController"
			}).state('book', {
				url : "/book",
				templateUrl : "view/book.html",
				controller : "HttpBookController"
			}).state('orders', {
				url : "/orders",
				templateUrl : "view/orders.html",
				controller : "HttpOrderController"
			}).state('writers', {
				url : "/writers",
				templateUrl : "view/writers.html",
				controller : "HttpWritersController"
			});

			$urlRouterProvider.otherwise("/");

		})
