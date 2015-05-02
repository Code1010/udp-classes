import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;


public class UDPServer implements Runnable {

	private int portNum;
	private String ip;
	byte[] receiveData;
	byte[] sendData;
	DatagramSocket serverSocket;
	InetAddress clientIP;
	int clientPort;
	
	boolean newDataAvailable = false;
	String received = new String();
	
	
	public UDPServer(int port) throws SocketException{
		//find your IP
		try {
			Socket s = new Socket("google.com", 80);
			ip = (s.getLocalAddress().getHostAddress());
			s.close();
			s = null;
		} catch (IOException e) {
			System.err.println("The internets are broken!");
		}
		
		System.err.printf("<<IP ADDRESS: %s>>", ip);
		portNum = port;

			serverSocket = new DatagramSocket(portNum);
		
	    receiveData = new byte[1024];
	    sendData = new byte[1024];
		
	    
	    System.out.println("Server Running");
	    run();
	}

	public String getData(){
		newDataAvailable = false;
		return received;
	}
	
	public void sendData(String data){
		
        try {
        	sendData = data.getBytes();
    		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
			serverSocket.send(sendPacket);
		} catch (IOException e) {
			System.err.println("The datagram just took a massive dump!");
		}
	}
	
	@Override
	public void run() {
		
		while(true){
			
            try {
            	DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket); //waits for a packet to come in

				received = new String(receivePacket.getData());
				newDataAvailable = true;
				if(received.equals("::CONNECTED::")){
					newDataAvailable = false;
					received = "";
					sendData = "::HELLO::".getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, portNum);
				      try {
						serverSocket.send(sendPacket);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				clientIP = receivePacket.getAddress();
                clientPort = receivePacket.getPort();

			} catch (IOException e) {
				System.err.println("Something went horribly wrong when trying to receive data");
			}
		}
		
	}
	
}
