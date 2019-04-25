package iut.rt.hachettp;

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
