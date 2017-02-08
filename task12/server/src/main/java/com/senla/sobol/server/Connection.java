package com.senla.sobol.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.di.DI;
import com.senla.sobol.intarfaces.IOnlineBook;

public class Connection extends Thread {
	private Socket socket;
	private Logger loger = Logger.getLogger(Connection.class.getName());
	private ObjectOutputStream objectoutput;
	private ObjectInputStream objectinput;
	private FunctionServer function = new FunctionServer();
	private IOnlineBook onlineBook;

	/**
	 * create new connection
	 * 
	 * @param socket
	 * @param conections
	 */
	public Connection(Socket socket) {
		this.socket = socket;

		try {
			onlineBook = (IOnlineBook) DI.load(IOnlineBook.class);
			objectinput = new ObjectInputStream(socket.getInputStream());
			objectoutput = new ObjectOutputStream(socket.getOutputStream());
			start();
		} catch (IOException e) {
			loger.error(e);
		} catch (InstantiationException e) {
			loger.error(e);
		} catch (IllegalAccessException e) {
			loger.error(e);
		} catch (ClassNotFoundException e) {
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
				EssenceCommon essence = (EssenceCommon) objectinput.readObject();
				if (!essence.getNameMetod().equals("EXIT")) {
					EssenceCommon essenseserver = function.getEssenceDate(onlineBook, essence);
					objectoutput.writeObject(essenseserver);
					objectoutput.flush();
				} else {
					objectoutput.writeObject(essence);
					objectoutput.flush();
					onlineBook.closeDBConnector();
					break;
				}

			}

		} catch (IOException e) {
			loger.error(e);
		} catch (SecurityException e) {
			loger.error(e);
		} catch (ClassNotFoundException e) {
			loger.error(e);
		} catch (IllegalAccessException e) {
			loger.error(e);
		} catch (IllegalArgumentException e) {
			loger.error(e);
		} catch (InvocationTargetException e) {
			loger.error(e);
		} finally {
			try {
				objectinput.close();
				objectoutput.close();
				socket.close();
			} catch (IOException e) {
				loger.error(e);
			}
		}

	}
}
