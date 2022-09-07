package DatabaseLayer;

import Models.Room;
import Helper.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import FrontendLayer.StaffHome;

public class DLRoom {
	private Room room;
	private DatabaseConnector db;
	private Connection connection;
	
	
	public DLRoom() throws Exception {
		this.room = new Room();
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public DLRoom(Room room) throws Exception {
		this.room = room;
		try {
			this.db = DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Room update() throws Exception {
		try {
			// create the statement
			String query = "UPDATE Room  SET name=? , address=? WHERE id=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, this.room.getFloorNo());
			statement.setInt(3, room.getRoomNo());
			// execute the query
			statement.executeUpdate();
			return this.room;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Room> viewRoom() throws Exception{
		try {
			ArrayList<Room> rooms = new ArrayList<Room>();
			String query = "SELECT * FROM room WHERE ROOM_TYPE = " + StaffHome.rType + "ORDER BY Room_No";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Room r = new Room();
				r.setRoomNo(rs.getInt("Room_no"));
				r.setFloorNo(rs.getInt("Floor_no"));
				r.setRate(rs.getInt("Rate"));
				r.setRoomType(rs.getString("Room_type"));
				rooms.add(r);
			}
			return rooms;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Room> viewAllRoom() throws Exception {
		try {
			ArrayList<Room> rooms = new ArrayList<Room>();
			String query = "SELECT * FROM room ORDER BY Room_No";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Room r = new Room();
				r.setRoomNo(rs.getInt("id"));
				r.setFloorNo(rs.getInt("name"));
				r.setRate(rs.getInt("address"));
				rooms.add(r);
			}
			return rooms;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Room> searchUser(String[] keys, String[] values) throws Exception{
		// SELECT * FROM user WHERE name LIKE '%Hari%' AND address LIKE '%PCPS%' ;
		ArrayList<Room> rooms = new ArrayList<Room>();
		try {
			int keyLength = keys.length;
			String where = "";
			for(int i=0; i<keyLength; ++i) {
				if(i==0) {
					where = where+" WHERE "+ keys[i]+" LIKE '%"+values[i]+"%' ";
				}else {
					where = where+" AND "+ keys[i]+" LIKE '%"+values[i]+"%' ";
				}
			}
			String query = "SELECT * FROM Room"+where+" ORDER BY name";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Room r = new Room();
				r.setRoomNo(rs.getInt("id"));
				r.setFloorNo(rs.getInt("name"));
				r.setRate(rs.getInt("address"));
				rooms.add(r);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return rooms;		
	}
}
