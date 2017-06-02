package onlineGroceries;

import java.util.ArrayList;

import controller.StoreMenuController;
import model.Command;
import model.Login;
import model.Person;
import model.PersonFactory;
import model.Product;
import model.Store;
import model.StoreFactory;
import view.StoreMenuView;

public class OnlineGroceryMain {

	public static void main(String[] args) {
		
		
		Command command = Command.getCommandInstance();
		
		Product productComputer = new Product("Computer");
		Product productMouse = new Product("Mouse");
		Product productKeyboard = new Product("Keyboard");
		Product productHarddisk = new Product("Hard disk");
		Product productRam = new Product("Ram");
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		products.add(productComputer);
		products.add(productMouse);
		products.add(productKeyboard);
		products.add(productHarddisk);
		products.add(productRam);

		
		
		StoreFactory sessionStoreFactory = new StoreFactory();
		Store englandStore = sessionStoreFactory.createStore("England", command, products);

		
		StoreMenuView storeView = new StoreMenuView();
		
		StoreMenuController storeController = new StoreMenuController(englandStore, storeView);
		storeController.updateView();
		
		
		
		
		
	}

}
