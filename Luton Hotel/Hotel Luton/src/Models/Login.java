package Models;

public class Login {

	//declaring variables
	private int userId;
	private String email;
	private String password;
	
	public Login() {
		this.userId = 0;
		this.email = "";
		this.password = "";
	}
	
	public Login(int id, String email, String password) {
		this.userId = id;
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}