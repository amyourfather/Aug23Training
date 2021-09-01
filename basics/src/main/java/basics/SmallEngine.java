package basics;

public class SmallEngine implements IEngine {

private int CylinderCount;
	
	public SmallEngine() {
		CylinderCount = 4;
	}
	
	public void Start() {
		System.out.println("Small Engine Started");
	}

	public int getCylinderCount() {
		return CylinderCount;
	}
}