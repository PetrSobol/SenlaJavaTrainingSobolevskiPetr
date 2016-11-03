package com.sobolevski.senla.onlinebook.action;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class CloneOrderAction implements IAction {
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private Logger log = Logger.getLogger(AddNewOrderAction.class.getName());
	private Scanner scaner;
	@Override
	public void process() {
		scaner = new Scanner(System.in);
		print.addOrderLastname();
		String lastname = scanerbox.getWord(scaner);
		try {
			if(OnlineBook.getInstance().getCloneOrder(lastname)!=null){
				print.printFinishOperation();
			}else{
				print.printNoFinishOperation();
			}
		} catch (CloneNotSupportedException e) {
			log.error(e);
		}
		
		
	}

}
