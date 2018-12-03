import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JPanel;


public class Panel extends JPanel{

	Button b = new Button("boutton1");
	Choice listederoulante = new Choice();
	TextField text = new TextField("texte par défaut"); 
	
	public Panel() {
		
		this.setLayout(new GridLayout(4,3)); 
		this.add(b);
		b.setLocation(200, 200);

		this.add(text);
		text.setEditable(false);
		
		this.add(listederoulante);
		listederoulante.addItem("element1"); // mettre autant d'element que l'on souhaite. 
	}
	
	  public void paintComponent(Graphics g){
		    g.setColor(Color.black);
		    g.fillRect(0, 100, 800000, 10);
		  }
	
	
	 
	
}
