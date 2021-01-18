//01-0024-0045
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * The Sort class is the primary class in which TeamMember information will be parsed
 * from a text document and sorted into an ArrayList using an insertion sort algorithm.
 */
public class Sort 
{	
	public static void main(String[] args) throws InterruptedException 
	{	
		String path = "team.txt";  //the name of the text document stored using a relative path
		ArrayList<TeamMember> memberList = new ArrayList<TeamMember>();
		try
		{
			FileReader read = new FileReader(path);
			BufferedReader reader = new BufferedReader(read);

			String line;
			while((line = reader.readLine()) != null)  //parse the entire document
			{
				if(line.equals("")) continue;  //continue skipping potential newlines until a name is found
				String name = line;                    //assuming alternating lines of name followed by id
				String id = reader.readLine();
				if(name.equalsIgnoreCase("stop") || id.equalsIgnoreCase("stop")) break;  //detect a parsed "stop" and exit without instantiating more objects
				if(id.equals(""))  //continue skipping potential newlines until an id is found
				{
					while(id.equals(""))
					{
						id = reader.readLine();
					}
				}
				TeamMember member = new TeamMember(name, id);
				insertionSort(memberList, member);
			}
			reader.close();
			
			printArrayList(memberList);
		}
		catch (FileNotFoundException e) 
		{
			System.err.println("The file was not found.");
		}
		catch (IOException e)
		{
			System.err.println("There was an error reading the file.");
		}
		Thread.sleep(3000); //prevent the .bat from exiting immediately
	}
	
	/**
	 * Performs an insertion sort into the ArrayList, one object at a time
	 * 
	 * @param memberList The list to which sorted data will be stored
	 * @param member The member to be sorted into the memberList
	 */
	public static void insertionSort(ArrayList<TeamMember> memberList, TeamMember member)
	{
		if(memberList.isEmpty())
		{
			memberList.add(member);
		}
		else
		{
			memberList.add(member);
			for(int i = memberList.size() - 1; i > 0; i--)
			{
				if(memberList.get(i).compareTo(memberList.get(i - 1)) < 0)
				{
					TeamMember storage = memberList.get(i - 1);
					memberList.set(i - 1, memberList.get(i));
					memberList.set(i, storage);
				}
			}
		}
	}
	
	/**
	 * Prints out the contents of the ArrayList using ArrayList.toString();
	 * 
	 * @param memberList The ArrayList containing sorted member data
	 */
	public static void printArrayList(ArrayList<TeamMember> memberList)
	{
		System.out.println(memberList.toString());
	}
}
