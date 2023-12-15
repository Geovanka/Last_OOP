package Repository;

import java.util.ArrayList;
import Main.*;
import Models.Team;
import Models.User;

public class TeamRepository implements Repository {
//	public  Connection teamlist1 = new Connection();
	public ArrayList<Team> TeamList = new ArrayList<>();
//	public  Connection userlist1 = new Connection();
	public ArrayList<User> UserList = new ArrayList<>();
	@Override
	public void find(String Kolom, String[] Kondisi, Boolean Join, String name, Connection conn, ArrayList<User> UserList, ArrayList<Team> TeamList) {
		this.TeamList = TeamList;
		this.UserList = UserList;
		
		if(Join == true) {
			//if mau display from different table
			if(Kolom.equals("name")) {
				Kolom = "id";
				Kondisi[1] = findIDfromName(Kondisi[1]);
			}else if(Kolom.equals("nim")){
				Kolom = "id";
				Kondisi[1] = findIDfromNIM(Kondisi[1]);
			}
			
			showTeam(Kolom, Kondisi[0], Kondisi[1]);
		}else {
			//if mau display from own table
			showTeam(Kolom, Kondisi[0], Kondisi[1]);
		}
	}

	@Override
	public void findOne(String Kolom, String[] Kondisi, Boolean Join, String name, Connection conn, ArrayList<User> UserList, ArrayList<Team> TeamList) {
		// TODO Auto-generated method stub
		this.TeamList = TeamList;
		this.UserList = UserList;
		
		if(Join == true) {
			//if mau display from different table
			if(Kolom.equals("name")) {
				Kolom = "id";
				Kondisi[1] = findIDfromName(Kondisi[1]);
			}else if(Kolom.equals("nim")){
				Kolom = "id";
				Kondisi[1] = findIDfromNIM(Kondisi[1]);
			}
			
			showTeamOne(Kolom, Kondisi[0], Kondisi[1]);
		}else {
			//if mau display from own table
			showTeamOne(Kolom, Kondisi[0], Kondisi[1]);
		}
	}

	@Override
	public void insert(String[] data, Connection conn, ArrayList<User> UserList, ArrayList<Team> TeamList) {
		// TODO Auto-generated method stub
		this.TeamList = TeamList;
		this.UserList = UserList;
		String ID = data[0];
		String team = data[1];
		Team b = new Team(ID, team);
//        TeamList.add(b);
        
        Connection.writeTeam(ID, team);
	}

	public void showTeam(String column,String searchtype, String target) {
		//shows team table based on criteria
			if(column.equals("team")) {
				System.out.println("|" + String.format("%-7s", "ID") + "|" + String.format("%-35s", "Teamname") + "|");
				for (int a = 0; a<TeamList.size(); a++) {
					if (TeamList.get(a).Teamname.equals(target)) {
	//				System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
					System.out.println("|" + String.format("%-7s", TeamList.get(a).ID) + "|" 
							+ String.format("%-35s", TeamList.get(a).Teamname) + "|");
					}
				}
			}else if(column.equals("id")) {
				System.out.println("|" + String.format("%-7s", "ID") + "|" + String.format("%-35s", "Teamname") + "|");
				for (int a = 0; a<TeamList.size(); a++) {
					if (TeamList.get(a).ID.equals(target)) {
	//				System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
					System.out.println("|" + String.format("%-7s", TeamList.get(a).ID) + "|" 
							+ String.format("%-35s", TeamList.get(a).Teamname) + "|");
					}
				}
			}else {
				System.out.println("Invalid column name!");
			}
	}
	
	public void showTeamOne(String column,String searchtype, String target) {
		//shows team table based on criteria
		if(column.equals("team")) {
			System.out.println("|" + String.format("%-7s", "ID") + "|" + String.format("%-35s", "Teamname") + "|");
			for (int a = 0; a<TeamList.size(); a++) {
				if (TeamList.get(a).Teamname.equals(target)) {
//				System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
				System.out.println("|" + String.format("%-7s", TeamList.get(a).ID) + "|" 
						+ String.format("%-35s", TeamList.get(a).Teamname) + "|");
				break;
				}
			}
		}else if(column.equals("id")) {
			System.out.println("|" + String.format("%-7s", "ID") + "|" + String.format("%-35s", "Teamname") + "|");
			for (int a = 0; a<TeamList.size(); a++) {
				if (TeamList.get(a).ID.equals(target)) {
//				System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
				System.out.println("|" + String.format("%-7s", TeamList.get(a).ID) + "|" 
						+ String.format("%-35s", TeamList.get(a).Teamname) + "|");
				break;
				}
			}
		}else {
			System.out.println("Invalid column name!");
		}
	}
	
	public  String findIDfromName(String team) {
		String ID = null;
		
		for (int i=0; i<UserList.size(); i++) {
			if (UserList.get(i).Username.equals(team)) {
				ID = UserList.get(i).ID;
				break;
			}
		}
		
		if (ID == null) {
			return null;
		}
		
		return ID;
	}
	
	public  String findIDfromNIM(String team) {
		String ID = null;
		
		for (int i=0; i<UserList.size(); i++) {
			if (UserList.get(i).NIM.equals(team)) {
				ID = UserList.get(i).ID;
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
