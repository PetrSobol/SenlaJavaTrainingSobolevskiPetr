package di;

import java.util.HashMap;
import java.util.Map;

public class DI {
	private static Map<Class, Object> instanceclazz = new HashMap<Class, Object>();
	private static PropertyInstance property = new PropertyInstance();

	/**
	 * fils maps rout
	 */

	/**
	 * creat instance object
	 * 
	 * @param nameclass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static Object load(Class clazz)

			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object object = instanceclazz.get(clazz.getName());
		if (object != null) {
			return object;
		} else if (object == null) {
			String rout = property.load(clazz.getName());
			if (rout != null) {
				Class clazz2 = Class.forName(rout);
				Object objectinstanceclazz = clazz2.newInstance();
				instanceclazz.put(clazz, objectinstanceclazz);
				return objectinstanceclazz;
			}
		}
		return null;

	}

}
