package com.senla.sobol.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;

public class Client {
	private Socket socket;
	private Logger loger = Logger.getLogger(Client.class.getName());
	private ObjectInputStream objectinput;
	private ObjectOutputStream objectoutput;

	public Client() {

		try {
			socket = new Socket("localhost", 6687);
			objectoutput = new ObjectOutputStream(socket.getOutputStream());
			objectinput = new ObjectInputStream(socket.getInputStream());

		} catch (IOException e) {
			loger.error(e);
		}

	}

	/**
	 * gets List with type ?
	 * 
	 * @param words
	 * @return
	 * @throws IOException
	 * @throws UnknownHostException
	 */

	public EssenceCommon getEssennce(EssenceCommon essence) {
		EssenceCommon essenceclient = null;
		try {
			objectoutput.writeObject(essence);
			essenceclient = (EssenceCommon) objectinput.readObject();
		} catch (ClassNotFoundException e) {
			loger.error(e);
		} catch (IOException e) {
			loger.error(e);
		}
		return essenceclient;
	}

	public void close() {
		if (socket != null && !socket.isClosed()) {
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
