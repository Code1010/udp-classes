import java.net.SocketException;
import java.util.Scanner;


public class Frontend {
	
	
/*
	Let's see if this works.....
*/	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		
		System.out.println("UDPTalk Version 1");
		System.out.println("Welcome. what is your name?");
		System.out.print(">");
		String resp = in.nextLine();
		System.out.printf("Welcome, %s! Are you a client? (Y/n)", resp);
		resp = in.nextLine();
		if(resp.equals("") || resp.equalsIgnoreCase("y")){
			client();
		} else {
			server();
		}
	}
	
	public static void server(){
		Scanner in = new Scanner(System.in);
		UDPServer server = new UDPServer(9137);
		
		while(true){
			if(server.newDataAvailable){
				String n = server.getData();
				System.out.println(n);
			}
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				System.err.println("The thread was sleeping when it suddenly bludgeoned itself to death");
			}
		}
		
	}
	
	public static void client(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the ip address and port number of the server you want to chat with");
		System.out.print("ip>");
		String ip = in.nextLine();
		System.out.print("port>");
		int port = in.nextInt();
		
		UDPClient client = new UDPClient(ip, port);
		
		while(true){
			if(client.newDataAvailable){
				String n = client.getData();
				System.out.println(n);
			}
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				System.err.println("The thread was sleeping when it suddenly bludgeoned itself to death");
			}
		}
	}
}
