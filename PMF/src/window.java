import java.awt.Dimension;
	import javax.swing.JFrame;
public class window {
	
	   public window() {
	      // création de l'application
	      JFrame f = new JFrame();
	      // affectation du titre et de l'icône
	      f.setTitle("FRIGO");
	      // affectation de l'opération à effectuer lors de la fermeture de la fenêtre
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      // taille et position
	      f.setPreferredSize(new Dimension(800, 800));
	      f.setLocation(100,100); // la fenêtre est en 100, 100
	      f.setLocationRelativeTo(null); // la fenêtre est centrée à l'écran
	      // rendre la fenêtre visible, pack fait en sorte que tous les composants de l'application soient à
	      // leur preferredSize, ou au dessus
	      f.pack();
	      f.setVisible(true);
	   }
	}

