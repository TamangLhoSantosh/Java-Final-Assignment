package BusinessLayer;

import java.util.ArrayList;

import Models.IndividualCustomer;
import DatabaseLayer.DLIndividualCust;
import Helper.InputException;

public class BLIndividualCust {


	//declaring staff variable of staff type
	private IndividualCustomer iCust;
	
	public BLIndividualCust() {
		this.iCust = new IndividualCustomer();
	}

	public IndividualCustomer getIndividualCust() {
		return iCust;
	}

	public void setIndividualCust(IndividualCustomer iCust) throws InputException{
		try{
			if(this.validateIndividualCust(iCust)) {
			this.iCust = iCust;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}
	
	//validates the individual customer details
	private boolean validateIndividualCust(IndividualCustomer iCust) throws InputException {
		if(iCust.getfName() == null || iCust.getfName().length() == 0) {
			throw new InputException("User first name cannot be empty.");
		}
		if(iCust.getlName() == null || iCust.getlName().length() == 0) {
			throw new InputException("User last name cannot be empty.");
		}
		if(iCust.getDateOfBirth() == null || iCust.getDateOfBirth().length() == 0) {
			throw new InputException("User date of birth cannot be empty.");
		}
		if(iCust.getPostalCode() == 0) {
			throw new InputException("User postal code cannot be empty.");
		}
		if(iCust.getContact() == null || iCust.getContact().length() == 0) {
			throw new InputException("User contact cannot be empty.");
		}
		if(iCust.getAddress() == null || iCust.getAddress().length() == 0) {
			throw new InputException("User address cannot be empty.");
		}
		return true;
	}
	
	//saves the individual customer details in the database
	public IndividualCustomer save() throws Exception{
		try {
			DLIndividualCust dlICust = new DLIndividualCust(this.iCust);
			return dlICust.save();
		}catch (Exception e) {
			throw e;
		}
	}
	
	//deletes the individual customer details from the database
	public void delete() throws Exception{
		try {
			DLIndividualCust dlICust = new DLIndividualCust(this.iCust);
			dlICust.delete();
		}catch(Exception e){
			throw e;
		}
	}
	
	//updates the detail of the individual customer in the database
	public IndividualCustomer update() throws Exception{
		try {
			DLIndividualCust dlICust = new DLIndividualCust(this.iCust);
					return dlICust.update();
		}catch(Exception e){
			throw e;
		}
	}
	
	//shows all the individual customer registered
	public ArrayList<IndividualCustomer> getAllICust() throws Exception {
		try {
			DLIndividualCust dlICust = new DLIndividualCust(this.iCust);
			return dlICust.getAllIndividualCust();
		}catch(Exception e) {
			throw e;
		}
	}
	
	//searches the specific individual customer
	public ArrayList<IndividualCustomer> searchUser(String[] keys, String[] values) throws Exception{
		try {
			DLIndividualCust dlICust = new DLIndividualCust(this.iCust);
			return dlICust.searchIndividualCust(keys, values);
		}catch(Exception e) {
			throw e;
		}
	}
	
}