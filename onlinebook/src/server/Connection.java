package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.util.List;
import org.apache.log4j.Logger;
import com.sobol.senla.anotation.PrintableTracker;
import di.DI;
import interfaces.IOnlineBook;
import model.Book;
import model.Order;

public class Connection extends Thread {
	private DataInputStream in;
	private Socket socket;
	private IOnlineBook onlinebook;
	private Logger loger = Logger.getLogger(Connection.class.getName());
	private ObjectOutputStream objectoutput;

	/**
	 * create new connection
	 * 
	 * @param socket
	 * @param conections
	 */
	public Connection(Socket socket) {
		this.socket = socket;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
		} catch (InstantiationException e1) {
			loger.error(e1);
		} catch (IllegalAccessException e1) {
			loger.error(e1);
		} catch (ClassNotFoundException e1) {
			loger.error(e1);
		}
		try {
			InputStream input = socket.getInputStream();
			in = new DataInputStream(input);
			objectoutput = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			loger.error(e);
		}
	}

	private String[] getArrysString(String words) {
		String[] array = words.split(",");
		return array;
	}

	/**
	 * override run
	 */
	@Override
	public void run() {

		try {
			String name = in.readUTF();
			while (true) {
				switch (name) {
				case "bookall":
					objectoutput.writeObject(onlinebook.getListBookAll());
					break;
				case "orderall":
					objectoutput.writeObject(onlinebook.getListOrderAll());
					break;
				case "sortbookdate":
					objectoutput.writeObject(onlinebook.sortBookDate());
					break;

				case "sortbookprice":
					objectoutput.writeObject(onlinebook.sortBookPrice());
					break;
				case "sortbookstage":
					objectoutput.writeObject(onlinebook.sortBookStage());
					break;
				case "sortbookname":
					objectoutput.writeObject(onlinebook.sortBookName());
					break;
				case "sortorderprice":
					objectoutput.writeObject(onlinebook.sortOrderPrice());
					break;
				case "exportbook":
					onlinebook.exportBookCSV();
					break;
				case "exportorder":
					onlinebook.exportOrderCSV();
					break;
				case "importorder":
					onlinebook.importOrderCSV();
					break;
				case "importbook":
					onlinebook.importBookCSV();
					break;
				case "sortorderstage":
					List<Order> listordrer4 = onlinebook.sortOrderStage();
					objectoutput.writeObject(listordrer4);
					break;
				case "savebaseaction":
					onlinebook.saveToDataBases();
					break;
				case "bookannotation":
					String annotationbook = PrintableTracker.getInstance().prinInformation(Book.class, false);
					objectoutput.writeObject(annotationbook);
					break;
				case "bookannotationdet":
					String annotationdetbook = PrintableTracker.getInstance().prinInformation(Book.class, true);
					objectoutput.writeObject(annotationdetbook);
					break;
				case "orderannotation":
					String annotationdetorder = PrintableTracker.getInstance().prinInformation(Order.class, false);
					objectoutput.writeObject(annotationdetorder);
					break;
				case "orderannootationdet":
					String annotationdetorderdet = PrintableTracker.getInstance().prinInformation(Order.class, true);
					objectoutput.writeObject(annotationdetorderdet);
					break;
				case "addnebook":
					String[] arrastring = getArrysString(in.readUTF());
					onlinebook.addNewBook(arrastring[0], arrastring[1], Integer.parseInt(arrastring[2]),
							Integer.parseInt(arrastring[3]));
					break;
				case "addneworder":
					String[] arraystring = getArrysString(in.readUTF());
					onlinebook.addOrder(arraystring[0], arraystring[1], arraystring[2]);
					break;
				case "cloneorder":
					onlinebook.cloneOrder(in.readUTF());
					break;
				case "closeorder":
					String[] arrayclone = getArrysString(in.readUTF());
					onlinebook.closeOrder(arrayclone[0], arrayclone[1]);
					break;
				case "deletebook":
					onlinebook.deleteBook(in.readUTF());
					break;
				case "muchorder":
					String[] arraymuchorder = getArrysString(in.readUTF());
					Integer much = onlinebook.printOrderPriceToOrder(arraymuchorder[0], arraymuchorder[1]);
					objectoutput.writeObject(much.toString());
					break;
				case "ordertodate":
					String[] arrayordertodate = getArrysString(in.readUTF());
					objectoutput.writeObject(onlinebook.sortOrderDateToDate(arrayordertodate[0], arrayordertodate[1]));
					break;
				case "finishorder":
					String[] arrayfinishorder = getArrysString(in.readUTF());
					Integer finish = onlinebook.printOrderFinish(arrayfinishorder[0], arrayfinishorder[1]);
					objectoutput.writeObject(finish.toString());
					break;
				default:
					break;
				}
				if (name.equals("exit")) {
					break;
				}
			}
		} catch (IOException e1) {
			loger.error(e1);
		} catch (ClassNotFoundException e) {
			loger.error(e);
		} catch (ParseException e) {
			loger.error(e);
		} catch (CloneNotSupportedException e) {
			loger.error(e);
		} finally {
			try {
				in.close();
				objectoutput.close();
				socket.close();
				} catch (IOException e) {
				loger.error(e);
			}
		}
	}
}
