#include "DHT.h" // ajout de la bibliothèque DHT

#define DHTPIN 2       // patte de l'arduino sur laquelle se fait la mesure
#define DHTTYPE DHT22   // type de sonde

DHT dht(DHTPIN, DHTTYPE); // instanciation objet dht
int peltier = 3; //The N-Channel MOSFET is on digital pin 3
int power = 99; //Power level fro 0 to 99%
int peltier_level = map(power, 0, 99, 0, 255); //This is a value from 0 to 255 that actually controls the MOSFET

//PI
int commande = 0;
int consigne = 18;
int erreur = 0;
int ecart;
float kp = 0.3;
int ki = 8;
int P_x = 0;
int I_x = 0;

void setup() {
  pinMode(A0, INPUT) ;
  Serial.begin(9600); // ouverture connexion serie
  dht.begin();
}

void loop() {
  float h = dht.readHumidity();    // lecture humidité et affectation a une variable
  float t = dht.readTemperature(); // lecture température et affectation a une variable

  float U = analogRead(0) * (5.0 / 1024);
  float R = (10000.0 / ((5.0 / U) - 1.0));
  float temp = (1 / (0.001096702 + 0.00024005 * log(R) + 0.0000000593486 * (pow(log(R), 3)))) - 273.15;


  if (isnan(t) || isnan(h)) {
    Serial.println("Erreur de lecture sonde dht22");
  } else {

    /*ecart = consigne - temp;
    P_x = kp * ecart;
    commande = P_x + I_x;
    I_x = I_x + ki * ecart;
    power = power + commande;*/
      if (t > 18.0){
        power = 99; // module peltier allume
      } else {
        power = 0; //moduel perltier eteind
      }

    peltier_level = map(power, 0, 99, 0, 255);
    analogWrite(peltier, peltier_level); 
  
  if (power == 99) {
      Serial.println(temp +","+ t +","+ h +","+ "1" );
    } else {
      Serial.println(temp +","+ t +","+ h +","+ "0");
    }

    delay(1000); 
  }

}
