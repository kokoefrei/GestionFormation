package view;

import java.util.TreeMap;
import java.util.Map.Entry;

public class AdminView extends AbstractView {
	
	public AdminView(){
		
	}
	
	
	public void printAdminMenu(TreeMap<String, Integer> storeProducts){
		
		System.out.println("~ ~ ~ Admin mode ~ ~ ~");
		
		System.out.println("Type a number's product to edit");
		
		int cpt = 1;
		
		for (Entry<String, Integer> entry : storeProducts.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();

		    System.out.println(cpt++ + ". " + key.toString() + " : " + value);
		}
		
		System.out.println("L. Logout");
		
		
		
	}
	
	
	
	
	
}
