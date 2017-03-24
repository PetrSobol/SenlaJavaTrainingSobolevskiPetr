angular.module('onlinebooksshop').service(
		"HttpBookService",
		[
				'$http',
				'CONSTANT',
				function($http, CONSTANT) {

					this.getHttpAll = function() {

						return $http({
							method : CONSTANT.GET,
							url : CONSTANT.URL + CONSTANT.GETBOOKS

						});

					}
					this.getHttpDelete = function(date) {
						var req = {
							method : CONSTANT.POST,
							url : CONSTANT.URL + CONSTANT.DELETEBOOK,
							headers : {
								'Content-Type' : undefined
							},
							data : {
								"idBook" : date
							}
						}
						return $http(req);

					}
					this.getHttpAdd = function(idWriter, nameBook,
							quantityPages, price) {
						var req = {
							method : CONSTANT.POST,
							url : CONSTANT.URL + CONSTANT.AddBook,
							headers : {
								'Content-Type' : undefined
							},
							data : {
								"idWriter" : idWriter,
								"nameBook" : nameBook,
								"quantityPages" : quantityPages,
								"price" : price

							}
						}
						return $http(req);

					}

				} ]);