package controller;

import di.DI;
import interfaces.IOnlineBook;
import property.PropertiesOnlineBook;

public class Runner {

	public static void main(String[] args) {
		DI di=new DI();
		System.out.println(PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getOnlinebook());
       	try {
			IOnlineBook onli=(IOnlineBook) di.load("IOnlainBook.class");
			if(onli==null){
				System.out.println("null");
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*for (Book book : OnlineBook.getInstance().getListBookAll()) {
			System.out.println(book.getName());

		}
		for (Order order : OnlineBook.getInstance().getListOrderAll()) {
			System.out.println(order.getLastname());
		}

       for (Book book : OnlineBook.getInstance().getListBookAll()) {
			System.out.println(book.getName());

		}*/
		// OnlineBook.getInstance().exportOrderCSV("Fedosevich");
		//OnlineBook.getInstance().saveToDataBases();
	}

}
