package Models;

public class AllModel {
	private int bookingId;
	private String arrivalDate;
	private String departureDate;
	private int roomNo;
	private String roomType;
	private int rate;
	private String bookingStatus;
	private int icustomerId;
	private int ccustomerId;
	private String name;
	private String compname;
	private int staffId;
	private int nightStayed;
	private int total;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public int getIcustomerId() {
		return icustomerId;
	}
	public void setIcustomerId(int icustomerId) {
		this.icustomerId = icustomerId;
	}
	public int getCcustomerId() {
		return ccustomerId;
	}
	public void setCcustomerId(int ccustomerId) {
		this.ccustomerId = ccustomerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompname() {
		return compname;
	}
	public void setCompname(String compname) {
		this.compname = compname;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getNightStayed() {
		return nightStayed;
	}
	public void setNightStayed(int nightStayed) {
		this.nightStayed = nightStayed;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}