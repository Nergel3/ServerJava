package iut.rt.hachettp;
import java.io.File;
import java.util.Vector;

/**
 * Le code ci-dessous correspont au code de la classe Requete.
 * 
 * @author Alexandre Negrel
 * @date 27/02/2019
 */


public class Requete {
	
	private Methode la_methode;
	private Vector<String> stockage = new Vector<String>();
	boolean pret = false;
	public Response reponse;

	public Requete() {
		
	}
	
	//Stock les lignes dans la données membre stockage et confirme que la requete est prête
	
	public void ajouteLigne(String ligne) throws HTTPException {
		if (ligne.length() != 0) {
			stockage.addElement(ligne);
			pret = false;
		} 
		else {
			pret = true;
			determineMethode(stockage);
		}	
	}
	
	//Determine la methode de la requete
	
	private void determineMethode(Vector<String> v) {
		String req = v.get(0); 
		String[] tab = v.toArray(new String[v.size()]);
		
		if (req.split(" ")[0].equals("GET")) {
			try {
			MethodeGet meth = new MethodeGet(tab);
			la_methode = meth;
			} catch (HTTPException e) {
				System.out.println(e);
				// TODO something...
			}
			
		} else {
			File f = new File(Serveur.root, "error405.html");
			reponse = new Rep405(f);
		}
	}
	
	//Renvoie si la requete est prete ou non
	
	public boolean estPrete() {
		return pret;
	}
	
	//Change la donnée reponse selon ce que renvoie le traitement de la methode.
	
	public void traiter() {
		reponse = la_methode.traiter(); 
	}

}
