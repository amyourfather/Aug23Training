package basics;

public class LargeEngine implements IEngine {
	private int CylinderCount;
	
	public LargeEngine() {
		CylinderCount = 8;
	}
	
	public void Start() {
		System.out.println("Large Engine Started");
	}

	public int getCylinderCount() {
		return CylinderCount;
	}
}