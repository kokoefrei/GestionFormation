package view;

public class EditProductCommandView extends AbstractView {
	
	public EditProductCommandView(){
		
	}
	
	
	public void printEditCommand(String productName, Integer quantity){
		
		System.out.println("Product: " + productName + " : " + quantity);
		System.out.println("Type '+' or '-' to add or remove this product to/from your command:");
	}
	
	
	
	
	
}
