
public class Bank {

	private double money;
	private String userID;
	private String passkey;
	
	public Bank(String u, String p){
		userID = u;
		passkey = p;
	}
	
	public void deposit(double amt){
		money += amt;
	}
	
	public void withdraw(double amt){
		money -= amt;
	}
	
	public double inquire(){
		return money;
	}
	
	public String getFormattedAmount(){
		return String.format("$%.2f", money);
	}
	
	public boolean authenticate(String user, String key){
		if(userID.equals(user) && passkey.equals(key)){
			return true;
		} else {
			return false;
		}
	}
	
}
