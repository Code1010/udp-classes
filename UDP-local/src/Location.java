
public class Location {

	private static String[] places = {"Dubai", "China", "Canada", "United States", "The Wuest Residence",
			 "Victor High School", "Canadaigua Academy", "Tokyo", "Kansas", "Timbuktu", "Texas", "New York",
			 "South Carolina", "Jackson Mississippi", "Victor Walmart", "Macedon Public Library",
			 "Papa Jack's", "Your Mom's Basement", "USS Enterprise", "Atlantis", "Auto Zone", "Rochester Institute of Technology",
			 "Zoomtan", "Yotality", "Georgian Bay", "Are 51", "Nuketown, USA", "St. Louis", "Africa",
			 "Neverland", "Bikini Bottom", "Springfield", "A Galaxy Far Far Away", "Gotham", "Metropolis",
			 "Hogwarts"};
	
	public static String getLocation(){
		int index = (int) ((places.length) * Math.random());
		return places[index];
	}
	
}
