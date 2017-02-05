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
	private Scanner scaner;
/**
 * gets date with scaner
 * 
 */
	public String dateFormat() {
		scaner=new Scanner(System.in);
		String date = scaner.nextLine();
		try {
			dateformat.parse(date);
			return date;
		} catch (ParseException e) {
			log.error(e);
		}
		return null;
	}
/**
 * gets number with scaner
 * 
 */
	public Integer getNumber() {
		scaner=new Scanner(System.in);
		Integer a = null;
		try {
			a = scaner.nextInt();
		} catch (InputMismatchException e) {
			log.error(e);
			return null;
		}
		return a;
	}
/**
 * gets string with scaner
 * 
 */
	public String getWord() {
		scaner=new Scanner(System.in);
		String word = scaner.nextLine();
		return word;
	}
}
