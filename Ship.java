import java.util.HashMap;
import java.util.Map;


public class Ship {
	private String shipID;
	private Map<CabinClass,Section> sections = new HashMap<CabinClass,Section>();
	public Ship(String shipID){
		this.shipID = shipID;
	}
	
	public String getShipID(){
		return shipID;
	}
	public void addSection(Section section){
		if(!sections.containsKey(((CabinSection) section).getCabinClass())){
			sections.put(((CabinSection) section).getCabinClass(), section);
		}else{
			System.err.println("Error, Section already exists withing ship");
		}
	}
	public Section getSection(CabinClass c){
		return sections.get(c);
	}
	
	public void displayAvailable(){
		for(Section s : sections.values()){
			s.displayAvailable();
		}
	}
}
