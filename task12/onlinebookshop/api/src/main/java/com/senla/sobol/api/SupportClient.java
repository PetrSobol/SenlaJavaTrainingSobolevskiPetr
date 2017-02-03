package com.senla.sobol.api;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class SupportClient {

	private ObjectInputStream objectinput;
	private ObjectOutputStream objectoutput;
	private Logger loger = Logger.getLogger(SupportClient.class.getName());

	public SupportClient(Socket socket) {

		try {
			
			objectoutput = new ObjectOutputStream(socket.getOutputStream());
			objectinput = new ObjectInputStream(socket.getInputStream());
		
			
		} catch (IOException e) {
			loger.error(e);
		}

	}

	public EssenceCommon getEssennce(EssenceCommon essence) {
		EssenceCommon essenceclient = null;
		try {
			objectoutput.writeObject(essence);
			objectoutput.flush();
			essenceclient = (EssenceCommon) objectinput.readObject();
		} catch (ClassNotFoundException e) {
			loger.error(e);
		} catch (IOException e) {
			loger.error(e);
		}
		return essenceclient;
	}

	public void close() {
		try {
			objectinput.close();
			objectoutput.close();
		} catch (IOException e) {
			loger.error(e);
		}

	}

}
