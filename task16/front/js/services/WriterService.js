angular.module('onlinebooksshop').service(
		"HttpWriterService",
		[
				'$http',
				'CONSTANT',
				function($http, CONSTANT) {

					this.getHttpAll = function() {

						return $http({
							method : CONSTANT.GET,
							url : CONSTANT.URL + CONSTANT.GETWRITER

						});

					}
					this.getHttpDelete = function(date) {
						var req = {
							method : CONSTANT.POST,
							url : CONSTANT.URL + CONSTANT.DELETEWRITER,
							headers : {
								'Content-Type' : undefined
							},
							data : {
								"idWriter" : date
							}
						}
						return $http(req);

					}
					this.getHttpAdd = function(firstname, lastname, startdate,
							dieddate) {
						var req = {
							method : CONSTANT.POST,
							url : CONSTANT.URL + CONSTANT.ADDNEWWRITER,
							headers : {
								'Content-Type' : undefined
							},
							data : {
								"firstname" : firstname,
								"lastname" : lastname,
								"startdate" : startdate,
								"dieddate" : dieddate
							}
						}
						return $http(req);

					}

				} ]);