package controller;

import java.util.Scanner;

import model.Login;
import model.Person;
import model.PersonFactory;
import model.Store;
import view.CommandView;
import view.CreateAccountView;

public class CreateAccountController implements ControllerInterface {

	
	private Store model;
	private CreateAccountView view;
	
	public CreateAccountController(Store model, CreateAccountView view){
		this.model = model;
		this.view = view;
	}
	
	
	public void updateView() {
		
		view.printCreateAccount();
		
		Scanner sc = new Scanner(System.in);
		
		String email = sc.nextLine();
		String username = sc.nextLine();
		String password = sc.nextLine();
		
		
		PersonFactory personFactory = new PersonFactory();
		Person newUser = personFactory.createPerson("user", email, new Login(username, password));
		model.addPerson(newUser);
		
		CommandController cartController = new CommandController(model, new CommandView(model.getCommand().getListProducts()));
		cartController.updateView();
		
		
		
		
	}

}
