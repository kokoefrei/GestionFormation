package controller;

import java.util.Scanner;

import model.Store;
import model.StoreFactory;
import view.ChangeStoreView;
import view.StoreMenuView;

public class ChangeStoreController implements ControllerInterface {
	
	
	private Store model;
	private ChangeStoreView view;
	
	
	public ChangeStoreController(Store model, ChangeStoreView view){
		
		this.model = model;
		this.view = view;
			
	}
	
	public void updateView(){
		
		view.printStoresDetails();
		
		
		while (true){
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			
			
			if (choice.equalsIgnoreCase("1")){
				StoreFactory storeFactory = new StoreFactory();

				model.flushCommand();
				
				StoreMenuController storeMenuController = new StoreMenuController(storeFactory.createStore("England", model.getCommand(), model.getProducts()), new StoreMenuView());
				storeMenuController.updateView();
			}
			else if (choice.equalsIgnoreCase("2")){
				StoreFactory storeFactory = new StoreFactory();
				
				model.flushCommand();
				
				StoreMenuController storeMenuController = new StoreMenuController(storeFactory.createStore("France", model.getCommand(), model.getProducts()), new StoreMenuView());
				storeMenuController.updateView();
			}
			else if (choice.equalsIgnoreCase("3")){
				StoreFactory storeFactory = new StoreFactory();
				
				model.flushCommand();
				
				StoreMenuController storeMenuController = new StoreMenuController(storeFactory.createStore("Cameroon", model.getCommand(), model.getProducts()), new StoreMenuView());
				storeMenuController.updateView();
			}
			
		}
		
	}
	
}
