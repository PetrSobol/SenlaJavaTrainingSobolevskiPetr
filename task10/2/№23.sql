SELECT DISTINCT sobol.product.maker 
FROM  sobol. product  JOIN sobol. pc  ON sobol. product .model=sobol. pc.model 
WHERE speed>=750 AND maker IN 
( SELECT sobol.product. maker 
FROM sobol. product JOIN sobol.laptop  ON sobol. product.model=sobol.laptop.model 
WHERE speed>=750 )
