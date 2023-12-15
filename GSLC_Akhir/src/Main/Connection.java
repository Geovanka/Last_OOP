package Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

import Models.Team;
import Models.User;

public class Connection {
	public static String csvTeam = "src\\teambaru.csv";
	public static String csvUser = "src\\userbaru.csv";
	
	public ArrayList<Team> readTeam(){
		ArrayList<Team> test = new ArrayList<Team>();
		String delimiter1 = ",";
			  
		try {
			File file = new File(csvTeam);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = " ";
			String[] tempArr = null;
				      
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter1);      
				Team p1 = new Team(tempArr[0],tempArr[1]);
				test.add(p1);
//				System.out.println(tempArr[0]+tempArr[1]);
//				System.out.println(test.size());
			}
			br.close(); 
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return test;
	}
	
	public ArrayList<User> readUser(){
		ArrayList<User> test = new ArrayList<User>();
		String delimiter1 = ",";
		  
		try {
			File file = new File(csvUser);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = " ";
			String[] tempArr = null;
			      
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter1);	       
				User p1 = new User(tempArr[0],tempArr[1], tempArr[2]);
				test.add(p1);
//		        System.out.println(tempArr[0]+tempArr[1]+tempArr[2]);
//		        System.out.println(test.size());
			}
			br.close(); 
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return test;
}
	
	public static void writeTeam(String id, String teamname) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvTeam, true))) {
            // Join array elements with a comma to form a CSV line
			String temp = (id+","+teamname);

            // Write the CSV line to the file
            writer.write(temp);

            // Move to the next line
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public static void writeUser(String NIM, String name, String ID) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvUser, true))) {
            // Join array elements with a comma to form a CSV line
			String temp = (NIM+","+name+","+ID);

            // Write the CSV line to the file
            writer.write(temp);

            // Move to the next line
            writer.newLine();

            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
		
}


