package com.sobolevski.senla.onlinebook.operationmenu;

import com.senla.sobol.client.Client;
import com.senla.sobol.di.DI;

public class Runner {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Client client = (Client) DI.load(Client.class);
		Navigator navigator = new Navigator();
		navigator.startMenu();

	}
}
