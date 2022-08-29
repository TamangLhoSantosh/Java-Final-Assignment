package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DatabaseConnector;
import Models.IndividualCustomer;

public class DLIndividualCust {

	//declaring variables
	private IndividualCustomer iCust;
	private DatabaseConnector db;
	private Connection connection;
	
	public DLIndividualCust() throws Exception {
		this.iCust = new IndividualCustomer();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	public DLIndividualCust(IndividualCustomer iCust) throws Exception{
		this.iCust = iCust;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	public IndividualCustomer getIndividualCustomer() {
		return iCust;
	}
	
	public void setIndividualCustomer(IndividualCustomer iCust) {
		this.iCust = iCust;
	}
	
	//method to insert data into 
	public IndividualCustomer save() throws Exception {
		try {
			
			//preparing to insert the data entered
			String generatedColumns[] = {"id", "fName", "lName", "dateOfBirth", "contact", "address"};
			
			//creating query to insert data
			String query = "INSERT INTO individualcustomer(fName,lName, dateOfBirth, contact, address) VALUES(?,?,?,?,?)";
			PreparedStatement statement =this.connection.prepareStatement(query, generatedColumns);
			statement.setString(1,this.iCust.getfName());
			statement.setString(2,this.iCust.getlName());
			statement.setString(3,this.iCust.getDateOfBirth());
			statement.setString(4,this.iCust.getContact());
			statement.setString(5,this.iCust.getAddress());
			
			//query execution
			int noOfUpdate = statement.executeUpdate();
			if(noOfUpdate > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					this.iCust.setCustomerId(id);
				}
			}
			return this.iCust;
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	//method to update the data
	public IndividualCustomer update() throws Exception{
		try {
			
			//creating query to updated data 
			String query = "Update individualcustomer SET fName = ?, lName = ?, dateOfBirth = ?, contact = ?, address = ?, designation = ? WHERE id = ?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, this.iCust.getfName());
			statement.setString(2, this.iCust.getlName());
			statement.setString(3, this.iCust.getDateOfBirth());
			statement.setString(4, this.iCust.getContact());
			statement.setString(5, this.iCust.getAddress());
		
			//executing query
			statement.executeUpdate();
			return this.iCust;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	//method to delete the selected data
	public void delete() throws Exception{
		try {
			
			//creating query to delete data
			String query = "DELETE FREOM individualcustomer WHERE id = ?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1,iCust.getCustomerId());
			
			//executing query
			statement.executeUpdate();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	//method to show all individual customer
	public ArrayList<IndividualCustomer> getAllIndividualCust() throws Exception{
		try {
			ArrayList<IndividualCustomer> ics = new ArrayList<IndividualCustomer>();
			
			//query to select all data of individual customer
			String query = "SELECT * FROM individualcustomer ORDER BY fName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				IndividualCustomer ic  = new IndividualCustomer();
				ic.setCustomerId(rs.getInt("id"));
				ic.setfName(rs.getString("fName"));
				ic.setlName(rs.getString("lName"));
				ic.setDateOfBirth(rs.getString("dateOfBirth"));
				ic.setContact(rs.getString("contact"));
				ic.setAddress(rs.getString("address"));
				ics.add(ic);
			}
			return ics;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	//method to show specific individual customer data
	public ArrayList<IndividualCustomer> searchIndividualCust(String[] keys, String[] values) throws Exception {
		
		//select from individual customer where name like '%a%' and address like '%sfgdf5'
		ArrayList<IndividualCustomer> ics = new ArrayList<IndividualCustomer>();
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
			String query ="SELECT * FROM individualcustomer " + where + " ORFER BY fName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				IndividualCustomer ic = new IndividualCustomer();
				ic.setCustomerId(rs.getInt("id"));
				ic.setfName(rs.getString("fName"));
				ic.setlName(rs.getString("lName"));
				ic.setDateOfBirth(rs.getString("dateOfBirth"));
				ic.setContact(rs.getString("contact"));
				ic.setAddress(rs.getString("address"));
				ics.add(ic);
			}
		}catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return ics;
	}
}
