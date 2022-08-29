package Models;

public class Booking {

	//declaring variables
	private int bookingId;
	private String bookingDate;
	private String roomType;
	private String arrivalDate;
	private String departureDate;
	private String bookingVerified;
	private String bookingStatus;
	private String paymentMethod;

	public Booking() {
		this.bookingId = 0;
		this.bookingDate = "";
		this.roomType = "";
		this.arrivalDate = "";
		this.departureDate = "";
		this.bookingVerified = "";
		this.bookingStatus = "";
		this.paymentMethod = "";
	}
	

	public Booking(int bookingId, String bookingDate, String roomType, String arrivalDate, String departureDate, String bookingVerified, String bookingStatus, String paymentMethod) {
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.roomType = roomType;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.bookingVerified = bookingVerified;
		this.bookingStatus = bookingStatus;
		this.paymentMethod = paymentMethod;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
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
	public String getBookingVerified() {
		return bookingVerified;
	}
	public void setBookingVerified(String bookingVerified) {
		this.bookingVerified = bookingVerified;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}
