package com.senla.sobol.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.model.IOnlineBook;

public class FunctionServer {

	public EssenceCommon getEssenceDate(IOnlineBook onlinebook, EssenceCommon essence)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		EssenceCommon esenceserver = new EssenceCommon();
		Class clazz = onlinebook.getClass();
		Method[] metods = clazz.getMethods();
		for (Method metod1 : metods) {
			if (metod1.getName().equals(essence.getNameMetod())) {

				if (essence.getObjects() != null) {
					String types = metod1.getReturnType().getName();
					if (types.equals("void")) {

						metod1.invoke(onlinebook, essence.getObjects());
						return esenceserver;

					} else if (types.equals("java.lang.Boolean")) {

						esenceserver.setAnswerend((Boolean) metod1.invoke(onlinebook, essence.getObjects()));
						return esenceserver;

					} else if (types.equals("java.util.List")) {

						esenceserver.setLsit((List<?>) metod1.invoke(onlinebook, essence.getObjects()));
						return esenceserver;

					} else if (types.equals("java.lang.Integer")) {

						esenceserver.setNumber((Integer) metod1.invoke(onlinebook, essence.getObjects()));
						return esenceserver;
					}

				} else {
					String types = metod1.getReturnType().getName();
					if (types.equals("void")) {

						metod1.invoke(onlinebook, null);
						return esenceserver;

					} else if (types.equals("java.lang.Boolean")) {

						esenceserver.setAnswerend((Boolean) metod1.invoke(onlinebook, null));
						return esenceserver;

					} else if (types.equals("java.util.List")) {

						esenceserver.setLsit((List<?>) metod1.invoke(onlinebook, null));
						return esenceserver;

					} else if (types.equals("java.lang.Integer")) {

						esenceserver.setNumber((Integer) metod1.invoke(onlinebook, null));
						return esenceserver;
					}

				}

			}

		}

		return null;

	}

}
