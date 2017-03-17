var firstModel = angular.module('onlinebooksshop', []);

firstModel
		.controller(
				"HttpGetController",
				[
						'$scope',
						'$http',
						function($scope, $http) {
							$scope.GetAllBook = function() {
								$http(
										{
											method : 'GET',
											url : 'http://localhost:8080/webbookonline/GetBooks'
										}).then(
										function successCallback(response) {
											$scope.books = response.data;
											console.log('success');
										}, function errorCallback(response) {
											console.log('error');
										});

							};
							$scope.DeleteBook = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/DeletBook',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"idBook" : $scope.idBook
									}
								}
								$http(req).then(function successCallback() {
									$scope.idBook = '';
									console.log('success')
								}, function errorCallback() {
									console.log('error')
								});

							}
							$scope.AddBook = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/AddBooks',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"idWriter" : $scope.idWriter,
										"nameBook" : $scope.nameBook,
										"quantityPages" : $scope.quantityPages,
										"price" : $scope.price
									}
								}
								$http(req).then(function successCallback() {
									$scope.idWriter = '';
									$scope.nameBook = '';
									$scope.quantityPages = '';
									$scope.price = '';
									console.log('success')
								}, function errorCallback() {
									console.log('error')
								});

							}
							$scope.GetAllWriter = function() {
								$http(
										{
											method : 'GET',
											url : 'http://localhost:8080/webbookonline/GetWriter'
										}).then(
										function successCallback(response) {
											$scope.writers = response.data;
											console.log('success');
										}, function errorCallback(response) {
											console.log(response);
										});

							};
							$scope.DeleteWriter = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/DeletWriter',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"idWriter" : $scope.idWriter
									}
								}
								$http(req).then(function successCallback() {
									$scope.idWriter = '';
									console.log('success')
								}, function errorCallback() {
									console.log('error')
								});

							}
							$scope.AddWriter = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/AddNewWriter',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"firstname" : $scope.firstname,
										"lastname" : $scope.lastname,
										"startdate" : $scope.startdate,
										"dieddate" : $scope.dieddate
									}
								}
								$http(req).then(function successCallback() {
									$scope.firstname = '';
									$scope.lastname = '';
									$scope.startdate = '';
									$scope.dieddate = '';
									console.log('success')
								}, function errorCallback() {
									console.log('error')
								});

							}
							$scope.GetAllCustomer = function() {
								$http(
										{
											method : 'GET',
											url : 'http://localhost:8080/webbookonline/GetCustomer'
										}).then(
										function successCallback(response) {
											$scope.customers = response.data;
											console.log('success');
										}, function errorCallback(response) {
											console.log('error');
										});

							};
							$scope.DeleteCustomer = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/DeleteCustomer',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"idCustomer" : $scope.idCustomer
									}
								}
								$http(req).then(function successCallback() {
									$scope.idCustomer = '';
									console.log('success')
								}, function errorCallback() {
									console.log('error')
								});

							}
							$scope.AddCustomer = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/AddNewCustomer',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"firstname" : $scope.firstname,
										"lastname" : $scope.lastname,
										"phone" : $scope.phone
									}
								}
								$http(req).then(function successCallback() {
									$scope.firstname = '';
									$scope.lastname = '';
									$scope.phone = '';
									console.log('success')
								}, function errorCallback() {
									console.log('error')
								});

							}
							$scope.GetAllOrder = function() {
								$http(
										{
											method : 'GET',
											url : 'http://localhost:8080/webbookonline/GetOrders'
										}).then(
										function successCallback(response) {
											$scope.orders = response.data;
											console.log('success');
										}, function errorCallback(response) {
											console.log(response);
										});

							};
							$scope.DeleteOrder = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/DeleteOrder',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"idOrder" : $scope.idOrder
									}
								}
								$http(req).then(function successCallback() {
									$scope.idOrder = '';
									console.log('success')
								}, function errorCallback() {
									console.log('error')
								});

							}
							$scope.AddOrder = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/AddNewOrder',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"idBook" : $scope.idBook,
										"idCustomer" : $scope.idCustomer
									}
								}
								$http(req).then(function successCallback() {
									$scope.idBook = '';
									$scope.idCustomer = '';
									console.log('success')
								}, function errorCallback() {
									console.log('error')
								});

							}
							$scope.AddOrderByCustomer = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/OrderByIdCustomer',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"idCustomer" : $scope.idCustomerTwo
									}
								}
								$http(req).then(
										function successCallback(response) {
											$scope.idCustomerTwo = '';
											$scope.ordersById = response.data;
											console.log('success');
										}, function errorCallback() {
											console.log('error')
										});

							}
							$scope.importBook = function() {
								var req = {
									method : 'POST',
									url : 'http://localhost:8080/webbookonline/ImportCustomer',
									headers : {
										'Content-Type' : undefined
									},
									data : {
										"idCustomer" : $scope.idCustomerTwo
									}
								}
								$http(req).then(
										function successCallback(response) {
											$scope.idCustomerTwo = '';
											$scope.ordersById = response.data;
											console.log('success');
										}, function errorCallback() {
											console.log('error')
										});

							}
											} ]);
