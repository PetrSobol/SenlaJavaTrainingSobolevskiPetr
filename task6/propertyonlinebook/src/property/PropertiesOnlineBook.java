package property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesOnlineBook {
	private static PropertiesOnlineBook propertyonlne;
	private Logger log = Logger.getLogger(PropertiesOnlineBook.class.getName());
	private FileInputStream file = null;
	private Properties property = new Properties();
/**
 * creat file property
 */
	private PropertiesOnlineBook() {
		try {
			file = new FileInputStream("resources/roat.properties");

			property.load(file);

		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

	}
/**
 * 	roat to export/import file order
 * 
 */
	public String getRoatImportExportOrder() {
		String roat = property.getProperty("dborderscvexport");
		return roat;
	}
/**
 * roat to export/import file book
 * 
 */
	public String getRoatImportExportBook() {
		String roat = property.getProperty("dbbookexport");
		return roat;
	}
/**
 * roat to databases	
 * 
 */
	public String getRoatSeriazeble() {
		String roat = property.getProperty("dbessence");
		return roat;
	}
	public Integer getOldMonth(){
		Integer oldmonth=Integer.parseInt(property.getProperty("dbinteger"));
		return oldmonth;
	}
	public Boolean getOrderSales(){
		Boolean ordersales=Boolean.parseBoolean(property.getProperty("dbboolean"));
		return ordersales;
	}
/**
 * creat instance 	 PropertiesOnlineBook
 * 
 */
	public static PropertiesOnlineBook getInstanceProperty() {
		if (propertyonlne == null) {
			propertyonlne = new PropertiesOnlineBook();
			return propertyonlne;
		}
		return propertyonlne;
	}

}
