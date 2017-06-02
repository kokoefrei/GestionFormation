package controller;

import java.util.Scanner;

import model.Admin;
import model.Person;
import model.Store;
import view.AdminLoginView;
import view.AdminView;
import view.StoreMenuView;

public class AdminLoginController implements ControllerInterface {
	
	private Store model;
	private AdminLoginView view;
	
	private String username;
	private String password;
	
	
	public AdminLoginController(Store model, AdminLoginView view){
		this.model = model;
		this.view = view;
	}
	
	public void updateView(){
		view.printLogin();
		
		Scanner sc = new Scanner(System.in);
		username = sc.nextLine();
		if (username.equalsIgnoreCase("C")){
			StoreMenuView shopView = new StoreMenuView();
			StoreMenuController shopController = new StoreMenuController(model, shopView);
			shopController.updateView();
		}
		
		password = sc.nextLine();
		if (password.equalsIgnoreCase("C")){
			StoreMenuView shopView = new StoreMenuView();
			StoreMenuController shopController = new StoreMenuController(model, shopView);
			shopController.updateView();
		}
		
		// check if username & password are matching with any admin	
		boolean isValid = false;
		
		
		
		if (model.getListPerson() != null){
			for (Person p : model.getListPerson()){
				if(p instanceof Admin && ((Admin) p).checkLogin(username, password)){
					isValid = true;
					break;
				}
			}
		}
		
		
		if(isValid){
			// log OK
			AdminController adminController = new AdminController(model, new AdminView());
			adminController.updateView();
		}else{
			// log KO
			System.out.println("WARNING: NOT MATCHES. TRY AGAIN");
			this.updateView();	
		}
	}
	
	
	
	
}
