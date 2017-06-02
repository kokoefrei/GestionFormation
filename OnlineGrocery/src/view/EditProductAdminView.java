package view;

public class EditProductAdminView extends AbstractView {
	
	private String productName;
	private Integer quantity;
	
	public EditProductAdminView(String productName, Integer quantity){
		this.productName = productName;
		this.quantity = quantity;
	}
	
	public void printEditProduct(){
		
		System.out.println("Product: " + productName + " : " + quantity);
		System.out.println("Type '+' or '-' to add or remove this product from your cart:");
		System.out.println("Q to quit");
		
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
