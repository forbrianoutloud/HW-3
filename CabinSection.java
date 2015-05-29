
public class CabinSection extends Section{
	private Class cabinClass;
	public CabinSection(String companyName, String ID, int rows, int cols, Class cabinClass) {
		super(companyName, ID, rows, cols);
		this.cabinClass = cabinClass;
	}
	
	public Class getCabinClass(){
		return cabinClass;
	}
}
