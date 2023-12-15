package Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import Models.*;
import Repository.*;

import Models.Team;
import Models.User;

public class Main {
	public static  Connection teamlist1 = new Connection();
	public static  ArrayList<Team> TeamList = teamlist1.readTeam();
	public static Connection userlist1 = new Connection();
	public static ArrayList<User> UserList = userlist1.readUser();
//	public  ArrayList <User> UserList = new ArrayList<>();
//	public  ArrayList <Team> TeamList = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		Menu();
		// PAKE PASSING ARRAY LIST --------------------------------------------------------------------

		
		// PAKE PASSING ARRAY LIST --------------------------------------------------------------------
		
//		for (int a = 0; a<UserList.size(); a++) {
//			System.out.println(UserList.get(a).NIM + UserList.get(a).Username + UserList.get(a).ID);
//		}
		
//		for (int a = 0; a<TeamList.size(); a++) {
//			System.out.println(TeamList.get(a).ID + TeamList.get(a).Teamname);
//		}
	 }
	
	public static void Menu() {
		int select = 0;
		
		do {			
			System.out.println("Hackathon Team Management");
			System.out.println("1. Menu Utama");
			System.out.println("2. Insert Data");
			System.out.println("3. Show");
			System.out.println("4. Exit");
			System.out.printf("Menu selection >> ");
			try {
				select = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid Input");
			}
			
			switch (select) {
			case 1:
				System.out.flush();
				break;
			case 2:
				insert();
				break;
			case 3:
				show();
				break;
			}
			
		} while (select != 4);
	}
	
	public static void insert() {
		int input = 0;
		String name;
		String nim;
		String team;
		
		do {
			System.out.println("Which table to insert?");
			System.out.println("1. User");
			System.out.println("2. Team");
			System.out.printf("Enter selection >> ");
			try {
				input = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid Input");
			}
			
			// USER MAU DIINSERT
			if (input == 1) {
				System.out.println("add name: ");
				name = sc.nextLine();
				System.out.println("add nim: ");
				nim = sc.nextLine();
				System.out.println("add team: ");
				team = sc.nextLine();
				
				String ID = getID();
				// USER DAN TEAM BARU
				String[] dataT = null;
			    String[] dataU = null;
			    String bee = name + ";" + nim + ";" + team;
			    String hive = ID + ";" + team;
			        
		        dataU = bee.split(";");
		        dataT = hive.split(";");
			        
				if (!findTeam(team)) {
					
					String temp = Integer.toString(TeamList.size());
					Team b = new Team(ID, team);
			        TeamList.add(b);
					User a = new User(nim, name, ID);
			        UserList.add(a);
			        
			        // WRITE
			        UserRepository userRepository = new UserRepository();
					userRepository.insert(dataU, userlist1, UserList, TeamList);
			        TeamRepository teamRepository = new TeamRepository();
					teamRepository.insert(dataT, teamlist1, UserList, TeamList);
			        System.out.println("User & team created!");
//			        Connection.writeUser(nim, name, ID);
//			        Connection.writeTeam(ID, team);
			        System.out.println("Data written to CSV file successfully.");
			    // TEAM IS FULL
				} else if (count(findID(team)) >= 3) {
					System.out.println("Error: Team Full");
				// USER BARU TEAM LAMA
				} else {
					User a = new User(nim, name, findID(team));
			        UserList.add(a);
					UserRepository userRepository2 = new UserRepository();
					userRepository2.insert(dataU, userlist1, UserList, TeamList);
					
			        System.out.println("User created!");
			        // WRITE
//			        Connection.writeUser(nim, name, findID(team));
			        System.out.println("Data written to CSV file successfully.");
				}
				
			// TEAM BARU MAU DIINSERT
			} else if (input == 2){
				String teamname1 = null;
				System.out.println("add teamname: ");
				teamname1 = sc.nextLine();
//				String temp1 = Integer.toString(TeamList.size());
//				Team c = new Team(temp1, teamname);
//				TeamList.add(c);
			
				if(!findTeam(teamname1)) {
//					String teamname1 = null;
//					System.out.println("add teamname: ");
//					teamname1 = sc.nextLine();
					String temp11 = Integer.toString(TeamList.size());
					Team c1 = new Team(temp11, teamname1);
					TeamList.add(c1);
					String[] dataT = null;
					String ID = Integer.toString(TeamList.size());
			        String aa = ID + ";" + teamname1;
			        dataT = aa.split(";");
			        
					
			        TeamRepository teamRepository2 = new TeamRepository();
					teamRepository2.insert(dataT, teamlist1, UserList, TeamList);
					
					System.out.println("Team successfully added!");
					
//					Connection.writeTeam(ID, teamname);
				} else {
					System.out.println("Team already exists...");
				}
			}
			
		} while (input != 1 && input != 2);
	}

	public static String getID() {
		String old = TeamList.get(TeamList.size() - 1).ID;
		int temp = Integer.parseInt(old) + 1;
		String neo = Integer.toString(temp);
		return neo;
	}
	
	public static boolean findTeam(String teamname) {
		for (int i=0; i<TeamList.size(); i++) {
			if (TeamList.get(i).Teamname.equals(teamname)) {
				return true;
			}
		}
		return false;
	}
	
	public static  String findID(String team) {
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
	
	public static int count(String ID) {
		
		int count = 0;
		
		for (int i=0; i<UserList.size(); i++) {
			if (UserList.get(i).ID.equals(ID)) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void show() {
		int select = 0;
		int yes = 0;
		do {
			System.out.println("Which table to show? 1. User, 2. Team.");
			select = sc.nextInt();
			sc.nextLine();
		} while(select != 1 && select != 2);
		do {
			System.out.println("Want to filter by condition? 1. Yes, 2. No");
			yes = sc.nextInt();
			sc.nextLine();
		} while(yes != 1 && yes != 2);
		
		if(yes == 2) {
			if(select == 1) {
				showAllUser();
			}
			else {
				showAllTeam();
			}
		} else if (yes == 1) {
			//Find by condition
			System.out.println("Find Options: 1. Find All, 2. Find One");
			Integer find;
			find = sc.nextInt();
			sc.nextLine();
			System.out.println("Add condition, separate by semicolon.");
			System.out.println("Example: name;=;kevin");
			String condition = " ";
			String[] conditions = null;
			condition = sc.nextLine();
			conditions = condition.split(";");
			
			if (find == 1) {
				showOptions(select, conditions);
			} else if (find == 2) {
				showOptionsOne(select, conditions);
			}
			
		}
	}
	
	public static void showOptions(Integer select, String[] conditions) {
		String column = conditions[0];
		String searchtype = conditions[1];
		String target = conditions[2];
		String[] conjoin = null;
		String bee = conditions[1] + ";" + conditions[2];
		conjoin = bee.split(";");
		
		if(select == 1) {
			
			if(conditions[0].equals("team")) {
				UserRepository userRepository = new UserRepository();
				userRepository.find(column, conjoin, true, "team", userlist1, UserList, TeamList);
//				column = "id";
//				target = findID(conditions[2]);
			}else {
				UserRepository userRepository2 = new UserRepository();
				userRepository2.find(column, conjoin, false, null, userlist1, UserList, TeamList);
			}
				
//			showUser(column, searchtype, target);
		} else {
			if(conditions[0].equals("name")) {
				TeamRepository teamRepository = new TeamRepository();
				teamRepository.find(column, conjoin, true, "User", userlist1, UserList, TeamList);
//				column = "id";
//				target = findIDfromName(conditions[2]);
			}else if(conditions[0].equals("nim")) {
				TeamRepository teamRepository2 = new TeamRepository();
				teamRepository2.find(column, conjoin, true, "User", userlist1, UserList, TeamList);
//				column = "id";
//				target = findIDfromNIM(conditions[2]);
			}else {
				TeamRepository teamRepository3 = new TeamRepository();
				teamRepository3.find(column, conjoin, false, null, userlist1, UserList, TeamList);
			}
//			
//			showTeam(column,searchtype,target);
		}
	}
	
	public static void showOptionsOne(Integer select, String[] conditions) {
		String column = conditions[0];
		String searchtype = conditions[1];
		String target = conditions[2];
		String[] conjoin = null;
		String bee = conditions[1] + ";" + conditions[2];
		conjoin = bee.split(";");
		
		if(select == 1) {
			
			if(conditions[0].equals("team")) {
				UserRepository userRepository = new UserRepository();
				userRepository.findOne(column, conjoin, true, "team", userlist1, UserList, TeamList);
//				column = "id";
//				target = findID(conditions[2]);
			}else {
				UserRepository userRepository2 = new UserRepository();
				userRepository2.findOne(column, conjoin, false, null, userlist1, UserList, TeamList);
			}
				
//			showUser(column, searchtype, target);
		} else {
			if(conditions[0].equals("name")) {
				TeamRepository teamRepository = new TeamRepository();
				teamRepository.findOne(column, conjoin, true, "User", userlist1, UserList, TeamList);
//				column = "id";
//				target = findIDfromName(conditions[2]);
			}else if(conditions[0].equals("nim")) {
				TeamRepository teamRepository2 = new TeamRepository();
				teamRepository2.findOne(column, conjoin, true, "User", userlist1, UserList, TeamList);
//				column = "id";
//				target = findIDfromNIM(conditions[2]);
			}else {
				TeamRepository teamRepository3 = new TeamRepository();
				teamRepository3.findOne(column, conjoin, false, null, userlist1, UserList, TeamList);
			}
//			
//			showTeam(column,searchtype,target);
		}
	}
	
	public static  void showAllUser() {
		for (int a = 0; a<UserList.size(); a++) {
//			System.out.println(UserList.get(a).NIM+"|"+UserList.get(a).Username+"|"+UserList.get(a).ID);
			System.out.println("|" + String.format("%-10s", UserList.get(a).NIM) + "|" 
					+ String.format("%-35s", UserList.get(a).Username) + "|"
					+ String.format("%-7s", UserList.get(a).ID) + "|");
		}
	}
	
	public static void showAllTeam() {
		for (int a = 0; a<TeamList.size(); a++) {
//			System.out.println(TeamList.get(a).ID+"|"+TeamList.get(a).Teamname);
			System.out.println("|" + String.format("%-3s", TeamList.get(a).ID) + "|" 
					+ String.format("%-30s", TeamList.get(a).Teamname) + "|");
		}
	}
	
}
