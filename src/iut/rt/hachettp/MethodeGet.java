package iut.rt.hachettp;
import java.io.File;
/**
 * Le code ci-dessous correspont au code de la classe MethodeGet.
 * 
 * @author Alexandre Negrel
 * @date 08/03/2019
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodeGet extends Methode {

	private String l_url;
	private String l_hote;
	private String l_agent;
	
	
	public MethodeGet(String[] tab) throws HTTPException {
		analyse(tab);
	}
	
	private void analyse(String[] tab) throws HTTPException {			//Analyse la requête GET si reçu.
		String l;
		String champ;
		String valeur;
		
		analyse_ligne_1(tab[0]);
		
		for(int i = 1; i < tab.length; i++) {
			l = tab[i];
			if(l.length() > 0) {
				Pattern p = Pattern.compile("^[-a-zA-Z]+: *.+ *$");
				Matcher m = p.matcher(l);
				boolean b = m.matches();
				
				if (b == true) {
					
					String[] info = tab[i].split(":");
					champ = info[0];
					valeur = info[1];

					if (champ.equals("Host") == true) {
						
						if (info.length == 2 || info.length == 3) {
							l_hote = valeur.trim();
						} else {
							throw new BadReqHTTP("ERROR 400 Requête mal formée");
						}
					}
					if (champ.equals("User-Agent") == true) {
						
						if (valeur.isEmpty() == false) {
							l_agent = valeur.trim();
						}
						else {
							throw new BadReqHTTP("ERROR 400 Requête mal formée");
						}
					} 
				}
				else {
					System.out.println("Problème 3");
					throw new BadReqHTTP("ERROR 400 Requête mal formée");
					// TODO a finir
				}
			}
			else {
				System.out.println("Problème 4");
				throw new BadReqHTTP("ERROR 400 Requête mal formée");
				// TODO a finir
			}
		}
	}
	
	private void analyse_ligne_1(String ligne) throws HTTPException {			//Analyse la premère ligne de la requête GET.

		String[] nbMot;
		
		nbMot = ligne.split(" ");

		//Première ligne de 3 mot.
		if (nbMot.length != 3) {
			throw new BadReqHTTP("ERROR 400 Requête mal formée");
			// TODO a finir
		}
		//Premier mot == GET
		if (nbMot[0].equals("GET") == false) {
			throw new HTTPException("ERROR 405 METHOD NOT ALLOWED");
			// TODO a finir
		}
		if (nbMot[1].length() == 0) {
			throw new BadReqHTTP("ERROR 400 Requête mal formée");
			// TODO a finir
		}
		else {l_url = nbMot[1];}
		if (nbMot[2].length() == 0) {
			throw new BadReqHTTP("ERROR 400 Requête mal formée");
			// TODO a finir
		}
		if(nbMot[2].split("/")[1].equals("1.0") || nbMot[2].split("/")[1].equals("1.1")){
		}
		else {
			throw new BadVHTTP("ERROR 505 version HTTP non supportée");
			// TODO a finir
		}
	}
		
	public Response traiter() {
		Response r;
		File f = new File(Serveur.root,l_url);
		
		if(!f.exists()) {
			f = new File(Serveur.root, "error404.html");
			r = new Rep404(f);
		} else {
			if (f.isDirectory()){
				f = new File(f, Serveur.defaultFile);
			} if (f.exists()) {
				r = new Rep200(f);
			} else {
				f = new File(Serveur.root, "error404.html");
				r = new Rep404(f);
			}
		}
		return r;
	}

	public String getURL() {
		return l_url;
	}

	public String getHote() {
		return l_hote;
	}
	
	public String getAgent() {
		return l_agent;
	}

}
