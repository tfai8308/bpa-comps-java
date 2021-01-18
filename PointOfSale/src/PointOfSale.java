//ID: 01-0024-0005
import java.util.InputMismatchException;
import java.util.Scanner;

public class PointOfSale {

	public static void main(String[] args) {
		double total = 0;
		int passwordValue = (int)(Math.random() * 10 + 10);
		String originalPassword = "";
		Scanner passwordInput = new Scanner(System.in);
		do {
			try {
				System.out.print("Enter password (" + passwordValue + "): ");
				originalPassword = passwordInput.nextLine();
				if(!validPassword(passwordValue, originalPassword)) {
					throw new InputMismatchException("Incorrect data has been entered");
				}
			}
			catch(InputMismatchException e) {
				System.err.println("Error: Incorrect Password");
				
			}
		}while(!validPassword(passwordValue, originalPassword));
		
		int userChoice = -1; //a harmless starting number for selection
		do {
			System.out.println( "\nMenu:\n"
					+   "1) Regular Coffee ($7.99)\n" 
					+	"2) Breakfast Croissant ($5.99)\n"
					+   "9) Total the order\n"
					+   "0) Exit\n"
					+   "Subtotal: $" + total + "\n");
			try {
				Scanner userChoiceInput = new Scanner(System.in);
				System.out.print("Your selection: ");
				userChoice = userChoiceInput.nextInt();
				//extra check
				if(userChoice == 1 || userChoice == 2 || userChoice == 9 || userChoice == 0) {
					switch(userChoice) {
					case 1:
						total += getOptions("Regular Coffee", 7.99, "cream", 0.10, "sugar", 0.15);
						break;
					case 2:
						total += getOptions("Breakfast Croissant", 5.99, "ham", 0.50, "cheese", 0.25);
						break;
					case 9:
						showTotal(total);
						total = 0; //reset the total
						break;
					case 0:
						System.out.println();
						System.out.println("Goodbye!");
						System.exit(0);
					default:
						break;
					}
				}
				else {
					System.err.println("Error: Invalid Input");
				}
			}
			catch(InputMismatchException e) {
				System.err.println("Error: Invalid Input");
				
			}
			
		}while(userChoice != 0);
	}
	
	/**
	 * Checks to see if the user's inputted password is legal according to the specifications.
	 * @param passwordValue the number that the password needs to add up to
	 * @param originalPassword the password that the user wishes to use
	 * @return a boolean either accepting or rejecting the password
	 */
	public static boolean validPassword(int passwordValue, String originalPassword) {
		String processedPassword = originalPassword.replaceAll("[^0-9]", "");
		
		int sum = 0;
		for(int i = 0; i < processedPassword.length(); i++) {
			int temp = Integer.parseInt(processedPassword.substring(i, i + 1));
			sum += temp;
		}
		return sum == passwordValue;
	}
	
	/**
	 * Shows the subtotal before tax, the tax, as well as the final total.
	 * @param subtotal the subtotal of the customer's order
	 */
	public static void showTotal(double subtotal) {
		double total = subtotal + subtotal/10.0;
		System.out.println();
		System.out.println("Subtotal: $" + subtotal + "\n"
						+  "Tax (10%): $" + (subtotal/10.0) + "\n"
						+  "Total: $" + total + "\n"
						+ "Please have the customer pay $" + total + ". Thank you!" );
	}
	
	/**
	 * Displays all menu options for each item as well as performs various calculations for those items
	 * @param itemName the name of the item
	 * @param itemPrice the price of the item
	 * @param opt1Name the name of the first option
	 * @param opt1Price the price of the first option
	 * @param opt2Name the name of the second option
	 * @param opt2Price the price of the second option
	 * @return the subtotal of ordering an item
	 */
	public static double getOptions(String itemName, double itemPrice, String opt1Name, double opt1Price, String opt2Name, double opt2Price) {
		double subtotal = itemPrice;
		System.out.println("\n" + itemName + ": ");
		
		String confirmation = "";
		do {
			System.out.print("Do you want " + opt1Name + " for $" + opt1Price + " more? (y/n) ");
			try {
				Scanner userInput = new Scanner(System.in);
				confirmation = userInput.nextLine();
				if(!validYN(confirmation)) {
					throw new InputMismatchException("Incorrect data has been entered");
				}
			}
			catch(InputMismatchException e) {
				System.err.println("\nError: Invalid Input");
				
			}
		}while(!validYN(confirmation));
		
		if(confirmation.substring(0, 1).equalsIgnoreCase("y")) {
			subtotal += opt1Price;
		}
		
		
		do {
			System.out.print("Do you want " + opt2Name + " for $" + opt2Price + " more? (y/n) ");
			try {
				Scanner userInput = new Scanner(System.in);
				confirmation = userInput.nextLine();
				if(!validYN(confirmation)) {
					throw new InputMismatchException("Incorrect data has been entered");
				}
			}
			catch(InputMismatchException e) {
				System.err.println("\nError: Invalid Input");
				
			}
		}while(!validYN(confirmation));
		
		if(confirmation.substring(0, 1).equalsIgnoreCase("y")) {
			subtotal += opt2Price;
		}
		System.out.println("Adding " + itemName + " for $" + subtotal + ".");
		return subtotal;
	}
	
	/**
	 * A helper method to determine if the user actually used y/n or a first letter variation
	 * @param confirmation the user's input
	 * @return accept or reject the user's input
	 */
	public static boolean validYN(String confirmation) {
		return confirmation.substring(0, 1).equalsIgnoreCase("y") || confirmation.substring(0, 1).equalsIgnoreCase("n");
	}
}
