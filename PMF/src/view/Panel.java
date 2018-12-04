package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


public class Panel extends JPanel implements ActionListener, ItemListener {

	 	private JButton temp;
	    private JButton humi ;
	    private JButton tempext;
	    private JButton rose;
	    private JButton achat;
	    private Label affichage; 
	    
		private ImageIcon image; 
	    private Choice liste; 
	    private JButton etat ; 
	    
	    private String temperature; 
	    private String humidite;
	    private String temperaturext; 
	    private float ptrose; 
	    private String imagepng = "image6.png"; 
	    public int allume = 1; 
	
	    
	    
		public Panel() {
	    	
	    	temp = new JButton();
	    	humi = new JButton();
	    	tempext = new JButton();
	    	rose = new JButton();
	    	achat = new JButton(); 
	    	affichage = new Label();
	    	image = new ImageIcon();
	    	liste = new Choice();
	    	etat = new JButton();
	    	
	    	this.setLayout(null);
	    	
	    	temp.setBounds(110 , 50 , 100, 100);
	    	humi.setBounds(250 , 50 , 100, 100);
	    	tempext.setBounds(390, 50 , 100, 100);
	    	rose.setBounds(530, 50, 100, 100);
	    	achat.setBounds(500, 500, 100, 100);
	    	liste.setBounds(0, 310, 800, 50);
	    	etat.setBounds(0, 0, 60, 40);
	    	
	    	listItem(liste); 
	    	
	    	affichage.setText("Appuyez sur un bouton");
	    	affichage.setBounds(200, 200, 400, 50);
	    	affichage.setBackground(Color.lightGray);
	    	
	    	initButtonForm();
	    	
	    	this.add(temp);
	    	this.add(humi);
	    	this.add(tempext);
	    	this.add(achat);
	    	this.add(rose);
	    	this.add(affichage);
	    	this.add(liste);
	    	this.add(etat);
	    	
	    	temp.addActionListener(this);
	    	humi.addActionListener(this);
	    	tempext.addActionListener(this);
	    	rose.addActionListener(this);
	    	achat.addActionListener(this);
	    	liste.addItemListener(this);
	    	etat.addActionListener(this);
	    	
	    	
	    	temp.setActionCommand("1");
	    	humi.setActionCommand("2");
	    	tempext.setActionCommand("3");
	    	rose.setActionCommand("4");
	    	achat.setActionCommand("5");
	    	
	    }
	    
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		switch(e.getActionCommand()) {
		case "1": affichage.setText("La Température interieur du frigo est de : "+ temperature + "C");
			break;
		case "2": affichage.setText("Le poucrentage d'humidité dans le frigo est de : "  + humidite + " %");
			break;
		case "3": affichage.setText("La Température du Module Peltier est de : "+ temperaturext +"C");
			break;
		case "4": affichage.setText("Le point de rose claculer est egale : "+ ptrose +"C");
			break;
		case "5": BrowserControl.displayURL("https://www.cdiscount.com/au-quotidien/alimentaire/boissons/boissons-gazeuses-sodas/l-127011001.html");
			break; 
		default : affichage.setText("Appuyez sur un bouton");
			break;
		}
		
	}
	  
	

	private void listItem(Choice liste) {
		
		liste.addItem("Votre Boisson preferee");
		liste.addItem("Coca-Cola"); 
		liste.addItem("Pepsi");
		liste.addItem("Fanta");
		liste.addItem("Schweppes");
		liste.addItem("Sprite");
		liste.addItem("Ice Tea");
		liste.addItem("Orangina");
		liste.addItem("7Up");
		liste.addItem("A completer...");
		
	}
	
	

	 private void initButtonForm(){
		 
	    	temp.setBackground(Color.decode("#355C"));
	    	humi.setBackground(Color.decode("#355C"));
	    	tempext.setBackground(Color.decode("#355C"));
	    	rose.setBackground(Color.decode("#355C"));
	    	achat.setBackground(Color.decode("#355C"));
	    	
	    	temp.setText("<HTML><BODY>Température <BR> à l'interieur<BR>du frigo</BODY></HTML>");
	    	humi.setText("<HTML><BODY>Pourcentage<BR>d'Humidité</BODY></HTML>");
	    	tempext.setText("<HTML><BODY>Température<BR> du <BR>module Peltier</BODY></HTML>");
	    	rose.setText("<HTML><BODY> Point de <BR>rosée</BODY></HTML>");
	    	achat.setText("<HTML><BODY> Achat <BR> en ligne</BODY></HTML>");
	    	
	    	temp.setForeground(Color.white); 
	    	humi.setForeground(Color.white); 
	    	tempext.setForeground(Color.white);
	    	rose.setForeground(Color.white);
	    	achat.setForeground(Color.white);
	    	
	    	temp.setBorder(new LineBorder(Color.BLACK));
	    	humi.setBorder(new LineBorder(Color.BLACK));
	    	tempext.setBorder(new LineBorder(Color.BLACK));
	    	rose.setBorder(new LineBorder(Color.BLACK));
	    	achat.setBorder(new LineBorder(Color.BLACK));
	    
		 	if(allume == 1) {
	    		etat.setBackground(Color.green);
	    	} else {
	    		etat.setBackground(Color.red);
	    		}
	    	etat.setText("Etat"); 
	    	
	 }
	 
	 public void paintComponent(Graphics g){
		 
	    	
		    g.setColor(Color.black);
		    g.fillRect (0, 300, 50000, 10);
		    try {
		    	  Image im = ImageIO.read(new File("Capture.PNG")); 
	    	      g.drawImage(im, 100, 450, this);
	    	      Image img = ImageIO.read(new File(imagepng)); 
	    	      g.drawImage(img, 100, 450, this);
	    	      
	    	    } catch (IOException e) {
	    	      e.printStackTrace();
	    	    } 
		  
		  }

	public Label getAffichage() {
		return affichage;
	}

	public void setAffichage(Label affichage) {
		this.affichage = affichage;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	   	 
   	 switch (liste.getSelectedIndex()) {
   	 case 0:
   		 imagepng = "image6.png";
   		 break;
   		 
   	 case 1:  
   		 imagepng = "image3.png";
   		 break; 
   		 
   	 case 2:
   		 imagepng = "image2.png";
   		 break;
   		 
   	 case 3:
   		 imagepng = "image4.png";
   		 break; 
   		 
   	 case 4:	
   		 imagepng = "image8.png";
   		 break;	
   		 
   	 case 5:	
   		 imagepng = "image0.png";
   		 break;
   		 
   	 case 6:
   		 imagepng = "image7.png";
   		 break;
   		 
   	 case 7:
   		 imagepng = "image5.png";
   		 break;	
   		 
   	 case 8:
   		 imagepng = "image1.png";
   		 break;
   		 
   	 case 9:
   		 imagepng = "image6.png";
   		 break;
   		 
   	 default: imagepng = "image6.png";
   		 break;
   		 
   	 } 
   	repaint();
	}


	public String getTemperature() {
		return temperature;
	}



	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}



	public String getHumidite() {
		return humidite;
	}



	public void setHumidite(String humidite) {
		this.humidite = humidite;
	}



	public String getTemperaturext() {
		return temperaturext;
	}



	public void setTemperaturext(String temperaturext) {
		this.temperaturext = temperaturext;
	}



	public float getPtrose() {
		return ptrose;
	}



	public void setPtrose(float ptrose) {
		this.ptrose = ptrose;
	}

	public int getAllume() {
		return allume;
	}



	public void setAllume(int allume) {
		this.allume = allume;
	}








}
