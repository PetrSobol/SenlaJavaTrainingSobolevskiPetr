SELECT 
sobol. product.maker, AVG(screen) 
FROM sobol.laptop 
LEFT JOIN sobol. product ON sobol. product.model = sobol. laptop.model 
GROUP BY sobol. product.maker
