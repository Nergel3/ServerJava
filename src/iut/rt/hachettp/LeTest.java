package iut.rt.hachettp;

public class LeTest {

	public LeTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Serveur s = new Serveur(8081);

		s.lance();
	}
}
