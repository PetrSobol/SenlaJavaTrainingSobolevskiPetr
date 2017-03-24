angular.module('onlinebooksshop').controller(
		"HttpBookController",
		[
				'$scope',
				'CONSTANT',
				'HttpBookService',
				function($scope, CONSTANT, HttpBookService) {

					$scope.exportbook = CONSTANT.EXPORTCSVBOOK;
					$scope.url = CONSTANT.URL + CONSTANT.ExportBook;

					$scope.GetAllBook = function() {
						HttpBookService.getHttpAll().then(
								function successCallback(response) {
									$scope.books = response.data;
									console.log(CONSTANT.succes);
								}, function errorCallback(response) {
									console.log(CONSTANT.error);
								});

					};
					$scope.DeleteBook = function() {
						HttpBookService.getHttpDelete($scope.idBook).then(
								function successCallback() {
									$scope.idBook = '';
									console.log(CONSTANT.succes);
								}, function errorCallback() {
									console.log(CONSTANT.error);
								});

					}
					$scope.AddBook = function() {
						HttpBookService.getHttpAdd($scope.idWriter,
								$scope.nameBook, $scope.quantityPages,
								$scope.price).then(function successCallback() {
							$scope.idWriter = '';
							$scope.nameBook = '';
							$scope.quantityPages = '';
							$scope.price = '';
							console.log(CONSTANT.succes);
						}, function errorCallback() {
							console.log(CONSTANT.error);
						});

					}

				} ]);