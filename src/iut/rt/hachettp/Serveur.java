package iut.rt.hachettp;
/**
 * Le code ci-dessous correspont au code de la classe serveur.
 * 
 * @author Alexandre Negrel
 * @date 27/02/2019
 */

import java.io.IOException;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	private int port; // Port TCP sur lequel le serveur http �coutera.
	static public File root = new File("D:/IUT/POO/public_html");
	static public String defaultFile = "index.html";
	
	public Serveur(int portTCP) {	//Cette m�thode est un constructeur de la classe serveur qui prend en param�tre un entier repr�sentant le port TCP.
		port = portTCP;
	}
	
	public void lance() {	//Lance le serveur WEB
		
		ServerSocket socketS;
		
		try {		//On essaie de cr�er un objet de type ServerSocket.
			socketS = new ServerSocket(port);
		} 
			
		catch(Exception b) {		//Si erreur on sort de la boucle.
			System.out.println("Erreur :" + b);
			return;
		}
			
		while(true) {
			try {
				Socket socketClient = socketS.accept();
				Client client = new Client(socketClient);
				client.traiter();
			}
			
			catch(IOException a) {
				System.out.println("Erreur IO :" + a);
			}
			catch(HTTPException b) {
				System.out.println("Erreur HTTP :" + b);
			}
		}	
	}
}
