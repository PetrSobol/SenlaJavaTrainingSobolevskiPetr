angular.module('onlinebooksshop').controller('CloseCtrl',
		[ '$scope', '$uibModalInstance', function($scope, $uibModalInstance) {

			$scope.ok = function() {
				$uibModalInstance.close();
			};

			$scope.close = function() {
				$uibModalInstance.dismiss('cancel');
			};
		} ]);