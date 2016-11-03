package controller;

import com.danco.training.TextFileWorker;

public class DataBases {
	// rout to text file
	private String db = "resources/TextFile/DB.txt";
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
