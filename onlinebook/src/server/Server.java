package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class Server {
	/**
	 * all connection in server
	 */
	private ServerSocket server;
	private Logger loger = Logger.getLogger(Server.class.getName());

	public Server() {
		try {
			/**
			 * run server on port 6687
			 */
			server = new ServerSocket(6687);
			while (true) {
				/**
				 * we wait new connection
				 */
				Socket sochet = server.accept();

				Connection con = new Connection(sochet);
				con.start();

			}
		} catch (IOException e) {
			loger.error(e);
		}
		/**
		 * server close
		 */
		finally {
			try {
				server.close();
			} catch (IOException e) {
				loger.error(e);
			}
		}
	}
}
