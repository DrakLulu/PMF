import arduino.Arduino;

public class controller {
	readArduino AA = new readArduino();
	intel infos = new intel();
	public controller() throws InterruptedException {
	Thread read = new Thread(new readArduino());
	Thread panel = new Thread(new panel());
	
	read.start();
	
	
}
}

