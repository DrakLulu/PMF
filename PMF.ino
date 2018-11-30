#include "DHT.h" // ajout de la bibliothèque DHT

#define DHTPIN 2       // patte de l'arduino sur laquelle se fait la mesure
#define DHTTYPE DHT22   // type de sonde

DHT dht(DHTPIN, DHTTYPE); // instanciation objet dht
int peltier = 3; //The N-Channel MOSFET is on digital pin 3
int power = 99; //Power level fro 0 to 99%
int peltier_level = map(power, 0, 99, 0, 255); //This is a value from 0 to 255 that actually controls the MOSFET

void setup() {
pinMode(A0, INPUT) ; 
Serial.begin(9600); // ouverture connexion serie
Serial.println("Tets DHT22 ----------------------");  //
dht.begin(); 
}

void loop() {

float h = dht.readHumidity();    // lecture humidité et affectation a une variable de type float
float t = dht.readTemperature(); // lecture température et affectation a une variable de type float

float U = analogRead(0)*(5.0/1024);
float R = (10000.0/((5.0/U)-1.0));
float temp = (1/(0.001096702 + 0.00024005*log(R) + 0.0000000593486*(pow(log(R),3))))-273.15; 
Serial.print("Temperature sonde : ");
Serial.println(temp);

// test si retour sonde dht2  ok ou pas ...
if (isnan(t) || isnan(h)) {
Serial.println("Erreur de lecture sonde dht22");
} else {
//affichage des donnees sur la console serie
Serial.print("Humidite : " ); 
Serial.print(h);
Serial.print( " %\t ");
Serial.print(" Temperature DHT22: " );
Serial.print(t);
Serial.println(" C");

if( temp < 18 ){
  power = 0;
} else{
  power = 99;
}
peltier_level = map(power, 0, 99, 0, 255);

Serial.print("Power=");
Serial.print(power);
Serial.print(" PLevel=");
Serial.println(peltier_level);
analogWrite(peltier, peltier_level); //Write this new value out to the port

if(power == 99){
  Serial.println("Allume");
} else {
  Serial.println("eteind"); 
}



delay(1000); // attente de 1 seconde avant de refaire une mesure
}

}
