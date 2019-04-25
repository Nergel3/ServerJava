package iut.rt.hachettp;
import java.io.File;
/**
 * Le code ci-dessous correspont au code de la classe Requete.
 * 
 * @author Alexandre Negrel
 * @date 27/02/2019
 */
import java.util.Vector;

public class Requete {
	
	private Methode la_methode;
	private Vector<String> stockage = new Vector<String>();
	boolean pret = false;
	public Response reponse;

	public Requete() {
		
	}
	
	public void ajouteLigne(String ligne) throws HTTPException {
		//System.out.println(ligne.length());
		if (ligne.length() != 0) {
			stockage.addElement(ligne);
			pret = false;
		} 
		else {
			pret = true;
			determineMethode(stockage);
		}	
	}

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
	
	public boolean estPrete() {
		return pret;
	}
	
	public void traiter() {
		reponse = la_methode.traiter(); 
	}

}
