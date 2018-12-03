import arduino.Arduino;

public class controller {
	Arduino frigo = new Arduino();
	readArduino AA = new readArduino();
	public controller() {
	AA.read(frigo);
	
	
	
}
}

