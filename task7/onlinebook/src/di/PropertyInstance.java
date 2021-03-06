package di;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import property.PropertiesOnlineBook;

public class PropertyInstance {
	private Logger log = Logger.getLogger(PropertiesOnlineBook.class.getName());
	private Properties property = new Properties();

	public PropertyInstance() {
		;
		try (FileInputStream file = new FileInputStream("resources/instance.properties");) {
			property.load(file);

		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

	}

	public String load(String name) {
		String rout = property.getProperty(name);
		return rout;

	}

}
