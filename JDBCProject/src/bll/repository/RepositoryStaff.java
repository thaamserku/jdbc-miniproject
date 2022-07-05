package bll.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.entity.Staff;
import dal.ConnectionSetting;

public class RepositoryStaff implements IRepository<Staff> {

	// create connection settings object and call getConnection method
	ConnectionSetting con = new ConnectionSetting();
	Connection cn = con.getConnection();

	// declare prepared statement and ResultSet
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	// declare relevant SQL commands
	public static final String INS_COMMAND =
			"INSERT INTO staff (name,gender,phone,email,address,annual_salary,join_date,post,department) VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_COMMAND =
			"UPDATE staff SET name = ?, gender = ?, phone = ?, email = ?, address = ?, annual_salary = ?, join_date = ?, post = ?, department = ? WHERE id = ?";
	public static final String DEL_COMMAND = "DELETE FROM staff	 WHERE id=?";
	public static final String FIND_COMMAND = "SELECT * FROM staff WHERE id=?";
	public static final String SELECT_ALL = "SELECT * FROM staff";

	@Override
	public void addItem(Staff item) {
		int i = 0;
		try {
			pst = cn.prepareStatement(INS_COMMAND);
			pst.setString(1, item.getName());
			pst.setString(2, item.getGender());
			pst.setString(3, item.getPhone());
			pst.setString(4, item.getEmail());
			pst.setString(5, item.getAddress());
			pst.setDouble(6, item.getAnnualSalary());
			pst.setDate(7, item.getJoinDate());
			pst.setString(8, item.getPost());
			pst.setString(9, item.getDepartment());
			i = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("\n\t\t\tAdding record failed...Unable to execute INSERT COMMAND.");
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
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

		// TODO Auto-generated method stub

	}

	@Override
	public void updateItem(Staff item) {
		int i = 0;
		try {
			pst = cn.prepareStatement(UPDATE_COMMAND);
			pst.setString(1, item.getName());
			pst.setString(2, item.getGender());
			pst.setString(3, item.getPhone());
			pst.setString(4, item.getEmail());
			pst.setString(5, item.getAddress());
			pst.setDouble(6, item.getAnnualSalary());
			pst.setDate(7, item.getJoinDate());
			pst.setString(8, item.getPost());
			pst.setString(9, item.getDepartment());
			pst.setInt(10, item.getId());
			i = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("\n\t\t\tUpdating record failed...Unable to execute UPDATE COMMAND.");
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			System.out.println("\n\t\t\tRecord updated successfully");
		}
	}

	@Override
	public boolean getItemByID(int id) {
		// TODO Auto-generated method stub
		boolean isFound = false;
		try {
			pst = cn.prepareStatement(FIND_COMMAND);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				isFound = true;
				printItem(
						new Staff(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), rs.getString("phone"),
								rs.getString("email"), rs.getString("address"), rs.getDouble("annual_salary"),
								rs.getDate("join_date"), rs.getString("post"), rs.getString("department")));
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

	}

	protected void printItem(Staff item) {
		System.out.println("\t\t\t------ INDIVIDUAL STAFF INFO -------------------");
		System.out.println("\t\t\t\tID : " + item.getId());
		System.out.println("\t\t\t\tName : " + item.getName());
		System.out.println("\t\t\t\tGender : " + item.getGender());
		System.out.println("\t\t\t\tPhone : " + item.getPhone());
		System.out.println("\t\t\t\tEmail : " + item.getEmail());
		System.out.println("\t\t\t\tAddress : " + item.getAddress());
		System.out.println("\t\t\t\tPost : " + item.getPost());
		System.out.println("\t\t\t\tDepartment : " + item.getDepartment());
		System.out.println("\t\t\t\tSalary : " + item.getAnnualSalary());
		System.out.println("\t\t\t\tJoinDate : " + item.getJoinDate());
		System.out.println("\t\t\t----------------------------------------------");

	} // End of printItem //

	@Override
	public void getAllItem() {
		// TODO Auto-generated method stub

	}

	Staff selectAllStaff = null;
	List<Staff> staffList = new ArrayList<>();

	@Override
	public List<Staff> showAllItem() {
		try {
			pst = cn.prepareStatement(SELECT_ALL);
			rs = pst.executeQuery();
			while (rs.next()) {
				selectAllStaff = new Staff();
				selectAllStaff.setId(rs.getInt("id"));
				selectAllStaff.setName(rs.getString("name"));
				selectAllStaff.setGender(rs.getString("gender"));
				selectAllStaff.setPhone(rs.getString("phone"));
				selectAllStaff.setEmail(rs.getString("email"));
				selectAllStaff.setAddress(rs.getString("address"));
				selectAllStaff.setAnnualSalary(rs.getDouble("annual_salary"));
				selectAllStaff.setJoinDate(rs.getDate("join_date"));
				selectAllStaff.setPost(rs.getString("post"));
				selectAllStaff.setDepartment(rs.getString("department"));
				staffList.add(selectAllStaff);

			}
		} catch (SQLException e) {
			System.out.println("Unable to generate STAFF LIST. Failed to execute SELECT_ALL COMMAND.");
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
		return staffList;
	}

	public void displayStaffList() {
		if (staffList.size() > 0) {
			printAllStaffList(staffList);
		} else {
			showAllItem();
			printAllStaffList(staffList);
		}
	}

	public void displayUpdatedStaffList() {
		staffList.clear();
		showAllItem();
		printAllStaffList(staffList);
	}

	public void printAllStaffList(List<Staff> staffList) {
		System.out.println(
				"\t-------------------------------------------------------------------------------------------------------------------------");

		System.out.printf(
				"\t%-4s %-15s %-7s %-10s %-15s %-15s %-10s %-14s %-14s %-6s\n",
				"ID",
				"NAME",
				"GENDER",
				"PHONE",
				"EMAIL",
				"ADDRESS",
				"POST",
				"DEPARTMENT",
				"JOINDATE",
				"SALARY");
		System.out.println(
				"\t-------------------------------------------------------------------------------------------------------------------------");

		for (Staff st : staffList) {
			System.out.printf(
					"\t%-4d %-15s %-7s %-10s %-15s %-15s %-10s %-14s %-13s %-90.2f%n",
					st.getId(),
					st.getName(),
					st.getGender(),
					st.getPhone(),
					st.getEmail(),
					st.getAddress(),
					st.getPost(),
					st.getDepartment(),
					st.getJoinDate().toString(),
					st.getAnnualSalary());
		}
		System.out.println(
				"\t-------------------------------------------------------------------------------------------------------------------------");

	}

	@Override
	public Staff findItem(Staff item) {
		// TODO Auto-generated method stub
		return null;
	}

}
