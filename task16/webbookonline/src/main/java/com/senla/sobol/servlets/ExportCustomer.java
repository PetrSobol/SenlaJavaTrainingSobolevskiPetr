package com.senla.sobol.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class ExportCustomer
 */
public class ExportCustomer extends AbstractServletes {
	private static final String APPLICATION_DOWNLOAD = "application/download";
	private static final String SRC = "src/main/resources/export.csv";
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(ExportCustomer.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_DOWNLOAD);
		getIOnlineBook().exportCustomerCSV();
		File csv = new File(SRC);
		try {
			FileUtils.copyFile(csv, response.getOutputStream());
		} catch (IOException e) {
			log.error(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}

}
