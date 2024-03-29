package BusinessLayer;


import DatabaseLayer.DLLogin;
import Helper.InputException;
import Models.Login;

public class BLLogin {

	//declaring variable
	private Login log;

	public BLLogin() {
		this.log = new Login();
	}

	public Login getLog() {
		return log;
	}

	//setting data
	public void setLog(Login log) throws Exception{
		try {
			if(this.ValidateLogin(log)) {
				this.log = log;
			}
		}catch (Exception ex) {
			throw ex;
		}	
	}
	
	/*
	 * provides true or false value
	 * validation during login
	 * the email and password cannot be empty.
	 */
	private boolean ValidateLogin(Login log) throws InputException {
		if(log.getEmail() == null || log.getEmail().length()==0){
			throw new InputException("Email cannot be empty.");
		}
		if(log.getPassword() == null || log.getPassword().length()==0){
			throw new InputException("Password cannot be empty.");
		}
//		if(!(log.getEmail().matches("^(.+)@(\\\\S+)$"))){
//			throw new InputException("Enter valid email");
//		}
		return true;
	}
	
	//connecting with database
	public Login login() throws Exception{
		try {
			
			//creating new object and initializing it
			DLLogin dlLogin = new DLLogin(this.log);
			return dlLogin.login();
		}catch (Exception e) {
			throw e;
		}
	}

	/*
	 * validates the data enterd during registration
	 */
	public void registerValidation(Login log, String conPass) throws InputException{
		if(log.getEmail() == null || log.getEmail().length()==0){
			throw new InputException("Email cannot be empty.");
		}
		if(log.getPassword() == null || log.getPassword().length()==0){
			throw new InputException("Password cannot be empty.");
		}
		if(conPass.equals(log.getPassword())){
		}
		else {
			throw new InputException("Password must be same.");
		}
		this.log = log;
	}

	/*
	 * creates a link with dl
	 * sends data to dl
	 */
	public Login register() throws Exception {
		try {
			DLLogin dlLogin = new DLLogin(this.log);
			return dlLogin.register();
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	
}