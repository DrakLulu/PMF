package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controller.Controller;
import javafx.scene.paint.Color;
import model.Model;

public class View extends JFrame implements ActionListener{

	
  private Panel pan = new Panel(); 
  


  public View() {
	  
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
  


