
public class NetworkClient {
	
	UDPClient client;
	
	public NetworkClient(String ip, int port){
		client = new UDPClient(ip, port);
	}
	
	public NetworkClient(UDPClient client){
		this.client = client;
	}
	
	public void update(){ //called iteratively by the game loop network thread
		if(client.newDataAvailable){
			interpret(client.getData());
		}
	}
	
	private void interpret(String data){
		
	}
	
}
