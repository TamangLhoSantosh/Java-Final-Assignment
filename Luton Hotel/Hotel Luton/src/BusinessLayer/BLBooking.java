package BusinessLayer;

import java.util.ArrayList;

import DatabaseLayer.DLBooking;
import Helper.InputException;
import Models.Booking;

public class BLBooking {

	//declaring variable
	private Booking book;

	public BLBooking() {
		this.book = new Booking();
	}

	public Booking getLog() {
		return book;
	}

	//setting data
	public void setBook(Booking book) throws Exception{
		try {
			if(this.ValidateBooking(book)) {
				this.book = book;
			}
		}catch (Exception ex) {
			throw ex;
		}	
	}
	
	/*
	 * provides true or false value
	 * validation during booking
	 * room type, arrival and departure date is validated
	 */
	private boolean ValidateBooking(Booking book) throws InputException {
		if(book.getArrivalDate() == null || book.getArrivalDate().length() == 0){
			throw new InputException("Arrival date cannot be empty.");
		}
		if(book.getDepartureDate() == null || book.getDepartureDate().length() == 0){
			throw new InputException("Departure date cannot be empty.");
		}
		if(book.getRoomType() == null || book.getRoomType().length() == 0) {
			throw new InputException("Room type cannot be empty.");
		}
		return true;
	}
	
	//connecting with database
	public Booking book() throws Exception{
		try {
			
			//creating new object and initializing it
			DLBooking dlBook = new DLBooking(this.book);
			return dlBook.book();
		}catch (Exception e) {
			throw e;
		}
	}
	
	//connection with database
	public void cancel() throws Exception{
		try {
			
			//connecting database
			DLBooking dlb = new DLBooking(this.book);
			dlb.cancel();
		}catch (Exception e) {
			throw e;
		}
	}
	
	//connecting with databasae
	public ArrayList<Booking> viewBooking() throws Exception {
		try {
			DLBooking book = new DLBooking();
			return book.viewBooking();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	//connectiong database
	public ArrayList<Booking> viewAllBooking() throws Exception{
		try {
			DLBooking book = new DLBooking();
			return book.viewAllBooking();
			
		}catch(Exception ex) {
			throw ex;
		}
	}
	
}