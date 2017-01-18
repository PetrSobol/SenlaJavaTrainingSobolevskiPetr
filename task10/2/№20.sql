SELECT mydb.product.maker,count(mydb.product.model) from mydb.product where mydb.product.type='PC' group by mydb.product.maker having count(mydb.product.model)>=3 
