import java.util.HashMap;
import java.util.Map;


public class Ship{
	private String shipID;
	private Map<Class,Section> sections = new HashMap<Class,Section>();
	
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
	public Section getSection(Class c){
		return sections.get(c);
	}
	
	public void displayAvailable(){
		for(Section s : sections.values()){
			s.displayAvailable();
		}
	}
	public Ship clone(){
		Ship cloneShip = new Ship(this.shipID);
		for (Section s : sections.values()){
			cloneShip.addSection(s);
		}
		return cloneShip;
	}
}
