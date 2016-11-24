package com.sobolevski.senla.onlinebook.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class Client {
	private Socket socket;
	private DataOutputStream dataout;
	private static Client client;
	private Logger loger = Logger.getLogger(Client.class.getName());
	private Print print = new Print();
	private ObjectInputStream objectinput;

	private Client() {
		/**
		 * create new socket for connection server with port(6687)
		 */
		try {
			socket = new Socket("localhost", 6687);
			OutputStream output = socket.getOutputStream();
			dataout = new DataOutputStream(output);
			objectinput = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			loger.error(e);
		} catch (IOException e) {
			loger.error(e);
		}

	}

	/**
	 * creat new instance Client
	 * 
	 * @return
	 */
	public static Client getInstance() {
		if (client == null) {
			client = new Client();

		}
		return client;
	}

	/**
	 * gets List with type ?
	 * 
	 * @param words
	 * @return
	 */
	public List<?> getWordList(String words) {

		try {
			dataout.writeUTF(words);
			return (List<?>) objectinput.readObject();
		} catch (ClassNotFoundException e) {
			loger.error(e);
		} catch (IOException e) {
			loger.error(e);
		}
		return null;
	}

	/**
	 * write string on server
	 * 
	 * @param words
	 */
	public void setWord(String words) {
		try {
			dataout.writeUTF(words);
		} catch (IOException e) {
			loger.error(e);
		}
	}

	/**
	 * close socket
	 */
	public void close() {
		if (socket != null && !socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				loger.error(e);
			}
		}
	}

}
