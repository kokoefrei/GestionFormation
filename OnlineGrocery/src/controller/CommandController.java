package controller;

import java.util.Scanner;

import model.Product;
import model.Store;
import view.CommandView;
import view.EditProductCommandView;
import view.FooterView;
import view.HeaderView;
import view.LoginView;
import view.StoreMenuView;

public class CommandController implements ControllerInterface {

	private Store model;
	private CommandView view;


	public CommandController(Store model, CommandView view){
		this.model = model;
		this.view = view;

	}


	public void updateView(){

		view.printCommandDetails();


		while (true){
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();


			if (choice.equalsIgnoreCase("C")){
				LoginView loginView = new LoginView();
				LoginController loginController = new LoginController(model, loginView);
				loginController.updateView();
			}
			else if (choice.equalsIgnoreCase("B")){
				StoreMenuView shopView = new StoreMenuView();
				StoreMenuController shopController = new StoreMenuController(model, shopView);
				shopController.updateView();
			}
			else if (choice.matches("^[0-9]*$")){
				if(model.getCommand().getListProducts().isEmpty()){
					System.out.println("EMPTY LIST");
					view.printCommandDetails();
				}
				else{
					int index = Integer.parseInt(choice) - 1;

					Object productName = model.getCommand().getListProducts().keySet().toArray()[index];

					int arraySize = model.getAvailableProducts().size();

					if (productName != null ){
						for (Product p : model.getProducts()){
							if (p.getName().equals(productName)){

								Integer productQuantity = model.getCommand().getListProducts().get(p.getName());
								EditProductCommandView viewEdit = new EditProductCommandView();					
								EditProductCommandController editController = new EditProductCommandController(this.model, new EditProductCommandView(), p, productQuantity);

								editController.updateView();

							}
						}
					}
				}
			}
		}
		
	}




}
