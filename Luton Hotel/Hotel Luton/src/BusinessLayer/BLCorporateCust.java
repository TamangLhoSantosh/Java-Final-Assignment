package BusinessLayer;

import java.util.ArrayList;

import DatabaseLayer.DLCorporateCust;
import Helper.InputException;
import Models.CorporateCustomer;

public class BLCorporateCust {

	//declaring corporatecust  variable of corporate customer  type
	CorporateCustomer corporateCust;
	
	public BLCorporateCust() {
		this.corporateCust = new CorporateCustomer();
	}

	public CorporateCustomer getCorporateCust() {
		return corporateCust;
	}

	public void setCorporateCust(CorporateCustomer corporateCust) throws InputException{
		try{
			if(this.validateCorporateCust(corporateCust)) {
			this.corporateCust = corporateCust;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}
	
	//validates the corporate customer details
	private boolean validateCorporateCust(CorporateCustomer corporateCust) throws InputException {
		if(corporateCust.getRegistrationNo() == 0) {
			throw new InputException("Company registration no cannot be empty.");
		}
		if(corporateCust.getCompanyName() == null || corporateCust.getCompanyName().length() == 0) {
			throw new InputException("Company name cannot be empty.");
		}
		if(corporateCust.getContact() == null || corporateCust.getContact().length() == 0) {
			throw new InputException("Company contact cannot be empty.");
		}
		if(corporateCust.getAddress() == null || corporateCust.getAddress().length() == 0) {
			throw new InputException("Company address cannot be empty.");
		}
		if(corporateCust.getDiscountDiscussed() == 0) {
			throw new InputException("Company discount discussed cannot be empty.");
		}
		
		return true;
	}
	
	//saves the corporate customer details in the database
	public CorporateCustomer register() throws Exception{
		try {
			DLCorporateCust dlCorporrateCust = new DLCorporateCust(this.corporateCust);
			return dlCorporrateCust.register();
		}catch (Exception e) {
			throw e;
		}
	}
	
	//deletes the corporate customer details from the database
	public void delete() throws Exception{
		try {
			DLCorporateCust dlCorporrateCust = new DLCorporateCust(this.corporateCust);
			dlCorporrateCust.delete();
		}catch(Exception e){
			throw e;
		}
	}
	
	//updates the detail of the corporate customer  in the database
	public CorporateCustomer update() throws Exception{
		try {
			DLCorporateCust dlCorporrateCust = new DLCorporateCust(this.corporateCust);
					return dlCorporrateCust.update();
		}catch(Exception e){
			throw e;
		}
	}
	
	//shows all the corporate customer registered in the hotel
	public ArrayList<CorporateCustomer> viewAllCC() throws Exception {
		try {
			DLCorporateCust dlCorporrateCust = new DLCorporateCust();
			return dlCorporrateCust.viewAllCC();
		}catch(Exception e) {
			throw e;
		}
	}
	
	//searches the specific corporate customer
	public ArrayList<CorporateCustomer> searchCorporateCust(String[] keys, String[] values) throws Exception{
		try {
			DLCorporateCust dlCorporrateCust = new DLCorporateCust();
			return dlCorporrateCust.searchCorporateCust(keys, values);
		}catch(Exception e) {
			throw e;
		}
	}
	
}

