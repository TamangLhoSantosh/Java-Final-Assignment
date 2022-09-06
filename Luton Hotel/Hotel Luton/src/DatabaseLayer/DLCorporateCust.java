package DatabaseLayer;

//importing packages
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import FrontendLayer.LoginPage;
import FrontendLayer.Main;
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
	public CorporateCustomer register() throws Exception {
		try {

			if(same()) {
				//preparing to insert the data entered
				String generatedColumns[] = {"id"};
				
				//creating query to insert data
				String query = "INSERT INTO corporatecustomer(Registration_No, Company_Name, Contact_No, Address, Discount_Discussed, Discount_Year, User_Id) VALUES(?,?,?,?,?,?,?)";
				PreparedStatement statement =this.connection.prepareStatement(query, generatedColumns);
				statement.setInt(1,this.corporateCust.getRegistrationNo());
				statement.setString(2,this.corporateCust.getCompanyName());
				statement.setString(3,this.corporateCust.getContact());
				statement.setString(4,this.corporateCust.getAddress());
				statement.setInt(5,this.corporateCust.getDiscountDiscussed());
				statement.setString(6,this.corporateCust.getDiscountYear());
				statement.setInt(7, DLLogin.foreignKey);
				
				//query execution
				int noOfUpdate = statement.executeUpdate();
				if(noOfUpdate > 0) {
					ResultSet rs = statement.getGeneratedKeys();
					if(rs.next()) {
						int id = rs.getInt(1);
						this.corporateCust.setCustomerId(id);

		                JOptionPane.showMessageDialog(null,"Account created");
		                JOptionPane.showMessageDialog(null,"Proceed With Login");
						Main.contentPane.removeAll();
						Main.contentPane.add(new LoginPage()).setVisible(true);
					}
				}
			}

		}catch (Exception ex) {
			throw ex;
		}				
		return this.corporateCust;

	}
	

	/*
	 * checking for the same data entries
	 */
	private boolean same() throws Exception{
		
		//generating query
		String query = "SELECT * FROM corporatecustomer WHERE registration_no = ? AND company_name = ?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, this.corporateCust.getRegistrationNo());
			statement.setString(2, this.corporateCust.getCompanyName());
			
			//executes the query
			ResultSet rs = statement.executeQuery();
			
			//checking no. of result
			if(rs.next()) {
				return false;
			}
		}catch (Exception ex) {
			throw ex;
		}
		return true;
	}

	//method to update the data
	public CorporateCustomer update() throws Exception{
		try {
			
			//creating query to updated data 
			String query = "Update corporatecustomer SET Registration_No = ?, Company_Name = ?, Contact = ?, Address = ?, Discount_Disussed = ?, Discount_Year = ?, User_Id = ? WHERE id = ?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1,this.corporateCust.getRegistrationNo());
			statement.setString(2,this.corporateCust.getCompanyName());
			statement.setString(3,this.corporateCust.getContact());
			statement.setString(4,this.corporateCust.getAddress());
			statement.setInt(5,this.corporateCust.getDiscountDiscussed());
			statement.setString(6,this.corporateCust.getDiscountYear());
			statement.setInt(7, DLLogin.foreignKey);
			
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
			String query = "DELETE FREOM corporateCustomer WHERE id = ?";
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
