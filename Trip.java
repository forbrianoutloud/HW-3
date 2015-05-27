import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public abstract class Trip {
	private String ID;
	private String companyName;
	private String orig;
	private String dest;
	private int year, month, day;
	
	Map<SeatClass,FlightSection> sections = new HashMap<SeatClass,FlightSection>();
	
	public Trip(String airlineName, String orig, String dest, int year, int month, int day, String flID){
		this.ID = flID;
		this.companyName = airlineName;
		this.orig = orig;
		this.dest = dest;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getID(){
		return this.ID;
	}
	
	/* Adds a section
	 * If the section already exists an error is displayed */
	public void addSection(FlightSection section){
		if(!sections.containsKey(section.getSeatClass())){
			sections.put(section.getSeatClass(),section);
		}else{
			System.err.println("Error: Failed to create section for flight:" + ID + " on Airline:" + companyName + " class:" + section.getSeatClass().toString() + " already exists");
		}
	}
	
	public String getAirline(){
		return this.companyName;
	}
	
	/* throws exception if section doesn't exist */
	public FlightSection getSection(SeatClass s) throws IOException{
		if (sections.get(s) != null){
			return sections.get(s);
		}else{
			throw new IOException();
		}
	}

	public String getOrig() {
		return this.orig;
	}

	public String getDest() {
		return this.dest;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	/* Used by displaySystemDetails() in systemManager
	 * Prints out information for flight and calls getDetails method for each section. */
	public void getDetails(){
		System.out.println("   Flight ID : " + this.getID());
		System.out.println("   Origin : " + this.getOrig());
		System.out.println("   Destination: " + this.getDest());
		System.out.println("   Date : " + this.getMonth() + "/" + this.getDay() + "/" + this.getYear());
		System.out.println("   Sections:");
		for(Map.Entry<SeatClass, FlightSection> entry : sections.entrySet()){
			entry.getValue().getDetails();
		}
		System.out.println();

	}
	
	public Map<SeatClass,FlightSection> getSections(){
		return sections;
	}


}
