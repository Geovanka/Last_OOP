package Repository;

import java.util.ArrayList;
import Main.*;
import Models.Team;
import Models.User;

public class UserRepository implements Repository {

//	public  Connection teamlist1 = new Connection();
	public  ArrayList<Team> TeamList = new ArrayList<>();
//	public  Connection userlist1 = new Connection();
	public  ArrayList<User> UserList = new ArrayList<>();
	
	public void find(String Kolom, String[] Kondisi, Boolean Join, String name, Connection conn, ArrayList<User> UserList, ArrayList<Team> TeamList) {
		this.TeamList = TeamList;
		this.UserList = UserList;
		//print user yang valid
		if(Join == true) {
			//if mau display from different table
			Kolom = "id";
			Kondisi[1] = findID(Kondisi[1]);
			showUser(Kolom, Kondisi[0], Kondisi[1], conn);
		}else {
			//if mau display from own table
			showUser(Kolom, Kondisi[0], Kondisi[1], conn);
		}
		
	}
	
	@Override
	public void findOne(String Kolom, String[] Kondisi, Boolean Join, String name, Connection conn, ArrayList<User> UserList, ArrayList<Team> TeamList) {
		// TODO Auto-generated method stub
		this.TeamList = TeamList;
		this.UserList = UserList;
		
		//print user yang valid
		if(Join == true) {
			//if mau display from different table
			Kolom = "id";
			Kondisi[1] = findID(Kondisi[1]);
			showUserOne(Kolom, Kondisi[0], Kondisi[1], conn);
		}else {
			//if mau display from own table
			showUserOne(Kolom, Kondisi[0], Kondisi[1], conn);
		}
	}

	public void insert(String[] data, Connection conn, ArrayList<User> UserList, ArrayList<Team> TeamList) {
		// TODO Auto-generated method stub
		this.TeamList = TeamList;
		this.UserList = UserList;
		String name = data[0];
		String nim = data[1];
		String ID = getID();
		
		User a = new User(nim, name, ID);
//        UserList.add(a);
        
		Connection.writeUser(nim, name, ID);
	}

	public void showUser(String column,String searchtype, String target, Connection conn) {
		//shows user table based on criteria
		if(column.equals("name")) {
		System.out.println("|" + String.format("%-10s", "NIM") + "|" + String.format("%-35s", "Username") + "|"
				+ String.format("%-7s", "ID") + "|");
		for (int a = 0; a<UserList.size(); a++) {
			if (UserList.get(a).Username.equals(target)) {
//			System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
			System.out.println("|" + String.format("%-10s", UserList.get(a).NIM) + "|" 
					+ String.format("%-35s", UserList.get(a).Username) + "|"
					+ String.format("%-7s", UserList.get(a).ID) + "|");
			}
		}
		}else if(column.equals("nim")) {
			System.out.println("|" + String.format("%-10s", "NIM") + "|" + String.format("%-35s", "Username") + "|"
					+ String.format("%-7s", "ID") + "|");
			for (int a = 0; a<UserList.size(); a++) {
				if (UserList.get(a).NIM.equals(target)) {
//				System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
				System.out.println("|" + String.format("%-10s", UserList.get(a).NIM) + "|" 
						+ String.format("%-35s", UserList.get(a).Username) + "|"
						+ String.format("%-7s", UserList.get(a).ID) + "|");
				}
			}
			
		}else if(column.equals("id")) {
			System.out.println("|" + String.format("%-10s", "NIM") + "|" + String.format("%-35s", "Username") + "|"
					+ String.format("%-7s", "ID") + "|");
			for (int a = 0; a<UserList.size(); a++) {
				if (UserList.get(a).ID.equals(target)) {
//				System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
				System.out.println("|" + String.format("%-10s", UserList.get(a).NIM) + "|" 
						+ String.format("%-35s", UserList.get(a).Username) + "|"
						+ String.format("%-7s", UserList.get(a).ID) + "|");
				}
			}
			
		}else {
			System.out.println("Invalid column name!");
		}
	}
	
	public void showUserOne(String column,String searchtype, String target, Connection conn) {
		//shows user table based on criteria
		if(column.equals("name")) {
		System.out.println("|" + String.format("%-10s", "NIM") + "|" + String.format("%-35s", "Username") + "|"
				+ String.format("%-7s", "ID") + "|");
		for (int a = 0; a<UserList.size(); a++) {
			if (UserList.get(a).Username.equals(target)) {
//			System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
			System.out.println("|" + String.format("%-10s", UserList.get(a).NIM) + "|" 
					+ String.format("%-35s", UserList.get(a).Username) + "|"
					+ String.format("%-7s", UserList.get(a).ID) + "|");
			break;
			}
		}
		}else if(column.equals("nim")) {
			System.out.println("|" + String.format("%-10s", "NIM") + "|" + String.format("%-35s", "Username") + "|"
					+ String.format("%-7s", "ID") + "|");
			for (int a = 0; a<UserList.size(); a++) {
				if (UserList.get(a).NIM.equals(target)) {
//				System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
				System.out.println("|" + String.format("%-10s", UserList.get(a).NIM) + "|" 
						+ String.format("%-35s", UserList.get(a).Username) + "|"
						+ String.format("%-7s", UserList.get(a).ID) + "|");
				break;
				}
			}
			
		}else if(column.equals("id")) {
			System.out.println("|" + String.format("%-10s", "NIM") + "|" + String.format("%-35s", "Username") + "|"
					+ String.format("%-7s", "ID") + "|");
			for (int a = 0; a<UserList.size(); a++) {
				if (UserList.get(a).ID.equals(target)) {
//				System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
				System.out.println("|" + String.format("%-10s", UserList.get(a).NIM) + "|" 
						+ String.format("%-35s", UserList.get(a).Username) + "|"
						+ String.format("%-7s", UserList.get(a).ID) + "|");
				break;
				}
			}
			
		}else {
			System.out.println("Invalid column name!");
		}
	}
	
	public String findID(String team) {
		String ID = null;
		
		for (int i=0; i<TeamList.size(); i++) {
			if (TeamList.get(i).Teamname.equals(team)) {
				ID = TeamList.get(i).ID;
				break;
			}
		}
		
		if (ID == null) {
			return null;
		}
		
		return ID;
	}
	
	public  String getID() {
		String old = TeamList.get(TeamList.size() - 1).ID;
		int temp = Integer.parseInt(old);
		String neo = Integer.toString(temp);
		return neo;
	}


}
