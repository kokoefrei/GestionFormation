package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Command;
import model.Product;

public class CommandTest {

	@Test
	public void testAddProduct() {
		
		
		Command cart = Command.getCommandInstance();
		
		Product product = new Product("product");
		
		int nbProductsCartBefore = 0;
		cart.addProduct(product);
		int nbProductsCartAfter = cart.getListProducts().get(product.getName());
		
		if (nbProductsCartBefore + 1 != nbProductsCartAfter){
			
			System.out.println("nbProductsCartBefore = " + nbProductsCartBefore);
			System.out.println("nbProductsCartBefore = " + nbProductsCartAfter);
			fail("CartTest - testAddProduct KO");
		}
		
		
		System.out.println("CartTest - testAddProduct OK");
	}
	
	@Test
	public void testRemoveProduct() {
		Command cart = Command.getCommandInstance();
		
		Product product = new Product("product");
		
		
		cart.addProduct(product);
		cart.addProduct(product);
		
		int nbProductsCartBefore = cart.getListProducts().get(product.getName());
		cart.removeProduct(product);
		int nbProductsCartAfter = cart.getListProducts().get(product.getName());
		
		if (nbProductsCartBefore - 1 != nbProductsCartAfter){
			
			System.out.println("testRemoveProduct = " + nbProductsCartBefore);
			System.out.println("testRemoveProduct = " + nbProductsCartAfter);
			fail("CartTest - testRemoveProduct KO");
		}
		System.out.println("CartTest - testRemoveProduct OK");
	}
	
	@Test
	public void flushCart() {
		
		Command cart = Command.getCommandInstance();
		
		Product product = new Product("product");
		Product product2 = new Product("product2");
		Product product3 = new Product("product3");
		
		cart.addProduct(product);
		cart.addProduct(product2);
		cart.addProduct(product3);
		
		int nbProductsCartBefore = cart.getListProducts().size();
		cart.flushCommand();
		int nbProductsCartAfter = cart.getListProducts().size();
		
		if (!(nbProductsCartBefore > 0 && nbProductsCartAfter == 0)){
			System.out.println("testRemoveProduct = " + nbProductsCartBefore);
			System.out.println("testRemoveProduct = " + nbProductsCartAfter);
			fail("CartTest - flushCart KO");
		}
		
		System.out.println("CartTest - flushCart OK");
	}
	
	
}
