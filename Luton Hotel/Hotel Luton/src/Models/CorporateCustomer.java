package Models;

public class CorporateCustomer {
	private int customerId;
	private int registrationNo;
	private String companyName;
	private String contact;
	private String address;
	private int discountDiscussed;
	
	
	public CorporateCustomer() {
		this.customerId = 0;
		this.contact = "";
		this.address = "";
		this.discountDiscussed = 0;
	}
	
	public CorporateCustomer(int id, int registrationNo, String companyName, String contact, String address, int discussedDiscount) {
		this.customerId = id;
		this.registrationNo = registrationNo;
		this.companyName = companyName;
		this.contact = contact;
		this.address = address;
		this.discountDiscussed = discussedDiscount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public int getDiscountDiscussed() {
		return discountDiscussed;
	}

	public void setDiscountDiscussed(int discountDiscussed) {
		this.discountDiscussed = discountDiscussed;
	}

}
