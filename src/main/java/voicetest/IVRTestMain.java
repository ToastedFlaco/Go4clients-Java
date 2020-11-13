package voicetest;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class IVRTestMain {

	public static void main(String[] args) {
		// Usando la librería de Unirest disponible en: http://kong.github.io/unirest-java/
		// Agregada en el pom.xml creando un nuevo proyecto simple de Maven (haciendo skip de arquetipos en SpringToolSuite 4)
		// Utilizando el JDK 1.8 en el build path de Java
		HttpResponse<String> response = Unirest.post("https://cloud.go4clients.com:8580/api/campaigns/voice/v1.0/5fad7d2751dcd90009afc0a0")
		  .header("Content-Type", "application/json")
		  .header("apiKey", "5a9ec569ada54cf69ef10c741232158a")
		  .header("apiSecret", "4785032210487465")
		  .body("{\n \"destinationsList\":"
		  		+ "[\n   \"528115655463\"\n ],"
		  		+ "\n \"stepList\":[\n     "
		  		+ "{\n       \"id\":\"1\",\n       \"rootStep\":true,\n       \"nextStepId\":\"2\",\n       \"stepType\":\"CALL\"\n     },\n     "
		  		+ "{\n       \"id\":\"2\",\n       \"rootStep\":false,\n       \"nextStepId\":\"3\",\n       \"text\":\"Hola, este es un mensaje de prueba\",\n       \"voice\":\"PEDRO\",\n       \"speed\":100,\n       \"stepType\": \"SAY\"\n     },\n     "
		  		+ "{\n       \"id\":\"3\",\n       \"rootStep\":false,\n       \"stepType\": \"HANGUP\"\n     }\n   ]\n}\n")
		  .asString();
		
		System.out.println(response.getBody());
	}

}
