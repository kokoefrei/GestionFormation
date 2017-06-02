package controller;

import java.util.Scanner;

import model.Person;
import model.Store;
import model.User;
import view.CommandView;
import view.CreateAccountView;
import view.FooterView;
import view.HeaderView;
import view.LoginView;
import view.StoreMenuView;

public class LoginController implements ControllerInterface {
	
	private Store model;
	private LoginView view;
	
	
	String username;
	String password;
	
	public LoginController(Store model, LoginView view){
		
		this.model = model;
		this.view = view;
		
		/*HeaderView header = HeaderView.getInstance();
		FooterView footer = FooterView.getInstance();*/
		
		
		
	}
	
	
	public void updateView(){
		
		view.printLoginDetails();
		
		Scanner sc = new Scanner(System.in);
		username = sc.nextLine();
		if (username.equalsIgnoreCase("A")){
			CreateAccountController createController = new CreateAccountController(model, new CreateAccountView());
			createController.updateView();
		}
		password = sc.nextLine();
		if (password.equalsIgnoreCase("A")){
			CreateAccountController createController = new CreateAccountController(model, new CreateAccountView());
			createController.updateView();
		}
		
		// check if username & password are OK	
		boolean isValid = false;
		
		if (model.getListPerson() != null){
			for (Person p : model.getListPerson()){
				if(p instanceof User && ((User) p).checkLogin(username, password)){
					isValid = true;
					break;
				}
			}
		}
		
		
		if(isValid){
			// log OK
			System.out.println("\t\t****************\n COMMAND SUCCESSFULY COMPLETE, THANK YOU \n\t\t*********************");
			model.buyCommand();
		
			StoreMenuController menuController = new StoreMenuController(model, new StoreMenuView());
			menuController.updateView();
			
		}else{
			// log KO
			updateViewLoginError();
			
		}
		
		sc.close();
			
	}
	
	private void updateViewLoginError(){
		
		boolean isValid = false;
		
		
		while(!isValid){
			view.printLoginDetailsError();
			
			if (model.getListPerson() != null){
				for (Person p : model.getListPerson()){
					if(p instanceof User && ((User) p).checkLogin(username, password)){
						isValid = true;
						break;
					}
				}
			}
			
			Scanner sc = new Scanner(System.in);
			username = sc.nextLine();
			
			if (username.equalsIgnoreCase("Q")){
				break;
			}
				
			password = sc.nextLine();
			if (password.equalsIgnoreCase("Q")){
				break;
			}
				
			//sc.close();
			
		}
		
		CommandView commandView = new CommandView(model.getCommand().getListProducts());
		CommandController commandController = new CommandController(model, commandView);
		commandController.updateView();
		
	}
	
	

	
	
	
	
}
