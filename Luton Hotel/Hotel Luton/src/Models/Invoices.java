package Models;

public class Invoices {

	//declaring variables
	private int invoiceId;
	private String issuedDate;
	private String description;
	private double amount;
	private String paymentStatus;
	
	public Invoices() {
		this.invoiceId = 0;
		this.issuedDate = "";
		this.description = "";
		this.amount = 0;
		this.paymentStatus = "";
	}
	
	public Invoices(int invoiceId, String issuedDate, String description, double amount, String paymentStatus) {
		this.invoiceId = invoiceId;
		this.issuedDate = issuedDate;
		this.description = description;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
