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
import com.senla.sobol.model.IBook;
import com.senla.sobol.model.ICustomer;
import com.senla.sobol.model.IOrder;
import com.senla.sobol.model.IWriter;


public class ImportExport  {
	private Converter converter = new Converter();
	private Logger log = Logger.getLogger(ImportExport.class.getName());

	/**
	 * export book to CSV
	 * 
	 * @param book
	 * @param rout
	 */
		public void exportBookCSV(List<IBook> book, String rout) {
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
	public void exportOrderCSV(List<IOrder> order, String rout) {
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
	public void exportCustomerCSV(List<ICustomer> customer, String rout) {
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
	public void exportWriterCSV(List<IWriter> writer, String rout) {
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
	public List<IBook> importBookCSV(String rout) {
		List<IBook> listbook = null;
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
	public List<IWriter> importWriterCSV(String rout) {
		List<IWriter> listwriter = null;
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
	public List<ICustomer> importCustomerCSV(String rout) {
		List<ICustomer> listcustomer = null;
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
