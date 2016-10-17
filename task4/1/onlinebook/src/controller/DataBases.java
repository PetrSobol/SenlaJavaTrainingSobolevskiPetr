package controller;

import com.danco.training.TextFileWorker;

public class DataBases {
	private String db = "resources/TextFile/DB.txt";
	private TextFileWorker textfile=new TextFileWorker(db);
	public String[] readFileDB() {
		String db[] = textfile.readFromFile();
		return db;
	}

	public void writeFileDB(String[] array) {
		textfile.writeToFile(array);
	}
}
