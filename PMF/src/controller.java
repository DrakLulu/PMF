
import arduino.Arduino;

public class controller {
	Arduino frigo = new Arduino();
	ReadArduino AA = new ReadArduino();
	public controller() {
	AA.read(frigo);
	
	
	
}
}

