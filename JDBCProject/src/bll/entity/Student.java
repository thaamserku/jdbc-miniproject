package bll.entity;

public class Student extends Person {

	private int grade;
	private double gpa;

	// default constructor
	public Student() {
	}

	// Parameterized constructor without ID : To set the data to insert data to
	// MySQL
	// ID is inserted by MySQL
	public Student(String name, String gender, String phone, String email, String address, int grade, double gpa) {

		super(name, gender, phone, email, address);
		this.grade = grade;
		this.gpa = gpa;
	}

	// Parameterized constructor with ID : To Display MySQL tables
	public Student(
			int id,
			String name,
			String gender,
			String phone,
			String email,
			String address,
			int grade,
			double gpa) {
		super(id, name, gender, phone, email, address);
		this.grade = grade;
		this.gpa = gpa;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}