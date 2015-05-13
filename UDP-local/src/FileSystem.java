import java.util.ArrayList;

public class FileSystem {
	ArrayList<VulnerableFile> files = new ArrayList<VulnerableFile>();
	
	public void addFile(VulnerableFile f){
		files.add(f);
	}
	
	public void addFile(String name, String data, String location){
		files.add(new VulnerableFile(name, data, location));
	}
	
	public VulnerableFile getFile(int index){
		if((index < files.size()) && (index >= 0)){
			return files.get(index);
		} else {
			return null;
		}
	}
	
	public ArrayList<VulnerableFile> getAllFiles(){
		return files;
	}
	
	public String getFileContents(VulnerableFile f){
		for(VulnerableFile v : files){
			if(v.getName().equals(f.getName())){
				return v.getData();
			}
		}
		return "";
	}
	
	public String getFileContents(int index) {
		return files.get(index).getData();
	}
	
}
