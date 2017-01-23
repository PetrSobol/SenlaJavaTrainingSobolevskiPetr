SELECT DISTINCT p1.model, p2.model, p1.speed, p1.ram 
FROM sobol.pc p1, sobol.pc p2 
WHERE p1.speed = p2.speed AND p1.ram = p2.ram AND p1.model > p2.model