import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//Assignment 8 Written by Charlie Quinn Student ID: 951334907
public class Server {	
	private static final int PORT = 1235;
	
	private static ArrayList<String> returnList = new ArrayList<String>();
	private static ArrayList<String> aye = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		aye.add("Server shutting down");
		try {
			InetAddress localHost = InetAddress.getLocalHost();			
			
			ServerSocket serverSocket = new ServerSocket(PORT);

			while (true) {
				Socket socket = null;
				ObjectInputStream inputStream = null;
				ObjectOutputStream outputStream = null;
				try {
		
					socket = serverSocket.accept();
		
					outputStream = new ObjectOutputStream(socket.getOutputStream());
					outputStream.flush();
					
					inputStream = new ObjectInputStream(socket.getInputStream());
					
					boolean running = true;
					while (running) {
						ArrayList<String> message = null;
						try {
							message = (ArrayList<String>) inputStream.readObject();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						
						returnList = primed(message);

						outputStream.writeObject(returnList);
						outputStream.flush();
						running = false;
					}					
				} catch (IOException ex) {
					System.out.println("Socket disconnected with: " + ex);
				} finally {
					outputStream.writeObject(aye);
					if (inputStream != null) {
						inputStream.close();
					}
					if (outputStream != null) {
						outputStream.close();
					}
					if (socket != null) {
						socket.close();
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
	}
	
	private static ArrayList<String> primed(ArrayList<String> li){
		int num;
		for(String i : li)
		{
			num = Integer.valueOf(i);
			if(isPrime(num))
			{
				returnList.add(num+"");
			}
		}
		return returnList;
	}
	
	private static boolean isPrime(int n)
	{
		if(n==2)
		{
			return true;
		}
		if((n % 2)== 0)
		{
			return false;
		}
		for(int i = 3; i*i <= n; i+= 2)
		{
			if (n % i == 0 )
			{
				return false;
			}
		}
		return true;
		
	}
}