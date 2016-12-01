package com.senla.sobol.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.model.IOnlineBook;

public class Connection extends Thread {
	private Socket socket;
	private IOnlineBook onlinebook;
	private Logger loger = Logger.getLogger(Connection.class.getName());
	private ObjectOutputStream objectoutput;
	private ObjectInputStream objectinput;
	private FunctionServer function = new FunctionServer();

	/**
	 * create new connection
	 * 
	 * @param socket
	 * @param conections
	 */
	public Connection(Socket socket, IOnlineBook onlineBook) {
		this.socket = socket;
		this.onlinebook = onlineBook;
		try {
			objectinput = new ObjectInputStream(socket.getInputStream());
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
				EssenceCommon essence = (EssenceCommon) objectinput.readObject();
				EssenceCommon essenseserver = function.getEssenceDate(onlinebook, essence);
				objectoutput.writeObject(essenseserver);
						
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
