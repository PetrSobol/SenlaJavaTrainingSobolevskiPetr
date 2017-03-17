package com.senla.sobol.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class ExportOrder
 */
public class ExportOrder extends AbstractServletes {
	private static final String APPLICATION_DOWNLOAD = "application/download";
	private static final String SRC_MAIN_RESOURCES_EXPORT_CSV = "src/main/resources/export.csv";
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(ExportOrder.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_DOWNLOAD);
		getIOnlineBook().exportOrderCSV();
		File csv = new File(SRC_MAIN_RESOURCES_EXPORT_CSV);
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
