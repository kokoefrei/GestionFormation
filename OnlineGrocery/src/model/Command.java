package model;

import java.util.TreeMap;

public class Command implements Model {
	
	
	protected TreeMap<String, Integer> listProducts;
	private static Command command = new Command();
	
	private Command(){
		listProducts = new TreeMap<String, Integer>();
	}
	
	public static Command getCommandInstance(){
		return command;
	}
	
	
	public void addProduct(Product p){
		Integer value = listProducts.get(p.getName());
		if (value != null) {
		   // key
			listProducts.put(p.getName(), listProducts.get(p.getName()) + 1);
		} else {
		    // No such key
			listProducts.put(p.getName(), 1);
		}
		
	}
	
	public boolean removeProduct(Product p){
		if (listProducts.get(p.getName()) > 0){
			if (listProducts.get(p.getName()) == 1){
				listProducts.remove(p.getName());
			}else{
				listProducts.put(p.getName(), listProducts.get(p.getName()) - 1);
			}
			
			return true;
		}else{
			return false;
		}
	}
	
	public void flushCommand(){
		listProducts.clear();
	}
	

	public static Command getCommand() {
		return command;
	}

	public static void setCommand(Command command) {
		Command.command = command;
	}

	public TreeMap<String, Integer> getListProducts() {
		return listProducts;
	}

	public void setListProducts(TreeMap<String, Integer> listProducts) {
		this.listProducts = listProducts;
	}

	
	
	
	

	
	
	
}
