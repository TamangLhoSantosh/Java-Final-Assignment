package Models;

public class Room {

	//declaring variables
	private int roomNo;
	private int floorNo;
	private double rate;
	private String roomType;
	private String availability;
	
	public Room() {
		this.roomNo = 0;
		this.floorNo = 0;
		this.rate = 0;
		this.availability = "";
	}
	
	public Room(int roomNo, int floorNo, double rate, String availability) {
		this.roomNo = roomNo;
		this.floorNo =floorNo;
		this.rate = rate;
		this.availability = availability;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getRoomType() {
		return roomType;
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
}
