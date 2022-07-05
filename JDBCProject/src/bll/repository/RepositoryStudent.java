package bll.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.entity.Student;
import dal.ConnectionSetting;

public class RepositoryStudent implements IRepository<Student> {

	Student selectAllStudent = null;
	List<Student> studentList = new ArrayList<>();

	// create connection settings object and call getConnection method
	ConnectionSetting con = new ConnectionSetting();
	Connection cn = con.getConnection();

	// declare prepared statement and ResultSet
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	// declare relevant SQL commands
	public static final String INS_COMMAND =
			"INSERT INTO student (name,gender,phone,email,address,grade,gpa) VALUES (?,?,?,?,?,?,?)";
	public static final String UPDATE_COMMAND =
			"UPDATE student SET name = ?,gender = ?,phone = ?,email = ?,address = ?, grade =? , gpa = ? WHERE id = ?";
	public static final String DEL_COMMAND = "DELETE FROM student WHERE id=?";
	public static final String FIND_COMMAND = "SELECT * FROM student WHERE id=?";
	public static final String SELECT_ALL = "SELECT * FROM student";

	@Override
	// This method adds records to table.
	public void addItem(Student item) {

		int i = 0;
		try {
			pst = cn.prepareStatement(INS_COMMAND);
			pst.setString(1, item.getName());
			pst.setString(2, item.getGender());
			pst.setString(3, item.getPhone());
			pst.setString(4, item.getEmail());
			pst.setString(5, item.getAddress());
			pst.setInt(6, item.getGrade());
			pst.setDouble(7, item.getGpa());
			i = pst.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("\n\t\t\tAdding record failed...Unable to execute INSERT COMMAND.");
			e1.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (i > 0) {
			System.out.println("\n\t\t\tRecord added successfully");
		}
	}

	@Override
	// This method deletes record from table. It takes id as parameter.
	public void deleteItem(int id) {

		int i = 0;
		try {
			pst = cn.prepareStatement(DEL_COMMAND);
			pst.setInt(1, id);
			i = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("\n\t\t\tDelete operation failed.. Unable to execute DELETE COMMAND.");
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			System.out.println("\n\t\t\tRecord deleted succesfully.");
		}

	}

	@Override
	// This method updates record in table. One record at a time.
	// If you want to update a record with ID 2, you provide all the new info along
	// with old ID (2 in this case).
	// It takes Student object as parameter.
	public void updateItem(Student item) {
		int i = 0;
		try {
			pst = cn.prepareStatement(UPDATE_COMMAND);
			pst.setString(1, item.getName());
			pst.setString(2, item.getGender());
			pst.setString(3, item.getPhone());
			pst.setString(4, item.getEmail());
			pst.setString(5, item.getAddress());
			pst.setInt(6, item.getGrade());
			pst.setDouble(7, item.getGpa());
			pst.setInt(8, item.getId());
			i = pst.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("\n\t\t\tUpdate operation failed.. Unable to execute UPDATE COMMAND.");
			e1.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (i > 0) {
			System.out.println("\n\t\t\tRecord updated successfully.");
		}

	}

	@Override
	public List<Student> showAllItem() {
		try {
			selectAllStudent = new Student();
			pst = cn.prepareStatement(SELECT_ALL);
			rs = pst.executeQuery();
			while (rs.next()) {
				selectAllStudent = new Student();
				selectAllStudent.setId(rs.getInt("id"));
				selectAllStudent.setName(rs.getString("name"));
				selectAllStudent.setGender(rs.getString("gender"));
				selectAllStudent.setPhone(rs.getString("phone"));
				selectAllStudent.setEmail(rs.getString("email"));
				selectAllStudent.setAddress(rs.getString("address"));
				selectAllStudent.setGrade(rs.getInt("grade"));
				selectAllStudent.setGpa(rs.getDouble("gpa"));
				studentList.add(selectAllStudent);
			}
			// printAllStudentList(slist);

		} catch (SQLException e) {
			System.out.println("Failed to get the student list..Unable to execute SELECT_ALL COMMAND.");
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return studentList;
	}

	// show list before delete/update
	public void showStudentList() {

		if (studentList.size() > 0) {
			printAllStudentList(studentList);
		} else {
			showAllItem();
			printAllStudentList(studentList);
		}
	}// End of showStudentList()

	// show list after delete/update
	public void updateStudentList() {
		studentList.clear();
		showAllItem();
		printAllStudentList(studentList);
	}// End of updateStudentList()

	// Print StudentList with printf;
	public void printAllStudentList(List<Student> studentList) {
		System.out.println("\t---------------------------------------------------------------------------------");
		System.out.printf(
				"\t%-4s %-14s %-9s %-9s %-14s %-14s %-6s %-6s\n",
				"ID",
				"NAME",
				"GENDER",
				"PHONE",
				"EMAIL",
				"ADDRESS",
				"GRADE",
				"GPA");
		System.out.println("\t---------------------------------------------------------------------------------");

		for (Student s : studentList) {
			System.out.printf(
					"\t%-5d%-15s%-10s%-10s%-15s%-15s%-7d%-40.2f\n",
					s.getId(),
					s.getName(),
					s.getGender(),
					s.getPhone(),
					s.getEmail(),
					s.getAddress(),
					s.getGrade(),
					s.getGpa());
		}
		System.out.println("\t---------------------------------------------------------------------------------");
	}

	// search for an item with ID, and print out the details
	public boolean getItemByID(int id) {
		boolean isFound = false;
		try {
			pst = cn.prepareStatement(FIND_COMMAND);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				isFound = true;
				printItem( // function defined below
						new Student(rs.getInt("id"), rs.getString("name"), rs.getString("gender"),
								rs.getString("phone"), rs.getString("email"), rs.getString("address"),
								rs.getInt("grade"), rs.getDouble("gpa")));
			} else {
				System.out.println("Record not found for id " + id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return isFound;

	}// End of getEmployeeByID()

	// To print single item data
	protected void printItem(Student item) {
		System.out.println("\t\t\t------ INDIVIDUAL STUDENT INFO -------------------");
		System.out.println("\t\t\t\tID : " + item.getId());
		System.out.println("\t\t\t\tName : " + item.getName());
		System.out.println("\t\t\t\tGender : " + item.getGender());
		System.out.println("\t\t\t\tPhone : " + item.getPhone());
		System.out.println("\t\t\t\tEmail : " + item.getEmail());
		System.out.println("\t\t\t\tAddress : " + item.getAddress());
		System.out.println("\t\t\t\tGrade : " + item.getGrade());
		System.out.println("\t\t\t\tGPA : " + item.getGpa());
		System.out.println("\t\t\t----------------------------------------------");

	} // End of printItem //

	public void printItemListColumn(Student item) {
		System.out.println("/t---------------------------------------------------------------------------------");
		System.out.printf(
				"\t%-4s %-14s %-9s %-9s %-14s %-14s %-6s %-6s\n",
				"ID",
				"NAME",
				"GENDER",
				"PHONE",
				"EMAIL",
				"ADDRESS",
				"GRADE",
				"GPA");
		System.out.println("\t---------------------------------------------------------------------------------");
		System.out.printf(
				"\t%-5d%-15s%-10s%-10s%-15s%-15s%-5d%-40.2f\n",
				item.getId(),
				item.getName(),
				item.getGender(),
				item.getPhone(),
				item.getEmail(),
				item.getAddress(),
				item.getGrade(),
				item.getGpa());
	}// End of printItemListColumn

	// Methods not currently utilized for the project
	@Override
	public void getAllItem() {
		try {
			pst = cn.prepareStatement(SELECT_ALL);
			rs = pst.executeQuery();
			while (rs.next()) {
				printItemListColumn(
						new Student(rs.getInt("id"), rs.getString("name"), rs.getString("gender"),
								rs.getString("phone"), rs.getString("email"), rs.getString("address"),
								rs.getInt("grade"), rs.getDouble("gpa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}// End of getAllItem()

	Student findStudent = new Student();

	@Override
	// not able to pass the rs to object.
	// need to look into it.
	public Student findItem(Student item) {

		try {
			// findStudent = new Student();

			pst = cn.prepareStatement(FIND_COMMAND);
			pst.setInt(1, item.getId());
			rs = pst.executeQuery();
			while (rs.next()) {

				findStudent.setId(rs.getInt("id"));
				findStudent.setName(rs.getString("name"));
				findStudent.setGender(rs.getString("gender"));
				findStudent.setPhone(rs.getString("phone"));
				findStudent.setEmail(rs.getString("email"));
				findStudent.setAddress(rs.getString("address"));
				findStudent.setGrade(rs.getInt("grade"));
				findStudent.setGpa(rs.getDouble("gpa"));
			}

		} catch (SQLException e) {
			System.out.println("Unable to execute find command.");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return findStudent;
		// return item;

	}

	// this function is tied with the one above.Not working at the moment
	public void displayFoundStudent() {
		printItemListColumn(findStudent);
	}

}