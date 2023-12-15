package Models;
import Main.*;

public class Model {
	public String ID;
	
	//override
	public String toString(String ID) {
		
		return "ID : " + ID + "\n";
	}

	public Model(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}
	
}
