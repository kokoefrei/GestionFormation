package controller;

import java.util.Scanner;

import model.Store;
import view.AdminLoginView;
import view.AdminView;
import view.CommandView;
import view.ChangeStoreView;
import view.FooterView;
import view.HeaderView;
import view.ProductsView;
import view.SearchView;
import view.StoreMenuView;

public class StoreMenuController implements ControllerInterface {
	
	private Store model;
	private StoreMenuView view;
	
	private HeaderView headerView;
	private FooterView footerView;
	
	
	
	public StoreMenuController(Store model, StoreMenuView view){
		
		this.model = model;
		this.view = view;

		headerView = HeaderView.getInstance();
		footerView = FooterView.getInstance();	
		
	}
	
	
	public void updateView(){
		headerView.printHeader();
		view.printMenu(model.getName());
		footerView.printFooter();
		
		while(true){
			Scanner sc = new Scanner(System.in);
			String choice = "";
			

			choice = sc.nextLine();
			
			if (choice.equalsIgnoreCase("C")){
				CommandController commandController = new CommandController(model, new CommandView(model.getCommand().getListProducts()));
				commandController.updateView();
			} 
			else if (choice.equals("B")){
				ProductsController productController = new ProductsController(model, new ProductsView());
				productController.updateView();
			} 
			else if (choice.equals("S")){
				SearchController searchController = new SearchController(model, new SearchView());
				searchController.updateView();
			}
			else if (choice.equalsIgnoreCase("A")){
				AdminLoginController adminLoginController = new AdminLoginController(model, new AdminLoginView());
				adminLoginController.updateView();
			}
			else if (choice.equalsIgnoreCase("G")){
				ChangeStoreController changeController = new ChangeStoreController(model, new ChangeStoreView());
				changeController.updateView();
			}
			sc.close();
		}
		
		
		
		
	}
	
	
	
	
}
