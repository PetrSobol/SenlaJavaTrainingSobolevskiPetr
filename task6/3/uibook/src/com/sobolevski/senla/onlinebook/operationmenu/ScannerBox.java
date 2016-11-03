package com.sobolevski.senla.onlinebook.operationmenu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ScannerBox {
	private Logger log = Logger.getLogger(ScannerBox.class.getName());
	private DateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");

	public String dateFormat(Scanner scaner) {
		String date = scaner.nextLine();
		try {
			dateformat.parse(date);
			return date;
		} catch (ParseException e) {
			log.error(e);
		}
		return null;
	}

	public Integer getNumber(Scanner scanner) {
		Integer a = null;
		try {
			a = scanner.nextInt();
		} catch (InputMismatchException e) {
			log.error(e);
			return null;
		}
		return a;
	}

	public String getWord(Scanner scanner) {
		String word = scanner.nextLine();
		return word;
	}
}
