package HttpServerGiulioTavella;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
	
	private Socket s;
	private PrintWriter pw; // utilizzato per mandare l'output al client
	private BufferedReader br; // utilizzato per prendere l'input dal client
	
	public ConnectionHandler(Socket s)
	{
		this.s = s;
		
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void run() {
		try {
		String reqS = "";
		
		
			while(br.ready() || reqS.length() == 0)
			{
				reqS += (char) br.read();
				
			}
			
		
		
		
			HttpRequest req = new HttpRequest(reqS);
		
			HttpResponse res = new HttpResponse(req);
			
			
			System.out.println(res.response.toCharArray());
			this.pw.write(res.response.toCharArray());
			this.pw.close();
			br.close();
			s.close();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
