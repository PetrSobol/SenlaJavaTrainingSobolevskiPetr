package com.sobol.senla.anotation;

import java.lang.reflect.Field;

public class PrintableTracker {
	private StringBuilder 	string = new StringBuilder();;
	/**
	 * print information short
	 * search anotation in class
	 * @param clazz
	 * @throws ClassNotFoundException
	 */

	public String prinInformation(Class clazz, boolean detaled) throws ClassNotFoundException {
	
		PrintableObject annotation = (PrintableObject) clazz.getAnnotation(PrintableObject.class);
		if (annotation != null) {
			String nametype = annotation.name();
			string.append(nametype);
			string.append(": ");
			for (Field metod : clazz.getDeclaredFields()) {
				Printable printable = metod.getAnnotation(Printable.class);
				PrintableRef printref = metod.getAnnotation(PrintableRef.class);
				if (detaled) {
					if (printref != null) {
						boolean printables = printref.isRecursiv();
						if (printables) {
							Class clazz2 = metod.getType();
							return prinInformation(clazz2, true);
						}
					}
					if (printable != null) {
						if (detaled) {
							String name = printable.name();
							string.append(name);
							string.append("  ");
						}
					}
				} else if (!detaled && printable != null) {
					boolean detalied = printable.isDetaledOnly();
					if (detalied) {
						String name = printable.name();
						string.append(name);
						string.append(" ");
					}
				}
			}
		}
		return string.toString();
	}

	
}
