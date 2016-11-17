package di;

import java.util.HashMap;
import java.util.Map;

public class DI {
	private Map<String, String> maps = new HashMap<String, String>();
	private Map<String, Object> mapsobject = new HashMap<String, Object>();

	/**
	 * fils maps rout
	 */
	public DI() {
		PropertyInstance property = new PropertyInstance();
		maps.put("IOnlainBook.class", property.getOnlinebook());
		maps.put("IBook.class", property.getIbook());
		maps.put("IOrder.class", property.getIorder());
		maps.put("IBookDao.class", property.getIbookdao());
		maps.put("IOrderDao.class", property.getIorderdao());
		maps.put("IBookService.class", property.getIbookservice());
		maps.put("IOrderService.class", property.getIorderservice());
		maps.put("ISeriazeble.class", property.getIseriazeble());
		maps.put("IImportExport.class", property.getIimportexport());
	}

	/**
	 * creat instance object
	 * 
	 * @param nameclass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public Object load(String nameclass)

			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object object = mapsobject.get(nameclass);
		if (object != null) {
			return object;
		} else if (object == null) {
			String rout = maps.get(nameclass);
			if (rout != null) {
				Class clazz = Class.forName(rout);
				Object objectnew = clazz.newInstance();
				mapsobject.put(nameclass, objectnew);
				return objectnew;
			}
		}
		return null;

	}

}
