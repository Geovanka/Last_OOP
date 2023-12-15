package Repository;
import java.util.ArrayList;
import Main.*;
import Models.Team;
import Models.User;

public interface Repository {
	public void find(String Kolom, String[] Kondisi,Boolean Join, String name, Connection conn, ArrayList<User> UserList, ArrayList<Team> TeamList);
	public void findOne(String Kolom, String[] Kondisi,Boolean Join, String name, Connection conn, ArrayList<User> UserList, ArrayList<Team> TeamList);
	public void insert(String[] data, Connection conn, ArrayList<User> UserList, ArrayList<Team> TeamList);
}
