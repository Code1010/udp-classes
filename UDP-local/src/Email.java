
public class Email {

	private String sender;
	private String subject;
	private String message;
	private Virus v;
	
	public Email(String from, String sub, String msg, Virus v){
		sender = from;
		subject = sub;
		message = msg;
		this.v = v;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
