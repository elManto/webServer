package HttpServerGiulioTavella;

public class HttpRequest {
	
	public String fileName;
	
	public HttpRequest(String request)
	{
		String lines[] = request.split("\n");
		lines = lines[0].split(" ");
		//this.fileName = lines[1];
		this.fileName = "/ciao.html";
		
	}

}
