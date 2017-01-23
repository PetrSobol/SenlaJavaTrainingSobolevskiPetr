SELECT DISTINCT sobol.product. maker 
FROM sobol.product 
WHERE       sobol.product .model IN ( 
SELECT sobol.pc. model 
FROM sobol. pc 
WHERE sobol.pc. ram = ( 
  SELECT MIN(sobol.pc.ram) 
  FROM sobol.pc 
  ) 
AND  sobol.pc. speed = ( 
  SELECT MAX( sobol.pc. speed) 
  FROM sobol. pc 
  WHERE sobol.pc. ram = ( 
   SELECT MIN(sobol.pc.ram) 
   FROM sobol. pc 
   ) 
  ) 
) AND 
sobol.product.   maker IN ( 
SELECT sobol.product. maker 
FROM sobol. product 
WHERE sobol.product.type='Printer' 
)
