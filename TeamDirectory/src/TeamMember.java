/**
 * The TeamMember class represents each member of the input team.
 */
public class TeamMember 
{	
	protected String fullName;
	protected String idString;
	
	/**
	 * Create a TeamMember object with the specified name and id
	 * 
	 * @param name The member's full name
	 * @param id   The member's full id
	 */
	public TeamMember(String name, String id) 
	{
		name = name.toLowerCase(); //convert all incoming names to lowercase for formatting
		
		for(int i = 0; i < name.length(); i++) //further conversion to title case
		{
			if(i == 0) 
			{
				name = name.substring(i, i + 1).toUpperCase() + name.substring(i + 1, name.length());
			}
			if(name.substring(i, i + 1).equals(" "))
			{
				name = name.substring(0, i + 1) + name.substring(i + 1, i + 2).toUpperCase() + name.substring(i + 2, name.length());
			}
		}
		this.fullName = name;
		this.idString = id;
	}
	
	/**
	 * Return the full name of a team member
	 * 
	 * @return A string representation of the member's name
	 */
	@Override
	public String toString() 
	{
		return this.fullName;
	}
	
	/**
	 * Compares the two unique ids of two different TeamMember objects using String.compareTo()
	 * 
	 * @param other The TeamMember object to which a comparison will be made to the current object
	 * @return A value less than, equal to, or greater than 0
	 */
	public int compareTo(TeamMember other) 
	{
		return this.idString.compareTo(other.idString);
	}
}
