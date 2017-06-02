package view;

public class FooterView extends AbstractView {
	
	private static FooterView instance = new FooterView();
	
	private FooterView(){};
	
	public static FooterView getInstance(){
		return instance;
	}
	
	public void printFooter(){
		System.out.println("\n**************************************************************************");
		System.out.println("C- Access your command");
		System.out.println("A- Administrator mode");
		System.out.println("\n**************************************************************************");
	}
	
	
}
