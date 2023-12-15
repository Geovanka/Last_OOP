package Models;
import Main.*;

public class User extends Model{
	public String NIM;
	public String Username;
	
	//override
	public String toString(String NIM, String Username, String ID) {
		
		return "ID : " + ID + "\nNIM : " + NIM + "\nUsername : " + Username + "\n";
	}
	
	public User(String NIM, String Username, String ID) {
		super(ID);
		this.NIM = NIM;
		this.Username = Username;
	}
	public String getUsername() {
		return Username;
	}
	
	public String getNIM() {
		return NIM;
	}
	
}
