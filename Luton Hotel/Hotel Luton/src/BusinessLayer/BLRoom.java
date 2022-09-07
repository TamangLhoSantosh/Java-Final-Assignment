package BusinessLayer;
import Models.Room;

import java.util.ArrayList;

import DatabaseLayer.DLRoom;

public class BLRoom {
	Room room;
	
	public BLRoom() {
		this.room = new Room();
	}
	
	public Room getUser() {
		return room;
	}
	
	public Room update() throws Exception {
		// This function saves the user detail to database and returns the user object after saving
		try {
			DLRoom dlRoom = new DLRoom(this.room);
			return dlRoom.update();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Room> viewRoom() throws Exception{
		try {
			DLRoom dlr = new DLRoom();
			return dlr.viewRoom();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Room> viewAllRoom() throws Exception {
		try {
			DLRoom dlRoom = new DLRoom();
			return dlRoom.viewAllRoom();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Room> searchRoom(String[] keys, String[] values) throws Exception{
		try {
			DLRoom dlRoom = new DLRoom();
			return dlRoom.searchUser(keys, values);
		}catch(Exception e) {
			throw e;
		}
	}
}
