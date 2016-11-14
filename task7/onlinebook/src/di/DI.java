package di;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import property.PropertiesOnlineBook;

public class DI {
	private Map<String, String> maps = new HashMap<String, String>();

	public DI() {
		maps.put("IOnlainBook.class",
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getOnlinebook());

		maps.put("IBook.class", PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getIbook());
		maps.put("IOrder.class", PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getIorder());
		maps.put("IBookDao.class",
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getIbookdao());
		maps.put("IOrderDao.class",
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getIorderdao());
		maps.put("IBookService.class",
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getIbookservice());
		maps.put("IOrderService.class",
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getIorderservice());
		maps.put("ISeriazeble.class",
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getIseriazeble());
		maps.put("IImportExport.class",
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getIimportexport());
	}

	public Object load(String nameclass)

			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Iterator it = maps.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> ent = (Entry<String, String>) it.next();

			if (ent.getKey().equals(nameclass)) {
				Class clazz = Class.forName(ent.getValue());
				Object object = clazz.newInstance();
				return object;
			}
		}
		return null;

	}

}
