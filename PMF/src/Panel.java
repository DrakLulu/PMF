import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Panel extends JPanel{

	Button b = new Button("boutton1");
	
	public Panel() {
		setLayout(new GridLayout(4,3)); 
		
		this.add(b);
	}
	
	 
	
}
