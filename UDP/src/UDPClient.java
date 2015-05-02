import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class UDPClient implements Runnable {
	
	private int portNum;
	InetAddress serverIP;
	byte[] sendData;
    byte[] receiveData;
    DatagramSocket serverSocket;
    String received = new String();
    boolean newDataAvailable = false;
	
	
	public UDPClient(String ip, int port){
		try {
			serverIP = InetAddress.getByName(ip);
			portNum = port;
			serverSocket = new DatagramSocket();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sendData = new byte[1024];
		receiveData = new byte[1024];
		
		System.out.println("Contacting to Server");
		sendData = "::CONNECT::".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, portNum);
	      try {
			serverSocket.send(sendPacket); //sent the connection message
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	      
		try {
			serverSocket.receive(receivePacket);
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection to server successfully established!");
	}


	public String getData(){
		newDataAvailable = false;
		return received;
	}
	
	public void sendData(String data){
		sendData = data.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, portNum);
	      try {
			serverSocket.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			try {
				serverSocket.receive(receivePacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //waits for a packet to come in

			received = new String(receivePacket.getData());
			newDataAvailable = true;
		}
	}
	
}
