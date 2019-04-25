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

	private Socket socket;		//Donn�e membre socket du client.
	private BufferedReader BR;	//Flux entrant pour lire.
	private BufferedWriter BW;	//Flux sortant pour �crire.
	private Requete la_requete; //Objet de la classe requete. 

	public Client(Socket socketClient) throws HTTPException {	
		
		// Donn�es membres permettants la lecture du socket client.
		
		InputStream IS ; 
		InputStreamReader ISR; 
		
		//Donn�es membres permettants l'�criture du socket client.
		
		OutputStream OS; 
		OutputStreamWriter OSW;
		
		
		//On teste l'acc�s lecture au socket et on g�n�re une exception si l'acc�s est impossible.
		
		socket = socketClient;
		
		la_requete = new Requete();	
		
		try {
			ISR = new InputStreamReader(socket.getInputStream());
			BR = new BufferedReader(ISR);
		} 
		
		catch (IOException error) {
			throw new HTTPException("Acc�s lecture au socket impossible : " + error.getMessage());
		}
		
		//On teste l'acc�s �criture au socket et on g�n�re une exception si l'acc�s est impossible.
		
		try {
			OSW = new OutputStreamWriter(socket.getOutputStream());
			BW = new BufferedWriter(OSW);
		} 
		
		catch (IOException error) {
			throw new HTTPException("Acc�s �criture au socket impossible : " + error.getMessage());
		}
	}
	
	public  void traiter() throws HTTPException {
		
		System.out.println("traitement du client");
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
			throw new HTTPException("Acc�s lecture au socket impossible : " + error.getMessage());
		}
	}
	
	private void envoi(Response r) throws HTTPException {
		
		String newLine = System.getProperty("line.separator");
		
		try {
			OutputStreamWriter OSW;
			
			OSW = new OutputStreamWriter(socket.getOutputStream());
			BW = new BufferedWriter(OSW);
			
			String rep;
			String contenu = new String(r.getContenu());
			int lengthRep = contenu.length();
			
			rep = r.toString() + lengthRep + newLine + contenu;
			System.out.println(rep);
			BW.write(contenu);
			
			//OSW.close();
			//BW.close();
			liberation();
		} 
		
		catch (IOException error) {
			throw new HTTPException("Acc�s �criture au socket impossible : " + error.getMessage());
		}
	}
	
	private void liberation() {
		try {
			socket.close();
			System.out.println("Fini");
		} catch (IOException e) {
			
		}
	}
}
