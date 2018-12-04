package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Window extends JFrame implements ActionListener{

  private static final Color fond = Color.lightGray;
  	public Panel pan = new Panel(); 
  


  public Window() {
	  
	  this.setTitle("Frigo");
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setResizable(false);
      this.setPreferredSize(new Dimension(800, 800));
      this.pack();
      this.add(pan); 
      this.setLocationRelativeTo(null);
      this.setVisible(true);
   }



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
	  
  }
  


