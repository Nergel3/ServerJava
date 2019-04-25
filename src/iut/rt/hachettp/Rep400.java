package iut.rt.hachettp;

/**
 * Le code ci-dessous correspont au code de la classe reponse 404.
 * 
 * @author Alexandre Negrel
 * @date 08/03/2019
 */

public class Rep400 extends Response {

	public Rep400() {
		code = 400;
		msgC = "BAD REQUEST";
	}

	public byte[] getContenu() {
		 byte[] t = new byte[] {5,5};
		return t;
	}
	
	public void traiter() {
		
	}
}
