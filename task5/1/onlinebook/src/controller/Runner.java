package controller;

import java.text.ParseException;

import org.apache.log4j.Logger;
import model.StageBook;

public class Runner {

	public static void main(String[] args) {
		

		Logger log =Logger.getLogger(Runner.class.getName());
		OnlineBook	onlineBook;
		try {
			onlineBook = OnlineBook.getInstance();
			
			// onlineBook.addOrder("Sidorenko", "Oleg", "SCreen");
			onlineBook.printBookAll();
			/*
			 * onlineBook.addNewBook("Moby-Dick or The Whale",
			 * "Herman Melville", 256, 2014);
			 * onlineBook.addNewBook("The Great Gatsby", "F. Scott Fitzgerald",
			 * 216, 2016); onlineBook.addNewBook("Ulysses", "James Joyce", 156,
			 * 2015); onlineBook.addNewBook("To The Lighthouse",
			 * "Virginia Woolf", 25, 1999); onlineBook.addNewBook("Pale Fire",
			 * "Vladimir Nabokov", 26, 2014);
			 * onlineBook.addNewBook("Madame Bovary", "Gustave Flaubert", 25,
			 * 2015); onlineBook.addNewBook("Great Expectations",
			 * "Herman Melville", 356, 2013);
			 * onlineBook.addNewBook("Things Fall Apart", "Chinua Achebe", 156,
			 * 2012);
			 */

			/*
			 * onlineBook.addOrder("Semenov", "Igor", "Madame Bovary");
			 * onlineBook.addOrder("Sobolevskii", "Igor", "To The Lighthouse");
			 * onlineBook.addOrder("Fedosevich", "Anton", "Great Expectations");
			 * onlineBook.addOrder("Sidorov", "Vasia", "The Great Gatsby");
			 * onlineBook.addOrder("Smonov", "Vadim", "SCreen");
			 */

			/*
			 * onlineBook.closeOrder("Semenov", "Igor");
			 * onlineBook.closeOrder("Sobolevskii", "Igor");
			 * onlineBook.closeOrder("Fedosevich", "Anton");
			 * onlineBook.closeOrder("Sidorov", "Vasia");
			 */

			System.out.println("Sort by date");
			onlineBook.printListBook(onlineBook.sortBookDate());
			System.out.println("Sort by name");
			onlineBook.printListBook(onlineBook.sortBookName());
			System.out.println("See date to date");
			onlineBook.printListOrder(onlineBook.sortOrderDateToDate("10.10.2016", "18.10.2016"));

			System.out.println("All orders");
			onlineBook.printOrderAll();
			onlineBook.saveToDataBases();
			System.out.println(StageBook.THERE_IS_STOCK);
			
			throw new ParseException(null, 0);
		} catch (ParseException e) {
			log.error(e);

		}

	}

}
