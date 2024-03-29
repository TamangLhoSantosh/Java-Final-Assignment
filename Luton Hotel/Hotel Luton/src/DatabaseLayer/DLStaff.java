package DatabaseLayer;

//importing utilities packages
import Models.Staff;
import Helper.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DLStaff {

	//declaring variables
	private Staff staff;
	private DatabaseConnector db;
	private Connection connection;
	
	public DLStaff() throws Exception {
		this.staff = new Staff();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	public DLStaff(Staff staff) throws Exception{
		this.staff = staff;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	public Staff getStaff() {
		return staff;
	}
	
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	//method to insert data into staff table 
	public Staff save() throws Exception {
		try {
			
			//preparing to insert the data entered
			String generatedColumns[] = {"id", "fName", "lName", "dateOfBirth", "contact", "address","designation"};
			
			//creating query to insert data
			String query = "INSERT INTO staff(fName,lName, dateOfBirth, contact, address, designstion) VALUES(?,?,?,?,?,?)";
			PreparedStatement statement =this.connection.prepareStatement(query, generatedColumns);
			statement.setString(1,this.staff.getfName());
			statement.setString(2,this.staff.getlName());
			statement.setString(3,this.staff.getDateOfBirth());
			statement.setString(4,this.staff.getContact());
			statement.setString(5,this.staff.getAddress());
			statement.setString(6,this.staff.getDesignation());
			
			//query execution
			int noOfUpdate = statement.executeUpdate();
			if(noOfUpdate > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					this.staff.setStaffId(id);
				}
			}
			return this.staff;
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	//method to update the data
	public Staff update() throws Exception{
		try {
			
			//creating query to updated data 
			String query = "Update staff SET fName = ?, lName = ?, dateOfBirth = ?, contact = ?, address = ?, designation = ? WHERE id = ?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, this.staff.getfName());
			statement.setString(2, this.staff.getlName());
			statement.setString(3, this.staff.getDateOfBirth());
			statement.setString(4, this.staff.getContact());
			statement.setString(5, this.staff.getAddress());
			statement.setString(6, this.staff.getDesignation());
		
			//executing query
			statement.executeUpdate();
			return this.staff;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	//method to delete the selected data
	public void delete() throws Exception{
		try {
			
			//creating query to delete data
			String query = "DELETE FREOM staff WHERE id = ?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1,staff.getStaffId());
			
			//executing query
			statement.executeUpdate();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	//method to show all staff
	public ArrayList<Staff> getAllStaff() throws Exception{
		try {
			ArrayList<Staff> staffs = new ArrayList<Staff>();
			
			//query to select all data of staff
			String query = "SELECT * FROM staff ORDER BY fName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Staff s = new Staff();
				s.setStaffId(rs.getInt("id"));
				s.setfName(rs.getString("fName"));
				s.setlName(rs.getString("lName"));
				s.setDateOfBirth(rs.getString("dateOfBirth"));
				s.setContact(rs.getString("contact"));
				s.setAddress(rs.getString("address"));
				s.setDesignation(rs.getString("designation"));
				staffs.add(s);
			}
			return staffs;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	//method to show specific staff data
	public ArrayList<Staff> searchStaff(String[] keys, String[] values) throws Exception {
		
		//select from user where name like '%a%' and address like '%sfgdf5'
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		try {
			int keyLength = keys.length;
			String where = "";
			for(int i = 0; i < keyLength; ++i) {
				if(i==0) {
					where = where + "WHERE " + keys[i] + " LIKE '%" + values[i] + "%' ";
				}
				else {
					where = where + "AND " + keys[i] + " LIKE '%" + values[i] + "%' ";
				}
			}
			String query ="SELECT * FROM staff " + where + " ORFER BY fName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Staff s = new Staff();
				s.setStaffId(rs.getInt("id"));
				s.setfName(rs.getString("fName"));
				s.setlName(rs.getString("lName"));
				s.setDateOfBirth(rs.getString("dateOfBirth"));
				s.setContact(rs.getString("contact"));
				s.setAddress(rs.getString("address"));
				s.setDesignation(rs.getString("designation"));
				staffs.add(s);
			}
		}catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return staffs;
	}
}