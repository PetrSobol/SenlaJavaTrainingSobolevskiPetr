package com.sobol.senla.anotation;

import java.lang.reflect.Field;

public class PrintableTracker {
	/**
	 * print information short
	 * 
	 * @param clazz
	 */
	public static void prinInformationShort(Class clazz) {
		PrintableObject annotation = (PrintableObject) clazz.getAnnotation(PrintableObject.class);
		if (annotation != null) {
			String nametype = annotation.name();
			System.out.print(nametype + ": ");
			for (Field metod : clazz.getDeclaredFields()) {
				Printable printable = metod.getAnnotation(Printable.class);
				if (printable != null) {
					boolean detalied = printable.isDetaledOnly();
					if (detalied) {
						String name = printable.name();
						System.out.print(name + " ");
					}
				}
			}
		}
		System.out.println();
	}

	/**
	 * print information detalied
	 * 
	 * @param clazz
	 */
	public static void prinInformationDetailed(Class clazz) {
		PrintableObject annotation = (PrintableObject) clazz.getAnnotation(PrintableObject.class);
		if (annotation != null) {
			String nametype = annotation.name();
			System.out.print(nametype + ": ");
			for (Field metod : clazz.getDeclaredFields()) {
				PrintableRef printref = metod.getAnnotation(PrintableRef.class);
				Printable printable = metod.getAnnotation(Printable.class);

				if (printable != null) {
					String name = printable.name();
					System.out.print(name + " ");
				}
				if (printref != null) {
					String name = printref.name();
					System.out.println(name + " ");

				}
			}

		}
		System.out.println();
	}
}
