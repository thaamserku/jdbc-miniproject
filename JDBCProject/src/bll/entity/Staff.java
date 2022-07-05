package bll.entity;

import java.sql.Date;

public class Staff extends Employee {

	private String post;
	private String department;

	// default
	public Staff() {
		super();
	}

	// with ID parameter : to get from MySQL
	public Staff(
			int id,
			String name,
			String gender,
			String phone,
			String email,
			String address,
			double annualSalary,
			Date sqlDate,
			String post,
			String department) {
		super(id, name, gender, phone, email, address, annualSalary, sqlDate);
		this.post = post;
		this.department = department;

	}

	// without ID parameter : to send to MySQL
	public Staff(
			String name,
			String gender,
			String phone,
			String email,
			String address,
			double annualSalary,
			Date sqlDate,
			String post,
			String department) {
		super(name, gender, phone, email, address, annualSalary, sqlDate);
		this.post = post;
		this.department = department;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
