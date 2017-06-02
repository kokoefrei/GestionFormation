package view;

public class HeaderView extends AbstractView {
	
	private static HeaderView instance = new HeaderView();
	
	private HeaderView(){}
	
	public static HeaderView getInstance(){
		return instance;
	}
	
	public void printHeader(){
		System.out.println("**************************************************************************");
		System.out.println("\t\t YOUR ONLINE GROCERIES !!!");
		
	}

	
	
}
