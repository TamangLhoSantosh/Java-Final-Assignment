package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import FrontendLayer.AssignRoom;
import FrontendLayer.LastPage;
import FrontendLayer.StaffHome;
import FrontendLayer.ViewBooking;
import Helper.DatabaseConnector;
import Models.Booking;

public class DLBooking {

	//declaring variables
	private Booking book;
	private DatabaseConnector db;
	private Connection connection;
	public static int foreignKey;
	

	public DLBooking() throws Exception {
		this.book = new Booking();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	public DLBooking(Booking book) throws Exception{
		this.book = book;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
		}
	}

	public Booking getBook() {
		return book;
	}

	public void setLog(Booking book) {
		this.book = book;
	}
	

	//method to insert data into 
	public Booking book() throws Exception {
		try {

			//preparing to insert the data entered
			String generatedColumns[] = {"id"};

			//creating query to insert data
				String query = "INSERT INTO booking (booking_Date, booking_verified, booking_status, arrival_date, departure_date, room_type, icustomer_id, ccustomer_id) VALUES(Current_Date(), 'NO', 'PENDING', ?,?,?,?,?)";
				PreparedStatement statement =this.connection.prepareStatement(query, generatedColumns);
				statement.setString(1,this.book.getArrivalDate());
				statement.setString(2,this.book.getDepartureDate());
				statement.setString(3,this.book.getRoomType());
				statement.setInt(4, DLLogin.icid);
				statement.setInt(5, DLLogin.ccid);
				
				//query execution
				int noOfUpdate = statement.executeUpdate();
				if(noOfUpdate > 0) {
					ResultSet rs = statement.getGeneratedKeys();
					if(rs.next()) {
						int id = rs.getInt(1);
						this.book.setBookingId(id);
						foreignKey = this.book.getBookingId();

		                JOptionPane.showMessageDialog(null,"Booking Request Made");
		                
		                //opening next page
		                LastPage lp = new LastPage();
		                lp.setVisible(true);
					}
				}
				return this.book;
			}catch (Exception ex) {
				throw ex;
			}
		}
		
		//method to update the data
		public void update() throws Exception{
			try {
				
				//creating query to updated data 
				String query = "Update booking SET Arrival_Date = ?, Departure_Date = ?, room_type = ? WHERE Booking_id = ?";
				PreparedStatement statement = this.connection.prepareStatement(query);
				statement.setString(1,this.book.getArrivalDate());
				statement.setString(2,this.book.getDepartureDate());
				statement.setString(3, this.book.getRoomType());
				statement.setInt(4, ViewBooking.id);
				
				//executing query
				statement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Booking Updated");
			}catch(Exception ex) {
				throw ex;
			}
		}
		
		//method to cancel the booking
		public void cancel() throws Exception{
			try {
				
				//qurey creation
				String query = "Update booking SET Booking_Status = 'CANCEL' WHERE Booking_id = ? AND Booking_Status = 'PENDING'";
				PreparedStatement statement = this.connection.prepareStatement(query);
				statement.setInt(1, ViewBooking.id);

				if(JOptionPane.showConfirmDialog(ViewBooking.cancel, "Are You Sure You Want To Cancel Booking?", "CANCEL",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{

					//executing query
					statement.executeUpdate();	

					JOptionPane.showMessageDialog(null, "Booking Cancelled");	
				}
				
				//validating user type
				if(DLLogin.icid != 0 ) {

					statement.setInt(1,DLLogin.icid);
				}
				else {
					
					statement.setInt(1,DLLogin.ccid);
				}
			}catch(Exception ex) {
				throw ex;
			}
		}
		
		//method to delete the selected data
		public void delete() throws Exception{
			try {
				
				//creating query to delete data
				String query = "DELETE FROM booking WHERE id = ?";
				PreparedStatement statement = this.connection.prepareStatement(query);
				statement.setInt(1,book.getBookingId());
				
				//executing query
				statement.executeUpdate();
			}catch(Exception ex) {
				throw ex;
			}
		}
		
		//making the booking verified;
		public void bookingVerified() throws Exception {
			try {
				//qurey creation
				String query = "Update booking SET Booking_Verified = 'YES' WHERE Booking_id = ? AND Booking_Verified = 'NO'";
				PreparedStatement statement = this.connection.prepareStatement(query);
				statement.setInt(1, ViewBooking.id);
				statement.executeUpdate();
				
				JOptionPane.showInternalMessageDialog(null, "Booking Verified");

			}catch(Exception ex) {
				throw ex;
			}
		}
		
		//assiging room
		public void assign() throws Exception{
			//making query
			try {
				String query = "UPDATE Booking SET Room_Id = " + AssignRoom.id + ", Booking_Verified = 'YES', Booking_Status = 'BOOKED', Staff_Id = " + DLLogin.sfid + " WHERE Booking_Id = " + StaffHome.bid;

				Statement statement = this.connection.createStatement();
				statement.executeUpdate(query);
			}catch(Exception ex) {
				throw ex;
			}
		}


		//method to all the booking made by an individual customer
		public ArrayList<Booking> viewBooking() throws Exception{
			ArrayList<Booking> bb = new ArrayList<Booking>();
			try {
				if(DLLogin.icid == 0) {
					
					//making query
					String query = "SELECT * FROM BOOKING b JOIN CORPORATECUSTOMER c ON b.CCustomer_ID = c.CCustomer_ID AND c..CCustomer_ID = " + DLLogin.ccid + " ORDER BY Arrival_Date";
					Statement statement = this.connection.createStatement();
					ResultSet rs = statement.executeQuery(query);
					while(rs.next()) {
						
						//creating and initializing new variable
						Booking book = new Booking();
						book.setBookingId(rs.getInt("Booking_Id"));
						book.setBookingDate(rs.getString("Booking_Date"));
						book.setRoomType(rs.getString("Room_Type"));
						book.setArrivalDate(rs.getString("Arrival_Date"));
						book.setDepartureDate(rs.getString("Departure_Date"));
						book.setBookingVerified(rs.getString("Booking_Verified"));
						book.setBookingStatus(rs.getString("Booking_Status"));
						
						//adding data to the arraylist
						bb.add(book);
										}
					}
				else {
					
					//making query
					String query = "SELECT * FROM BOOKING b, INDIVIDUALCUSTOMER i WHERE b.iCustomer_ID = i.iCustomer_Id AND i.icustomer_id = " + DLLogin.icid + " ORDER BY Arrival_Date";
					Statement statement = this.connection.createStatement();
					ResultSet rs = statement.executeQuery(query);
					while(rs.next()) {
						
						//creating and initializing new variable
						Booking book = new Booking();
						book.setBookingId(rs.getInt("Booking_Id"));
						book.setBookingDate(rs.getString("Booking_Date"));
						book.setRoomType(rs.getString("Room_Type"));
						book.setArrivalDate(rs.getString("Arrival_Date"));
						book.setDepartureDate(rs.getString("Departure_Date"));
						book.setBookingVerified(rs.getString("Booking_Verified"));
						book.setBookingStatus(rs.getString("Booking_Status"));
						
						//adding data to the arraylist
						bb.add(book);
					}
								}
				return bb;				
			}catch (SQLException ex) {
				throw ex;
			}
		}

		//method to view all bookings
		public ArrayList<Booking> viewPendingBooking() throws Exception{
			try {
				ArrayList<Booking> bb = new ArrayList<Booking>();
				
				//making query for view booking
				String query = "SELECT * FROM BOOKING WHERE Booking_Status = 'Pending'";
				Statement statement = this.connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()) {
					
					//creating and initializing new variable
					Booking book = new Booking();
					book.setBookingId(rs.getInt("Booking_Id"));
					book.setBookingDate(rs.getString("Booking_Date"));
					book.setRoomType(rs.getString("Room_Type"));
					book.setArrivalDate(rs.getString("Arrival_Date"));
					book.setDepartureDate(rs.getString("Departure_Date"));
					book.setBookingVerified(rs.getString("Booking_Verified"));
					book.setBookingStatus(rs.getString("Booking_Status"));
					bb.add(book);
				}
				
				//adding data to the arraylist
				return bb;
			}catch(Exception ex) {
				throw ex;
			}
		}
		

		//method to view all bookings
		public ArrayList<Booking> viewAllBooking() throws Exception{
			try {
				ArrayList<Booking> bb = new ArrayList<Booking>();
				
				//making query for view booking
				String query = "SELECT * FROM BOOKING";
				Statement statement = this.connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()) {
					
					//creating and initializing new variable
					Booking book = new Booking();
					book.setBookingId(rs.getInt("Booking_Id"));
					book.setBookingDate(rs.getString("Booking_Date"));
					book.setRoomType(rs.getString("Room_Type"));
					book.setArrivalDate(rs.getString("Arrival_Date"));
					book.setDepartureDate(rs.getString("Departure_Date"));
					book.setBookingVerified(rs.getString("Booking_Verified"));
					book.setBookingStatus(rs.getString("Booking_Status"));
					bb.add(book);
				}
				
				//adding data to the arraylist
				return bb;
			}catch(Exception ex) {
				throw ex;
			}
		}
}