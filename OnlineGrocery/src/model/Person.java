package model;

public abstract class Person implements Model {
	
	protected String email;
	protected Login login;
	
	public Person(String email, Login login){
		this.email = email;
		this.login = login;
	}
	
	public boolean checkLogin(String username, String password){
		
		boolean isValid = false;;
		
		if (username.equals(login.getUserName()) && password.equals(login.getPassword())){
			isValid = true;
		}
		
		return isValid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
}
