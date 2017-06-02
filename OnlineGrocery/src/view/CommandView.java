package view;

import java.util.Map.Entry;
import java.util.TreeMap;

import model.Product;

public class CommandView extends AbstractView {
	
	
	private TreeMap<String, Integer> products;
	
	
	public CommandView(TreeMap<String, Integer> products){
		this.products = products;
	}
	
	
	public void printCommandDetails(){
		
		int cpt = 1;
		
		System.out.println("--------------- Your products List -------------");
	
		
		for (Entry<String, Integer> entry : products.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    if (value > 0)
		    	System.out.println(cpt++ + ". " + key.toString() + " : " + value);
		}
		
		
		
		System.out.println("-->You can type the product n° to edit quantity of this in your command");
		System.out.println("\t\t\t1 --> Computer\n\t\t\t2 --> Hard Disk\n\t\t\t3 --> Keyboard\n\t\t\t4 --> Mouse\n\t\t\t5 --> Ram");
		System.out.println("C- ---> complete command");
		System.out.println("B- ---> Continue your buys");
		
	}
	
	
}
