package model;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreFactory implements Model {
	
	
	private static final HashMap<String, Store> storeMap = new HashMap<String, Store>();
	
	
		
		
	public Store createStore(String storeName, Command command, ArrayList<Product> products){
		
		Store store = storeMap.get(storeName);
		
		if (store == null){
			store = new Store(storeName, command, products);
			PersonFactory sessionPersonFactory = new PersonFactory();
			Person admin = sessionPersonFactory.createPerson("admin", "test@test.com", new Login("root", "root"));
			store.addPerson(admin);
			storeMap.put(storeName, store);
			
		}
		
		return store;
	}




	
		
	
	
}
