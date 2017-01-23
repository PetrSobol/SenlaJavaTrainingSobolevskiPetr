SELECT model
FROM ( 
 SELECT sobol.pc. model, sobol.pc.price 
 FROM sobol.pc
 UNION 
 SELECT sobol.laptop. model,sobol.laptop. price 
 FROM sobol.laptop
  UNION 
 SELECT sobol.printer. model, sobol.printer. price 
 FROM sobol.printer
) t1 
WHERE  price = ( 
 SELECT MAX(t2.price) 
 FROM ( 
  SELECT sobol.pc. price 
  FROM sobol.pc 
  UNION 
  SELECT sobol.laptop. price 
  FROM sobol.laptop 
  UNION 
  SELECT sobol.printer. price 
  FROM sobol.printer 
  ) t2 
 )
