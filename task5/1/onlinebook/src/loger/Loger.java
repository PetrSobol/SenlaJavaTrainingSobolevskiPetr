package loger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Loger {
	private Logger loger;

	public Loger(String nameclass) {
		this.loger = Logger.getLogger(nameclass);
		FileHandler fh;
		try {
			fh = new FileHandler("resources/TextFile/log.log", true);
			this.loger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (SecurityException e) {
			System.out.println("Access denied!!!");
		} catch (IOException e) {
			System.out.println("Not able to open file");
		}

	}

	public void writeToLoger(String exeption, Throwable ter) {
		loger.log(Level.SEVERE, exeption, ter);
	}
}
