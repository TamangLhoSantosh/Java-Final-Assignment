package BusinessLayer;


import DatabaseLayer.DLLogin;
import Helper.InputException;
import Models.Login;

public class BLLogin {

	//declaring variable
	private Login log;

	public BLLogin() {
	}

	public Login getLog() {
		return log;
	}

	public void setLog(Login log) throws Exception{
		try {
			if(this.ValidateLogin(log)) {
				this.log = log;
			}
		}catch (Exception ex) {
			throw ex;
		}	
	}
	
	public boolean ValidateLogin(Login log) throws InputException {
		if(log.getEmail() == null || log.getEmail().length()==0){
			throw new InputException("Email cannot be empty.");
		}
		if(log.getPassword() == null || log.getPassword().length()==0){
			throw new InputException("Password cannot be empty.");
		}
		return true;
	}
	
	public Login login(Login log) throws Exception{
		try {
			DLLogin dlLogin = new DLLogin(log);
			return dlLogin.login(log);
		}catch (Exception e) {
			throw e;
		}
	}
	
	
}