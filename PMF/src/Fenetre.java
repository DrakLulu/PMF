import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
public class Fenetre extends JFrame {
	
	Panel panel1 = new Panel();
	
	   public Fenetre() {
	      this.setTitle("FRIGO");
	      this.setLocationRelativeTo(null);
	      this.setLayout(new BorderLayout());
	      this.setPreferredSize(new Dimension(800,800));
	      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	      this.setContentPane(panel1);
	      this.pack();
	      this.setVisible(true);
	   }
	}

