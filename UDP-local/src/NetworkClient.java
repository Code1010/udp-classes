
public class NetworkClient {
	
	UDPClient client;
	Bank bank;
	
	public NetworkClient(String ip, int port){
		client = new UDPClient(ip, port);
	}
	
	public NetworkClient(UDPClient client, Bank b){
		this.client = client;
		bank = b;
	}
	
	public void update(){ //called iteratively by the game loop network thread
		if(client.newDataAvailable){
			interpret(client.getData());
		}
	}
	
	private void interpret(String data){
		data = data.substring(2);
		String cmd = data.substring(0, data.indexOf("::"));
		if(cmd.equals("HELLO")){
			hello(cmd.substring(cmd.indexOf("::") + 2, cmd.length()));
		} else if(cmd.equals("BANK")){
			String op = cmd.substring(cmd.indexOf("::"), cmd.indexOf("["));
			String command = cmd.substring(cmd.indexOf("[") + 1, cmd.indexOf("]"));
			bank(op, command);
		}
	}

	private void bank(String op, String param){
		if(op.equals("w")){ //withdraw
			bank.withdraw(Double.valueOf(param));
		} else if(op.equals("d")) { //deposit
			bank.withdraw(Double.valueOf(param));
		} else if(op.equals("bankrupt")){
			//THE OTHER PLAYER IS DEAD!
			//you win!
		}
	}
	
	private void hello(String param){
		if(param.equals("kill"))
			System.err.println("The connection was terminated, or the server could not be found");
		else 
			System.err.println("The connection was established");
	}
	
}
