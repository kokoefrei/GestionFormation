package model;

public class Product implements Model {
	
	private int id;
	private static int cptId;
	private String name;
	
	public Product(String name){
		cptId = cptId + 1;
		id = cptId;
		this.name = name;
	}
	
	public String toString(){		
		return name + "n°" + id;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
