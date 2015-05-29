
public class CabinSection extends Section{
	private CabinClass cabinClass;
	public CabinSection(String companyName, String ID, int rows, int cols, CabinClass cabinClass) {
		super(companyName, ID, rows, cols);
		this.cabinClass = cabinClass;
	}
	
	public CabinClass getCabinClass(){
		return cabinClass;
	}
}
