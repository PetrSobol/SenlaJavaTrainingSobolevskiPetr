SELECT DISTINCT sobol.product.model,sobol. pc.price 
FROM sobol.product JOIN sobol. pc ON sobol. product.model =mydb. pc.model WHERE maker = 'ASUS '
UNION 
SELECT DISTINCT sobol. product.model,sobol. laptop.price 
FROM sobol. product JOIN sobol. laptop ON sobol. product.model= sobol. laptop.model WHERE maker='ASUS' 
UNION 
SELECT DISTINCT sobol. product.model, sobol. printer.price 
FROM sobol. product JOIN sobol. printer ON sobol. product.model= sobol. printer.model WHERE maker='ASUS'