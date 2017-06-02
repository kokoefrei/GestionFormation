package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Store implements Model{
	
	private String name;
	private Command command;
	private ArrayList<Person> listPerson;
	private TreeMap<String, Integer> availableProducts;
	private ArrayList<Product> products;
	
	// waiting for an array of products
	public Store(String name, Command cart, ArrayList<Product> products){
		
		this.products = products;
		this.name = name;
		
		availableProducts = new TreeMap<String, Integer>();
		
		listPerson = new ArrayList<Person>();
		
		for (Product p : products){
			availableProducts.put(p.getName(), 5);
		}		
		
		this.command = Command.getCommandInstance();
		/*
		for(Map.Entry<String, Integer> entry : availableProducts.entrySet()){
			this.cart.getListProducts().put(entry.getKey(), 0);
		}*/
		
	}
	



	public void addPerson(Person p){
		listPerson.add(p);
	}
	
	public void addProduct(Product p){
		availableProducts.put(p.getName(), availableProducts.get(p.getName()) + 1);
	}
	
	public boolean removeProduct(Product p){
		if (availableProducts.get(p.getName()) > 0){
			availableProducts.put(p.getName(), availableProducts.get(p.getName()) - 1);
			return true;
		}
		
		return false;
	}
	
	public void addProductCommand(Product p){
		command.addProduct(p);
	}
	
	public boolean removeProductCommand(Product p){
		if (command.getListProducts().get(p.getName()) != null){
			if (command.getListProducts().get(p.getName()) > 0){
				this.addProduct(p);
				return command.removeProduct(p);
			}
		}
		
		return false;
		
	}
	
	public void buyCommand(){
		command.flushCommand();
	}
	
	public void flushCommand(){
		for (Entry<String, Integer> entry : command.getListProducts().entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    
		    for (int i = 0; i < value; i++){
		    	availableProducts.put(key, availableProducts.get(key) + 1);
		    }

		}
		
		command.flushCommand();
	}
	
	
	// GETTERS & SETTERS
	
	
	public ArrayList<Person> getListPerson() {
		return listPerson;
	}


	public void setListPerson(ArrayList<Person> listPerson) {
		this.listPerson = listPerson;
	}
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public Command getCommand() {
		return command;
	}


	public void setCart(Command cart) {
		this.command = cart;
	}




	public TreeMap<String, Integer> getAvailableProducts() {
		return availableProducts;
	}




	public void setAvailableProducts(TreeMap<String, Integer> availableProducts) {
		this.availableProducts = availableProducts;
	}




	public ArrayList<Product> getProducts() {
		return products;
	}




	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
	
	
	
}
