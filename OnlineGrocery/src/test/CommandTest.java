package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Command;
import model.Product;

public class CommandTest {

	@Test
	public void testAddProduct() {
		
		
		Command command = Command.getCommandInstance();
		
		Product product = new Product("product");
		
		int nbProductsCommandBefore = 0;
		command.addProduct(product);
		int nbProductsCommandAfter = command.getListProducts().get(product.getName());
		
		/*if (nbProductsCommandBefore + 1 != nbProductsCommandAfter){
			
			System.out.println("nbProductsCommandBefore = " + nbProductsCommandBefore);
			System.out.println("nbProductsCommandBefore = " + nbProductsCommandAfter);
			fail("CommandTest - testAddProduct KO");
		}
		System.out.println("CartTest - testAddProduct OK");
		*/
		assertFalse("CommandTest - testAddProduct KO",nbProductsCommandBefore + 1 != nbProductsCommandAfter);
		
		
	}
	
	@Test
	public void testRemoveProduct() {
		Command cart = Command.getCommandInstance();
		
		Product product = new Product("product");
		
		
		cart.addProduct(product);
		cart.addProduct(product);
		
		int nbProductsCommandBefore = cart.getListProducts().get(product.getName());
		cart.removeProduct(product);
		int nbProductsCommandAfter = cart.getListProducts().get(product.getName());
		
		/*if (nbProductsCommandBefore - 1 != nbProductsCommandAfter){
			
			System.out.println("testRemoveProduct = " + nbProductsCommandBefore);
			System.out.println("testRemoveProduct = " + nbProductsCommandAfter);
			fail("CartTest - testRemoveProduct KO");
		}
		System.out.println("CartTest - testRemoveProduct OK");
	}*/
		assertFalse("CartCommand - testRemoveProduct KO",nbProductsCommandBefore - 1 != nbProductsCommandAfter);
	}
	
	@Test
	public void flushCommand() {
		
		Command command = Command.getCommandInstance();
		
		Product product = new Product("product");
		Product product2 = new Product("product2");
		Product product3 = new Product("product3");
		
		command.addProduct(product);
		command.addProduct(product2);
		command.addProduct(product3);
		
		int nbProductsCommandBefore = command.getListProducts().size();
		command.flushCommand();
		int nbProductsCommandAfter = command.getListProducts().size();
		
		/*if (!(nbProductsCartBefore > 0 && nbProductsCartAfter == 0)){
			System.out.println("testRemoveProduct = " + nbProductsCartBefore);
			System.out.println("testRemoveProduct = " + nbProductsCartAfter);
			fail("CartTest - flushCart KO");
		}
		
		System.out.println("CartTest - flushCart OK");*/
		
		assertFalse("CommandTest - flushCart KO",(!(nbProductsCommandBefore > 0 && nbProductsCommandAfter == 0)));
	}
	
	
}
