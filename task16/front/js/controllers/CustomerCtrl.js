angular.module('onlinebooksshop').controller(
		"HttpCustomerController",
		[
				'$scope',
				'HttpCustomerService',
				'CONSTANT',
				function($scope, HttpCustomerService, CONSTANT) {
					$scope.exportcustomer = CONSTANT.EXPORTCSVCUSTOMER;
					$scope.url = CONSTANT.URL + CONSTANT.EXPORTCUSTOMER;
					$scope.GetAllCustomer = function() {
						HttpCustomerService.getHttpAll().then(
								function successCallback(response) {
									$scope.customers = response.data;
									console.log(CONSTANT.succes);
								}, function errorCallback(response) {
									console.log(CONSTANT.error);
								});

					};
					$scope.DeleteCustomer = function() {
						HttpCustomerService.getHttpDelete($scope.idCustomer)
								.then(function successCallback() {
									$scope.idCustomer = '';
									console.log(CONSTANT.succes);
								}, function errorCallback() {
									console.log(CONSTANT.error);
								});

					}
					$scope.AddCustomer = function() {
						HttpCustomerService.getHttpAdd($scope.firstname,
								$scope.lastname, $scope.phone).then(
								function successCallback() {
									$scope.firstname = '';
									$scope.lastname = '';
									$scope.phone = '';
									console.log(CONSTANT.succes);
								}, function errorCallback() {
									console.log(CONSTANT.error);
								});

					}

				} ]);