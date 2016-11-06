package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesOnlineBook {
	private Logger log = Logger.getLogger(PropertiesOnlineBook.class.getName());
	private FileInputStream file = null;
	private  Properties property = new Properties();

	public PropertiesOnlineBook() {
		try {
			file = new FileInputStream("resources/roat.properties");

			property.load(file);

		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

	}

	public String getRoatPropertyBook() {
		String roat = property.getProperty("dbbook");
		return roat;

	}

	public  String getRoatPropertyOrder() {
		String roat = property.getProperty("dborder");
		return roat;
	}

	public  String getRoatImportExportOrder() {
		String roat = property.getProperty("dborderscvexport");
		return roat;
	}

	public  String getRoatImportExportBook() {
		String roat = property.getProperty("dbbookexport");
		return roat;
	}


}
