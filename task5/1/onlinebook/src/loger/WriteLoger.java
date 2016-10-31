package loger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class WriteLoger {

	private static Logger log ;

	public static Logger getLogger(String nameclass) {
		log= Logger.getLogger(nameclass);
		PropertyConfigurator.configure("resources/ log4j.properties");
		return log;
	}
	
}
