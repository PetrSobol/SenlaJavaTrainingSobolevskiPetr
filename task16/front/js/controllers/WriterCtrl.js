angular.module('onlinebooksshop').controller(
		"HttpWritersController",
		[
				'$scope',
				'HttpWriterService',
				'CONSTANT',
				'$uibModal',
				function($scope, HttpWriterService, CONSTANT, $uibModal) {
					$scope.exportwriters = CONSTANT.EXPORTCSVWRITER;
					$scope.url = CONSTANT.URL + CONSTANT.EXPORTWRITER;

					$scope.openAddWriter = function() {
						var uibModalInstance = $uibModal.open({
							templateUrl : 'view/addWriter.html',
							controller : 'CloseCtrl'
						});
					}
					$scope.deleteWriterView = function() {
						var uibModalInstance = $uibModal.open({
							templateUrl : 'view/deleteWriter.html',
							controller : 'CloseCtrl'
						});
					}

					$scope.GetAllWriter = function() {
						HttpWriterService.getHttpAll().then(
								function successCallback(response) {
									$scope.writers = response.data;
									console.log(CONSTANT.succes);
								}, function errorCallback(response) {
									console.log(CONSTANT.error);
								});

					};
					$scope.DeleteWriter = function() {
						HttpWriterService.getHttpDelete($scope.idWriter).then(
								function successCallback() {
									$scope.idWriter = '';
									console.log(CONSTANT.succes);
								}, function errorCallback() {
									console.log(CONSTANT.error);
								});

					}
					$scope.AddWriter = function() {
						HttpWriterService.getHttpAdd($scope.firstname,
								$scope.lastname, $scope.startdate,
								$scope.dieddate).then(
								function successCallback() {
									$scope.firstname = '';
									$scope.lastname = '';
									$scope.startdate = '';
									$scope.dieddate = '';
									console.log(CONSTANT.succes);
								}, function errorCallback() {
									console.log(CONSTANT.error);
								});

					}

				} ]);