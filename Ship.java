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
		if(!sections.containsKey(section.getclass())){
			sections.put(section.getclass(), section);
		}else{
			System.err.println("Error, Section already exists withing ship");
		}
	}
	public Section getSection(Class c){
		return sections.get(c);
	}
	

	public Map<Class,Section> getSections(){
		return sections;
	}
}
