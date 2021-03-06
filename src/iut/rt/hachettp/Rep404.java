package iut.rt.hachettp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Le code ci-dessous correspont au code de la classe reponse 404.
 * 
 * @author Alexandre Negrel
 * @date 08/03/2019
 */

public class Rep404 extends Response {

	public Rep404(File f) {
		code = 404;
		msgC = "NOT FOUND";
		page = f;
	}

	public byte[] getContenu() {
		byte[] fileContent;
		try {
			fileContent = Files.readAllBytes(page.toPath());
			return fileContent;
		} catch (IOException e) {
			return null;
		}
	}
	
	public void traiter() {
		
	}
}
