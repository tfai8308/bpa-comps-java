import java.util.Arrays;

public class Player {
	
	private String name;
	private int[] scores;
	
	public Player(String playerData) {
		name = playerData.substring(0, playerData.indexOf(","));
		playerData = playerData.substring(playerData.indexOf(",") + 1); //further process playerData to remove the name from the data
		scores = Arrays.stream(playerData.split(",")).mapToInt(Integer::parseInt).toArray(); //convert text string to integer array
	}
	
	/**
	 * Calculates the player's handicap based on the average their 5 lowest rounds 
	 * or the average of all rounds if less than 5 were played
	 * @return the player's handicap
	 */
	public int getHandicap() {
		//less than 5 rounds played
		if(scores.length < 5) {
			int total = scores[0];
			for(int i = 1; i < scores.length; i++) {
				total += scores[i];
			}
			return (int)Math.round((total / scores.length) * 0.9);
		}
		else {
			int[] sortedScores = scores.clone();
			Arrays.sort(sortedScores);
			//now that it's sorted in a different place, grab the first 5 values without
			//altering the original score list
			return (int)Math.round(((sortedScores[0] + sortedScores[1] + sortedScores[2] + sortedScores[3] + sortedScores[4]) / 5) * .9);
		}
	}
	
	/**
	 * Returns the player's first and last name
	 * @return the player's first and last name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Calculates the player's lowest score
	 * @return the player's lowest score
	 */
	public int getLowScore() {
		int min = scores[0];
		for(int i = 1; i < scores.length; i++) {
			if(scores[i] < min) {
				min = scores[i];
			}
		}
		return min;
	}
}
