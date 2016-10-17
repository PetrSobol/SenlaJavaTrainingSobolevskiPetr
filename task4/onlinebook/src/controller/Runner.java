package controller;

import java.text.ParseException;

public class Runner {

	public static void main(String[] args) {

		OnlineBook onlineBook;
		try {
			onlineBook = new OnlineBook();
			System.out.println("Список книг");
			onlineBook.printBookOll();
			System.out.println("Список заказов");
			onlineBook.printOrderOll();
			System.out.println("Добавляем новый заказ");
            onlineBook.addOrder("Fedosevich", "Oksana", "Xobbit");
            onlineBook.addOrder("Tarachkevich", "Leon", "Catch-22");
            onlineBook.printOrderOll();
            onlineBook.printBookOll();
            System.out.println("Закрываем заказ");
            onlineBook.closeOrder("Tarachkevich", "Leon");
            onlineBook.printOrderOll();
            onlineBook.printBookOll();
            onlineBook.printOrderDateToDate("10.10.2016", "16.10.2016");
			onlineBook.printOrderPriceToOrder("10.10.2016", "16.10.2016");
			onlineBook.printOrderFinish("10.10.2016", "16.10.2016");
			System.out.println("Сохраняем в базу данных");
			onlineBook.saveToDataBases();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
