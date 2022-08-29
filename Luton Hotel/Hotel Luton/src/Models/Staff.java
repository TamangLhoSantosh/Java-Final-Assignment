package Models;

public class Staff {
	
	//declaring variables
	private int staffId;
	private String fName;
	private String lName;
	private String dateOfBirth;
	private String contact;
	private String address;
	private String designation;


	public Staff() {
		this.staffId = 0;
		this.fName = "";
		this.lName = "";
		this.dateOfBirth = "";
		this.contact = "";
		this.address = "";
		this.designation = "";
	}

	public Staff(int id, String fName, String lName, String dateOfBirth, String contact, String address, String designation) {
		this.staffId = id;
		this.fName = fName;
		this.lName = lName;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.address = address;
		this.designation = designation;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
