package controller;

import com.danco.training.TextFileWorker;

import property.Rout;

public class DataBases {
	private Rout route=new Rout();
	// rout to text file
	private String db = route.getRoutBD();
	private TextFileWorker textfile = new TextFileWorker(db);

	// gets String array
	public String[] readFileDB() {
		String db[] = textfile.readFromFile();
		return db;
	}

	// write string array to text file
	public void writeFileDB(String[] array) {
		textfile.writeToFile(array);
	}
}
