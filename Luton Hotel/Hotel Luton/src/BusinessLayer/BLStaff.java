package BusinessLayer;

//importing different utilities packages
import Models.Staff;
import java.util.ArrayList;
import DatabaseLayer.DLStaff;
import Helper.InputException;

public class BLStaff {

	//declaring staff variable of staff type
	Staff staff;
	
	public BLStaff() {
		this.staff = new Staff();
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) throws InputException{
		try{
			if(this.validateStaff(staff)) {
			this.staff = staff;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}
	
	//validates the staff details
	private boolean validateStaff(Staff staff) throws InputException {
		if(staff.getfName() == null || staff.getfName().length() == 0) {
			throw new InputException("User first name cannot be empty.");
		}
		if(staff.getlName() == null || staff.getlName().length() == 0) {
			throw new InputException("User last name cannot be empty.");
		}
		if(staff.getDateOfBirth() == null || staff.getDateOfBirth().length() == 0) {
			throw new InputException("User date of birth cannot be empty.");
		}
		if(staff.getContact() == null || staff.getContact().length() == 0) {
			throw new InputException("User contact cannot be empty.");
		}
		if(staff.getAddress() == null || staff.getAddress().length() == 0) {
			throw new InputException("User address cannot be empty.");
		}
		if(staff.getDesignation() == null || staff.getDesignation().length() == 0) {
			throw new InputException("User designation cannot be empty.");
		}
		return true;
	}
	
	//saves the staff details in the database
	public Staff save() throws Exception{
		try {
			DLStaff dlStaff = new DLStaff(this.staff);
			return dlStaff.save();
		}catch (Exception e) {
			throw e;
		}
	}
	
	//deletes the staff details from the database
	public void delete() throws Exception{
		try {
			DLStaff dlStaff = new DLStaff(this.staff);
			dlStaff.delete();
		}catch(Exception e){
			throw e;
		}
	}
	
	//updates the detail of the staff in the database
	public Staff update() throws Exception{
		try {
			DLStaff dlStaff = new DLStaff(this.staff);
					return dlStaff.update();
		}catch(Exception e){
			throw e;
		}
	}
	
	//shows all the staff working in the hotel
	public ArrayList<Staff> getAllStaff() throws Exception {
		try {
			DLStaff dlStaff = new DLStaff(this.staff);
			return dlStaff.getAllStaff();
		}catch(Exception e) {
			throw e;
		}
	}
	
	//searches the specific staff
	public ArrayList<Staff> searchUser(String[] keys, String[] values) throws Exception{
		try {
			DLStaff dlStaff = new DLStaff(this.staff);
			return dlStaff.searchStaff(keys, values);
		}catch(Exception e) {
			throw e;
		}
	}
	
}