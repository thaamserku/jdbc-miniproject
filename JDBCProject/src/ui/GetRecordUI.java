package ui;

import java.util.Scanner;

import service.IServiceStaff;
import service.IServiceStudent;
import service.IServiceTeacher;

public class GetRecordUI {

	int id;
	Scanner sc = new Scanner(System.in);

	IServiceStudent student = new IServiceStudent();
	IServiceTeacher teacher = new IServiceTeacher();
	IServiceStaff staff = new IServiceStaff();

	public void findStaffByID() {
		while (true) {
			Menu.clearScreen();
			System.out.print("\t\t\tEnter ID of the Staff record you want to retrieve :");
			id = Integer.parseInt(sc.nextLine());
			staff.getItemByID(id);
			System.out.print("\n\t\t\tWould you like to continue looking for another staff record [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				Menu.clearScreen();
				break;
			}
		}
	}

	public void findTeacherByID() {
		while (true) {
			Menu.clearScreen();
			System.out.print("\t\t\tEnter ID of the Teacher record you want to retrieve :");
			id = Integer.parseInt(sc.nextLine());
			teacher.getItemByID(id);
			System.out.print("\n\t\t\tWould you like to continue looking for another teacher record [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				Menu.clearScreen();
				break;
			}
		}
	}

	public void findStudentByID() {
		while (true) {
			Menu.clearScreen();
			System.out.print("\t\t\tEnter ID of the Student record you want to retrieve :");
			id = Integer.parseInt(sc.nextLine());
			// student.displayFoundItem();//not working
			student.getItemByID(id);
			System.out.print("\n\t\t\tWould you like to continue looking for another student record [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				Menu.clearScreen();
				break;
			}
		}
	}

}
