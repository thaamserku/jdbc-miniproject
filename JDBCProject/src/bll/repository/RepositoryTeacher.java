package bll.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.entity.Teacher;
import dal.ConnectionSetting;

public class RepositoryTeacher implements IRepository<Teacher> {

	// create connection settings object and call getConnection method
	ConnectionSetting con = new ConnectionSetting();
	Connection cn = con.getConnection();

	// declare prepared statement and ResultSet
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	// declare relevant SQL commands
	public static final String INS_COMMAND =
			"INSERT INTO teacher (name,gender,phone,email,address,major_subject,annual_salary,join_date) VALUES (?,?,?,?,?,?,?,?)";
	public static final String UPDATE_COMMAND =
			"UPDATE teacher SET name = ?,gender = ?,phone = ?,email = ?,address = ?, major_subject =? , annual_salary = ?, join_date = ? WHERE id = ?";
	public static final String DEL_COMMAND = "DELETE FROM teacher	 WHERE id=?";
	public static final String FIND_COMMAND = "SELECT * FROM teacher WHERE id=?";
	public static final String SELECT_ALL = "SELECT * FROM teacher";

	@Override
	// This method adds records to table.
	public void addItem(Teacher item) {

		int i = 0;
		try {
			pst = cn.prepareStatement(INS_COMMAND);
			pst.setString(1, item.getName());
			pst.setString(2, item.getGender());
			pst.setString(3, item.getPhone());
			pst.setString(4, item.getEmail());
			pst.setString(5, item.getAddress());
			pst.setString(6, item.getMajorSubject());
			pst.setDouble(7, item.getAnnualSalary());
			pst.setDate(8, item.getJoinDate());
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
	public void updateItem(Teacher item) {

		int i = 0;
		try {
			pst = cn.prepareStatement(UPDATE_COMMAND);

			pst.setString(1, item.getName());
			pst.setString(2, item.getGender());
			pst.setString(3, item.getPhone());
			pst.setString(4, item.getEmail());
			pst.setString(5, item.getAddress());
			pst.setString(6, item.getMajorSubject());
			pst.setDouble(7, item.getAnnualSalary());
			pst.setDate(8, item.getJoinDate());
			pst.setInt(9, item.getId());
			i = pst.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("\n\t\t\tUpdating record failed...Unable to execute UPDATE COMMAND.");
			e1.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (i > 0) {
			System.out.println("\n\t\t\tRecord updated successfully");
		}
	}

	@Override
	public boolean getItemByID(int id) {

		boolean isFound = false;
		try {
			pst = cn.prepareStatement(FIND_COMMAND);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				isFound = true;
				printItem(
						new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("gender"),
								rs.getString("phone"), rs.getString("email"), rs.getString("address"),
								rs.getString("major_subject"), rs.getDouble("annual_salary"), rs.getDate("join_date")));
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
		// return false;
	}

	protected void printItem(Teacher item) {
		System.out.println("\t\t\t------ INDIVIDUAL TEACHER INFO -------------------");
		System.out.println("\t\t\t\tID : " + item.getId());
		System.out.println("\t\t\t\tName : " + item.getName());
		System.out.println("\t\t\t\tGender : " + item.getGender());
		System.out.println("\t\t\t\tPhone : " + item.getPhone());
		System.out.println("\t\t\t\tEmail : " + item.getEmail());
		System.out.println("\t\t\t\tAddress : " + item.getAddress());
		System.out.println("\t\t\t\tSubject : " + item.getMajorSubject());
		System.out.println("\t\t\t\tSalary : " + item.getAnnualSalary());
		System.out.println("\t\t\t\tJoinDate : " + item.getJoinDate());
		System.out.println("\t\t\t----------------------------------------------");

	} // End of printItem //

	@Override
	public void getAllItem() {
		// TODO Auto-generated method stub

	}

	Teacher selectAllTeacher = null;
	List<Teacher> teacherList = new ArrayList<>();

	@Override
	public List<Teacher> showAllItem() {
		try {
			pst = cn.prepareStatement(SELECT_ALL);
			rs = pst.executeQuery();
			while (rs.next()) {
				selectAllTeacher = new Teacher();
				selectAllTeacher.setId(rs.getInt("id"));
				selectAllTeacher.setName(rs.getString("name"));
				selectAllTeacher.setGender(rs.getString("gender"));
				selectAllTeacher.setPhone(rs.getString("phone"));
				selectAllTeacher.setEmail(rs.getString("email"));
				selectAllTeacher.setAddress(rs.getString("address"));
				selectAllTeacher.setMajorSubject(rs.getString("major_subject"));
				selectAllTeacher.setAnnualSalary(rs.getDouble("annual_salary"));
				selectAllTeacher.setJoinDate(rs.getDate("join_date"));
				teacherList.add(selectAllTeacher);
			}
		} catch (SQLException e) {
			System.out.println("Unable to generate TEACHER LIST. Failed to execute SELECT_ALL COMMAND.");
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Failed to close PreparedStatement and ResultSet.");
				e.printStackTrace();
			}
		}
		return teacherList;
	}

	public void showTeacherList() {
		if (teacherList.size() > 0) {
			printAllTeacherList(teacherList);
		} else {
			showAllItem();
			printAllTeacherList(teacherList);
		}
	}

	public void showUpdatedTeacherList() {
		teacherList.clear(); // clears old list
		showAllItem(); // gets new list
		printAllTeacherList(teacherList); // prints new list
	}

	public void testDisplayTeacherData() {
		System.out.println("\nID\tName\t\tGender\tPhone\tEmail\t\t\t\tAddress\t\t\tSubject\t\tSalary\t\tJoinDate");
		showAllItem();
		for (Teacher t : teacherList) {
			System.out.println(
					t.getId() + "\t" + t.getName() + "\t\t" + t.getGender() + "\t" + t.getPhone() + "\t" + t.getEmail()
							+ "\t\t\t\t" + t.getAddress() + "\t\t\t" + t.getMajorSubject() + "\t\t"
							+ t.getAnnualSalary() + "\t\t" + t.getJoinDate().toString());
		}
	}

	public void printAllTeacherList(List<Teacher> teacherList) {
		System.out.println(
				"\t----------------------------------------------------------------------------------------------------------");

		System.out.printf(
				"\t%-4s %-15s %-7s %-10s %-15s %-14s %-12s %-14s %-6s\n",
				"ID",
				"NAME",
				"GENDER",
				"PHONE",
				"EMAIL",
				"ADDRESS",
				"SUBJECT",
				"JOINDATE",
				"SALARY");
		System.out.println(
				"\t----------------------------------------------------------------------------------------------------------");

		for (Teacher t : teacherList) {
			System.out.printf(
					"\t%-5d %-15s %-7s %-9s %-15s %-15s %-11s %-12s %-90.2f%n",
					t.getId(),
					t.getName(),
					t.getGender(),
					t.getPhone(),
					t.getEmail(),
					t.getAddress(),
					t.getMajorSubject(),
					t.getJoinDate().toString(),
					t.getAnnualSalary());
		}
		System.out.println(
				"\t----------------------------------------------------------------------------------------------------------");

	}

	@Override
	public Teacher findItem(Teacher item) {
		// TODO Auto-generated method stub
		// Not implemented
		return null;
	}

}
