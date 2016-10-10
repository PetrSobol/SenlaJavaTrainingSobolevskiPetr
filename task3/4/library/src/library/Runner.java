package library;

public class Runner {

	public static void main(String[] args) {
		Book bookchamberofsecrets = new Book("Harry Potter and chamber of secrets", "Rolling", 299);
		Book booktwotavers = new Book("The Lord of the rings", "Tolkin", 455);
		Book bookenemy = new Book("Enemy", "King", 675);
		Book bookhouse = new Book("House and world", "Bahtin", 195);
		Book bookxobit = new Book("Xobit", "Tolkin", 244);

		ReadPerson person1 = new ReadPerson("Semenov", "Igor");
		ReadPerson person2 = new ReadPerson("Kunec", "Pavel");
		ReadPerson person3 = new ReadPerson("Roslikov", "Aleksandr");
		Library library = new Library();
		// add a book to the library
		library.addBooksLibrary(bookchamberofsecrets);
		library.addBooksLibrary(bookenemy);
		library.addBooksLibrary(bookhouse);
		library.addBooksLibrary(booktwotavers);
		library.addBooksLibrary(bookxobit);
		// add a new reader
		library.addReadPersonLibrary(person1);
		library.addReadPersonLibrary(person2);
		library.addReadPersonLibrary(person3);
		// See the list of all the books, where they are and the full list of
		// all readers
		library.printOll();
		// write a book on the reader
		library.givesPersonBook(person1, bookchamberofsecrets);
		library.givesPersonBook(person1, bookenemy);
		library.givesPersonBook(person1,bookhouse );

		// watch what books the reader on his hands
		library.printBookPerson(person1);

		library.printOll();
		// We look at what particular book reader
		System.out.println(library.whereBook(bookenemy));
		System.out.println(library.whereBook(bookxobit));

	}

}
