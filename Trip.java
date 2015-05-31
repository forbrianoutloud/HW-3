import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public abstract class Trip {
	private String tripID;
	private String companyName;
	private int[] startDate;
	private int[] endDate;
	private String[] portSequence;
	private Map<Class,Section> sections = new HashMap<Class,Section>();
	
	public Trip(String companyName, String[] sequence, int[] startDate, int[] endDate, String tripID){
		this.tripID = tripID;
		this.companyName = companyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.portSequence = sequence;
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
	
	public String getCompany(){
		return this.companyName;
	}
	
	/* throws exception if section doesn't exist */
	public Section getSection(Class s) throws IOException{
		if (sections.get(s) != null){
			return sections.get(s);
		}else{
			throw new IOException();
		}
	}
	
	public void diplayDetails(){
		System.out.println("    Trip ID: " + tripID);
		System.out.print("      Route - ");
		int i = 0;
		for(i = 0; i < portSequence.length - 1;i++){
			System.out.print(portSequence[i] + " -> " );
		}
		System.out.println(portSequence[i]);
		
		System.out.print("      StartDate: ");
		for(i = 0; i < startDate.length -1; i++){
			System.out.print(startDate[i] + "/");
		}
		System.out.println(startDate[i]);
		
		System.out.print("      endDate: ");
		for(i = 0; i < endDate.length -1; i++){
			System.out.print(endDate[i] + "/");
		}
		System.out.println(endDate[i]);
		
		System.out.println("      Sections:");
		for(Section section : sections.values()){
			System.out.println("       " + section.getclass());
			section.diplayDetails();
		}
	}
	
	public void findAvailable(){
		int i;
		System.out.println("    Trip ID: " + tripID);
		System.out.print("    StartDate: ");
		for(i = 0; i < startDate.length -1; i++){
			System.out.print(startDate[i] + "/");
		}
		System.out.println(startDate[i]);
		
		System.out.print("    endDate: ");
		for(i = 0; i < endDate.length -1; i++){
			System.out.print(endDate[i] + "/");
		}
		System.out.println(endDate[i]);
		
		System.out.println("      Sections:");
		for(Section section : sections.values()){
			System.out.println("       " + section.getclass());
			section.findAvailable();
		}
	}
	
	public Map<Class,Section> getSections(){
		return sections;
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
