select mydb.product.maker from mydb.product,mydb.pc where mydb.product.model=mydb.pc.model and mydb.pc.speed<'450'