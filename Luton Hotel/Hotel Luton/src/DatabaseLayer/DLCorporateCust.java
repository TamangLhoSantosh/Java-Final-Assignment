package DatabaseLayer;

//importing packages
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DatabaseConnector;
import Models.CorporateCustomer;

public class DLCorporateCust {


	//declaring variables
	private CorporateCustomer corporateCust;
	private DatabaseConnector db;
	private Connection connection;
	
	public DLCorporateCust() throws Exception {
		this.corporateCust = new CorporateCustomer();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	public DLCorporateCust(CorporateCustomer corporateCust) throws Exception {
		this.corporateCust = corporateCust;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	public CorporateCustomer getCorporateCust() {
		return corporateCust;
	}
	
	public void setCorporateCust(CorporateCustomer corporateCust) {
		this.corporateCust = corporateCust;
	}
	
	//method to insert data into 
	public CorporateCustomer save() throws Exception {
		try {
			
			//preparing to insert the data entered
			String generatedColumns[] = {"id", "registrationNo", "companyName", "contact", "address", "discountDiscussed"};
			
			//creating query to insert data
			String query = "INSERT INTO corporatecustomer(registrationNo, companyName, contact, address, discountDiscussed VALUES(?,?,?,?,?)";
			PreparedStatement statement =this.connection.prepareStatement(query, generatedColumns);
			statement.setInt(1,this.corporateCust.getRegistrationNo());
			statement.setString(2,this.corporateCust.getCompanyName());
			statement.setString(4,this.corporateCust.getContact());
			statement.setString(5,this.corporateCust.getAddress());
			statement.setInt(6,this.corporateCust.getDiscountDiscussed());
			
			//query execution
			int noOfUpdate = statement.executeUpdate();
			if(noOfUpdate > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					this.corporateCust.setCustomerId(id);
				}
			}
			return this.corporateCust;
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	//method to update the data
	public CorporateCustomer update() throws Exception{
		try {
			
			//creating query to updated data 
			String query = "Update corporatecustomer SET fName = ?, lName = ?, dateOfBirth = ?, contact = ?, address = ?, designation = ? WHERE id = ?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, this.corporateCust.getRegistrationNo());
			statement.setString(2, this.corporateCust.getCompanyName());
			statement.setString(4, this.corporateCust.getContact());
			statement.setString(5, this.corporateCust.getAddress());
			statement.setInt(6, this.corporateCust.getDiscountDiscussed());
		
			//executing query
			statement.executeUpdate();
			return this.corporateCust;
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
			statement.setInt(1,corporateCust.getCustomerId());
			
			//executing query
			statement.executeUpdate();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	//method to show all corporate customer
	public ArrayList<CorporateCustomer> getAllCorporateCust() throws Exception{
		try {
			ArrayList<CorporateCustomer> ccs = new ArrayList<CorporateCustomer>();
			
			//query to select all data of corporate customer
			String query = "SELECT * FROM corporatecustomer ORDER BY fName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				CorporateCustomer cc = new CorporateCustomer();
				cc.setCustomerId(rs.getInt("id"));
				cc.setRegistrationNo(rs.getInt("registrationNo"));
				cc.setCompanyName(rs.getString("CompanyName"));
				cc.setContact(rs.getString("contact"));
				cc.setAddress(rs.getString("address"));
				cc.setDiscountDiscussed(rs.getInt("discountDiscussed"));
				ccs.add(cc);
			}
			return ccs;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	//method to show specific corporate customer data
	public ArrayList<CorporateCustomer> searchCorporateCust(String[] keys, String[] values) throws Exception {
		
		//select from corporate customer where name like '%a%' and address like '%sfgdf5'
		ArrayList<CorporateCustomer> ccs = new ArrayList<CorporateCustomer>();
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
			String query ="SELECT * FROM corporatecustomer" + where + "ORFER BY fName";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				CorporateCustomer cc = new CorporateCustomer();
				cc.setCustomerId(rs.getInt("id"));
				cc.setRegistrationNo(rs.getInt("registrationNo"));
				cc.setCompanyName(rs.getString("CompanyName"));
				cc.setContact(rs.getString("contact"));
				cc.setAddress(rs.getString("address"));
				cc.setDiscountDiscussed(rs.getInt("discountDiscussed"));
				ccs.add(cc);
			}
			}catch (SQLException e) {
			throw new Exception(e.getMessage());
			}
		return ccs;
		}
}