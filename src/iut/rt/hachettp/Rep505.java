package iut.rt.hachettp;

/**
 * Le code ci-dessous correspont au code de la classe reponse 505.
 * 
 * @author Alexandre Negrel
 * @date 08/03/2019
 */

public class Rep505 extends Response {

	public Rep505() {
		code = 505;
		msgC = "HTTP VERSION NOT SUPPORTED";
	}

	public byte[] getContenu() {
		 byte[] t = new byte[] {5,5};
		return t;
	}
	
	public void traiter() {
		
	}
}
