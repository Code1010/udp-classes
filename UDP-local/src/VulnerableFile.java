
public class VulnerableFile {

	private String name;
	private String data;
	private String location;
	
	public VulnerableFile(String n, String d, String l){
		name = n;
		data = d;
		setLocation(l);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
