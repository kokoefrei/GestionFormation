package controller;

import java.util.Scanner;

import org.hamcrest.core.IsNull;

import model.Product;
import model.Store;
import view.EditProductCommandView;
import view.SearchView;
import view.StoreMenuView;

public class SearchController implements ControllerInterface {

	
	private Store model;
	private SearchView view;
	
	
	public SearchController(Store model, SearchView view){
		
		this.model = model;
		this.view = view;
			
	}
	
	@Override
	public void updateView() {
		
		view.printSearch();
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		sc.close();
		
		if (choice.equals("Q")){

			StoreMenuView shopView = new StoreMenuView();
			StoreMenuController shopController = new StoreMenuController(model, shopView);
			shopController.updateView();
		}else{
			
			String productName = choice;
			
			for (Product p : model.getProducts()){
				Integer productQuantity;
				if (p.getName().equalsIgnoreCase(productName)){
					if(model.getCommand().getListProducts().get(p.getName())==null ){
						productQuantity = 0;
					}
					else{
						productQuantity = model.getCommand().getListProducts().get(p.getName());
					}
					
					EditProductCommandView viewEdit = new EditProductCommandView();					
					EditProductCommandController editController = new EditProductCommandController(this.model, viewEdit, p, productQuantity);
					
					editController.updateView();
					
				}
			}
			
		}
		
		
		
		
		
		
	}

}
