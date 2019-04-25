package iut.rt.hachettp;

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
