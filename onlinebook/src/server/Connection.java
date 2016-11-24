package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import org.apache.log4j.Logger;

import di.DI;
import interfaces.IOnlineBook;
import model.Book;
import model.Order;

public class Connection extends Thread {
	private DataInputStream in;
	private Socket socket;
	private IOnlineBook onlinebook;
	private List<Connection> connections;
	private Logger loger = Logger.getLogger(Connection.class.getName());
	private ObjectOutputStream objectoutput;

	/**
	 * create new connection
	 * 
	 * @param socket
	 * @param conections
	 */
	public Connection(Socket socket, List<Connection> conections) {
		this.socket = socket;
		this.connections = conections;
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

	/**
	 * override run
	 */
	@Override
	public void run() {

		try {
			while (true) {

				String name = in.readUTF();
				if (name.equals("bookall")) {
					try {
						List<Book> listbook = onlinebook.getListBookAll();
						objectoutput.writeObject(listbook);
					} catch (IOException e) {
						loger.error(e);
					}
				} else if (name.equals("orderall")) {
					List<Order> listordrer = onlinebook.getListOrderAll();
					objectoutput.writeObject(listordrer);
				} else if (name.equals("exit")) {
					break;
				}
			}
		} catch (IOException e1) {
			loger.error(e1);
		} finally {
			try {
				in.close();
				objectoutput.close();
				socket.close();
				connections.remove(this);
			} catch (IOException e) {
				loger.error(e);
			}

		}

	}
}
