package library;

import java.util.Arrays;

public class Library {
	private IBook books[] = new Book[0];
	private IPerson person[] = new ReadPerson[0];
	private StringBuilder stringbilder;
	private Integer dimensionReadPerson = 0;
	private Integer dimensionBooks = 0;

	public void printOll() {
		System.out.println("Books library: ");
		for (IBook books : this.books) {
			System.out.println(books.toString());
		}
		System.out.println("ReadPerson library: ");
		for (IPerson persons : this.person) {
			System.out.println(persons.toString());
		}
	}

	public void addReadPersonLibrary(IPerson persons) {
		IPerson person2[] = Arrays.copyOf(this.person, this.person.length + 1);
		this.person = Arrays.copyOf(person2, person2.length);
		this.person[dimensionReadPerson] = persons;
		dimensionReadPerson++;

	}

	public void addBooksLibrary(IBook book) {
		IBook book2[] = Arrays.copyOf(this.books, this.books.length + 1);
		this.books = Arrays.copyOf(book2, book2.length);
		this.books[dimensionBooks] = book;
		dimensionBooks++;

	}

	public void givesPersonBook(IPerson person, IBook book) {
		person.addBookPerson(book);
		book.setLastNamePerson(person.getLastName());

	}

	public void printBookPerson(IPerson person) {
		person.printBookPerson();
	}

	public String whereBook(IBook book) {
		stringbilder = new StringBuilder();
		stringbilder.append("Book with name:");
		stringbilder.append(book.getName());
		stringbilder.append(" It is the reader with the name :");
		stringbilder.append(book.lastNamePerson());
		return stringbilder.toString();
	}

}
