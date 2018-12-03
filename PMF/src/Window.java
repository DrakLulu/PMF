import java.awt.BorderLayout;
import java.awt.Dimension;
	import javax.swing.JFrame;
public class Window extends JFrame {
	
	   public Window() {
	      JFrame f = new JFrame();
	      Panel panel1 = new Panel();
	      f.setTitle("FRIGO");
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setPreferredSize(new Dimension(800, 800));
	      f.setLayout(new BorderLayout());
	      f.setLocation(0,0); 
	      f.setLocationRelativeTo(null);
	      f.add(panel1);
	      f.pack();
	      f.setVisible(true);
	   }
	}

