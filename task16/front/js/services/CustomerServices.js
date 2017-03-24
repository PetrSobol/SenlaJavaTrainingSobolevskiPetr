angular.module('onlinebooksshop').service("HttpCustomerService",
		[ '$http', 'CONSTANT', function($http, CONSTANT) {

			this.getHttpAll = function() {

				return $http({
					method : CONSTANT.GET,
					url : CONSTANT.URL + CONSTANT.GETCUSTOMER

				});

			}
			this.getHttpDelete = function(date) {
				var req = {
					method : CONSTANT.POST,
					url : CONSTANT.URL + CONSTANT.DELETECUSTOMER,
					headers : {
						'Content-Type' : undefined
					},
					data : {
						"idCustomer" : date
					}
				}
				return $http(req);

			}
			this.getHttpAdd = function(firstname, lastname, phone) {
				var req = {
					method : CONSTANT.POST,
					url : CONSTANT.URL + CONSTANT.ADDNEWCUSTOMER,
					headers : {
						'Content-Type' : undefined
					},
					data : {
						"firstname" : firstname,
						"lastname" : lastname,
						"phone" : phone
					}
				}
				return $http(req);

			}

		} ]);