package Models;

public class IndividualCustomer {

	private int customerId;
	private String fName;
	private String lName;
	private String dateOfBirth;
	private String contact;
	private String address;
	private int postalCode;
	private String creditCardNo;
	private String expDate;
	
	public IndividualCustomer() {
		this.customerId = 0;
		this.fName = "";
		this.lName = "";
		this.dateOfBirth = "";
		this.contact = "";
		this.address = "";
		this.postalCode = 0;
		this.creditCardNo = "";
		this.expDate = "";
	}
	
	public IndividualCustomer(int id, String fName, String lName, String dateOfBirth, String contact, String address, int postalCode, String creditCardNo, String expDate) {
		this.customerId = id;
		this.fName = fName;
		this.lName = lName;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.address = address;
		this.postalCode = postalCode;
		this.creditCardNo = creditCardNo;
		this.expDate = expDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
}