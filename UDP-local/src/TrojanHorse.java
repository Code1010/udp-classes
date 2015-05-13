
public class TrojanHorse extends Virus{

	private Email email;
	
	public TrojanHorse(String n, String d, Email eml) {
		super(n, d);
		email = eml;
	}
	
}
