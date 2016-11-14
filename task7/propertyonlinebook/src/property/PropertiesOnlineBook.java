package property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesOnlineBook {
	private static PropertiesOnlineBook propertyonlne;
	private PropertyHolder propertyholder;
	private Logger log = Logger.getLogger(PropertiesOnlineBook.class.getName());
	private Properties property = new Properties();

	/**
	 * creat file property
	 */
	private PropertiesOnlineBook() {
		propertyholder = new PropertyHolder();
		try {
			FileInputStream file = new FileInputStream("resources/roat.properties");
			property.load(file);
			propertyholder.setRoatimportexportBook(property.getProperty("dbbookexport"));
			propertyholder.setRoatimportexportOrder(property.getProperty("dborderscvexport"));
			propertyholder.setRoatseriazeble(property.getProperty("dbessence"));
			propertyholder.setOldmonth(Integer.parseInt(property.getProperty("dbinteger")));
			propertyholder.setSalesorder(Boolean.parseBoolean(property.getProperty("dbboolean")));
			propertyholder.setOnlinebook(property.getProperty("IOnlainBook.class"));
			propertyholder.setIbook(property.getProperty("IBook.class"));
			propertyholder.setIorder(property.getProperty("IOrder.class"));
			propertyholder.setIbookdao(property.getProperty("IBookDao.class"));
			propertyholder.setIorderdao(property.getProperty("IOrderDao.class"));
			propertyholder.setIbookservice(property.getProperty("IBookService.class"));
			propertyholder.setIorderservice(property.getProperty("IOrderService.class"));
			propertyholder.setIseriazeble(property.getProperty("ISeriazeble.class"));
			propertyholder.setIimportexport(property.getProperty("IImportExport.class"));
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

	}

	public static PropertiesOnlineBook getInstanceProperty() {
		if (propertyonlne == null) {
			propertyonlne = new PropertiesOnlineBook();
			return propertyonlne;
		}
		return propertyonlne;
	}

	public PropertyHolder getInstancePropertyHolder() {
		return propertyholder;
	}

}
