package iut.rt.hachettp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Rep405 extends Response {

	public Rep405(File f) {
		code = 405;
		msgC = "METHOD NOT ALLOWED";
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
