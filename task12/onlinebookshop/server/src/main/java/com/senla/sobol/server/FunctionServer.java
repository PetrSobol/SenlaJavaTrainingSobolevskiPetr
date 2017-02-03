package com.senla.sobol.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.intarfaces.IOnlineBook;

public class FunctionServer {

	public EssenceCommon getEssenceDate(IOnlineBook onlinebook, EssenceCommon essence)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		EssenceCommon esenceserver = new EssenceCommon();
		Class clazz = onlinebook.getClass();
		Method[] metods = clazz.getMethods();
		for (Method metod1 : metods) {
			if (metod1.getName().equals(essence.getNameMetod())) {

				if (essence.getObjects() != null) {
					Object types = metod1.getReturnType();
					if (types.equals(void.class)) {

						metod1.invoke(onlinebook, essence.getObjects());
						return esenceserver;

					} else {
						Object listobjet = metod1.invoke(onlinebook, essence.getObjects());
						esenceserver.setCurront(listobjet);
						return esenceserver;
					}

				} else {
					Object types = metod1.getReturnType();
					if (types.equals(void.class)) {

						metod1.invoke(onlinebook, null);
						return esenceserver;

					} else {
						Object listobjet = metod1.invoke(onlinebook, null);
						esenceserver.setCurront(listobjet);
						return esenceserver;
					}
				}
			}
		}

		return null;

	}

}
