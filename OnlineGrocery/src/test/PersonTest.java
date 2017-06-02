package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Command;
import model.Login;
import model.Person;
import model.PersonFactory;
import model.Product;
import model.Store;
import model.StoreFactory;

public class PersonTest {

	@Test
	public void testCheckLogin() {
		
		PersonFactory personFactory = new PersonFactory();
		Person admin = personFactory.createPerson("admin", "test@test.com", new Login("root", "root"));
		Person user = personFactory.createPerson("user", "test@test.com", new Login("user", "user"));
		
		/*if (!(admin.checkLogin("root", "root"))){
			fail("testCheckLogin KO: admin testCheckLogin");
		}
		if (!(user.checkLogin("user", "user"))){
			fail("PersonTest - testCheckLogin KO: user testCheckLogin");
		}
		System.out.println("PersonTest - testCheckLogin OK");*/
		
		
		assertFalse("testCheckLogin KO: admin testCheckLogin",!(admin.checkLogin("root", "root")));
		assertFalse("PersonTest - testCheckLogin KO: user testCheckLogin", !(user.checkLogin("user", "user")));
		
	}

}
