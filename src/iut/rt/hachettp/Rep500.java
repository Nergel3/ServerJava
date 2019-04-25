package iut.rt.hachettp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Le code ci-dessous correspont au code de la classe reponse 500.
 * 
 * @author Alexandre Negrel
 * @date 08/03/2019
 */

public class Rep500 extends Response {

	public Rep500(File f) {
		code = 500;
		msgC = "INTERNAL SERVER ERROR";
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
