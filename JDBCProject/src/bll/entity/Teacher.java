package bll.entity;

import java.sql.Date;

public class Teacher extends Employee {

	private String majorSubject;

	// overloading the constructor

	public Teacher() {
	}

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

	public String getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(String majorSubject) {
		this.majorSubject = majorSubject;
	}

}