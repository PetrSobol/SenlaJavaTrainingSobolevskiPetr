SELECT DISTINCT mydb.product.model,mydb. pc.price 
FROM mydb.product JOIN mydb. pc ON mydb. product.model =mydb. pc.model WHERE maker = 'ASUS '
UNION 
SELECT DISTINCT mydb. product.model,mydb. laptop.price 
FROM mydb. product JOIN mydb. laptop ON mydb. product.model= mydb. laptop.model WHERE maker='ASUS' 
UNION 
SELECT DISTINCT mydb. product.model, mydb. printer.price 
FROM mydb. product JOIN mydb. printer ON mydb. product.model= mydb. printer.model WHERE maker='ASUS'