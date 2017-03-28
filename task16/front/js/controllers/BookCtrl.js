angular.module('onlinebooksshop').controller(
		"HttpBookController",
		[
				'$scope',
				'CONSTANT',
				'HttpBookService',
				'$uibModal',
				function($scope, CONSTANT, HttpBookService, $uibModal) {
					$scope.books = [];

					$scope.openAddBook = function() {
						var uibModalInstance = $uibModal.open({
							templateUrl : 'view/addBook.html',
							controller : 'CloseCtrl'
						});
					}
					$scope.deleteBookView = function() {
						var uibModalInstance = $uibModal.open({
							templateUrl : 'view/deleteBook.html',
							controller : 'CloseCtrl'
						});
					}
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
								$scope.namebook, $scope.quantityPages,
								$scope.price).then(function successCallback() {
							$scope.idWriter = '';
							$scope.namebook = '';
							$scope.quantityPages = '';
							$scope.price = '';
							console.log(CONSTANT.succes);
						}, function errorCallback() {
							console.log(CONSTANT.error);
						});

					}
					$scope.viewby = 10;
					$scope.totalItems = $scope.books.length;
					$scope.currentPage = 4;
					$scope.itemsPerPage = $scope.viewby;
					$scope.maxSize = 5; // Number of pager buttons to show

					$scope.setItemsPerPage = function(num) {
						$scope.itemsPerPage = num;
						$scope.currentPage = 1; // reset to first paghe
					}

				} ]);