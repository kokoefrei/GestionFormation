package test;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.AssertionFailedError;
import model.Command;
import model.Login;
import model.Person;
import model.PersonFactory;
import model.Product;
import model.Store;
import model.StoreFactory;

public class StoreTest {

	
	@Test
	public final void testAddProduct(){
		
		Command command = Command.getCommandInstance();
		
		Product productBanana = new Product("Banana");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(productBanana);
		
		StoreFactory storeFactory = new StoreFactory();
		Store unionStore = storeFactory.createStore("Union", command, products);
		
		int nbProductBefore = unionStore.getAvailableProducts().get(productBanana.getName());
		unionStore.addProduct(productBanana);
		int nbProductAfter = unionStore.getAvailableProducts().get(productBanana.getName());
		
		if (nbProductBefore + 1 != nbProductAfter){
			System.out.println("nbProductBefore: " + nbProductBefore);
			System.out.println("nbProductAfter: " + nbProductAfter);
			fail("StoreTest - testAddProduct KO: product not added");
		}
		
		System.out.println("StoreTest - testAddProduct: OK");
		
		//assertFalse("StoreTest - testAddProduct KO: product not added", nbProductBefore + 1 != nbProductAfter);
		
	}
	
	@Test
	public final void testRemoveProduct(){
		
		Command command = Command.getCommandInstance();
		
		Product productComputer = new Product("Computer");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(productComputer);
		
		StoreFactory storeFactory = new StoreFactory();
		Store englandStore = storeFactory.createStore("England", command, products);
		
		int nbProductBefore = englandStore.getAvailableProducts().get(productComputer.getName());
		englandStore.removeProduct(productComputer);
		int nbProductAfter = englandStore.getAvailableProducts().get(productComputer.getName());
		
		if (nbProductBefore - 1 != nbProductAfter){
			System.out.println("nbProductBefore: " + nbProductBefore);
			System.out.println("nbProductAfter: " + nbProductAfter);
			fail("StoreTest - testRemoveProduct KO: product not removed");
		}
		
		System.out.println("StoreTest - testRemoveProduct: OK");
		
	}

	@Test
	public final void testRemoveProductCommand(){
		
		Command command = Command.getCommandInstance();
		
		Product productComputer = new Product("Computer");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(productComputer);
		
		StoreFactory storeFactory = new StoreFactory();
		Store englandStore = storeFactory.createStore("England", command, products);
		
		englandStore.addProductCommand(productComputer);
		englandStore.addProductCommand(productComputer);
		
		int nbProductBefore = englandStore.getCommand().getListProducts().get(productComputer.getName());
		englandStore.removeProductCommand(productComputer);
		int nbProductAfter = englandStore.getCommand().getListProducts().get(productComputer.getName());
		
		if (nbProductBefore - 1 != nbProductAfter){			
			System.out.println("nbProductBefore: " + nbProductBefore);
			System.out.println("nbProductAfter: " + nbProductAfter);
			fail("StoreTest - testRemoveProductCommand KO: product not removed");
		}
		
		System.out.println("StoreTest - testRemoveProductCommand: OK");
	}
	
	@Test
	public final void testAddProductCommand(){
		
		Command command = Command.getCommandInstance();
		
		Product productComputer = new Product("Computer");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(productComputer);
		
		StoreFactory storeFactory = new StoreFactory();
		Store englandStore = storeFactory.createStore("England", command, products);
		
		
		
		int nbProductBefore = englandStore.getCommand().getListProducts().get(productComputer.getName());
		englandStore.addProductCommand(productComputer);
		int nbProductAfter = englandStore.getCommand().getListProducts().get(productComputer.getName());
		
		if (nbProductBefore + 1 != nbProductAfter){			
			System.out.println("nbProductBefore: " + nbProductBefore);
			System.out.println("nbProductAfter: " + nbProductAfter);
			fail("StoreTest - testAddProductCommand KO: product not removed");
		}
		else{
			System.out.println("StoreTest - testAddProductCommand: OK");
		}
		
	}
	
	@Test
	public final void testAddPerson(){
		
		Command command = Command.getCommandInstance();
		
		Product productComputer = new Product("Computer");
		ArrayList<Product> products = new ArrayList<Product>();
		
		StoreFactory storeFactory = new StoreFactory();
		Store englandStore = storeFactory.createStore("England", command, products);
		
		PersonFactory personFactory = new PersonFactory();
		Person admin = personFactory.createPerson("admin", "test@test.com", new Login("root", "root"));
		Person user = personFactory.createPerson("user", "test@test.com", new Login("user", "user"));
		
		
		int nbPersonBefore;
		int nbPersonAfter;
		
		nbPersonBefore = englandStore.getListPerson().size();
		englandStore.addPerson(user);
		nbPersonAfter = englandStore.getListPerson().size();
		
		if (nbPersonBefore + 1 != nbPersonAfter){
			System.out.println("nbPersonBefore: " + nbPersonBefore);
			System.out.println("nbPersonAfter" + nbPersonAfter);
			fail("StoreTest - testAddPerson KO: user not added");
		}
		
		nbPersonBefore = englandStore.getListPerson().size();
		englandStore.addPerson(admin);
		nbPersonAfter = englandStore.getListPerson().size();
		
		if (nbPersonBefore + 1 != nbPersonAfter){
			System.out.println("nbPersonBefore: " + nbPersonBefore);
			System.out.println("nbPersonAfter" + nbPersonAfter);
			fail("StoreTest - testAddPerson KO: admin not added");
		}
		
		
		System.out.println("StoreTest - testAddPerson: OK");
		
		
	}
	

}
