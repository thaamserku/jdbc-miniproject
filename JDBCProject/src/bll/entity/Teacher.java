package bll.entity;

import java.sql.Date;

/**
 * Teacher entity class extends Employee entity class.
 * 
 * Adds one attribute relevant to Teacher entity objects.
 * 
 * This entity class contains an attribute, its getter and setter, and
 * constructors.
 *
 * Constructors are overloaded.
 * 
 * @author kcpaudel
 * @version 0.0.1
 *
 */

public class Teacher extends Employee {

	private String majorSubject;

	// overloading the constructor

	public Teacher() {
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
	 * @param name         : First name and last name combined.
	 * @param gender       : Biological sex of the entity object.
	 * @param phone        : 10-digit phone number
	 * @param email        : Email address.
	 * @param address      : Physical Location. State or City Name only.
	 * @param majorSubject : Subject entity object teaches at the school.
	 * @param annualSalary : Annual salary earned by entity object.
	 * @param sqlDate      : Date entity object joined the School.
	 * 
	 */
	public Teacher(
			String name,
			String gender,
			String phone,
			String email,
			String address,
			String majorSubject,
			double annualSalary,
			Date sqlDate) {
		super(name, gender, phone, email, address, annualSalary, sqlDate);
		this.majorSubject = majorSubject;
	}

	/**
	 * /** Parameterized constructor with ID parameter.
	 * 
	 * This constructor is used to access data to carry out manipulation and
	 * visualization tasks that is primary-key based(ID based in our case).
	 * 
	 * @param id           : Auto-incremented, auto-inserted primary attribute of
	 *                     entity object.
	 * @param name         : First name and last name combined.
	 * @param gender       : Biological sex of the entity object.
	 * @param phone        : 10-digit phone number
	 * @param email        : Email address.
	 * @param address      : Physical Location. State or City Name only.
	 * @param majorSubject : Subject entity object teaches at the school.
	 * @param annualSalary : Annual salary earned by entity object.
	 * @param sqlDate      : Date entity object joined the School.
	 * 
	 */

	public Teacher(
			int id,
			String name,
			String gender,
			String phone,
			String email,
			String address,
			String majorSubject,
			double annualSalary,
			Date sqlDate) {
		super(id, name, gender, phone, email, address, annualSalary, sqlDate);
		this.majorSubject = majorSubject;
	}

	/*-
	 * Getter and Setter
	 */

	public String getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(String majorSubject) {
		this.majorSubject = majorSubject;
	}

}