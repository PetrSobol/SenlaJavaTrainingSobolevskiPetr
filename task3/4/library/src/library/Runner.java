package library;

public class Runner {
	private Book bookchamberofsecrets = new Book("Harry Potter and chamber of secrets", "Rolling", 299);
	private Book booktwotavers = new Book("The Lord of the rings", "Tolkin", 455);
	private Book bookenemy = new Book("Enemy", "King", 675);
	private Book bookhouse = new Book("House and world", "Bahtin", 195);
	private Book bookxobit = new Book("Xobit", "Tolkin", 244);

	private ReadPerson person1 = new ReadPerson("Semenov", "Igor", 2);
	private ReadPerson person2 = new ReadPerson("Kunec", "Pavel", 2);
	private ReadPerson person3 = new ReadPerson("Roslikov", "Aleksandr", 1);

	public static void main(String[] args) {
		Runner runner = new Runner();
		Library library = new Library(5, 3);
		// add a book to the library
		library.addBooksLibrary(runner.bookchamberofsecrets, 0);
		library.addBooksLibrary(runner.bookenemy, 1);
		library.addBooksLibrary(runner.bookhouse, 2);
		library.addBooksLibrary(runner.booktwotavers, 3);
		library.addBooksLibrary(runner.bookxobit, 4);
		// add a new reader
		library.addReadPersonLibrary(runner.person1, 0);
		library.addReadPersonLibrary(runner.person2, 1);
		library.addReadPersonLibrary(runner.person3, 2);
		// See the list of all the books, where they are and the full list of
		// all readers
		library.printOll();
		// write a book on the reader
		library.givesPersonBook(runner.person1, runner.bookchamberofsecrets, 0);
		library.givesPersonBook(runner.person1, runner.bookenemy, 1);

		// watch what books the reader on his hands
		library.printBookPerson(runner.person1);

		library.printOll();
		// We look at what particular book reader
		System.out.println(library.whereBook(runner.bookenemy));
		System.out.println(library.whereBook(runner.bookxobit));

	}

}
