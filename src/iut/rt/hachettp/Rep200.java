package iut.rt.hachettp;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Le code ci-dessous correspont au code de la classe reponse 200.
 * 
 * @author Alexandre Negrel
 * @date 08/03/2019
 */

public class Rep200 extends Response {

	public Rep200(File f) {
		code = 200;
		msgC = "OK";
		page = f;
	}

	public byte[] getContenu() {
		byte[] fileContent;
		try {
			fileContent = Files.readAllBytes(page.toPath());
			return fileContent;
		} catch (IOException e) {
			System.out.println("ICIxcwc");
			File f = new File(Serveur.root, "error500.html");
			Rep500 repErr = new Rep500(f);
			return repErr.getContenu();
		}
	}
}
