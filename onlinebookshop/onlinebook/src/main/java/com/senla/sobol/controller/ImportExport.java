package com.senla.sobol.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.sobol.model.Book;
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.Orders;
import com.senla.sobol.model.Writer;


public class ImportExport  {
	private Converter converter = new Converter();
	private Logger log = Logger.getLogger(ImportExport.class.getName());

	/**
	 * export book to CSV
	 * 
	 * @param book
	 * @param rout
	 */
		public void exportBookCSV(List<Book> book, String rout) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rout), "UTF-8"))) {

			String[] arraybook = converter.getArrayBook(book);
			for (int i = 0; i < arraybook.length; i++) {
				bw.write(arraybook[i]);
				bw.newLine();
				bw.flush();
			}
		}

		catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

	}

	/**
	 * export order to CSV
	 * 
	 * @param order
	 * @param rout
	 */
	public void exportOrderCSV(List<Orders> order, String rout) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rout), "UTF-8"))) {
			String[] arrayorder = converter.getArrayOrder(order);
			for (int i = 0; i < arrayorder.length; i++) {
				bw.write(arrayorder[i]);
				bw.newLine();
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}
	/**
	 * export order to CSV
	 * 
	 * @param customer
	 * @param rout
	 */
	public void exportCustomerCSV(List<Customer> customer, String rout) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rout), "UTF-8"))) {
			String[] arrayorder = converter.getArrayCustomer(customer);
			for (int i = 0; i < arrayorder.length; i++) {
				bw.write(arrayorder[i]);
				bw.newLine();
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}
	public void exportWriterCSV(List<Writer> writer, String rout) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rout), "UTF-8"))) {
			String[] arrayorder = converter.getArrayWriter(writer);
			for (int i = 0; i < arrayorder.length; i++) {
				bw.write(arrayorder[i]);
				bw.newLine();
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
	}
	public List<Book> importBookCSV(String rout) {
		List<Book> listbook = null;
		String line = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rout), "UTF-8"))) {
			List<String> liststring = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				liststring.add(line);
			}
			listbook = converter.getListBook(listbook, liststring.toArray(new String[liststring.size()]));
			return listbook;

		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return null;
	}
	public List<Writer> importWriterCSV(String rout) {
		List<Writer> listwriter = null;
		String line = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rout), "UTF-8"))) {
			List<String> liststring = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				liststring.add(line);
			}
			listwriter = converter.getListWriter(listwriter, liststring.toArray(new String[liststring.size()]));
			return listwriter;

		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} catch (ParseException e) {
			log.error(e);
		}
		return null;
	}
	public List<Customer> importCustomerCSV(String rout) {
		List<Customer> listcustomer = null;
		String line = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rout), "UTF-8"))) {
			List<String> liststring = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				liststring.add(line);
			}
			listcustomer = converter.getListCustomer(listcustomer, liststring.toArray(new String[liststring.size()]));
			return listcustomer;

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
