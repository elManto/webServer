package HttpServerGiulioTavella;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


// https://www.youtube.com/watch?v=eXv5H2Y_hF4&list=PLTluf9NM53UqFFZQSc51uVbVOBFovqJXX&index=2#t=609.235627341 LINK PER VIDEO
public class Main {

	private static ServerSocket serverSocket;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Server is started");
		serverSocket = new ServerSocket(6543);
		
		while(true)
		{
			
			Socket s = serverSocket.accept();
			ConnectionHandler connectionHandler = new ConnectionHandler(s);
			Thread t = new Thread(connectionHandler);
			t.start();
		}

	}

}
