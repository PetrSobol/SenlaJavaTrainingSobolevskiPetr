package com.senla.sobol.client;

import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Navigator;

public class Client {
	private Socket socket;
	private Logger loger = Logger.getLogger(Client.class.getName());

	public Client() {

		try {

			socket = new Socket("localhost", 6687);
			SupportClient support = new SupportClient(socket);
			Navigator navigator = new Navigator(support);
			navigator.startMenu();

		} catch (IOException e) {
			loger.error(e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				loger.error(e);
			}
		}

	}

}
