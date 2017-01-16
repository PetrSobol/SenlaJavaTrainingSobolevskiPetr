SELECT 
mydb. product.maker, AVG(screen) 
FROM mydb.laptop 
LEFT JOIN mydb. product ON mydb. product.model = mydb. laptop.model 
GROUP BY mydb. product.maker
