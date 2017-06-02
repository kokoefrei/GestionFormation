package controller;

import java.util.Scanner;

import model.Product;
import model.Store;
import view.AdminView;
import view.CommandView;
import view.EditProductAdminView;

public class EditProductAdminController {
	
	private Store model;
	private EditProductAdminView view;
	
	private Product product;
	private Integer productQuantity;
	
	public EditProductAdminController(Store model,  EditProductAdminView view, Product product, Integer productQuantity){
		
		this.model = model;
		this.view = view;
		
		this.product = product;
		this.productQuantity = productQuantity;
		

	}
	
	public void updateView(){
		
		view.setQuantity(this.productQuantity);
		view.printEditProduct();
		
		while (true){
			
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			
			if (choice.equals("+")){
				model.addProduct(product);
				this.productQuantity++;
				
				this.updateView();
			}
			else if (choice.equals("-")){
				
				if(model.removeProduct(product)){
					if (this.productQuantity > 0)
						this.productQuantity--;
				}

				this.updateView();
			}
			else if (choice.equalsIgnoreCase("Q")){		
				AdminController adminController = new AdminController(model, new AdminView());
				adminController.updateView();
			}
			
			
			
		}
		
		
	}
	
	
	
	
}
