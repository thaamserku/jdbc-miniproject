package bll.entity;

public class Person {
	protected int id;
	protected String name;
	protected String gender;
	protected String phone;
	protected String email;
	protected String address;

	// default constructor
	public Person() {

	}

	// constructor without id. This will be used to insert data into table.
	// MySQL table has it with auto_increment, so for data insertion we are not
	// going to use id.
	public Person(String name, String gender, String phone, String email, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	// Constructor with id.
	// This will be used to process and format ResultSet data for display.

	public Person(int id, String name, String gender, String phone, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
