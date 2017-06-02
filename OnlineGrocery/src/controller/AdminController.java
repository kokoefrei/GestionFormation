package controller;

import java.util.Scanner;

import model.Product;
import model.Store;
import view.AdminView;
import view.EditProductAdminView;
import view.EditProductCommandView;
import view.LoginView;
import view.StoreMenuView;

public class AdminController {
	
	private Store model;
	private AdminView view;
	
	
	public AdminController(Store model, AdminView view){
		this.model = model;
		this.view = view;
	}
	
	public void updateView(){
		
		view.printAdminMenu(model.getAvailableProducts());
		
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();

		if (choice.equalsIgnoreCase("L")){
			StoreMenuView storeView = new StoreMenuView();
			StoreMenuController storeController = new StoreMenuController(model, storeView);
			storeController.updateView();
		}
		
		int index = Integer.parseInt(choice) - 1;
		
		
		Object productName = model.getAvailableProducts().keySet().toArray()[index];
		
		
		if (productName != null ){
			for (Product p : model.getProducts()){
				if (p.getName().equals(productName)){
					
					Integer productQuantity = model.getAvailableProducts().get(p.getName());
					EditProductAdminController editProductController = new EditProductAdminController(this.model, new EditProductAdminView(p.getName(), productQuantity), p, productQuantity);
					editProductController.updateView();
					
				}
			}
		}
		
		
	}
	
	
	
	
	
}
