import controller.Controller;
import model.Model;
import view.View; 

public class Main {

	public static void main(String[] args) {
		View view = new View();
		Controller control = new Controller(view); 
		Model model = new Model(); 
	
	}

}