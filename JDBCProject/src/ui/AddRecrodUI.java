package ui;

import java.util.Scanner;

import bll.entity.Staff;
import bll.entity.Student;
import bll.entity.Teacher;
import service.IServiceStaff;
import service.IServiceStudent;
import service.IServiceTeacher;

public class AddRecrodUI {

	Scanner sc = new Scanner(System.in);
	IServiceStudent student = new IServiceStudent();
	IServiceTeacher teacher = new IServiceTeacher();
	IServiceStaff staff = new IServiceStaff();

	public void addStaffDetails() {
		System.out.println();
		System.out.println("\t\t\t*********** ADD STAFF RECORD **********");
		System.out.println();
		while (true) {
			System.out.print("\n\t\t\tPlease enter all relevant data.\n");

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

			System.out.println("\n\t\t\tPost :");
			String postStaff = sc.nextLine();

			System.out.println("\n\t\t\tDepartment :");
			String departmentStaff = sc.nextLine();

			staff.addItem(
					new Staff(nameStaff, genderStaff, phoneStaff, emailStaff, addressStaff, salaryStaff, joinDateStaff,
							postStaff, departmentStaff));
			System.out.print("\n\t\t\tWould you like to continue inserting another record [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				break;
			}
		}

	}

	public void addTeacherDetails() {
		System.out.println();
		System.out.println("\t\t\t*********** ADD TEACHER RECORD **********");
		System.out.println();
		while (true) {
			System.out.print("\n\t\t\tPlease enter all relevant data.\n");

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

			/*-
			 * How to format date from JDBC to MySQL ?
			 * 
			 * For JDBC 4.2 and above, LocalDate can be used :
			 * 
			 * String input = "01/01/2009" ;
			 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM/dd/yyyy" ) ;
			 * LocalDate localDate = LocalDate.parse( input, formatter ) ;
			 * pstmt.setObject( 5, localDate ) ;  // Pass java.time object directly, without any need for java.sql.*.
			 * 
			 *  java.sql.Date can always be used for any sql database date requirements
			 * 
			 *  Also, String input can be converted to sql date as well. For example,
			 * 
			 *  String str="2015-03-31";  
			 *  Date date=Date.valueOf(str); //converting string into sql date
			 * 
			 * 
			 * KP: not using following code. Instead using java.sql.Date
			 * 
			 *  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 *  LocalDate.parse(joinDate, dtf);
			 *  LocalDate joinTeacherDate = LocalDate.parse(sc.nextLine(), dtf);
			 * 
			*/

			System.out.print("\n\t\t\tJoinDate : ");
			java.sql.Date joinDate = java.sql.Date.valueOf(sc.nextLine());

			teacher.addItem(
					new Teacher(nameTeacher, genderTeacher, phoneTeacher, emailTeacher, addressTeacher, subjectTeacher,
							salaryTeacher, joinDate));

			System.out.print("\n\t\t\tWould you like to continue inserting another record [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				break;
			}
		}

	}

	public void addStudentDetails() {
		System.out.println();
		System.out.println("\t\t\t*********** ADD STUDENT RECORD **********");
		System.out.println();

		while (true) {

			System.out.print("\t\t\tPlease enter all relevant data below.\n");

			System.out.print("\n\t\t\tName	:");
			String name = sc.nextLine();

			System.out.print("\n\t\t\tGender	:");
			String gender = sc.nextLine();

			System.out.print("\n\t\t\tPhone	:");
			String phone = sc.nextLine();

			System.out.print("\n\t\t\tEmail	:");
			String email = sc.nextLine();

			System.out.print("\n\t\t\tAddress	:");
			String address = sc.nextLine();

			System.out.print("\n\t\t\tGrade	:");
			int grade = Integer.parseInt(sc.nextLine());

			System.out.print("\n\t\t\tGPA	:");
			double gpa = Double.parseDouble(sc.nextLine());

			student.addItem(new Student(name, gender, phone, email, address, grade, gpa));

			System.out.print("\n\t\t\tWould you like to continue inserting another record [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				break;
			}

		}

	}

	//
//	public void addRecordSubMenu() {
//
//		boolean isRunning = true;
//		while (isRunning) {
//			System.out.println("******ADD RECORD******");
//			System.out.println("1.STUDENT");
//			System.out.println("2.TEACHER");
//			System.out.println("3.STAFF");
//			System.out.println("4.MAIN MENU");
//
//			int ch = -1;
//
//			System.out.println("Enter your choice : ");
//			ch = Integer.parseInt(sc.nextLine());
//
//			switch (ch) {
//
//			case 1:
//
//				addStudentDetails();
//				break;
//
//			case 2:
//
//				addTeacherDetails();
//				break;
//
//			case 3:
//
//				addStaffDetails();
//				break;
//
//			case 4:
//
//				isRunning = false;
//				break;
//
//			default:
//				System.out.println("INVALID CHOICE");
//				break;
//			}
//
//		}
//
//	}

}
