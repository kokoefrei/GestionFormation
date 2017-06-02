package test;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

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
		
		Command cart = Command.getCommandInstance();
		
		Product productBanana = new Product("Banana");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(productBanana);
		
		StoreFactory storeFactory = new StoreFactory();
		Store unionStore = storeFactory.createStore("Union", cart, products);
		
		int nbProductBefore = unionStore.getAvailableProducts().get(productBanana.getName());
		unionStore.addProduct(productBanana);
		int nbProductAfter = unionStore.getAvailableProducts().get(productBanana.getName());
		
		if (nbProductBefore + 1 != nbProductAfter){
			System.out.println("nbProductBefore: " + nbProductBefore);
			System.out.println("nbProductAfter: " + nbProductAfter);
			fail("StoreTest - testAddProduct KO: product not added");
		}
		
		System.out.println("StoreTest - testAddProduct: OK");
		
	}
	
	@Test
	public final void testRemoveProduct(){
		
		Command cart = Command.getCommandInstance();
		
		Product productBanana = new Product("Banana");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(productBanana);
		
		StoreFactory storeFactory = new StoreFactory();
		Store unionStore = storeFactory.createStore("Union", cart, products);
		
		int nbProductBefore = unionStore.getAvailableProducts().get(productBanana.getName());
		unionStore.removeProduct(productBanana);
		int nbProductAfter = unionStore.getAvailableProducts().get(productBanana.getName());
		
		if (nbProductBefore - 1 != nbProductAfter){
			System.out.println("nbProductBefore: " + nbProductBefore);
			System.out.println("nbProductAfter: " + nbProductAfter);
			fail("StoreTest - testRemoveProduct KO: product not removed");
		}
		
		System.out.println("StoreTest - testRemoveProduct: OK");
		
	}

	@Test
	public final void testRemoveProductCart(){
		
		Command cart = Command.getCommandInstance();
		
		Product productBanana = new Product("Banana");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(productBanana);
		
		StoreFactory storeFactory = new StoreFactory();
		Store unionStore = storeFactory.createStore("Union", cart, products);
		
		unionStore.addProductCart(productBanana);
		
		int nbProductBefore = unionStore.getCommand().getListProducts().get(productBanana.getName());
		unionStore.removeProductCommand(productBanana);
		int nbProductAfter = unionStore.getCommand().getListProducts().get(productBanana.getName());
		
		if (nbProductBefore - 1 != nbProductAfter){			
			System.out.println("nbProductBefore: " + nbProductBefore);
			System.out.println("nbProductAfter: " + nbProductAfter);
			fail("StoreTest - testRemoveProductCart KO: product not removed");
		}
		
		System.out.println("StoreTest - testRemoveProductCart: OK");
	}
	
	@Test
	public final void testAddProductCart(){
		
		Command cart = Command.getCommandInstance();
		
		Product productBanana = new Product("Banana");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(productBanana);
		
		StoreFactory storeFactory = new StoreFactory();
		Store unionStore = storeFactory.createStore("Union", cart, products);
		
		
		
		int nbProductBefore = unionStore.getCommand().getListProducts().get(productBanana.getName());
		unionStore.addProductCart(productBanana);
		int nbProductAfter = unionStore.getCommand().getListProducts().get(productBanana.getName());
		
		if (nbProductBefore + 1 != nbProductAfter){			
			System.out.println("nbProductBefore: " + nbProductBefore);
			System.out.println("nbProductAfter: " + nbProductAfter);
			fail("StoreTest - testAddProductCart KO: product not removed");
		}
		
		System.out.println("StoreTest - testAddProductCart: OK");
	}
	
	@Test
	public final void testAddPerson(){
		
		Command cart = Command.getCommandInstance();
		
		Product productBanana = new Product("Banana");
		ArrayList<Product> products = new ArrayList<Product>();
		
		StoreFactory storeFactory = new StoreFactory();
		Store unionStore = storeFactory.createStore("Union", cart, products);
		
		PersonFactory personFactory = new PersonFactory();
		Person admin = personFactory.createPerson("admin", "test@test.com", new Login("root", "root"));
		Person user = personFactory.createPerson("user", "test@test.com", new Login("user", "user"));
		
		
		int nbPersonBefore;
		int nbPersonAfter;
		
		nbPersonBefore = unionStore.getListPerson().size();
		unionStore.addPerson(user);
		nbPersonAfter = unionStore.getListPerson().size();
		
		if (nbPersonBefore + 1 != nbPersonAfter){
			System.out.println("nbPersonBefore: " + nbPersonBefore);
			System.out.println("nbPersonAfter" + nbPersonAfter);
			fail("StoreTest - testAddPerson KO: user not added");
		}
		
		nbPersonBefore = unionStore.getListPerson().size();
		unionStore.addPerson(admin);
		nbPersonAfter = unionStore.getListPerson().size();
		
		if (nbPersonBefore + 1 != nbPersonAfter){
			System.out.println("nbPersonBefore: " + nbPersonBefore);
			System.out.println("nbPersonAfter" + nbPersonAfter);
			fail("StoreTest - testAddPerson KO: admin not added");
		}
		
		
		System.out.println("StoreTest - testAddPerson: OK");
		
		
	}
	

}
