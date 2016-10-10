package library;

public class ReadPerson implements IPerson {
	private String lastname;
	private String firstname;
	private StringBuilder stringbilder;
	private Integer dimensionBook = 0;
	private Integer dimension=2;
	private IBook book[] = new Book[dimension];

	public ReadPerson() {

	}

	public ReadPerson(String lastname, String firstname) {
		this.lastname = lastname;
		this.firstname = firstname;

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
	public void addBookPerson(IBook book) {

		this.book[dimensionBook] = book;
		dimensionBook++;
	
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
