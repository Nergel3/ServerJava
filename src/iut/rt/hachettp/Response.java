package iut.rt.hachettp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Le code ci-dessous correspont au code de la classe Response.
 * 
 * @author Alexandre Negrel
 * @date 08/03/2019
 */

public  abstract class Response {
	protected int code;
	protected String msgC;
	protected String[] rep;
	protected File page;
	
	//Renvoie sous forme de String l'en-tête de la reponse
	
	public String toString() {
		
		SimpleDateFormat dateFormat;
		Date dateD;
		String date;
		String newLine = System.getProperty("line.separator");
		
		
		 String msg = "HTTP/1.1 " + code + " " + msgC; 
		 dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
		 dateD = new Date();
		 
		 date = dateFormat.format(dateD);
		 
		 msg = msg + newLine +"Date: " + date + newLine +"Server: HacheTTP" + newLine + "Content-Type: text/html; charset=UTF-8" + newLine + "Content-Length: ";
		 return msg;
		 
	}
	 
	public abstract byte[] getContenu() throws IOException;
	
}
