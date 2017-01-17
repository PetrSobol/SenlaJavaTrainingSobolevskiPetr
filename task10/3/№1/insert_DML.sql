INSERT INTO `mydb`.`book` (`name_Book`, `writer_Book`, `quantity_pages`, `price`) VALUES ('The Lord of the rings', 'Tolkin', '211', '10');
INSERT INTO `mydb`.`book` (`name_Book`, `writer_Book`, `quantity_pages`, `price`) VALUES ('Harry Potter', 'Rolling', '214', '11');
INSERT INTO `mydb`.`book` (`name_Book`, `writer_Book`, `quantity_pages`, `price`) VALUES ('Xobbit', 'Tolkin', '124', '8');
INSERT INTO `mydb`.`customer` (`lastname`, `firstname`) VALUES ('Sobolevski', 'Petr');
INSERT INTO `mydb`.`customer` (`lastname`, `firstname`) VALUES ('Semenov', 'Igor');
INSERT INTO `mydb`.`customer` (`lastname`, `firstname`) VALUES ('Urenkov', 'Vasilii');
INSERT INTO `mydb`.`order` (`id_book`, `id_customer`, `date_order`) VALUES ('1', '2', '12.01.2017');
INSERT INTO `mydb`.`order` (`id_book`, `id_customer`, `date_order`) VALUES ('2', '1', '11.09.2016');
INSERT INTO `mydb`.`order` (`id_book`, `id_customer`, `date_order`) VALUES ('3', '3', '11.10.2016');