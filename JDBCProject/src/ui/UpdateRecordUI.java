package ui;

import java.util.Scanner;

import bll.entity.Staff;
import bll.entity.Student;
import bll.entity.Teacher;
import service.IServiceStaff;
import service.IServiceStudent;
import service.IServiceTeacher;

public class UpdateRecordUI {

	Scanner sc = new Scanner(System.in);
	IServiceStudent student = new IServiceStudent();
	IServiceTeacher teacher = new IServiceTeacher();
	IServiceStaff staff = new IServiceStaff();

	public void updateStaffDetails() {
		System.out.println();
		System.out.println("\t\t\t*********** UPDATE STAFF RECORD **********");
		System.out.println();
		while (true) {

			Menu.clearScreen();
			System.out.println("\t\t\tLIST OF STAFF RECORDS");
			staff.displayAllItem();

			System.out.print("\n\t\t\tPlease enter all relevant data.\n");

			System.out.print("\n\t\t\tID :");
			int idStaff = Integer.parseInt(sc.nextLine());
			System.out.print("\n\t\t\tName	:");
			String nameStaff = sc.nextLine();

			System.out.print("\n\t\t\tGender	:");
			String genderStaff = sc.nextLine();

			System.out.print("\n\t\t\tPhone	:");
			String phoneStaff = sc.nextLine();

			System.out.print("\n\t\t\tEmail	:");
			String emailStaff = sc.nextLine();

			System.out.print("\n\t\t\tAddress	:");
			String addressStaff = sc.nextLine();

			System.out.print("\n\t\t\tSalary	:");
			double salaryStaff = Double.parseDouble(sc.nextLine());

			System.out.print("\n\t\t\tJoinDate : ");
			java.sql.Date joinDateStaff = java.sql.Date.valueOf(sc.nextLine());

			System.out.print("\n\t\t\tPost :");
			String postStaff = sc.nextLine();

			System.out.print("\n\t\t\tDepartment :");
			String departmentStaff = sc.nextLine();

			staff.updateItem(
					new Staff(idStaff, nameStaff, genderStaff, phoneStaff, emailStaff, addressStaff, salaryStaff,
							joinDateStaff, postStaff, departmentStaff));

			Menu.clearScreen();
			System.out.println("\t\t\tLIST OF UPDATED STAFF RECORDS");
			staff.displayUpdatedItems();

			System.out.print("\n\t\t\tWould you like to continue updating another record [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				break;
			}
		}

	}

	public void updateTeacherDetails() {
		System.out.println();
		System.out.println("\t\t\t*********** UPDATE TEACHER RECORD **********");
		System.out.println();

		while (true) {
			Menu.clearScreen();
			System.out.println("\t\t\tLIST OF TEACHER RECORDS");
			teacher.displayAllItem();

			System.out.print("\n\t\tPlease enter all relevant data below.\n");

			System.out.println("\n\t\t\tID:");
			int idTeacher = Integer.parseInt(sc.nextLine());

			System.out.print("\n\t\t\tName	:");
			String nameTeacher = sc.nextLine();

			System.out.print("\n\t\t\tGender	:");
			String genderTeacher = sc.nextLine();

			System.out.print("\n\t\t\tPhone	:");
			String phoneTeacher = sc.nextLine();

			System.out.print("\n\t\t\tEmail	:");
			String emailTeacher = sc.nextLine();

			System.out.print("\n\t\t\tAddress	:");
			String addressTeacher = sc.nextLine();

			System.out.print("\n\t\t\tSubject	:");
			String subjectTeacher = sc.nextLine();

			System.out.print("\n\t\t\tSalary	:");
			double salaryTeacher = Double.parseDouble(sc.nextLine());

			System.out.print("\n\t\t\tJoinDate : ");
			java.sql.Date joinDate = java.sql.Date.valueOf(sc.nextLine());

			teacher.updateItem(
					new Teacher(idTeacher, nameTeacher, genderTeacher, phoneTeacher, emailTeacher, addressTeacher,
							subjectTeacher, salaryTeacher, joinDate));

			Menu.clearScreen();
			System.out.println("\t\t\tLIST OF UPDATED TEACHER RECORDS");
			teacher.displayUpdatedItems();

			System.out.print("\n\t\t\tWould you like to continue updating another record [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				Menu.clearScreen();
				break;
			}

		}

	}

	public void updateStudentDetails() {
		System.out.println();
		System.out.println("\t\t\t*********** UPDATE STUDENT RECORD **********");
		System.out.println();

		while (true) {

			Menu.clearScreen();
			System.out.println("\t\t\tLIST OF STUDENT RECORDS");
			student.displayAllItem();

			System.out.print("\t\t\tPlease enter all relevant data below.\n");

			System.out.print("\n\t\t\tID :");
			int idStudent = Integer.parseInt(sc.nextLine());
			System.out.print("\n\t\t\tName	:");
			String nameStudent = sc.nextLine();

			System.out.print("\n\t\t\tGender	:");
			String genderStudent = sc.nextLine();

			System.out.print("\n\t\t\tPhone	:");
			String phoneStudent = sc.nextLine();

			System.out.print("\n\t\t\tEmail	:");
			String emailStudent = sc.nextLine();

			System.out.print("\n\t\t\tAddress	:");
			String addressStudent = sc.nextLine();

			System.out.print("\n\t\t\tGrade	:");
			int gradeStudent = Integer.parseInt(sc.nextLine());

			System.out.print("\n\t\t\tGPA	:");
			double gpaStudent = Double.parseDouble(sc.nextLine());

			student.updateItem(
					new Student(idStudent, nameStudent, genderStudent, phoneStudent, emailStudent, addressStudent,
							gradeStudent, gpaStudent));

			Menu.clearScreen();
			System.out.println("\t\t\tLIST OF UPDATED STUDENT RECORDS");
			student.displayUpdatedItems();

			System.out.print("\n\t\t\tWould you like to continue updating another record [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				break;
			}

		}

	}

}
