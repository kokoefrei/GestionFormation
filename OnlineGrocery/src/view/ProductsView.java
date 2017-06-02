package view;

import java.util.TreeMap;
import java.util.Map.Entry;

public class ProductsView extends AbstractView{
	
	public ProductsView(){}
	
	public void printProducts(TreeMap<String, Integer> products){
		
		int cpt = 1;
		
		System.out.println("\t\tProducts in this store: ");
		System.out.println("\t-------Type a product number to add it to your command------");
		
		for (Entry<String, Integer> entry : products.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();

		    System.out.println(cpt++ + " --> " + key.toString() + " : " + value);
		}
		
		System.out.println("B- Back to main menu");
		
	}
	
	

}
