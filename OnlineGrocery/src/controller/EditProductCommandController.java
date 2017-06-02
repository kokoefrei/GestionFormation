package controller;

import java.util.Scanner;

import model.Product;
import model.Store;
import view.CommandView;
import view.EditProductCommandView;
import view.FooterView;

public class EditProductCommandController implements ControllerInterface {
	
	private Store model;
	private EditProductCommandView view;
	private Product product;
	private Integer productQuantity;
	
	private FooterView footer;
	
	public EditProductCommandController(Store model,  EditProductCommandView view, Product product, Integer productQuantity){
		
		this.model = model;
		this.view = view;
		this.footer = FooterView.getInstance();
		
		this.product = product;
		this.productQuantity = productQuantity;
		

	}
	
	
	public void updateView(){
		
		view.printEditCommand(product.getName(), productQuantity);
		footer.printFooter();
		
		
		while (true){
			
			Scanner sc = new Scanner(System.in);
			String choice = "";
			
			if (sc.hasNext())
				choice = sc.nextLine();
			
			if (choice.equals("+")){
				if(model.removeProduct(product)){
					model.getCommand().addProduct(product);
					this.productQuantity++;
				}				
				
				this.updateView();
			}
			else if (choice.equals("-")){
				
				
				if (this.productQuantity > 0){
					model.removeProductCommand(product);	
					this.productQuantity--;
				}
					
				
				this.updateView();
			}
			else if (choice.equalsIgnoreCase("C")){		
				CommandController commandController = new CommandController(model, new CommandView(model.getCommand().getListProducts()));
				commandController.updateView();	
			}			
			sc.close();
		}
		
		
	}
	
	
	
	
	
}
