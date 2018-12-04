package model;

import java.util.Observable;

public class Model extends Observable {
	
	private String temperature;
	private String tempext = "25";
	private String humidite = "50";
	private static String tempvoulue = "18";
	private String allume = "1"; 
	
	
	public Model() {
	RxTx connexion = new RxTx();
	
	}
	
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
		setChanged();
		notifyObservers(this.temperature); 
	}

	public String getTempext() {
		return tempext;
	}

	public void setTempext(String tempext) {
		this.tempext = tempext;
		setChanged();
		notifyObservers(this.tempext);
	}

	public String getHumidite() {
		return humidite;
	}

	public void setHumidite(String chunks) {
		this.humidite = chunks;
		setChanged();
		notifyObservers(this.humidite);
	}

	public static String getTempvoulue() {
		return tempvoulue;
	}

	public static void setTempvoulue(String tempvoulue) {
		Model.tempvoulue = tempvoulue;
	}

	public String getAllume() {
		return allume;
	}

	public void setAllume(String allume) {
		this.allume = allume;
	} 
	
	

	
	

}
