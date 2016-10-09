package library;

public class ReadPerson implements IPerson {
	private String lastname;
	private String firstname;
	private StringBuilder stringbilder;
	private IBook book[];

	public ReadPerson() {

	}

	public ReadPerson(String lastname, String firstname, Integer quantity) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.book = new Book[quantity];
	}

	@Override
	public String getLastName() {

		return lastname;
	}

	@Override
	public void setLastName(String lastname) {
		this.lastname = lastname;

	}

	@Override
	public String getFirstName() {
		return firstname;
	}

	@Override
	public void setFirstName(String firstname) {
		this.firstname = firstname;

	}

	@Override
	public void printBookPerson() {
		System.out.println("List of books the reader with the name  " + getLastName());
		for (IBook books : book) {
			System.out.println(books);
		}

	}

	@Override
	public void addBookPerson(IBook book, Integer quantity) {
		this.book[quantity] = book;

	}

	@Override
	public String toString() {
		stringbilder = new StringBuilder();
		stringbilder.append(" LasName:  ");
		stringbilder.append(getLastName());
		stringbilder.append(" ");
		stringbilder.append(" FirstName:  ");
		stringbilder.append(firstname);
		return stringbilder.toString();
	}

}
