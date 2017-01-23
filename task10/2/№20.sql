SELECT sobol.product.maker,count(sobol.product.model) from sobol.product where sobol.product.type='PC' group by sobol.product.maker having count(sobol.product.model)>=3 
