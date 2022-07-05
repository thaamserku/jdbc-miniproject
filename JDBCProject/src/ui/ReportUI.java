package ui;

import java.util.Scanner;

import service.IServiceStaff;
import service.IServiceStudent;
import service.IServiceTeacher;

public class ReportUI {
	Scanner sc = new Scanner(System.in);
	IServiceStudent student = new IServiceStudent();
	IServiceTeacher teacher = new IServiceTeacher();
	IServiceStaff staff = new IServiceStaff();

	public void showStaffList() {
		System.out.println("\t\t\t\t\tLIST OF STAFF RECORDS");
		System.out.println();
		staff.displayAllItem();
	}

	public void showTeacherList() {
		System.out.println("\t\t\t\t\tLIST OF TEACHER RECORDS");
		System.out.println();
		teacher.displayAllItem();
	}

	public void showStudentList() {
		System.out.println("\t\t\t\tLIST OF STUDENT RECORDS");
		System.out.println();
		student.displayAllItem();
	}

}
