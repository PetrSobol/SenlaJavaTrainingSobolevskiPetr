angular.module('onlinebooksshop').controller(
		"HttpOrderController",
		[
				'$scope',
				'HttpOrdersService',
				'CONSTANT',
				function($scope, HttpOrdersService, CONSTANT) {
					$scope.exportorders = CONSTANT.EXPORTCSVORDERS;
					$scope.url = CONSTANT.URL + CONSTANT.EXPORTORDERS;
					$scope.GetAllOrder = function() {
						HttpOrdersService.getHttpAll().then(
								function successCallback(response) {
									$scope.orders = response.data;
									console.log(CONSTANT.succes);
								}, function errorCallback(response) {
									console.log(CONSTANT.error);
								});

					};
					$scope.DeleteOrder = function() {
						HttpOrdersService.getHttpDelete($scope.idOrder).then(
								function successCallback() {
									$scope.idOrder = '';
									console.log(CONSTANT.succes);
								}, function errorCallback() {
									console.log(CONSTANT.error);
								});

					}
					$scope.AddOrder = function() {
						HttpOrdersService.getHttpAdd($scope.idBook,
								$scope.idCustomer).then(
								function successCallback() {
									$scope.idBook = '';
									$scope.idCustomer = '';
									console.log(CONSTANT.succes);
								}, function errorCallback() {
									console.log(CONSTANT.error);
								});

					}
					$scope.AddOrderByCustomer = function() {
						HttpOrdersService.getHttpAddByCustomer(
								$scope.idCustomerTwo).then(
								function successCallback(response) {
									$scope.idCustomerTwo = '';
									$scope.ordersById = response.data;
									console.log(CONSTANT.succes);
								}, function errorCallback() {
									console.log(CONSTANT.error);
								});

					}
				
				} ]);