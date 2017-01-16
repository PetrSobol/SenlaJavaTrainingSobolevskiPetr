SELECT model
FROM ( 
 SELECT mydb.pc. model, mydb.pc.price 
 FROM mydb.pc
 UNION 
 SELECT mydb.laptop. model,mydb.laptop. price 
 FROM mydb.laptop
  UNION 
 SELECT mydb.printer. model, mydb.printer. price 
 FROM mydb.printer
) t1 
WHERE  price = ( 
 SELECT MAX(t2.price) 
 FROM ( 
  SELECT mydb.pc. price 
  FROM mydb.pc 
  UNION 
  SELECT mydb.laptop. price 
  FROM mydb.laptop 
  UNION 
  SELECT mydb.printer. price 
  FROM mydb.printer 
  ) t2 
 )
