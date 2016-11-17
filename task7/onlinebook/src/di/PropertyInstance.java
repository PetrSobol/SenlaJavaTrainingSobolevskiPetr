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
	private String onlinebook;
	private String ibook;
	private String iorder;
	private String ibookdao;
	private String iorderdao;
	private String iorderservice;
	private String ibookservice;
	private String iseriazeble;
	private String iimportexport;

	public PropertyInstance() {
		;
		try (FileInputStream file = new FileInputStream("resources/instance.properties");) {
			property.load(file);
			onlinebook = property.getProperty("IOnlainBook.class");
			ibook = property.getProperty("IBook.class");
			iorder = property.getProperty("IOrder.class");
			ibookdao = property.getProperty("IBookDao.class");
			iorderdao = property.getProperty("IOrderDao.class");
			iorderservice = property.getProperty("IOrderService.class");
			ibookservice = property.getProperty("IBookService.class");
			iseriazeble = property.getProperty("ISeriazeble.class");
			iimportexport = property.getProperty("IImportExport.class");
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

	}

	public String getIseriazeble() {
		return iseriazeble;
	}

	public String getIimportexport() {
		return iimportexport;
	}

	public String getIbook() {
		return ibook;
	}

	public String getIorder() {
		return iorder;
	}

	public String getIbookdao() {
		return ibookdao;
	}

	public String getIorderdao() {
		return iorderdao;
	}

	public String getIorderservice() {
		return iorderservice;
	}

	public String getIbookservice() {
		return ibookservice;
	}

	public String getOnlinebook() {
		return onlinebook;
	}

}
