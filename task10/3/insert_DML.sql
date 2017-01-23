INSERT INTO `mydb`.`writer` (`lastnameWriter`, `firstnameWriter`, `yearOfBirthday`) VALUES ('Rolling', 'Oksana', '1987.10.10');
INSERT INTO `mydb`.`writer` (`lastnameWriter`, `firstnameWriter`, `yearOfBirthday`, `diedYear`) VALUES ('Mur', 'Demmy', '1976.04.16', '2006.09.25');

INSERT INTO `mydb`.`customer` (`lastnameCustomer`, `firstnameCustomer`, `phone`) VALUES ('Sobolevski', 'Petr', '2134');
INSERT INTO `mydb`.`customer` (`lastnameCustomer`, `firstnameCustomer`, `phone`) VALUES ('Semenov', 'Igar', '4251');
INSERT INTO `mydb`.`customer` (`lastnameCustomer`, `firstnameCustomer`, `phone`) VALUES ('Verishko', 'Aleksandr', '2142');

INSERT INTO `mydb`.`book` (`idWriter`, `nameBook`, `quantityBook`, `price`) VALUES ('2', 'Harry Potter', '12', '100');
INSERT INTO `mydb`.`book` (`idWriter`, `nameBook`, `quantityBook`, `price`) VALUES ('2', 'Silmarion', '12', '112');
INSERT INTO `mydb`.`book` (`idWriter`, `nameBook`, `quantityBook`, `price`) VALUES ('1', 'The lord of the rings', '18', '111');
INSERT INTO `mydb`.`book` (`idWriter`, `nameBook`, `quantityBook`, `price`) VALUES ('3', 'Xobbit', '9', '123');

INSERT INTO `mydb`.`order` (`idCustomer`, `dBook`, `dateOrder`) VALUES ('1', '2', '2017.01.18');
INSERT INTO `mydb`.`order` (`idCustomer`, `dBook`, `dateOrder`) VALUES ('2', '1', '2017.01.18');
INSERT INTO `mydb`.`order` (`idCustomer`, `dBook`, `dateOrder`) VALUES ('1', '3', '2017.01.18');
