package model;

public class Customer {
	private String lastName;
	private String firstName;
	private String numberPhone;

	public Customer() {
		super();
	}

	public Customer(String lastName, String firstName, String numberPhone) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.numberPhone = numberPhone;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

}
