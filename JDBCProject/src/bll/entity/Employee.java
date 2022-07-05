package bll.entity;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Employee extends Person {

	private double annualSalary;
	private Date joinDate;

	Scanner sc = new Scanner(System.in);

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");

	// Default Constructor
	public Employee() {
		super();
	}

	// Parameterized constructor without ID
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

	// Parameterized constructor with ID
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
