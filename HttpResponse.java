package HttpServerGiulioTavella;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpResponse {
	
	private HttpRequest req;
	public String response;
	private String root = "/Users/giulioTavella/Desktop/FileServer";
	
	public HttpResponse(HttpRequest request) throws IOException
	{
		this.req = request;
		File f = new File(root + this.req.fileName);
		FileInputStream fi = new FileInputStream(f);
		this.response = "HTTP/1.1 200 \r\nServer: Our Java Server/1.0 \r\nContent-Type: text/html \r\nConnection: close \r\nContent-Length: "+f.length()+" \r\n\r\n";
		
		int s ;
		while(( s = fi.read()) != -1) // torna -1 quando finisce le cose da leggere
		{
			this.response += (char) s;
			
		}
		System.out.println(this.response);
		// qyu response ha il valore giusto
		fi.close();
	}

}
