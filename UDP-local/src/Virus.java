
public class Virus {
	private String name;
	private String description;
	private int destruction;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Virus(String n, String d){
		name = n;
		description = d;
	}

	public int getDestruction() {
		return destruction;
	}

	public void setDestruction(int destruction) {
		this.destruction = destruction;
	}
	
}
