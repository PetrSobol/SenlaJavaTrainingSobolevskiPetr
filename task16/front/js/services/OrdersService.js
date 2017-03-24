angular.module('onlinebooksshop').service("HttpOrdersService",
		[ '$http', 'CONSTANT', function($http, CONSTANT) {

			this.getHttpAll = function() {

				return $http({
					method : CONSTANT.GET,
					url : CONSTANT.URL + CONSTANT.GETORDERS,

				});

			}
			this.getHttpDelete = function(date) {
				var req = {
					method : CONSTANT.POST,
					url : CONSTANT.URL + CONSTANT.DELETEORDERS,
					headers : {
						'Content-Type' : undefined
					},
					data : {
						"idOrder" : date
					}
				}
				return $http(req);

			}
			this.getHttpAdd = function(idBook, dCustomer) {
				var req = {
					method : CONSTANT.POST,
					url : CONSTANT.URL + CONSTANT.ADDNEWORDERS,
					headers : {
						'Content-Type' : undefined
					},
					data : {
						"idBook" : idBook,
						"idCustomer" : dCustomer
					}
				}
				return $http(req);

			}
			this.getHttpAddByCustomer = function(idCustomerTwo) {
				var req = {
					method : CONSTANT.POST,
					url : CONSTANT.URL + CONSTANT.ORDERSBYCUSTOMERS,
					headers : {
						'Content-Type' : undefined
					},
					data : {
						"idCustomer" : idCustomerTwo
					}
				}
				return $http(req);

			}

		} ]);