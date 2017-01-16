SELECT DISTINCT mydb.product.maker 
FROM  mydb. product  JOIN mydb. pc  ON mydb. product .model=mydb. pc.model 
WHERE speed>=750 AND maker IN 
( SELECT mydb.product. maker 
FROM mydb. product JOIN mydb.laptop  ON mydb. product.model=mydb.laptop.model 
WHERE speed>=750 )
