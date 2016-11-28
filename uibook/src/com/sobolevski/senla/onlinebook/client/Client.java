package com.sobolevski.senla.onlinebook.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.log4j.Logger;

public class Client {
	private Socket socket;
	private DataOutputStream dataout;
	private static Client client;
	private Logger loger = Logger.getLogger(Client.class.getName());
	private ObjectInputStream objectinput;

	private Client() {
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
	 * @throws IOException
	 * @throws UnknownHostException
	 */

	public List<?> getWordList(String wordsnamecommand) {

		try {
			dataout.writeUTF(wordsnamecommand);
			return (List<?>) objectinput.readObject();
		} catch (ClassNotFoundException e) {
			loger.error(e);
		} catch (IOException e) {
			loger.error(e);
		}
		return null;
	}

	public List<?> getDateList(String wordsnamecommand, String date) {

		try {
			dataout.writeUTF(wordsnamecommand);
			dataout.writeUTF(date);
			return (List<?>) objectinput.readObject();
		} catch (ClassNotFoundException e) {
			loger.error(e);
		} catch (IOException e) {
			loger.error(e);
		}
		return null;
	}

	public void goWord(String words) {
		try {
			dataout.writeUTF(words);
		} catch (IOException e) {
			loger.error(e);
		}
	}

	public String getWordString(String wordsnamecommand) {
		try {
			dataout.writeUTF(wordsnamecommand);
			return (String) objectinput.readObject();
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
	public void setWord(String wordsnamecommand) {
		try {
			dataout.writeUTF(wordsnamecommand);
		} catch (IOException e) {
			loger.error(e);
		}
	}

	public void setDateToServer(String wordsnamecommand, String stringdate) {
		try {
			dataout.writeUTF(wordsnamecommand);
			dataout.writeUTF(stringdate);

		} catch (IOException e) {
			loger.error(e);
		}

	}

	public String getDateServer(String wordsnamecommand, String stringdate) {
		try {
			dataout.writeUTF(wordsnamecommand);
			dataout.writeUTF(stringdate);
			return (String) objectinput.readObject();

		} catch (IOException e) {
			loger.error(e);
		} catch (ClassNotFoundException e) {
			loger.error(e);
		}
		return null;
	}

	/**
	 * close socket
	 */
	public void close() {
		if (socket != null && !socket.isClosed()) {
			try {
				objectinput.close();
				dataout.close();
				socket.close();
			} catch (IOException e) {
				loger.error(e);
			}
		}
	}

}
