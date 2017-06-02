package view;

public class LoginView extends AbstractView{
	
	public LoginView(){}
	
	
	public void printLoginDetails(){
		System.out.println("\t---->Please login to complete your command");
		System.out.println("\t---->Type A to create a new account");
		System.out.println("\t---->Enter your username and password: ");
		
	}
	
	public void printLoginDetailsError(){
		System.out.println("\t---->WARNING: Your credentials do not match, please retype them (Type Q to Quit): ");
	}

	
	
	
}
