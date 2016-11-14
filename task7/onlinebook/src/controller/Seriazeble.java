package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import interfaces.IBook;
import interfaces.IOrder;
import interfaces.ISeriazeble;
import property.PropertiesOnlineBook;

public class Seriazeble implements ISeriazeble {
	private Logger log = Logger.getLogger(Seriazeble.class.getName());
	private List<IBook> listbook;
	private List<IOrder> listorder;

	/**
	 * gets data with essence.out
	 */
	public Seriazeble() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getRoatseriazeble()))) {
			listbook = (ArrayList<IBook>) ois.readObject();
			listorder = (ArrayList<IOrder>) ois.readObject();
		} catch (Exception e) {
			log.error(e);
		}

	}

	/**
	 * save to essence.out
	 */
	public void saveToDataBases() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getRoatseriazeble()))) {
			oos.writeObject(listbook);
			oos.writeObject(listorder);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public List<IBook> getListBook() {
		return listbook;
	}

	public List<IOrder> getListOrder() {
		return listorder;
	}
}
