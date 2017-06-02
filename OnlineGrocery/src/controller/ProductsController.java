package controller;

import java.util.Scanner;

import model.Product;
import model.Store;
import view.ProductsView;
import view.StoreMenuView;

public class ProductsController implements ControllerInterface {

	
	private Store model;
	private ProductsView view;
	

	
	public ProductsController(Store model, ProductsView view){
		
		this.model = model;
		this.view = view;
		
		
		
	}
	
	@Override
	public void updateView() {
		
		view.printProducts(model.getAvailableProducts());
		
		while(true){
			Scanner sc = new Scanner(System.in);
			String choice = "";

			choice = sc.nextLine();
			
			if (choice.equalsIgnoreCase("B")){
				StoreMenuView shopView = new StoreMenuView();
				StoreMenuController shopController = new StoreMenuController(model, shopView);
				shopController.updateView();
			}else if (choice.matches("^-?\\d+$")){
				
				// -1 because index starts at 0
				int index = Integer.parseInt(choice) - 1;
				
				Object productName = model.getAvailableProducts().keySet().toArray()[index];
				
				int arraySize = model.getAvailableProducts().size();
				
				if (productName != null && index < arraySize && index >= 0){
					for (Product p : model.getProducts()){
						if (p.getName().equals(productName)){
							
							if(model.removeProduct(p))
								model.getCommand().addProduct(p);
							
							this.updateView();	
						}
					}
				}
				
				
			}
				

			
			
		
			
			
		}
		
		
		
	}

}
