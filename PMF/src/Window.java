import java.awt.Dimension;
	import javax.swing.JFrame;
public class window {
	
	   public window() {

		   JFrame f = new JFrame();
	      f.setTitle("FRIGO");
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setPreferredSize(new Dimension(800, 800));
	      f.setLocation(100,100); 
	      f.setLocationRelativeTo(null);
	      f.pack();
	      f.setVisible(true);
	   }
	}

