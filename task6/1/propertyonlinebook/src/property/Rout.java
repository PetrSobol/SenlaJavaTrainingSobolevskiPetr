package property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Rout {
	private static Logger log = Logger.getLogger(Rout.class.getName());
	private Properties property;
	private FileInputStream file;

	public Rout() {
		property = new Properties();
		try {
			file = new FileInputStream("resources/1.properties");
			property.load(file);
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}

	public String getRoutBD() {
		String rout = property.getProperty("dbBD");
		return rout;
	}

}
