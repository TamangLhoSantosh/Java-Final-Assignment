package DatabaseLayer;

import Models.Room;
import Helper.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public void delete() throws Exception {
		try {
			// create the statement
			String query = "DELETE FROM Room WHERE id=?";
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, room.getRoomNo());
			// execute the query
			statement.executeUpdate();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public ArrayList<Room> getAllUser() throws Exception {
		try {
			ArrayList<Room> users = new ArrayList<Room>();
			String query = "SELECT * FROM user ORDER BY name";
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Room u = new Room();
				u.setRoomNo(rs.getInt("id"));
				u.setFloorNo(rs.getInt("name"));
				u.setRate(rs.getInt("address"));
				users.add(u);
			}
			return users;
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
				Room u = new Room();
				u.setRoomNo(rs.getInt("id"));
				u.setFloorNo(rs.getInt("name"));
				u.setRate(rs.getInt("address"));
				rooms.add(u);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return rooms;		
	}
}
