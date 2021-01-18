//ID: 01-0024-0005
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerDriver {
	
	public static void main(String[] args) {
		
		String path = new File("src\\Players.txt").getAbsolutePath();
		ArrayList<Player> playerList = new ArrayList<Player>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String data; //store the line or else the while structure will skip lines
			//populate the player data structure
			while((data = in.readLine()) != null) {
				Player player = new Player(data);
				playerList.add(player);
			}
		}
		catch(FileNotFoundException e){
			System.err.println("The file path specified was not found.");
		}
		catch(IOException e){
			System.err.println("The file failed to be read.");
		}
		
		int choice = -1;  //harmless starting value for program to run
		System.out.println("The file was successfully loaded.");
		do {
			System.out.println("Menu:\n" 
					+  "1- Find player handicap\n"
					+  "2- List all players' best round\n"
					+  "3- List all players' handicaps\n"
					+  "0- Exit\n");
			try {
				Scanner userInput = new Scanner(System.in); //takes in the user's choice
				Scanner nextPage = new Scanner(System.in); //used later for changing pages
				choice = userInput.nextInt();
				if(choice == 1 || choice == 2 || choice == 3 || choice == 0) {  //extra input check
					switch(choice) {
					case 1:
						System.out.println("Please enter the name of a player: ");
						System.out.println(findPlayerHandicap(playerList));
						System.out.println("\nPress ENTER to continue");
						nextPage.nextLine(); //enter prompt
						break;
					case 2:
						listBestRounds(playerList);
						System.out.println("\nPress ENTER to continue");
						nextPage.nextLine();
						break;
					case 3:
						listAllHandicaps(playerList);
						System.out.println("\nPress ENTER to continue");
						nextPage.nextLine();
						break;
					case 0:
						System.out.println("The program has exited.");
						System.exit(0);
						break;
					default:
						break;
					}
				}
				else {
					System.err.println("Error: Invalid Input");
				}
			}
			catch(InputMismatchException e){
				System.err.println("Error: Invalid Input");
			}
		}while(choice != 0);
	}
	
	/**
	 * Creates the list of player names and their respective handicaps
	 * @param playerList the list of all recorded golfers
	 * @return a string with either the name+handicap information, or a failed message
	 */
	public static String findPlayerHandicap(ArrayList<Player> playerList) {
		Scanner nameInput = new Scanner(System.in);
		String name = nameInput.nextLine();
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).getName().equalsIgnoreCase(name)) {
				return "Name: " + playerList.get(i).getName() + " \nHandicap: " + playerList.get(i).getHandicap();
			}
			else {
				continue;
			}
		}
		return "The requested player was not found.";
	}
	
	/**
	 * Creates the list of player names and their respective best scores
	 * @param playerList the list of all recorded golfers
	 */
	public static void listBestRounds(ArrayList<Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
			System.out.println("Name: " + playerList.get(i).getName() + " \tBest Score: " + playerList.get(i).getLowScore());
		}
	}
	
	/**
	 * Creates the list of player names and their respective handicaps
	 * @param playerList the list of all recorded golfers
	 */
	public static void listAllHandicaps(ArrayList<Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
			System.out.println("Name: " + playerList.get(i).getName() + " \tHandicap: " + playerList.get(i).getHandicap());
		}
	}
}
