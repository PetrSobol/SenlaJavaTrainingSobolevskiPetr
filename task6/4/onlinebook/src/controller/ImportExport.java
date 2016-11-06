package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;

import org.apache.log4j.Logger;

import model.Book;
import model.Order;

public class ImportExport {
	private Converter converter = new Converter();
	private Logger log = Logger.getLogger(ImportExport.class.getName());

	public void exportBookCSV(Book book, String rout) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rout), "UTF-8"));
			bw.write(converter.getStringBook(book));
			bw.newLine();
			bw.flush();
			bw.close();

		}

		catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

	}

	public void exportOrderCSV(Order order, String rout) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rout), "UTF-8"));
			bw.write(converter.getStringOrder(order));
			bw.newLine();
			bw.flush();
			bw.close();

		}

		catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}

	public Book importBookCSV(String rout) {
		Book book = null;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rout), "UTF-8"));
			book = converter.getBook(br.readLine());
			br.close();
			return book;

		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

		return null;

	}

	public Order importOrderCSV(String rout) {
		Order order = null;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rout), "UTF-8"));
			order = converter.getOrder(br.readLine());
			br.close();
			return order;

		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} catch (ParseException e) {
			log.error(e);
		}

		return null;
	}

}
