import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public abstract class Trip {
	private String tripID;
	private String companyName;
	private int[] startDate;
	private int[] endDate;
	private String[] sequence;
	
	Map<SeatClass,Section> sections = new HashMap<SeatClass,Section>();
	
	public Trip(String companyName, String[] sequence, int[] startDate, int[] endDate, String tripID){
		this.tripID = tripID;
		this.companyName = companyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sequence = sequence;
	}
	
	public String getID(){
		return this.tripID;
	}
	
	/* Adds a section
	 * If the section already exists an error is displayed */
//	public void addSection(Section section){
//		if(!sections.containsKey(section.getSeatClass())){
//			sections.put(section.getSeatClass(),section);
//		}else{
//			System.err.println("Error: Failed to create section for flight:" + tripID + " on Airline:" + companyName + " class:" + section.getSeatClass().toString() + " already exists");
//		}
//	}
	
	public String getAirline(){
		return this.companyName;
	}
	
	/* throws exception if section doesn't exist */
	public Section getSection(SeatClass s) throws IOException{
		if (sections.get(s) != null){
			return sections.get(s);
		}else{
			throw new IOException();
		}
	}

	
	/* Used by displaySystemDetails() in systemManager
	 * Prints out information for flight and calls getDetails method for each section. */
//	public void getDetails(){
//		System.out.println("   Flight ID : " + this.getID());
//		System.out.println("   Origin : " + this.getOrig());
//		System.out.println("   Destination: " + this.getDest());
//		System.out.println("   Date : " + this.getMonth() + "/" + this.getDay() + "/" + this.getYear());
//		System.out.println("   Sections:");
//		for(Map.Entry<SeatClass, FlightSection> entry : sections.entrySet()){
//			entry.getValue().getDetails();
//		}
//		System.out.println();
//
//	}
//	
//	public Map<SeatClass,Section> getSections(){
//		return sections;
//	}


}
