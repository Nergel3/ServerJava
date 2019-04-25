package iut.rt.hachettp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Le code ci-dessous correspont au code de la classe serveur.
 * 
 * @author Alexandre Negrel
 * @date 27/02/2019
 */


public class Client {

	private Socket socket;		//Donnï¿½e membre socket du client.
	private BufferedReader BR;	//Flux entrant pour lire.
	private BufferedWriter BW;	//Flux sortant pour ï¿½crire.
	private Requete la_requete; //Objet de la classe requete. 

	public Client(Socket socketClient) throws HTTPException {	
		
		// Donnï¿½es membres permettants la lecture du socket client.
		
		InputStream IS ; 
		InputStreamReader ISR; 
		
		//Donnï¿½es membres permettants l'ï¿½criture du socket client.
		
		OutputStream OS; 
		OutputStreamWriter OSW;
		
		
		//On teste l'accï¿½s lecture au socket et on gï¿½nï¿½re une exception si l'accï¿½s est impossible.
		
		socket = socketClient;
		
		la_requete = new Requete();	
		
		try {
			ISR = new InputStreamReader(socket.getInputStream());
			BR = new BufferedReader(ISR);
		} 
		
		catch (IOException error) {
			throw new HTTPException("Accï¿½s lecture au socket impossible : " + error.getMessage());
		}
		
		//On teste l'accï¿½s ï¿½criture au socket et on gï¿½nï¿½re une exception si l'accï¿½s est impossible.
		
		try {
			OSW = new OutputStreamWriter(socket.getOutputStream());
			BW = new BufferedWriter(OSW);
		} 
		
		catch (IOException error) {
			throw new HTTPException("Accï¿½s ï¿½criture au socket impossible : " + error.getMessage());
		}
	}
	
	
	//Traitement du client. Appel d'autre methode --> lecture et analyse de la requête puis envoi la réponse correspondante.
	
	public  void traiter() throws HTTPException {
		
		try {
			lecture_requete();
			la_requete.traiter();
			envoi(la_requete.reponse);
			liberation();
		}
		catch (IOException error) {
			System.out.println(error);
		}
	}
	
	//Lecture du socket, de la requête.
	
	public void lecture_requete() throws HTTPException, IOException {
		String ligne;
			
		try {
			InputStreamReader ISR; 
			
			ISR = new InputStreamReader(socket.getInputStream());
			BR = new BufferedReader(ISR);
			
			while (la_requete.estPrete() == false) {
				ligne = BR.readLine();				
				la_requete.ajouteLigne(ligne);
			}
		} 
		catch (IOException error) {
			System.out.println("err acc socket " + error);
			throw new HTTPException("Accï¿½s lecture au socket impossible : " + error.getMessage());
		}
	}
	
	//Envoie de la réponse sur le socket.
	
	private void envoi(Response r) throws HTTPException {
		
		String newLine = System.getProperty("line.separator");
		
		try {
			OutputStreamWriter OSW;
			
			OSW = new OutputStreamWriter(socket.getOutputStream());
			BW = new BufferedWriter(OSW);
			
			String rep;
			String contenu = new String(r.getContenu());
			byte[] lengthRep = contenu.getBytes();
			
			rep = r.toString() + lengthRep.length + newLine + newLine + contenu;
			BW.write(rep);
			BW.flush();

			liberation();
		} 
		
		catch (IOException error) {
			throw new HTTPException("Accï¿½s ï¿½criture au socket impossible : " + error.getMessage());
		}
	}
	
	//Libération du socket
	
	private void liberation() {
		try {
			socket.close();
		} catch (IOException e) {
			
		}
	}
}
