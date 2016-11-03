package controller;

import java.text.ParseException;

import org.apache.log4j.Logger;

public class Runner {

	public static void main(String[] args) {
		Logger log =Logger.getLogger(Runner.class.getName());
		try{
			throw new ParseException(null, 0);
		} catch (ParseException e) {
			log.error(e);

		}

	}

}
