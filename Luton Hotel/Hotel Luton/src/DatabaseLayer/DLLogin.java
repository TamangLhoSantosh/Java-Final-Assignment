package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import FrontendLayer.CustomerHome;
import FrontendLayer.Main;
import Helper.DatabaseConnector;
import Models.Login;

public class DLLogin {

	//declaring variables
	private Login log;
	private DatabaseConnector db;
	private Connection connection;
	

	public DLLogin() throws Exception {
		this.log = new Login();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	public DLLogin(Login log) throws Exception{
		this.log = log;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public Login getLog() {
		return log;
	}

	public void setLog(Login log) {
		this.log = log;
	}
	

	//method to insert data into login table 
	public Login register() throws Exception {
		try {
			
			//preparing to insert the data entered
			String generatedColumns[] = {"id", "email", "password"};
			
			//creating query to insert data
			String query = "INSERT INTO login(email, password) VALUES(?,?)";
			PreparedStatement statement = this.connection.prepareStatement(query, generatedColumns);
			statement.setString(1,this.log.getEmail());
			statement.setString(2,this.log.getPassword());
			
			//query execution
			int noOfUpdate = statement.executeUpdate();
			if(noOfUpdate > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					this.log.setUserId(id);
				}
			}
			return this.log;
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	public Login login(Login log) throws Exception{
		String query = "SELECT * FROM LOGIN WHERE Email = ? AND Password = ?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, this.log.getEmail());
			statement.setString(2, this.log.getPassword());
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				Main.contentPane.removeAll();
				CustomerHome home = new CustomerHome();
				home.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invaild email or password", "Login Error", 2);
			}
		}catch (Exception ex) {
			throw ex;
		}
		return log;
	}
	
}
