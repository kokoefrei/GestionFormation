package model;

public class PersonFactory implements Model {
	
	public Person createPerson(String personType, String email, Login login){
		
		if (personType == null){
			return null;
		}
		else if(personType.equalsIgnoreCase("admin")){
			return new Admin(email, login);
		}
		else if(personType.equalsIgnoreCase("user")){
			return new User(email, login);
		}
		
		return null;
		
	}
	
	
	
	
}
