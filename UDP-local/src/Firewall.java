
public class Firewall {

	private String password;
	private boolean active;

	public void activate(){
		active = true;
	}
	
	public void deactivate(){
		active = false;
	}
	
	public boolean isActive(){
		return active;
	}
	
	public boolean allowAccess(String passkey){
		if(!active || passkey.equals(password)){
			return true;
		} else {
			return false;
		}
	}

	
	
	
}
