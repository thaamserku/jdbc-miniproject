package bll.entity;

/**
 * Parent class for all other entity classes.
 * 
 * This is the parent entity class which is extended by all other subsequent
 * entity classes of the project. It contains six attributes common across all
 * other entities.
 * 
 * This entity class contains attributes, constructors, getters and setters.
 * 
 * Constructors are overloaded.
 * 
 * @author kcpaudel
 * @version 0.0.1
 *
 */

public class Person {
	private int id;
	private String name;
	private String gender;
	private String phone;
	private String email;
	private String address;

	// Default constructor
	public Person() {

	}

	/**
	 * Parameterized constructor without ID parameter.
	 * 
	 * Database(MySQL in this case) has an ID column as primary key column, with
	 * auto-increment feature enabled.
	 * 
	 * We will use this constructor to insert data into the table.
	 * 
	 * Since the ID is incrementally auto-inserted by database software, we don't
	 * need to supply it while inserting data.
	 * 
	 * @param name    : First name and last name combined.
	 * @param gender  : Biological sex of the entity object.
	 * @param phone   : 10-digit phone number
	 * @param email   : Email address.
	 * @param address : Physical Location. State or City Name only.
	 */

	public Person(String name, String gender, String phone, String email, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	/**
	 * Parameterized constructor with ID parameter.
	 * 
	 * This constructor is used to access data to carry out manipulation and
	 * visualization tasks that is primary-key based(ID based in our case).
	 * 
	 * @param id      : Auto-incremented, auto-inserted primary attribute of entity
	 *                object.
	 * @param name    : First name and last name combined.
	 * @param gender  : Biological sex of the entity object.
	 * @param phone   : 10-digit phone number
	 * @param email   : Email address.
	 * @param address : Physical Location. State or City Name only.
	 */
	/*-
	 *  1. 
	 *  2. This constructor can be used to access data to carry out  manipulation
	 *     and visualization tasks that is primary-key based(ID based in our case).
	 */

	public Person(int id, String name, String gender, String phone, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	/*-
	 * Relevant Getters and Setters.
	 */

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
