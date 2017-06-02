package view;

public class StoreMenuView extends AbstractView{
	
	
	public StoreMenuView() {
		
	}
	
	public void printMenu(String storeName){
		
		
		
		System.out.println("\t\t\t WELCOME TO " + storeName.toUpperCase());
		System.out.println("\t\t CHOOSE AN ACTION BY TYPING THE LETTER");
		System.out.println("S- Search a product");
		System.out.println("B- Browse a products");
		System.out.println("G- Go to another store");	
		
	}
	

	
}
