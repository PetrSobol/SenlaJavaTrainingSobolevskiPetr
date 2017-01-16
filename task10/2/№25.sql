SELECT DISTINCT mydb.product. maker 
FROM mydb.product 
WHERE       mydb.product .model IN ( 
SELECT mydb.pc. model 
FROM mydb. pc 
WHERE mydb.pc. ram = ( 
  SELECT MIN(mydb.pc.ram) 
  FROM mydb.pc 
  ) 
AND  mydb.pc. speed = ( 
  SELECT MAX( mydb.pc. speed) 
  FROM mydb. pc 
  WHERE mydb.pc. ram = ( 
   SELECT MIN(mydb.pc.ram) 
   FROM mydb. pc 
   ) 
  ) 
) AND 
mydb.product.   maker IN ( 
SELECT mydb.product. maker 
FROM mydb. product 
WHERE mydb.product.type='Printer' 
)
