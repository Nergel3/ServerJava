
package iut.rt.hachettp;

import iut.rt.hachettp.Serveur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import iut.rt.hachettp.MethodeGet;

public class Beta {
	@Test
	public void test1() throws HTTPException{

		String[] reqe = new String[] {
				"GET /index.html HTTP/1.1",
				"Host: localhost", 
				"User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57",
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
				"Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3",
				"Accept-Encoding: gzip, deflate",
				"DNT: 1",
				"Connection: keep-alive",
				"Upgrade-Insecure-Requests: 1", 
				"If-Modified-Since: Fri, 22 Sep 2017 12:26:13 GMT", 
				"Cache-Control: max-age=0"
		};
		
		MethodeGet XZ = new MethodeGet(reqe);
		assertEquals(XZ.getHote(),"localhost");
		assertEquals(XZ.getURL(),"/index.html");
		assertEquals(XZ.getAgent(),"Mozilla/5.0 (X11; Linux x86_64; rv");
	}
	@Test
	public void test2() throws HTTPException{
		boolean thrown = false;
		
		String[] reqe2 = new String[] {
				"GET /index.html HTTP/1.1",
				"Host:", 
				"User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57",
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
				"Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3",
				"Accept-Encoding: gzip, deflate",
				"DNT: 1",
				"Connection: keep-alive",
				"Upgrade-Insecure-Requests: 1", 
				"If-Modified-Since: Fri, 22 Sep 2017 12:26:13 GMT", 
				"Cache-Control: max-age=0"
		};
		try {
		MethodeGet XZ2 = new MethodeGet(reqe2);
		assertEquals(XZ2.getURL(),"/index.html");
		assertEquals(XZ2.getAgent(),"Mozilla/5.0 (X11; Linux x86_64; rv");
		}
		catch (BadReqHTTP e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test
	public void test3() throws HTTPException{
		boolean thrown = false;
		
		String[] reqe3 = new String[] {
				"GET HTTP/1.1",
				"Host: localhost", 
				"User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57",
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
				"Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3",
				"Accept-Encoding: gzip, deflate",
				"DNT: 1",
				"Connection: keep-alive",
				"Upgrade-Insecure-Requests: 1", 
				"If-Modified-Since: Fri, 22 Sep 2017 12:26:13 GMT", 
				"Cache-Control: max-age=0"
		};
		try {
		MethodeGet XZ3 = new MethodeGet(reqe3);
		assertEquals(XZ3.getHote(),"localhost");
		assertEquals(XZ3.getAgent(),"Mozilla/5.0 (X11; Linux x86_64; rv");
		}
		catch (HTTPException e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void test4() throws HTTPException {
		boolean thrown = false;
		
		String[] reqe4 = new String[] {
				"GET /index.html HTTP/1.3",
				"Host: localhost", 
				"User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57",
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
				"Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3",
				"Accept-Encoding: gzip, deflate",
				"DNT: 1",
				"Connection: keep-alive",
				"Upgrade-Insecure-Requests: 1", 
				"If-Modified-Since: Fri, 22 Sep 2017 12:26:13 GMT", 
				"Cache-Control: max-age=0"
		};
		try {
		MethodeGet XZ4 = new MethodeGet(reqe4);
		XZ4.getHote();
		}
		catch (BadVHTTP e){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void test5() throws HTTPException {
		boolean thrown = false;
		
		String[] reqe5 = new String[] {
				"GETT /index.html HTTP/1.1",
				"Host: localhost", 
				"User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57",
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
				"Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3",
				"Accept-Encoding: gzip, deflate",
				"DNT: 1",
				"Connection: keep-alive",
				"Upgrade-Insecure-Requests: 1", 
				"If-Modified-Since: Fri, 22 Sep 2017 12:26:13 GMT", 
				"Cache-Control: max-age=0"
		};
		try {
			MethodeGet XZ5 = new MethodeGet(reqe5);
		XZ5.getHote();
		} catch (HTTPException e) {
			thrown = true;
			System.out.println(e);
		}
		
		assertTrue(thrown);

	}
	
	@Test
	public void test6() {
		
		String[] reqe6 = new String[] {
				"GET /index.html HTTP/1.1",
				"Host: localhost", 
				"User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57",
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
				"Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3",
				"Accept-Encoding: gzip, deflate",
				"DNT: 1",
				"Connection: keep-alive",
				"Upgrade-Insecure-Requests: 1", 
				"If-Modified-Since: Fri, 22 Sep 2017 12:26:13 GMT", 
				"Cache-Control: max-age=0"
		};
		
		MethodeGet XZ6;
		try {
			XZ6 = new MethodeGet(reqe6);
			File f = new File(Serveur.root,XZ6.getURL());
			Rep200 r = new Rep200(f);
			
			assertTrue(XZ6.traiter().getClass().equals(r.getClass()));
		} catch (HTTPException e) {}
	}
	
	@Test
	public void test7() {
		
		String[] reqe7 = new String[] {
				"GET /inde.html HTTP/1.1",
				"Host: localhost", 
				"User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57",
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
				"Accept-Language: fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3",
				"Accept-Encoding: gzip, deflate",
				"DNT: 1",
				"Connection: keep-alive",
				"Upgrade-Insecure-Requests: 1", 
				"If-Modified-Since: Fri, 22 Sep 2017 12:26:13 GMT", 
				"Cache-Control: max-age=0"
		};
		
		MethodeGet XZ7;
		try {
			XZ7 = new MethodeGet(reqe7);
			File f = new File(Serveur.root,XZ7.getURL());
			Rep404 r = new Rep404(f);
			
			assertTrue(XZ7.traiter().getClass().equals(r.getClass()));
		} catch (HTTPException e) {}
	}

	@Test
	public void test8() {
		
			File f = new File(Serveur.root, "inde.html");
			Rep200 r = new Rep200(f);
			String s = new String(r.getContenu());
			String p = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"  <head>\r\n" + 
					"    <title>ERROR 500</title>\r\n" + 
					"    <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/theme.css\">\r\n" + 
					"  </head>\r\n" + 
					"    <body style=\"background-image: none; background-color: white;\">\r\n" + 
					"        <div id=\"d404\">\r\n" + 
					"            <h1>Error 500</h1>\r\n" + 
					"        </div>\r\n" + 
					"    </body>\r\n" + 
					"</html>";
			
			assertEquals(s, p);
	}
	
}