package ui;

import java.util.Scanner;

import service.IServiceStaff;
import service.IServiceStudent;
import service.IServiceTeacher;

public class DeleteRecordUI {

	int id;
	Scanner sc = new Scanner(System.in);

	IServiceStudent student = new IServiceStudent();
	IServiceTeacher teacher = new IServiceTeacher();
	IServiceStaff staff = new IServiceStaff();

	public void deleteStaffRecordByID() {
		int id;
		while (true) {
			Menu.clearScreen();
			System.out.println("\t\t\t\tLIST OF STAFF RECORDS");
			System.out.println();
			staff.displayAllItem();

			System.out.print("\n\t\tYou are about to delete a record.");
			System.out.print("\n\t\tEnter ID of the Staff Record you want to delete :");
			id = Integer.parseInt(sc.nextLine());
			staff.deleteItem(id);

			Menu.clearScreen();
			System.out.println("\t\t\t\tUPDATED LIST OF STAFF RECORDS");
			System.out.println();
			staff.displayUpdatedItems();

			System.out.print("\t\tWould you like to continue deleting records [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				Menu.clearScreen();
				break;
			}
		}
	}

	public void deleteTeacherRecordByID() {
		while (true) {
			Menu.clearScreen();
			System.out.println("\t\t\t\tLIST OF TEACHER RECORDS");
			System.out.println();
			teacher.displayAllItem();

			System.out.print("\n\t\tYou are about to delete a record.");
			System.out.print("\n\t\tEnter ID of the Teacher Record you want to delete :");
			id = Integer.parseInt(sc.nextLine());
			teacher.deleteItem(id);

			Menu.clearScreen();
			System.out.println("\t\t\t\tUPDATED LIST OF TEACHER RECORDS");
			System.out.println();
			teacher.displayUpdatedItems();

			System.out.print("\t\tWould you like to continue deleting records [Yes/No]?");
			String option = sc.nextLine();
			if (option.equalsIgnoreCase("No")) {
				Menu.clearScreen();
				break;
			}
		}
	}

	public void deleteStudentRecordByID() {
		while (true) {
			// Clear Screen and provide user with the list of records prior to deleting
			Menu.clearScreen();
			System.out.println("\t\t\t\tLIST OF STUDENT RECORDS");
			System.out.println();
			student.displayAllItem();

			// Gentle reminder to user what they are about to do, and prompting them for id
			// of the record to be deleted.
			System.out.print("\n\t\tYou are about to delete a record.");
			System.out.print("\n\t\tEnter ID of the Student Record you want to delete :");
			id = Integer.parseInt(sc.nextLine()); // get the id
			student.deleteItem(id); // delete the corresponding record
			Menu.clearScreen();

			// display the list of all records after deleting the user-requested record
			System.out.println("\t\t\t\tUPDATED LIST OF STUDENT RECORDS");
			System.out.println();
			student.displayUpdatedItems();

			// Prompt user if they want to further continue with the deleting of records.
			// If they want, loop it from above one more time, otherwise break out of it
			System.out.print("\t\tWould you like to continue deleting records[Yes/No]?");
			String option = sc.nextLine();

			if (option.equalsIgnoreCase("No")) {
				Menu.clearScreen();
				break; // break out of while-loop
			}
		}
	}
}
