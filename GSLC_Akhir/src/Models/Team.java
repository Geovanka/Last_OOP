package Models;
import Main.*;

public class Team extends Model {
	public String Teamname;
	public String toString(String ID, String Teamname) {
		
		return "ID : " + ID + "\nName : " + Teamname + "\n";
	}
	
	public Team(String ID, String Teamname) {
		super(ID);
		this.Teamname = Teamname;
	}
	public String getTeamname() {
		return Teamname;
	}
	
}
