package bll.entity;

import java.sql.Date;
import java.util.Scanner;

/**
 * Employee entity class that extends Person entity class and also serves as
 * parent class for Teacher and Staff entity classes.
 * 
 * Includes two attributes common to both derived classes.
 * 
 * This entity class contains attributes, constructors, getters and setters.
 * 
 * Constructors are overloaded.
 * 
 * @author kcpaudel
 * @version 0.0.1
 */

public class Employee extends Person {

	private double annualSalary;
	private Date joinDate;

	Scanner sc = new Scanner(System.in);

	// Default Constructor
	public Employee() {
		super();
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
	 * @param annualSalary : Annual salary earned by entity object.
	 * @param sqlDate      : Date entity object joined the School.
	 */
	public Employee(
			String name,
			String gender,
			String phone,
			String email,
			String address,
			double annualSalary,
			Date sqlDate) {

		super(name, gender, phone, email, address);
		this.annualSalary = annualSalary;
		this.joinDate = sqlDate;
	}

	/**
	 * Parameterized constructor with ID parameter.
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
	 * @param annualSalary : Annual salary earned by entity object.
	 * @param sqlDate      :Date entity object joined the School.
	 */
	public Employee(
			int id,
			String name,
			String gender,
			String phone,
			String email,
			String address,
			double annualSalary,
			Date sqlDate) {
		super(id, name, gender, phone, email, address);
		this.annualSalary = annualSalary;
		this.joinDate = sqlDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

}
